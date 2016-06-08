
package chat.vistas;
import chat.controladores.ChatCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class GUI_Chat extends JFrame
{
    private JTextArea jTextAreaMensajes;
    private JList jListConectados;
    private JTextField txtMensaje;
    private JButton btnEnviar;
    private JPanel jPanel;
    private JPanel jPanelMensajes;
    private JPanel jPanelConectados;
    private ChatCliente chatCliente;    
    
    public GUI_Chat(ChatCliente chatCliente)
    {
        this.chatCliente = chatCliente;
        initComponents();
    }
    
    public void initComponents()
    {
        setTitle("Chat v1.0");
        setBounds(100, 100, 700, 530);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jPanel = new JPanel();
        jPanel.setBounds(0, 0, 680, 510);
        jPanel.setLayout(null);
        
        jPanelConectados = new JPanel();
        jPanelConectados.setBounds(10, 10, 260, 410);
        jPanelConectados.setBorder(new TitledBorder("Conectados"));
        jPanelConectados.setLayout(null);
        jPanel.add(jPanelConectados);
        
        jPanelMensajes = new JPanel();
        jPanelMensajes.setBounds(280, 10, 400, 410);
        jPanelMensajes.setBorder(new TitledBorder("Mensajes"));
        jPanelMensajes.setLayout(null);
        jPanel.add(jPanelMensajes);
        
        this.getContentPane().setLayout(null);
        this.getContentPane().add(jPanel);
        
        JList<DefaultListModel> jListConetados = new JList<DefaultListModel>();
        jListConetados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jListConetados.setBounds(10, 20, 240, 380);
        jPanelConectados.add(jListConetados);
        
        jTextAreaMensajes = new JTextArea();
        jTextAreaMensajes.setBounds(10, 20, 380, 380);
        jPanelMensajes.add(jTextAreaMensajes);
        
        txtMensaje = new JTextField();
        txtMensaje.setBounds(280, 430, 200, 25);
        jPanel.add(txtMensaje);
        
        JButton btnEnviar = new JButton("Enviar");
        btnEnviar.setBounds(490,430,90,25);
        jPanel.add(btnEnviar);
        
        btnEnviar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                btnEnviarActionPerformed();
            }
        });
        setVisible(true);
    }
    
    public void btnEnviarActionPerformed()
    {
        chatCliente.enviar(txtMensaje.getText());
    }
    
    public JTextField getTxtMensaje()
    {
        return txtMensaje;
    }
    
    public JTextArea getJTextAreaMensajes()
    {
        return jTextAreaMensajes;
    }
}
