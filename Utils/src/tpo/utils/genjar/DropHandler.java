
package tpo.utils.genjar;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.File;
import java.util.Iterator;


public class DropHandler
    implements DropTargetListener
{

    public DropHandler()
    {
    }

    public void dragEnter(DropTargetDragEvent droptargetdragevent)
    {
    }

    public void dragOver(DropTargetDragEvent droptargetdragevent)
    {
    }

    public void dropActionChanged(DropTargetDragEvent droptargetdragevent)
    {
    }

    public void dragExit(DropTargetEvent droptargetevent)
    {
    }

    public void drop(DropTargetDropEvent evt)
    {
        Transferable xfer = evt.getTransferable();
        DataFlavor flavors[] = xfer.getTransferDataFlavors();
        for(int i = 0; i < flavors.length; i++)
        {
            DataFlavor flav = flavors[i];
            if(flav.equals(DataFlavor.javaFileListFlavor))
            {
                evt.acceptDrop(evt.getDropAction());
                java.util.List files = null;
                try
                {
                    files = (java.util.List)xfer.getTransferData(flav);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                    evt.dropComplete(false);
                    return;
                }
                for(Iterator it = files.iterator(); it.hasNext(); AddAction.addFile((File)it.next()));
                evt.dropComplete(true);
                return;
            }
        }

        evt.dropComplete(false);
    }
}
