package chat.controladores;

import chat.utilidades.Usuario;
import chat.utilidades.Validador;
import chat.vistas.GUI_Chat;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JOptionPane;

public class ChatCliente 
{
    private String server;
    private int port;
    private Usuario user;
    private GUI_Chat vistaChat;
    private Socket socket;
    private BufferedReader lector;
    private PrintWriter escritor;
    
    /**
     * @param server direccion del server
     * @param port numero de puerto del server
     * @param user Usuario registrador
     */
    public ChatCliente(String server, int port, Usuario user)
    {
        vistaChat = new GUI_Chat(this);
        this.user = user;
        this.server = server;
        this.port = port;
        
        this.start();
        Thread lectorDeMensajes = new Thread(new LectorMensajesServer(vistaChat.getJTextAreaMensajes(),lector));
        lectorDeMensajes.start();
    }
    
    public void start()
    {
        try {
            socket = new Socket(server, port);
            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
            lector = new BufferedReader(streamReader);
            escritor = new PrintWriter(socket.getOutputStream());
            
        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(vistaChat, "No se ha podido establecer la conección");
            vistaChat.dispose();
        }
    }
    
    public void enviar(String msj)
    {
        if (!Validador.validarVacio(msj)) 
        {
            try 
            {
                escritor.println(user.getUsuario()+": "+msj);
                escritor.flush();
            } catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
        vistaChat.getTxtMensaje().setText("");
        vistaChat.getTxtMensaje().requestFocus();
    }
    
    
    
}
