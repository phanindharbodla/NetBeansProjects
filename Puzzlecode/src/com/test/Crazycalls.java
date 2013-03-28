package com.test;

import java.io.IOException;

/**
 *
 * @author Phanindhar Bodla
 */
public class Crazycalls {
    public static void main(String args[]) throws IOException
    {
    boolean b=true;
    System.out.println("Lets do some crazy things ..!! Like Opening Eclipse here..!!");
    String myShellScript="C:\\juno\\eclipse.exe -data  D:\\workspaces\\eclipse\\TPO_7720  -vmargs -Xms1024m -Xmx1024m -XX:MaxPermSize=128m";
    Runtime.getRuntime().exec(myShellScript);
    b=!b;
    System.out.println(" "+(b));
    
}

}
