
package tpo.utils.genjar;

import java.io.*;
import java.util.*;
import java.util.jar.*;


public class Data
{

   Set<String> paths = new HashSet();

    private Data() 
    {
        _mainClass = null;
        
    }

    public List getEntries()
    {
        return _entries;
    }

    public void setMainClassEnt(FileEntry fEnt)
    {
        _mainClass = fEnt;
        Events.MAIN_CLASS.post(fEnt);
    }

    public FileEntry getMainClassEnt()
    {
        return _mainClass;
    }

    private String getMainClassStr()
    {
        String rawStr = _mainClass.toString();
        int ixDot = rawStr.lastIndexOf(".class");
        if(ixDot == -1)
            return null;
        String mc = rawStr;
        for(mc = mc.substring(0, ixDot); mc.indexOf(File.separatorChar) != -1; mc = mc.replace(File.separatorChar, '.'));
        return mc;
    }

    public List add(File container, File f)
    {
        if(f.isDirectory())
            return add(container, f.listFiles());
        List ents = new ArrayList();
        //System.out.println(f.getAbsoluteFile());
        paths.add(f.getAbsolutePath());
        FileEntry fEnt = new FileEntry(container, f);
        if(!_entries.contains(fEnt))
        {
            _entries.add(fEnt);
            ents.add(fEnt);
            Events.ADD.post(fEnt);
        }
        return ents;
    }

    private List add(File container, File fs[])
    {
        List ents = new ArrayList();
        for(int i = 0; i < fs.length; i++)
            ents.addAll(add(container, fs[i]));

        return ents;
    }

    public Thread mkAddThread(final File container, final File fs[])
    {
        return new Thread() {

            public void run()
            {
                Events.SELECT.post(add(container, fs));
            }

        };
    }

    public void rem(FileEntry fe)
    {
        int ix = _entries.indexOf(fe);
        //System.out.println(fe.file.getAbsoluteFile());
        paths.remove(fe.file.getAbsoluteFile());
        if(_entries.remove(ix) != null)
            Events.REM.post(new Integer(ix));
    }

    public Thread mkRemoveThread(final FileEntry fes[])
    {
        return new Thread() {

            public void run()
            {
                for(int i = 0; i < fes.length; i++)
                    rem(fes[i]);

                Events.SELECT.post(null);
            }

        };
    }

    public void createJAR(File dest)
        throws Exception
    {
        boolean goodTarget = dest.isFile() || dest.createNewFile();
        if(!goodTarget)
            throw new Exception("Unable to write to file: " + dest);
        FileOutputStream fos = new FileOutputStream(dest);
        JarOutputStream jos;
        if(_mainClass != null)
            jos = new JarOutputStream(fos, mkManifest());
        else
            jos = new JarOutputStream(fos);
        for(Iterator entIt = _entries.iterator(); entIt.hasNext(); jos.closeEntry())
        {
            FileEntry fEnt = (FileEntry)entIt.next();
            File f = fEnt.file;
            JarEntry jEntry = new JarEntry(getEntryStr(fEnt));
            jos.putNextEntry(jEntry);
            FileInputStream fis = new FileInputStream(f);
            long sz = 0L;
            byte buff[] = new byte[1024];
            for(int n = fis.read(buff); n != -1; n = fis.read(buff))
            {
                jos.write(buff, 0, n);
                sz += n;
            }

        }

        jos.close();
    }

    private Manifest mkManifest()
        throws Exception
    {
        Attributes attr = new Attributes();
        attr.put(java.util.jar.Attributes.Name.MANIFEST_VERSION, "1.0");
        if(_mainClass != null)
            attr.put(java.util.jar.Attributes.Name.MAIN_CLASS, getMainClassStr());
        Manifest m = new Manifest();
        m.getMainAttributes().putAll(attr);
        return m;
    }

    private static String getEntryStr(FileEntry fEnt)
    {
        File f = fEnt.file;
        File fCont = fEnt.container;
        StringBuffer sb = new StringBuffer();
        for(File current = f; current != null && !current.equals(fCont); current = current.getParentFile())
        {
            sb.insert(0, current.getName());
            sb.insert(0, "/");
        }

        sb.insert(0, fCont.getName());
        return sb.toString();
    }

    public static Data INSTANCE = new Data();
    private final List _entries = Collections.synchronizedList(new ArrayList());
    private FileEntry _mainClass;


}
