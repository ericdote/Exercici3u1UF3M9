package activitat3;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

public class TCPServidor {
    static int PORT = 5487;

    public TCPServidor(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            Socket ss = serverSocket.accept();

            DataOutputStream outToClient = new DataOutputStream(ss.getOutputStream());
            BufferedReader bf = new BufferedReader(new InputStreamReader(ss.getInputStream()));

            String cadena = bf.readLine();
            System.out.println(cadena);

            outToClient.writeBytes(cadena + " desde el Server \n");
            JOptionPane.showMessageDialog(null, cadena);

            outToClient.close();
            bf.close();

        }
    }

    public static void main(String[] args) throws IOException {
        new TCPServidor(PORT);
    }
}
