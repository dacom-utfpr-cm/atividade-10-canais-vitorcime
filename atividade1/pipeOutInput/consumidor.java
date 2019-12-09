

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * produtor
 */
public class consumidor implements Runnable {

    PipedInputStream pipein;

    public consumidor(PipedInputStream pipein) {
        this.pipein = pipein;
    }

    @Override
    public void run() {
        int value;
        while (true) {
            try {
                value = pipein.read();
                System.out.println("Consumidor: " + value);
                
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000);    
            } catch (Exception e) {
                //TODO: handle exception
            }
            

        }
    }
}