
package chat.vistas;
import chat.controladores.ChatCliente;
import javax.swing.*;

public class GUI_Chat extends JFrame
{
    private JTextArea jTextAreaMensajes;
    private JList jListConectados;
    private JTextField txtMensaje;
    private JButton btnEnviar;
    private JPanel jPanel;
    private ChatCliente chatCliente;    
    
    public GUI_Chat(ChatCliente chatCliente)
    {
        this.chatCliente = chatCliente;
        initComponents();
    }
    
    public void initComponents()
    {
        setBounds(100, 100, 700, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jPanel = new JPanel();
        jPanel.setBounds(0, 0, 680, 580);
        jPanel.setLayout(null);
        
        this.getContentPane().setLayout(null);
        this.getContentPane().add(jPanel);
        
        
        jTextAreaMensajes.setBounds(WIDTH, WIDTH, WIDTH, HEIGHT);
    }
    
}
