
package tpo.utils.genjar;

import java.util.*;
import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;


public class EntryListModel
    implements ListModel, Observer
{

    public EntryListModel()
    {
        Events.ADD.addObserver(this);
        Events.REM.addObserver(this);
    }

    public int getSize()
    {
        return Data.INSTANCE.getEntries().size();
    }

    public Object getElementAt(int index)
    {
        return Data.INSTANCE.getEntries().get(index);
    }

    public void addListDataListener(ListDataListener l)
    {
        _listeners.add(l);
    }

    public void removeListDataListener(ListDataListener l)
    {
        _listeners.remove(l);
    }

    public void fireAdd(ListDataEvent evt)
    {
        for(Iterator it = _listeners.iterator(); it.hasNext(); ((ListDataListener)it.next()).intervalAdded(evt));
    }

    public void fireRemove(ListDataEvent evt)
    {
        for(Iterator it = _listeners.iterator(); it.hasNext(); ((ListDataListener)it.next()).intervalRemoved(evt));
    }

    private ListDataEvent mkEvt(FileEntry fEnt, int type)
    {
        int ix = Data.INSTANCE.getEntries().indexOf(fEnt);
        return new ListDataEvent(this, type, ix, ix);
    }

    public void update(Observable o, Object msg)
    {
        if(o == Events.ADD)
            fireAdd(mkEvt((FileEntry)msg, 1));
        if(o == Events.REM)
        {
            int ix = ((Integer)msg).intValue();
            fireRemove(new ListDataEvent(this, 2, ix, ix));
        }
    }

    private final List _listeners = new ArrayList();
}
