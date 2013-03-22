

package tpo.utils.genjar;

import java.awt.Component;
import java.awt.dnd.*;
import java.io.File;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.*;

public class FileTree
{
    private class FileTreeDGL
        implements DragGestureListener
    {

        public void dragGestureRecognized(DragGestureEvent dge)
        {
            java.awt.datatransfer.Transferable xfer = FileXFerUtil.createXFer(_tree);
            dge.startDrag(DragSource.DefaultMoveDrop, xfer);
        }

        FileTreeDGL()
        {
        }
    }


    public FileTree(FSRootNode root)
    {
        _tree = new JTree(new DefaultTreeModel(root));
        _tree.setRootVisible(false);
        _tree.setShowsRootHandles(true);
        _tree.setCellRenderer(FileNode.RENDERER);
        DragSource.getDefaultDragSource().createDefaultDragGestureRecognizer(_tree, 3, new FileTreeDGL());
    }

    public Component getComponent()
    {
        JScrollPane jsp = new JScrollPane(_tree);
        return jsp;
    }

    public TreePath[] getSelectionPaths()
    {
        return _tree.getSelectionPaths();
    }

    public void expandToFile(File goal)
    {
        String gPath = goal.getPath();
        File levels[] = new File[count(gPath, File.separatorChar) + 1];
        int ix = 0;
        for(int i = 0; i < levels.length; i++)
        {
            ix = gPath.indexOf(File.separatorChar, ix + 1);
            if(ix == -1)
                ix = gPath.length();
            String pathStr = gPath.substring(0, ix) + File.separatorChar;
            levels[i] = new File(pathStr);
        }

        TreeModel tMod = _tree.getModel();
        Object node = tMod.getRoot();
        TreePath path = new TreePath(node);
        for(int lev = 0; lev < levels.length; lev++)
        {
            int sz = tMod.getChildCount(node);
            for(int i = 0; i < sz; i++)
            {
                Object tmpNode = (FileNode)tMod.getChild(node, i);
                File f = ((FileNode)tmpNode).getFile();
                if(!f.equals(levels[lev]))
                    continue;
                Object oldPath[] = path.getPath();
                Object rawPath[] = new Object[oldPath.length + 1];
                System.arraycopy(((Object) (oldPath)), 0, ((Object) (rawPath)), 0, oldPath.length);
                rawPath[oldPath.length] = tmpNode;
                path = new TreePath(rawPath);
                node = tmpNode;
                break;
            }

        }

        _tree.expandPath(path);
    }

    private int count(String s, char c)
    {
        int count = 0;
        for(int i = 0; i < s.length(); i++)
            if(s.charAt(i) == c)
                count++;

        return count;
    }

    private final JTree _tree;

}
