

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
/**
 * consumidor
 */
public class consumidor implements Runnable{

    private Pipe pipe;

    public consumidor(Pipe pipe) {
        this.pipe = pipe;
    }

    @Override
    public void run() {
        while (true) {
            Pipe.SourceChannel sourceChannel = pipe.source();
            ByteBuffer buffer = ByteBuffer.allocate(48);
            buffer.clear();

            try {
                
                sourceChannel.read(buffer);
                buffer.rewind();
                System.out.println("Consumidor: " + buffer.getInt());
            } catch (IOException e) {
                e.printStackTrace();
            }

            buffer.flip();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}