

package tpo.utils.genjar;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class MainClassAction extends AbstractAction
{

    public MainClassAction(EntryList entries)
    {
        putValue("Name", "Set as Main Class");
        _entries = entries;
    }

    public void actionPerformed(ActionEvent e)
    {
        FileEntry fileEnts[] = _entries.getSelectedEntries();
        if(fileEnts.length != 1)
            return;
        if(fileEnts[0].toString().endsWith(".class"))
            Data.INSTANCE.setMainClassEnt(fileEnts[0]);
    }

    private static final long serialVersionUID = 1L;
    private final EntryList _entries;
}
