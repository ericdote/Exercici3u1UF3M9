package activitat3;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServidor {

    int port = 5487;
    ServerSocket ss;

    public TCPServidor() throws IOException {
        this.ss = new ServerSocket(port);
        Socket accept = ss.accept();
        DataOutputStream outToClient = new DataOutputStream(accept.getOutputStream());
        BufferedReader bf = new BufferedReader(new InputStreamReader(accept.getInputStream()));

    }

}