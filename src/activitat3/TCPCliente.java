package activitat3;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.JOptionPane;

public class TCPCliente {
    //Declarem el HOST i el PORT
    static String HOST = "localhost";
    static int PORT = 5487;
    //Inicialitzem el DataOutput i el BufferReader
    DataOutputStream outToServer;
    BufferedReader bf;
    /**
     * Constructor que li arriba un host i un port.
     * S'inicialitza el Socket, s'escriu i s'envia una frase al server.
     * @param host
     * @param port
     * @throws IOException 
     */
    public TCPCliente(String host, int port) throws IOException {
        //Inicializa el Socket
        Socket ss = new Socket(host, port);
        //Inicializamos el DataOutput i el BufferedReader
        outToServer = new DataOutputStream(ss.getOutputStream());
        bf = new BufferedReader(new InputStreamReader(ss.getInputStream()));
        //Escribimos en el DataOutput una frase
        outToServer.writeBytes("Hola  \n");
        //Leemos la linea que nos llega del BufferedReader
        String cadena = bf.readLine();
        //La mostramos
        System.out.println(cadena);
        //La mostramos en un Pane
        JOptionPane.showMessageDialog(null, cadena);

        outToServer.close();
        bf.close();
        ss.close();
    }

    public static void main(String[] args) throws IOException {
        new TCPCliente(HOST, PORT);

    }

}
