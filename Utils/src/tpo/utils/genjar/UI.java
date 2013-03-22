

package tpo.utils.genjar;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class UI extends JPanel
{
    private class CreateJAR
        implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {
            ExampleFileFilter eff = new ExampleFileFilter();
            eff.addExtension("jar");
            eff.setDescription("Java Archive");
            JFileChooser jfc = new JFileChooser();
            jfc.setFileFilter(eff);
            jfc.setSelectedFile(new File("untitled.jar"));
            int opt = jfc.showSaveDialog(UI.this);
            if(opt == 0)
            {
                File f = jfc.getSelectedFile();
                if(canWriteFile(f))
                    mkJar(ensureExtn(f));
            }
        }

        private File ensureExtn(File f)
        {
            if(f.getPath().toLowerCase().endsWith(".jar"))
                return f;
            else
                return new File(f.getPath() + ".jar");
        }

        private boolean canWriteFile(File f)
        {
            SecurityManager sm = System.getSecurityManager();
            try
            {
                sm.checkWrite(f.getPath());
            }
            catch(SecurityException se)
            {
                String title = "Oops!";
                String msg = "Unable to write selected file.\nProblem: " + se.getMessage();
                JOptionPane.showMessageDialog(UI.this, msg, "Oops!", 0);
                return false;
            }
            if(f.exists())
            {
                String title = "Hmmm...";
                String msg = "Overwrite existing file: " + f.getName();
                int op = JOptionPane.showConfirmDialog(UI.this, msg, "Hmmm...", 2);
                return op == 0;
            } else
            {
                return true;
            }
        }

        CreateJAR()
        {
        }
    }

    private static class EntryFollower
        implements Observer
    {

        public void update(Observable o, Object arg)
        {
            boolean on = Data.INSTANCE.getEntries().size() > 0;
            _c.setEnabled(on);
        }

        private final Component _c;

        public EntryFollower(Component c)
        {
            _c = c;
            Events.ADD.addObserver(this);
            Events.REM.addObserver(this);
            update(null, null);
        }
    }


    public UI()
    {
        super(new GridBagLayout());
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException exception) { exception.toString();}
        JLabel labThisComp = new JLabel("Files on this Computer");
        JLabel labJarFiles = new JLabel("Jar Files");
        JButton btAdd = new JButton(new AddAction(_fileTree));
        JButton btRem = new JButton(new RemoveAction(_entList));
        new EntryFollower(btRem);
        int CENTER = 10;
        int NONE = 0;
        int HORIZ = 2;
        int BOTH = 1;
        add(this, labThisComp, 0, 0, 1, 1, 0.0D, 0.0D, 12, 12, 6, 12, 10, 0);
        add(this, labJarFiles, 1, 0, 1, 1, 1.0D, 0.0D, 12, 12, 6, 12, 10, 0);
        add(this, _fileTree.getComponent(), 0, 1, 1, 1, 0.0D, 1.0D, 0, 12, 6, 12, 10, 1);
        add(this, _entList.getComponent(), 1, 1, 1, 1, 1.0D, 1.0D, 0, 0, 6, 12, 10, 1);
        Component strut = Box.createHorizontalStrut(250);
        add(this, strut, 0, 1, 1, 1, 0.0D, 0.0D, 0, 12, 0, 12, 10, 0);
        add(this, btAdd, 0, 2, 1, 1, 0.0D, 0.0D, 0, 12, 12, 12, 10, 0);
        add(this, btRem, 1, 2, 1, 1, 1.0D, 0.0D, 0, 12, 12, 12, 10, 0);
        JSeparator sep = new JSeparator(0);
        add(this, sep, 0, 3, 2, 1, 1.0D, 0.0D, 0, 12, 12, 12, 10, 2);
        add(this, mkButtonBar(), 0, 4, 2, 1, 1.0D, 0.0D, 0, 12, 12, 12, 10, 2);
    }

    public FileTree getFileTree()
    {
        return _fileTree;
    }

    private JPanel mkButtonBar()
    {
        JPanel buttonPan = new JPanel(new GridBagLayout());
        JButton btJar = new JButton("Create JAR...");
        btJar.addActionListener(new CreateJAR());
        new EntryFollower(btJar);
        add(buttonPan, btJar, 0, 0, 2, 1, 1.0D, 0.0D, 0, 0, 0, 6, 10, 0);
        return buttonPan;
    }

    private void mkJar(File f)
    {
        setCursor(WAIT_CURSOR);
        try
        {
            Data.INSTANCE.createJAR(f);
        }
        catch(Exception ex)
        {
            setCursor(DEFAULT_CURSOR);
            String title = "Ouch!";
            String msg = "Failed to create JAR.\nProblem: " + ex.getMessage();
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, msg, "Ouch!", 0);
        }
        setCursor(DEFAULT_CURSOR);
    }

    private static void add(JComponent host, Component c, int x, int y, int wid, int ht, double wtx, 
            double wty, int top, int left, int bottom, int right, int anchor, 
            int fill)
    {
        GBC.anchor = anchor;
        GBC.gridwidth = wid;
        GBC.gridheight = ht;
        GBC.fill = fill;
        GBC.gridx = x;
        GBC.gridy = y;
        INSETS.set(top, left, bottom, right);
        GBC.insets = INSETS;
        GBC.weightx = wtx;
        GBC.weighty = wty;
        host.add(c, GBC);
    }

    private static final long serialVersionUID = 1L;
    private final FileTree _fileTree = new FileTree(new FSRootNode());
    private final EntryList _entList = new EntryList(new EntryListModel());
    private static Cursor DEFAULT_CURSOR = Cursor.getPredefinedCursor(0);
    private static Cursor WAIT_CURSOR = Cursor.getPredefinedCursor(3);
    private static final GridBagConstraints GBC = new GridBagConstraints();
    private static final Insets INSETS = new Insets(0, 0, 0, 0);


}
