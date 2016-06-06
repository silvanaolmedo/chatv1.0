/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.controladores;
import chat.utilidades.*;
import chat.vistas.*;

/**
 *
 * @author Silvana
 */
public class Login 
{
    private GUI_LoginUsuario gui_login;
    private Usuario user;
    
    
    public Login()
    {
        gui_login = new GUI_LoginUsuario(this);
        //gui_login.setVisible(true);
    }
    
    
    
    public void abrirVentanaLogin()
    {
        gui_login.setVisible(true);
    }
    
    public void iniciarSesion()
    {
        
    }
    
    public void registrarUsuario()
    {
        
    }
    
}
