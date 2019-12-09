
import java.nio.channels.Pipe;
/**
 * main
 */
public class main {

    public static void main(String[] args) {
        try {
            Pipe pipe = Pipe.open();    
            
            new Thread(new produtor(pipe)).start();
            new Thread(new consumidor(pipe)).start();
            
        } catch (Exception e) {
            System.out.println("Erro no main");
        }
    }
}