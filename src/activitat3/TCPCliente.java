package activitat3;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.JOptionPane;


public class TCPCliente {
    static String HOST = "localhost";
    static int PORT = 5487;
    

    public TCPCliente(String host, int port) throws IOException{
        Socket ss = new Socket(host, port);
        
        DataOutputStream outToServer = new DataOutputStream(ss.getOutputStream());
        BufferedReader bf = new BufferedReader (new InputStreamReader(ss.getInputStream()));
                        
        outToServer.writeBytes("Hola  \n");        
        
        String cadena = bf.readLine();
        System.out.println(cadena);
        JOptionPane.showMessageDialog(null, cadena);
        
        outToServer.close();
        bf.close();
        ss.close();
    }
    
   public static void main(String[] args) throws IOException {
        new TCPCliente(HOST, PORT);
        
    }
    
    
    
}
