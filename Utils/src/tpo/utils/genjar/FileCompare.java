

package tpo.utils.genjar;

import java.io.File;
import java.util.Comparator;

public class FileCompare
    implements Comparator
{

    private FileCompare()
    {
    }

    public int compare(Object o1, Object o2)
    {
        File f1 = (File)o1;
        File f2 = (File)o2;
        if(f1.isDirectory() && !f2.isDirectory())
            return -1;
        if(!f1.isDirectory() && f2.isDirectory())
            return 1;
        else
            return f1.compareTo(f2);
    }

    public static final Comparator INSTANCE = new FileCompare();

}
