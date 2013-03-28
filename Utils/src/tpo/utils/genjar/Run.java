
package tpo.utils.genjar;

import java.awt.*;
import java.io.File;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileSystemView;

public class Run extends JApplet
{
    static String home;

    public Run()
    {
    }

    public void init()
    {
        EventQueue.invokeLater(new Runnable() {

            public void run()
            {
                Container content = getContentPane();
                content.setLayout(new BorderLayout());
                UI ui = new UI();
                ui.setBorder(new LineBorder(Color.BLACK));
                content.add(ui, "Center");
                ui.getFileTree().expandToFile(Run.home());
            }

        });
    }

    private static File home()
    {
        
        return FileSystemView.getFileSystemView().createFileObject(home);
    }

    public static void main(String args[])
    {
        final UI ui = new UI();
        home = args[0];//"C:\\Users\\j1013563\\Desktop";//
        JFrame frm = new JFrame("Make Jar");
        frm.setDefaultCloseOperation(3);
        frm.setSize(600, 580);
        frm.setLocationRelativeTo(null);
        frm.getContentPane().add(ui);
        frm.setVisible(true);
        EventQueue.invokeLater(new Runnable() {

            public void run()
            {
                ui.getFileTree().expandToFile(Run.home());
            }

        });
    }

    private static final long serialVersionUID = 1L;
    public static final int WID = 600;
    public static final int HT = 580;

}
