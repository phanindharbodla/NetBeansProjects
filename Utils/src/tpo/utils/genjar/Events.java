

package tpo.utils.genjar;

import java.util.Observable;

public class Events extends Observable
{

    private Events()
    {
    }

    public void post(Object evt)
    {
        setChanged();
        notifyObservers(evt);
    }

    public static final Events ADD = new Events();
    public static final Events REM = new Events();
    public static final Events SELECT = new Events();
    public static final Events MAIN_CLASS = new Events();

}
