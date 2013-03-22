
package tpo.utils.genjar;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.dnd.DropTarget;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.DefaultListCellRenderer;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.ListModel;


public class EntryList
    implements Observer
{
    private class PopupListener extends MouseAdapter
    {

        public void mousePressed(MouseEvent e)
        {
            int ix = _list.locationToIndex(e.getPoint());
            if(e.getButton() == 3 && !_list.isSelectedIndex(ix))
                _list.setSelectedIndex(ix);
        }

        public void mouseReleased(MouseEvent e)
        {
            maybeShowPopup(e);
        }

        private void maybeShowPopup(MouseEvent e)
        {
            FileEntry selEnts[] = getSelectedEntries();
            boolean canShow = selEnts.length == 1 && selEnts[0].toString().endsWith(".class");
            if(e.isPopupTrigger())
            {
                _mcAction.setEnabled(canShow);
                _pop.show(e.getComponent(), e.getX(), e.getY());
            }
        }

        private final JPopupMenu _pop;

        public PopupListener(JPopupMenu pop)
        {
            _pop = pop;
        }
    }

    private class EntryRenderer extends DefaultListCellRenderer
    {

        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
        {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if(value.equals(Data.INSTANCE.getMainClassEnt()))
                setFont(BOLD);
            else
                setFont(PLAIN);
            return this;
        }

        private static final long serialVersionUID = 1L;
        private final Font PLAIN = getFont();
        private final Font BOLD = getFont().deriveFont(1);

        EntryRenderer()
        {
        }
    }


    public EntryList(ListModel model)
    {
        _list = new JList(model);
        _list.setDropTarget(new DropTarget(_list, new DropHandler()));
        _list.setCellRenderer(new EntryRenderer());
        _list.getActionMap().put("delete", new RemoveAction(this));
        KeyStroke delKs = KeyStroke.getKeyStroke(127, 0);
        _list.getInputMap().put(delKs, "delete");
        _list.addMouseListener(new PopupListener(mkPopup()));
        Events.MAIN_CLASS.addObserver(this);
        Events.SELECT.addObserver(this);
    }

    private JPopupMenu mkPopup()
    {
        JPopupMenu jpm = new JPopupMenu();
        jpm.add(_mcAction);
        return jpm;
    }

    public JComponent getComponent()
    {
        JScrollPane jsp = new JScrollPane(_list);
        return jsp;
    }

    public FileEntry[] getSelectedEntries()
    {
        int ixs[] = _list.getSelectedIndices();
        FileEntry selEnts[] = new FileEntry[ixs.length];
        for(int i = 0; i < ixs.length; i++)
            selEnts[i] = (FileEntry)_list.getModel().getElementAt(ixs[i]);

        return selEnts;
    }

    public void update(Observable o, Object arg)
    {
        if(o == Events.MAIN_CLASS)
            _list.repaint();
        else
        if(o == Events.SELECT)
        {
            final java.util.List selEnts = (java.util.List)arg;
            EventQueue.invokeLater(new Runnable() {

                public void run()
                {
                    if(selEnts != null)
                    {
                        _list.requestFocusInWindow();
                        _list.setSelectedIndices(getIx(selEnts));
                    } else
                    {
                        _list.clearSelection();
                    }
                }

                private int[] getIx(java.util.List fEnts)
                {
                    ListModel lm = _list.getModel();
                    Hashtable hTab = new Hashtable();
                    for(int i = 0; i < lm.getSize(); i++)
                    {
                        Integer key = new Integer(lm.getElementAt(i).hashCode());
                        hTab.put(key, new Integer(i));
                    }

                    int ixs[] = new int[fEnts.size()];
                    for(int i = 0; i < ixs.length; i++)
                    {
                        Integer key = new Integer(fEnts.get(i).hashCode());
                        int ix = ((Integer)hTab.get(key)).intValue();
                        ixs[i] = ix;
                    }

                    Arrays.sort(ixs);
                    return ixs;
                }

            });
        }
    }

    private final JList _list;
    private final Action _mcAction = new MainClassAction(this);


}
