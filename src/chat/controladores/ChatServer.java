package chat.controladores;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

/**
 *
 * @author Silvana
 */
public class ChatServer implements Runnable
{
    private Socket clientSocket;
    private ServerSocket serverSocket;
    private BufferedReader lector;
    private PrintWriter escritor;
    private int port;
    private ArrayList clientes;
    
    public ChatServer(int port)
    {
        
        this.port = port;
    }
    
    public void start()
    {
        clientes = new ArrayList();
        try {
            serverSocket = new ServerSocket(port);
            
            while (true) 
            {                
                clientSocket = serverSocket.accept();
                escritor = new PrintWriter(clientSocket.getOutputStream());
                clientes.add(escritor);
                
                
                Thread threadServer = new Thread(this);
                InputStreamReader input = new InputStreamReader(clientSocket.getInputStream());
                lector = new BufferedReader(input);
                threadServer.start();
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void run() 
    {
        String msj;
        try {
            while((msj = lector.readLine()) != null)
            {
                avisarleATodos(msj);
            }
        } catch (Exception e) {
        }
    }
    
    public void avisarleATodos(String msj)
    {
        Iterator it = clientes.iterator();
        while (it.hasNext()) 
        {
            try 
            {
                escritor = (PrintWriter) it.next();
                escritor.println(msj);
                escritor.flush();
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
            
        }
    }
    
    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer(5000);
    }
    
}
