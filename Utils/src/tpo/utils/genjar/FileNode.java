

package tpo.utils.genjar;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import javax.swing.JTree;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeNode;


public class FileNode
    implements MutableTreeNode
{
    private static class FileNodeRenderer extends DefaultTreeCellRenderer
    {

        public java.awt.Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus)
        {
            super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
            if(value instanceof FileNode)
                setIcon(_fsv.getSystemIcon(((FileNode)value).getFile()));
            return this;
        }

        private static final long serialVersionUID = 1L;
        private final FileSystemView _fsv = FileSystemView.getFileSystemView();

        FileNodeRenderer()
        {
        }
    }


    public FileNode(TreeNode parent, File f)
    {
        _parent = parent;
        _thisFile = f;
        if(f.isDirectory())
            _children = null;
        else
            _children = Collections.EMPTY_LIST;
    }

    public File getFile()
    {
        return _thisFile;
    }

    public String toString()
    {
        return _fsv.getSystemDisplayName(_thisFile);
    }

    public boolean equals(Object obj)
    {
        return toString().equals(obj.toString());
    }

    public int hashCode()
    {
        return toString().hashCode();
    }

    private List getChildren()
    {
        if(_children == null)
        {
            File arrChilds[] = _fsv.getFiles(_thisFile, true);
            Arrays.sort(arrChilds, FileCompare.INSTANCE);
            _children = new ArrayList(arrChilds.length);
            for(int i = 0; i < arrChilds.length; i++)
                _children.add(new FileNode(this, arrChilds[i]));

        }
        return _children;
    }

    public TreeNode getChildAt(int childIndex)
    {
        return (FileNode)getChildren().get(childIndex);
    }

    public int getChildCount()
    {
        return getChildren().size();
    }

    public TreeNode getParent()
    {
        return _parent;
    }

    public int getIndex(TreeNode node)
    {
        return getChildren().indexOf(node);
    }

    public boolean getAllowsChildren()
    {
        return _thisFile.isDirectory();
    }

    public boolean isLeaf()
    {
        return _thisFile.isFile();
    }

    public Enumeration children()
    {
        return new Enumify(getChildren().iterator());
    }

    public void insert(MutableTreeNode child, int index)
    {
        throw new RuntimeException("[FileNode] invalid op: insert()");
    }

    public void remove(int index)
    {
        throw new RuntimeException("[FileNode] invalid op: remove()");
    }

    public void remove(MutableTreeNode node)
    {
        throw new RuntimeException("[FileNode] invalid op: remove()");
    }

    public void setUserObject(Object object)
    {
        throw new RuntimeException("[FileNode] invalid op: setUserObject()");
    }

    public void removeFromParent()
    {
        _parent = null;
    }

    public void setParent(MutableTreeNode newParent)
    {
        _parent = newParent;
    }

    public static final TreeCellRenderer RENDERER = new FileNodeRenderer();
    private final FileSystemView _fsv = FileSystemView.getFileSystemView();
    private final File _thisFile;
    private List _children;
    private TreeNode _parent;

}
