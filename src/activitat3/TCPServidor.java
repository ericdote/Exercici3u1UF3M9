package activitat3;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

public class TCPServidor {
    //Inicialitzem el port, ServerSocket, DataOutput i BufferedReader
    static int PORT = 5487;
     ServerSocket serverSocket;
     DataOutputStream outToClient;
     BufferedReader bf;
     /**
      * El constructor li arriba un port.
      * Inicialitza el ServerSocket i li arriba del Client una frase que llegeix.
      * A aquesta cadena li inclueix un string que hem escrit nosaltres i el mostra en un Pane.
      * @param port
      * @throws IOException 
      */
    public TCPServidor(int port) throws IOException {
        //Inicialitzem el ServerSocket
       serverSocket = new ServerSocket(port);
       //Realitzem un bucle
        while (true) {
            //Inicialitzem un Socket
            Socket ss = serverSocket.accept();
            //Inicialitzem DataOutput i BufferedReader
            outToClient = new DataOutputStream(ss.getOutputStream());
            bf = new BufferedReader(new InputStreamReader(ss.getInputStream()));
            //Donem valor a un String amb lo que llegim a la linea del Buffered
            String cadena = bf.readLine();
            //Mostrem per pantalla la cadena de text
            System.out.println(cadena);
            //Mostrem la cadena + un text adicional que hem ficat nosaltres (I ho escribim)
            outToClient.writeBytes(cadena + " desde el Server \n");
            //Mostrem en un Pane la cadena.
            JOptionPane.showMessageDialog(null, cadena);
            
            outToClient.close();
            bf.close();

        }
    }

    public static void main(String[] args) throws IOException {
        new TCPServidor(PORT);
    }
}
