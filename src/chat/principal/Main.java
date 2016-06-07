package chat.principal;

import chat.controladores.ChatCliente;
import chat.controladores.Login;
import chat.utilidades.Usuario;

/**
 *
 * @author Silvana
 */
public class Main 
{
    public static void main(String[] args) {
        //Login l = new Login();
        ChatCliente chatCliente = new ChatCliente(new Usuario("Silvana","1234"));
        
    }
}
