package atividade1.pipe;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.util.Random;
/**
 * escritor
 */
public class produtor implements Runnable{

    Pipe pipe;
    Random random;

    public produtor(Pipe pipe) {
        this.pipe = pipe;
        
    }

    @Override
    public void run() {
        while (true) {

            Pipe.SinkChannel sinkChannel = pipe.sink(); 

            ByteBuffer buffer = ByteBuffer.allocate(16);
            buffer.clear();
            buffer.putInt(random.nextInt(1000));
            buffer.flip();

            while (buffer.hasRemaining()) {
                try {
                    sinkChannel.write(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}