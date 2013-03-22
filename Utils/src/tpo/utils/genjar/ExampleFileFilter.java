
package tpo.utils.genjar;

import java.io.File;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.filechooser.FileFilter;

public class ExampleFileFilter extends FileFilter
{

    public ExampleFileFilter()
    {
        _filters = new Hashtable();
    }

    public ExampleFileFilter(String extension)
    {
        this(extension, null);
    }

    public ExampleFileFilter(String extension, String description)
    {
        this();
        if(extension != null)
            addExtension(extension);
        if(description != null)
            setDescription(description);
    }

    public ExampleFileFilter(String filters[])
    {
        this(filters, null);
    }

    public ExampleFileFilter(String filters[], String description)
    {
        this();
        for(int i = 0; i < filters.length; i++)
            addExtension(filters[i]);

        if(description != null)
            setDescription(description);
    }

    public boolean accept(File f)
    {
        if(f != null)
        {
            if(f.isDirectory())
                return true;
            String extension = getExtension(f);
            if(extension != null && _filters.get(getExtension(f)) != null)
                return true;
        }
        return false;
    }

    public String getExtension(File f)
    {
        if(f != null)
        {
            String filename = f.getName();
            int i = filename.lastIndexOf('.');
            if(i > 0 && i < filename.length() - 1)
                return filename.substring(i + 1).toLowerCase();
        }
        return null;
    }

    public void addExtension(String extension)
    {
        _filters.put(extension.toLowerCase(), this);
        _fullDescription = null;
    }

    public String getDescription()
    {
        if(_fullDescription == null)
            if(_description == null || isExtensionListInDescription())
            {
                _fullDescription = _description != null ? _description + " (" : "(";
                Enumeration extensions = _filters.keys();
                if(extensions != null)
                    for(_fullDescription += "." + (String)extensions.nextElement(); extensions.hasMoreElements(); _fullDescription += extensions.nextElement().toString())
                        _fullDescription += ", ";

                _fullDescription += ")";
            } else
            {
                _fullDescription = _description;
            }
        return _fullDescription;
    }

    public void setDescription(String description)
    {
        _description = description;
        _fullDescription = null;
    }

    public void setExtensionListInDescription(boolean b)
    {
        _useExtensionsInDescription = b;
        _fullDescription = null;
    }

    public boolean isExtensionListInDescription()
    {
        return _useExtensionsInDescription;
    }

    private final Hashtable _filters;
    private String _description;
    private String _fullDescription;
    private boolean _useExtensionsInDescription;
}
