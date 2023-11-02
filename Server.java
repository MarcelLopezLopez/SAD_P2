import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    // Port on s'executarà en servidor
    private static final int PORT = 8080;
    // Diccionari de clients pel seu nick i el seu socket
    private static Map<String, MySocket> clientDictionary = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        try(MyServerSocket myServerSocket = new MyServerSocket(PORT)){

            while(true){

            }
            
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
