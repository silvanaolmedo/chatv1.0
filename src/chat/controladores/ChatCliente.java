package chat.controladores;

import chat.utilidades.Usuario;
import chat.utilidades.Validador;
import chat.vistas.GUI_Chat;

public class ChatCliente 
{
    private Usuario user;
    private GUI_Chat vistaChat;
    
    public ChatCliente(Usuario user)
    {
        vistaChat = new GUI_Chat(this);
        this.user = user;
    }
    
    public void enviar(String msj)
    {
        boolean validacionOk = true;
        if (Validador.validarVacio(msj)) 
        {
            
        }
    }
    
    
}
