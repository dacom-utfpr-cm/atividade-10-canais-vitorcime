
import java.nio.channels.Pipe;
/**
 * main
 */
public class main {

    public static void main(String[] args) {
        try {
            Pipe pipe = Pipe.open();

            produtor p = new produtor(pipe);
            consumidor c = new consumidor(pipe);

            new Thread(p).start();
            new Thread(c).start();
        } catch (Exception e) {
            System.out.println("Erro no main");
        }
    }
}