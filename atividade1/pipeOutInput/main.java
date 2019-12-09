

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * main
 */
public class main {

    public static void main(String[] args) throws IOException{
        PipedOutputStream pipeout = new PipedOutputStream();
        PipedInputStream pipein = new PipedInputStream(pipeout, 1);

        new Thread(new produtor(pipeout)).start();
        new Thread(new consumidor(pipein)).start();
    }
}