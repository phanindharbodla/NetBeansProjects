

package tpo.utils.genjar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JTree;
import javax.swing.tree.TreePath;

public class FileXFerUtil
{
    public static class FileListXFer
        implements java.awt.datatransfer.Transferable
    {

        public java.awt.datatransfer.DataFlavor[] getTransferDataFlavors()
        {
            return (new java.awt.datatransfer.DataFlavor[] {
                java.awt.datatransfer.DataFlavor.javaFileListFlavor
            });
        }

        public boolean isDataFlavorSupported(java.awt.datatransfer.DataFlavor flav)
        {
            return flav.equals(java.awt.datatransfer.DataFlavor.javaFileListFlavor);
        }

        public Object getTransferData(java.awt.datatransfer.DataFlavor flavor)
            throws java.awt.datatransfer.UnsupportedFlavorException, IOException
        {
            return _files;
        }

        private final List _files;

        public FileListXFer(List files)
        {
            _files = files;
        }
    }


    public FileXFerUtil()
    {
    }

    public static java.awt.datatransfer.Transferable createXFer(JComponent c)
    {
        JTree tree = (JTree)c;
        TreePath paths[] = tree.getSelectionPaths();
        if(paths == null)
            paths = new TreePath[0];
        List files = new ArrayList();
        for(int i = 0; i < paths.length; i++)
        {
            FileNode fn = (FileNode)paths[i].getLastPathComponent();
            files.add(fn.getFile());
        }

        return new FileListXFer(files);
    }
}
