
package tpo.utils.genjar;

import java.io.File;
import java.util.*;
import javax.swing.tree.TreeNode;

public class FSRootNode
    implements TreeNode
{

    public FSRootNode()
    {
        File roots[] = File.listRoots();
        Arrays.sort(roots, FileCompare.INSTANCE);
        _children = new ArrayList(roots.length);
        for(int i = 0; i < roots.length; i++)
            _children.add(new FileNode(this, roots[i]));

    }

    public TreeNode getChildAt(int childIndex)
    {
        return (FileNode)_children.get(childIndex);
    }

    public int getChildCount()
    {
        return _children.size();
    }

    public TreeNode getParent()
    {
        return null;
    }

    public int getIndex(TreeNode node)
    {
        return _children.indexOf(node);
    }

    public boolean getAllowsChildren()
    {
        return true;
    }

    public boolean isLeaf()
    {
        return false;
    }

    public Enumeration children()
    {
        return new Enumify(_children.iterator());
    }

    private final List _children;
}
