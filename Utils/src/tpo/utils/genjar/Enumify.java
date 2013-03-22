
package tpo.utils.genjar;

import java.util.Enumeration;
import java.util.Iterator;

public class Enumify
    implements Enumeration
{

    public Enumify(Iterator it)
    {
        _it = it;
    }

    public boolean hasMoreElements()
    {
        return _it.hasNext();
    }

    public Object nextElement()
    {
        return _it.next();
    }

    private final Iterator _it;
}
