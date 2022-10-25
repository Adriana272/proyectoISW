package icai.dtc.isw.ui;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.domain.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;


public class JVentana extends JFrame {
    private static int id;
    private static String password;


    public static void main(String[] args) {
        //new JVentana();
        JFrame frame = new JFrame("Madrimentate");
        frame.setSize(500, 250);
        //frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);
        frame.setResizable(true);
        //frame.pack();
    }

    //public int id;
    //public String password;
   //public JVentana() {
    private static void placeComponents(JPanel panel) {
            panel.setLayout(null);

            final JLabel userLabel = new JLabel("User");
            userLabel.setBounds(10, 10, 80, 25);
            panel.add(userLabel);

            JTextField userText = new JTextField(20);
            userText.setBounds(100, 10, 160, 25);
            panel.add(userText);

            final  JLabel passwordLabel = new JLabel("Password");
            passwordLabel.setBounds(10, 40, 80, 25);
            panel.add(passwordLabel);

            final  JPasswordField passwordText = new JPasswordField(20);
            passwordText.setBounds(100, 40, 160, 25);
            panel.add(passwordText);

            //insertar imagen
            JLabel label= new JLabel();
           // label.setIcon(new ImageIcon("src/main/resources/images"));
            /*ImageIcon icono = new javax.swing.ImageIcon(getClass().getResource("main/resources/images/madrimentate.jpg"));
            Image imagen = icono.getImage();
            ImageIcon iconoEscalado = new ImageIcon (imagen.getScaledInstance(100,100,Image.SCALE_SMOOTH));
            label.setIcon(iconoEscalado);*/
            
            //insertar boton

            final  JButton btnInformacion = new JButton("login");
            btnInformacion.setBounds(10, 80, 80, 25);

            panel.add(btnInformacion);

            JLabel lblResultado = new JLabel("El usuario correspondiente a las credenciales es: ", SwingConstants.CENTER);
            JTextField txtResultado = new JTextField();
            txtResultado.setBounds(new Rectangle(100, 80, 160, 25));
            txtResultado.setEditable(false);
            //txtResultado.setResizable(true);
            //txtResultado.setVerticalAlignment(JTextField.SOUTH);;
            panel.add(lblResultado);
            panel.add(txtResultado);

            //Añado el listener al botón
            btnInformacion.addActionListener(actionEvent -> {
                id=Integer.parseInt(userText.getText());
                password=(passwordText).toString();
                txtResultado.setText(recuperarInformacion());
                });

            }

    private static String recuperarInformacion() {
        Client cliente=new Client();
        HashMap<String,Object> session=new HashMap<>();
        String context="/getCustomer";
        session.put("id",id);
        session.put("password", password);
        session=cliente.sentMessage(context,session);
        Customer cu=(Customer)session.get("Customer");
        return cu.getName();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

        /*super("MADRIMENTATE");
        this.setLayout(new BorderLayout());
        //Pongo un panel arriba con el título
        JPanel pnlNorte = new JPanel();
        JLabel lblTitulo = new JLabel("LOGIN", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Courier", Font.BOLD, 20));
        pnlNorte.add(lblTitulo);
        this.add(pnlNorte, BorderLayout.NORTH);*/

/*
        //Pongo el panel central el botón
        JPanel pnlCentro = new JPanel();
        JLabel lblId = new JLabel("Usuario", SwingConstants.CENTER);
        JButton btnInformacion = new JButton("Enter");
        JTextField txtId = new JTextField();
        txtId.setBounds(new Rectangle(250,150,150,250));
        //txtId.setVerticalAlignment(JTextField.CENTER);
        pnlCentro.add(lblId);
        pnlCentro.add(txtId);
        JLabel lblPw = new JLabel("Password", SwingConstants.CENTER);
        JTextField txtPw = new JTextField();
        txtPw.setBounds(new Rectangle(250,150,150,250));
        //txtPw.setVerticalAlignment(JTextField.CENTER);
        pnlCentro.add(lblPw);
        pnlCentro.add(txtPw);
        pnlCentro.add(btnInformacion);
        pnlCentro.setLayout(new BoxLayout(pnlCentro, BoxLayout.	X_AXIS));
        this.add(pnlCentro, BorderLayout.CENTER);

        //El Sur lo hago para recoger el resultado
        JPanel pnlSur = new JPanel();
        JLabel lblResultado = new JLabel("El usuario correspondiente a las credenciales es: ", SwingConstants.CENTER);
        JTextField txtResultado = new JTextField();
        txtResultado.setBounds(new Rectangle(250,150,250,150));
        txtResultado.setEditable(false);
        //txtResultado.setVerticalAlignment(JTextField.SOUTH);;
        pnlSur.add(lblResultado);
        pnlSur.add(txtResultado);

        //Añado el listener al botón
        btnInformacion.addActionListener(actionEvent -> {
            id=Integer.parseInt(txtId.getText());
            password=(txtPw.getText()).toString();
            txtResultado.setText(recuperarInformacion());

        });
        pnlSur.setLayout(new BoxLayout(pnlSur, BoxLayout.X_AXIS));
        this.add(pnlSur,BorderLayout.SOUTH);
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        //this.setVerticalAlignment(JLabel.CENTER);
        this.setSize(700,700);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

 */
/*
    public String recuperarInformacion() {
        Client cliente=new Client();
        HashMap<String,Object> session=new HashMap<>();
        String context="/getCustomer";
        session.put("id",id);
        session.put("password", password);
        session=cliente.sentMessage(context,session);
        Customer cu=(Customer)session.get("Customer");
        return cu.getName();
    }

 */

