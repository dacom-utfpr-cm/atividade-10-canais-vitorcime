


import java.io.IOException;
import java.io.PipedOutputStream;
import java.util.Random;

/**
 * produtor
 */
public class produtor implements Runnable {

    PipedOutputStream pipeout;

    public produtor(PipedOutputStream pipeout) {
        this.pipeout = pipeout;
    }

    @Override
    public void run() {
        Random r = new Random();
        while (true) {
            try {
                pipeout.write(r.nextInt(5000));
                
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