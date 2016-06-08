
package chat.controladores;

import java.io.BufferedReader;
import javax.swing.JTextArea;

public class LectorMensajesServer implements Runnable
{    
    private BufferedReader lector;
    private JTextArea mensajes;
    
    public LectorMensajesServer(JTextArea mensajes, BufferedReader lector)
    {
        this.mensajes = mensajes;
        this.lector = lector;
    }

    @Override
    public void run() 
    {
        String msj;
        try 
        {
            while ((msj = lector.readLine()) != null) 
            {                
                mensajes.append(msj+"\n");
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
