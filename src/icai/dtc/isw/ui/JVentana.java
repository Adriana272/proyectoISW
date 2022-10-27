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

    private static String IdUsuario;


    public static void main(String[] args) {
        //new JVentana();
        JFrame frame = new JFrame("MADRIMENTATE");
        frame.setSize(650, 500);
        //frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponentsInicio(panel);
        frame.setVisible(true);
        frame.setResizable(true);
        //frame.pack();
    }


    private static void placeComponentsInicio(JPanel panelLogin) {
            panelLogin.setLayout(null);

            final JLabel userLabelLogin = new JLabel("Id");
            userLabelLogin.setBounds(50, 220, 160, 40);
            panelLogin.add(userLabelLogin);

            JTextField userTextLogin = new JTextField(20);
            userTextLogin.setBounds(245, 220, 340, 40);
            panelLogin.add(userTextLogin);
            IdUsuario = userTextLogin.getText();

            final  JLabel passwordLabelLogin = new JLabel("Password");
            passwordLabelLogin.setBounds(50, 270, 160, 40);
            //passwordLabel.setResizable(true);
            panelLogin.add(passwordLabelLogin);

            final  JPasswordField passwordTextLogin = new JPasswordField(20);
            passwordTextLogin.setBounds(245, 270, 340, 40);
            //passwordText.setResizable(true);
            panelLogin.add(passwordTextLogin);

            //insertar imagen
            JLabel img = new JLabel(" ");
            ImageIcon Imagen = new ImageIcon("src/main/resources/images/madrimentate2.jpg");
            img.setIcon(Imagen);
            img.setSize(160,160);
            img.setLocation(245,25);
            img.setVisible(true);
            panelLogin.add(img);

            //insertar boton registro
            final  JButton btnReg = new JButton("Crear una cuenta");
            btnReg.setBounds(245, 400, 160, 40);
            panelLogin.add(btnReg);

            btnReg.addActionListener(actionEvent -> {
                JFrame frameReg = new JFrame("REGISTRO");
                frameReg.setSize(650, 500);
                frameReg.setLocationRelativeTo(null);
                //frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
                frameReg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JPanel panelReg = new JPanel();
                frameReg.add(panelReg);
                placeComponentsRegistro(panelReg);
                frameReg.setVisible(true);
                frameReg.setResizable(true);

            });

            //insertar boton login
            final  JButton btnInformacion = new JButton("Login");
            btnInformacion.setBounds(245, 350, 160, 40);
            panelLogin.add(btnInformacion);


            //Añado el listener al botón
            btnInformacion.addActionListener(actionEvent -> {
                id=Integer.parseInt(userTextLogin.getText());
                password=(passwordTextLogin).toString();
                JFrame framePerfil = new JFrame("PERFIL "+ recuperarInformacion().toUpperCase());
                framePerfil.setSize(650, 300);
                framePerfil.setLocationRelativeTo(null);
                //frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
                framePerfil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JPanel panel = new JPanel();
                framePerfil.add(panel);
                placeComponentsPerfil(panel);
                framePerfil.setVisible(true);
                framePerfil.setResizable(true);

                });

    }

    private static void placeComponentsRegistro(JPanel panelReg) {
        panelReg.setLayout(null);

        final JLabel idLabelReg = new JLabel("Id");
        idLabelReg.setBounds(50, 50, 160, 40);
        panelReg.add(idLabelReg);

        JTextField idTextReg = new JTextField(20);
        idTextReg.setBounds(170, 50, 340, 40);
        panelReg.add(idTextReg);

        final JLabel userLabelReg = new JLabel("Nombre");
        userLabelReg.setBounds(50, 100, 160, 40);
        panelReg.add(userLabelReg);

        JTextField userTextReg = new JTextField(20);
        userTextReg.setBounds(170, 100, 340, 40);
        panelReg.add(userTextReg);

        final JLabel passwordLabelReg = new JLabel("Password");
        passwordLabelReg.setBounds(50, 150, 160, 40);
        //passwordLabel.setResizable(true);
        panelReg.add(passwordLabelReg);

        final JPasswordField passwordTextReg = new JPasswordField(20);
        passwordTextReg.setBounds(170, 150, 340, 40);
        //passwordText.setResizable(true);
        panelReg.add(passwordTextReg);

        //insertar boton registro
        final JButton btnReg2 = new JButton("Registrarme");
        btnReg2.setBounds(245, 220, 160, 40);
        panelReg.add(btnReg2);
    }

    private static void placeComponentsPerfil(JPanel panelperfil) {

        JPanel panelperfilnorte = new JPanel();
        JPanel panelperfilcentro = new JPanel();
        panelperfilcentro.setLayout(new BoxLayout(panelperfilcentro, BoxLayout.Y_AXIS));
        JPanel panelperfilsur= new JPanel(new GridLayout());
        panelperfilsur.setLayout(new java.awt.GridLayout(1,3));

        final JLabel idLabelPerfil = new JLabel("Id:");
        idLabelPerfil.setBounds(50, 220, 160, 40);
        panelperfilcentro.add(idLabelPerfil);

        final JTextField idTextPerfil = new JTextField(20);
        //idTextPerfil.setBounds(260, 220, 340, 40);
        idTextPerfil.setText(IdUsuario);
        panelperfilcentro.add(idTextPerfil);
        idTextPerfil.setEditable(false);

        final  JLabel userLabelPerfil = new JLabel("Nombre:");
        //userLabelPerfil.setBounds(50, 270, 160, 40);
        //passwordLabel.setResizable(true);
        panelperfilcentro.add(userLabelPerfil);

        final  JTextField userTextPerfil = new JTextField(20);
        //userTextPerfil.setBounds(260, 270, 340, 40);
        userTextPerfil.setText(recuperarInformacion());
        userTextPerfil.setEditable(false);
        panelperfilcentro.add(userTextPerfil);

        //insertar imagen
        JLabel img = new JLabel(" ");
        ImageIcon Imagen = new ImageIcon("src/main/resources/images/perfil.png");
        img.setIcon(Imagen);
        img.setSize(160,160);
        //img.setLocation(245,25);
        img.setVisible(true);
        panelperfilnorte.add(img);

        //insertar botones reservas, pedidos, configuracion.
        final JButton btnReservas = new JButton("Mis Reservas");
        //btnReservas.setBounds(245, 220, 160, 40);
        ImageIcon iconoreservas=new ImageIcon("src/main/resources/images/reserva.png");
        btnReservas.setIcon(iconoreservas);
        panelperfilsur.add(btnReservas);

        //Action listener boton reservas
        btnReservas.addActionListener(actionEvent -> {
            JFrame frameRes = new JFrame("RESERVAS");
            frameRes.setSize(650, 300);
            frameRes.setLocationRelativeTo(null);
            //frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
            frameRes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panelRes = new JPanel();
            //placeComponentsReservas(panelRes);
            frameRes.add(panelRes);
            frameRes.setVisible(true);
            frameRes.setResizable(true);

        });

        final JButton btnPedidos = new JButton("Mis Pedidos");
        //btnPedidos.setBounds(245, 220, 160, 40);
        ImageIcon iconopedidos=new ImageIcon("src/main/resources/images/pedido.png");
        btnPedidos.setIcon(iconopedidos);
        panelperfilsur.add(btnPedidos);

        //Action listener boton pedidos
        btnPedidos.addActionListener(actionEvent -> {
            JFrame framePed = new JFrame("PEDIDOS");
            framePed.setSize(650, 300);
            framePed.setLocationRelativeTo(null);
            //frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
            framePed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panelPed = new JPanel();
            //placeComponentsPedidos(panelPed);
            framePed.add(panelPed);
            framePed.setVisible(true);
            framePed.setResizable(true);

        });

        final JButton btnAjustes = new JButton("Ajustes");
        //btnConfig.setBounds(245, 220, 160, 40);
        ImageIcon iconoajustes=new ImageIcon("src/main/resources/images/ajustes.png");
        btnAjustes.setIcon(iconoajustes);
        panelperfilsur.add(btnAjustes);

        //Action listener boton ajustes
        btnAjustes.addActionListener(actionEvent -> {
            JFrame frameAj = new JFrame("AJUSTES");
            frameAj.setSize(650, 300);
            frameAj.setLocationRelativeTo(null);
            //frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
            frameAj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panelAj = new JPanel();
            //placeComponentsAjustes(panelAj);
            frameAj.add(panelAj);
            frameAj.setVisible(true);
            frameAj.setResizable(true);

        });

        panelperfil.add(panelperfilnorte, BorderLayout.NORTH);
        panelperfil.add(panelperfilcentro, BorderLayout.CENTER);
        panelperfil.add(panelperfilsur, BorderLayout.SOUTH);

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