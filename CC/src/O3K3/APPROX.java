package O3K3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Phanindhar Bodla
 */
class APPROX{

    public static BufferedReader readerObj = new BufferedReader(new InputStreamReader(System.in));
    static int denom = 33102;
    static int remainder =  103993 % denom;
    public static void main(String[] args) throws IOException{
        int testcases;
        testcases = Integer.parseInt(readerObj.readLine());
        while (testcases != 0) {
            testcases--;
            int offset = Integer.parseInt(readerObj.readLine());
            if (offset == 0) {
                System.out.println("3");
                continue;
            }
            int bufferModulus = remainder;
            System.out.print("3.");
            while (offset != 0) {
                offset--;
                bufferModulus *= 10;
                System.out.print(bufferModulus / denom);
                bufferModulus %= denom;
            }
            System.out.println();
        }
    }
}