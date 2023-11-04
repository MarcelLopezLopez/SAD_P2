import java.io.IOException;
import java.security.cert.CRLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Handler;

public class Server {
    // Port on s'executarà en servidor
    private static final int PORT = 8080;
    // Diccionari de clients pel seu nick i el seu socket
    private static Map<String, MySocket> clientDictionary = new ConcurrentHashMap<>();
    // Variable boolean per verificar que no hi hagi noms repetits
    public static boolean nomValid = false;

    public static void main(String[] args) {

        MyServerSocket myServerSocket = null;

        try {
            myServerSocket = new MyServerSocket(PORT);

            while (true) {
                MySocket client = myServerSocket.accept();
                // Demanem al client que introdueixi un nom i validem si ja existeix
                while (!nomValid) {
                    client.printLine("Introdueixi el seu nom d'usuari: ");
                    String line = client.readLine();

                    // Busquem al diccionari si existeix algun usuari amb el mateix nom registrat
                    if (clientDictionary.containsKey(line)) {
                        client.printLine("El nom d'usuari " + line + " ja està sent utilitzat");
                    } else {
                        clientDictionary.put(line, client);
                        nomValid = true;
                        client.printLine("Hola " + line + " benvingut, t'has unit correctament al xat");
                        System.out.println(line + " s'ha unit al xat");
                    }
                }
                nomValid = false;
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (myServerSocket != null) {
                myServerSocket.close();
            }
        }
    }

}
