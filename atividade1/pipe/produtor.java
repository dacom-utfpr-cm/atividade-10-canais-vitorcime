
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
        this.random = new Random();
    }

    @Override
    public void run() {
        Pipe.SinkChannel sinkChannel = pipe.sink(); 
        ByteBuffer buffer = ByteBuffer.allocate(48);
        
        while (true) {

            buffer.clear();
            int i = random.nextInt(5000);
            buffer.putInt(i);
            System.out.println("Produtor: " + i);
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