package tpo.utils.genjar;

import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.AbstractAction;
import javax.swing.tree.TreePath;

public class AddAction extends AbstractAction {

    public AddAction(FileTree ft) {
        super("Add >>");
        _tree = ft;
    }

    public void actionPerformed(ActionEvent e) {
        TreePath paths[] = _tree.getSelectionPaths();
        String path = "";
        FileNode node = null;
        for (int i = 0; i < paths.length; i++) {
            node = (FileNode) paths[i].getLastPathComponent();
            //path=node.getFile().getAbsolutePath();
            addFile(node.getFile());
            
        }
    }

    public static void addFile(File f) {
        Data dat = Data.INSTANCE;
        if (f.isDirectory()) {
            Thread t = dat.mkAddThread(f, f.listFiles());
            t.setPriority(1);
            t.start();
        } else {
            Events.SELECT.post(dat.add(null, f));
        }
    }
    private static final long serialVersionUID = 1L;
    private final FileTree _tree;
}
