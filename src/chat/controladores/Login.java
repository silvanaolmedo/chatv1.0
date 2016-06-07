package chat.controladores;

import chat.modelos.ModelLogin;
import chat.utilidades.*;
import chat.vistas.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Silvana
 */
public class Login 
{
    private GUI_LoginUsuario gui_login;
    private Usuario user;
    private ModelLogin modelLogin;
    
    
    public Login()
    {
        gui_login = new GUI_LoginUsuario(this);
        //gui_login.setVisible(true);
    }
    
    
    
    public void abrirVentanaLogin()
    {
        gui_login.setVisible(true);
    }
    
    public void iniciarSesion(String usuario, String password)
    {
        boolean validacionOk = true;
        if (Validador.validarVacio(usuario)) 
        {
            JOptionPane.showMessageDialog(gui_login, "El usuario no puede ser vacío");
            validacionOk = false;
            return;
        }
        
        if (Validador.validarVacio(password)) 
        {
            JOptionPane.showMessageDialog(gui_login, "La contraseña no puede estar vacía");
            validacionOk = false;
            return;
        }
        
        if (true) {
            
        }
        
        if (validacionOk) {
            
        }
        
        
    }
    
    public void registrarUsuario()
    {
        
    }
    
}
