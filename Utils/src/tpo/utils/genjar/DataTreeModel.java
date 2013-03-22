

package tpo.utils.genjar;

import java.io.File;
import java.util.*;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 * @deprecated Class DataTreeModel is deprecated
 */

public class DataTreeModel
    implements TreeModel, Observer
{

    public DataTreeModel()
    {
        _rootMap = new TreeMap(FileCompare.INSTANCE);
        Events.ADD.addObserver(this);
        Events.REM.addObserver(this);
    }

    public Object getRoot()
    {
        return _rootMap;
    }

    public Object getChild(Object parent, int index)
    {
        if(parent == getRoot())
            return _rootMap.get(_rootMap.keySet().toArray()[index]);
        else
            return ((FileNode)parent).getChildAt(index);
    }

    public int getChildCount(Object parent)
    {
        if(parent == getRoot())
            return _rootMap.size();
        else
            return ((FileNode)parent).getChildCount();
    }

    public boolean isLeaf(Object node)
    {
        if(node == getRoot())
            return false;
        else
            return ((FileNode)node).isLeaf();
    }

    public void valueForPathChanged(TreePath treepath, Object obj)
    {
    }

    public int getIndexOfChild(Object parent, Object child)
    {
        if(parent == getRoot())
        {
            Iterator it = _rootMap.keySet().iterator();
            for(int ix = 0; it.hasNext(); ix++)
            {
                Object node = _rootMap.get(it.next());
                if(node.equals(child))
                    return ix;
            }

            return -1;
        }
        FileNode fn = (FileNode)parent;
        for(int i = 0; i < fn.getChildCount(); i++)
            if(fn.getChildAt(i).equals(child))
                return i;

        return -1;
    }

    public void addTreeModelListener(TreeModelListener l)
    {
        _listeners.add(l);
    }

    public void removeTreeModelListener(TreeModelListener l)
    {
        _listeners.remove(l);
    }

    private void fireInserted(int nodeIx, Object node)
    {
        TreeModelEvent evt = new TreeModelEvent(this, new Object[] {
            getRoot()
        }, new int[] {
            nodeIx
        }, new Object[] {
            node
        });
        TreeModelListener l;
        for(Iterator it = _listeners.iterator(); it.hasNext(); l.treeStructureChanged(evt))
            l = (TreeModelListener)it.next();

    }

    private void fireRemoved(int nodeIx, Object node)
    {
        TreeModelEvent evt = new TreeModelEvent(this, new Object[] {
            _rootMap
        }, new int[] {
            nodeIx
        }, new Object[] {
            node
        });
        TreeModelListener l;
        for(Iterator it = _listeners.iterator(); it.hasNext(); l.treeStructureChanged(evt))
            l = (TreeModelListener)it.next();

    }

    private void insert(File f)
    {
        Object node = new FileNode(null, f);
        _rootMap.put(f, new FileNode(null, f));
        int ix = getIndexOfChild(_rootMap, node);
        fireInserted(ix, node);
    }

    private void remove(File f)
    {
        Object node = _rootMap.get(f);
        int ix = getIndexOfChild(_rootMap, node);
        _rootMap.remove(f);
        fireRemoved(ix, node);
    }

    public void update(Observable src, Object obj)
    {
        if(src == Events.ADD)
            insert((File)obj);
        if(src == Events.REM)
            remove((File)obj);
    }

    private final List _listeners = new LinkedList();
    private final SortedMap _rootMap;
}
