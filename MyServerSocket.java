import java.net.ServerSocket;
import java.io.IOException;

public class MyServerSocket extends ServerSocket {

    public ServerSocket ss;
    public boolean connect;

    // Crea un socket de servidor, vinculado al puerto especificado.
    public MyServerSocket(int port) throws IOException {
        super(port);
    }

    public int getLocalPort() {
        return ss.getLocalPort();
    }

    public boolean isBound(){
        return connect;
    }

    public boolean isClosed(){
        return !connect;
    }

    public MySocket accept() {
        try {
            connect = true;
            return new MySocket(super.accept())
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Tanquem el socket
    public void close() {
        try {
            connect = false;
            ss.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
