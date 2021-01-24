
import java.io.*;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadServer extends Thread {
    private Socket socket;
 private ObjectInputStream in;
 private ObjectOutputStream out;

    
    public ThreadServer(Socket s) throws IOException, ClassNotFoundException {
        socket = s;
        in = new ObjectInputStream(socket.getInputStream());
        out = new ObjectOutputStream(socket.getOutputStream());

        start();
    }

    public void run() {
        Integer idOperation;
        ServerWork obj = new ServerWork(out, in);
        try {
            while (true) {
                String bufString = (String) in.readObject();
                if (bufString.equals("END")) {
                    System.out.println("Сервер отсоединен от базы данных");
                    break;
                }
                idOperation = Integer.parseInt(bufString);
                obj.getId(idOperation);
            }
            System.out.println("Клиент был отсоединен");
        }
        catch (IOException | ClassNotFoundException ex) {
            System.err.println("IO Exception");
        } catch (SQLException ex) {
            Logger.getLogger(ThreadServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                socket.close();
            }
            catch (IOException ex) {
                System.err.println("Socket not closed");
            }
        }
    }
}
