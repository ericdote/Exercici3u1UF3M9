package activitat3;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class TCPCliente {
    
    Socket s;
    DataOutputStream outToServer = new DataOutputStream(s.getOutputStream());
    BufferedReader bf = new BufferedReader(new InputStreamReader(s.getInputStream()));

    public TCPCliente() throws IOException {
        this.s = new Socket("localhost", 5487);
    }
    
    
    
}
