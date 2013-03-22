

package tpo.utils.genjar;

import java.io.File;

public class FileEntry
{

    public FileEntry(File container, File file)
    {
        this.container = container;
        this.file = file;
    }

    public String toString()
    {
        if(container == null)
        {
            return file.getName();
        } else
        {
            String fullName = file.getPath();
            String prefix = container.getPath();
            int tailLen = container.getName().length();
            return fullName.substring(prefix.length() - tailLen);
        }
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof FileEntry)
        {
            FileEntry o2 = (FileEntry)obj;
            return file.equals(o2.file);
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return file.hashCode();
    }

    public final File container;
    public final File file;
}
