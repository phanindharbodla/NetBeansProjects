

package tpo.utils.genjar;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class RemoveAction extends AbstractAction
{

    public RemoveAction(EntryList tree)
    {
        super("<< Remove");
        _entList = tree;
    }

    public void actionPerformed(ActionEvent e)
    {
        FileEntry selEnts[] = _entList.getSelectedEntries();
        Thread t = Data.INSTANCE.mkRemoveThread(selEnts);
        t.setPriority(1);
        t.start();
    }

    private static final long serialVersionUID = 1L;
    private final EntryList _entList;
}
