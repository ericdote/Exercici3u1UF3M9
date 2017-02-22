package activitat3;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.JOptionPane;


public class TCPCliente {
    
    Socket s;
    DataOutputStream outToServer;
    BufferedReader bf;

    public TCPCliente() throws IOException {
        this.s = new Socket("localhost", 5487);
        outToServer = new DataOutputStream(s.getOutputStream());
        bf = new BufferedReader(new InputStreamReader(s.getInputStream()));
        outToServer.writeBytes("hola \n");
        String cadena = bf.readLine();
        JOptionPane.showMessageDialog(null, cadena);
        outToServer.close();
        bf.close();
        s.close();
    }
    
    
    
}
