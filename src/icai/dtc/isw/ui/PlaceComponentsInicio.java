package icai.dtc.isw.ui;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.server.SocketServer;
import static icai.dtc.isw.ui.JVentana.recuperarInformacion;

import javax.swing.*;
import java.io.Serializable;

public class PlaceComponentsInicio extends JPanel implements Serializable {

        private static int id;
        private static String password;
        private static String IdUsuario;

        public PlaceComponentsInicio(){

        this.setLayout(null);

        final JLabel userLabelLogin = new JLabel("Id");
        userLabelLogin.setBounds(50, 220, 160, 40);
        this.add(userLabelLogin);

        JTextField userTextLogin = new JTextField(20);
        userTextLogin.setBounds(245, 220, 340, 40);
        this.add(userTextLogin);
        IdUsuario = userTextLogin.getText();

        final  JLabel passwordLabelLogin = new JLabel("Password");
        passwordLabelLogin.setBounds(50, 270, 160, 40);
        //passwordLabel.setResizable(true);
        this.add(passwordLabelLogin);

        final  JPasswordField passwordTextLogin = new JPasswordField(20);
        passwordTextLogin.setBounds(245, 270, 340, 40);
        //passwordText.setResizable(true);
        this.add(passwordTextLogin);

        //insertar imagen
        JLabel img = new JLabel(" ");
        ImageIcon Imagen = new ImageIcon("src/main/resources/images/madrimentate2.jpg");
        img.setIcon(Imagen);
        img.setSize(160,160);
        img.setLocation(245,25);
        img.setVisible(true);
        this.add(img);

        //insertar boton registro
        final  JButton btnReg = new JButton("Crear una cuenta");
        btnReg.setBounds(245, 400, 160, 40);
        this.add(btnReg);

        btnReg.addActionListener(actionEvent -> {
            JFrame frameReg = new JFrame("REGISTRO");
            frameReg.setSize(650, 500);
            frameReg.setLocationRelativeTo(null);
            //frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
            frameReg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //JPanel panelReg = new JPanel();
            //frameReg.add(panelReg);
            JPanel registro=new PlaceComponentsRegistro();
            frameReg.add(registro);
            frameReg.setVisible(true);
            frameReg.setResizable(true);

        });

        //insertar boton login
        final  JButton btnInformacion = new JButton("Login");
        btnInformacion.setBounds(245, 350, 160, 40);
        this.add(btnInformacion);


        //Añado el listener al botón
        btnInformacion.addActionListener(actionEvent -> {
            id=Integer.parseInt(userTextLogin.getText());
            password=(passwordTextLogin).toString();
            JFrame framePerfil = new JFrame("PERFIL "+ recuperarInformacion().toUpperCase());
            framePerfil.setSize(650, 300);
            framePerfil.setLocationRelativeTo(null);
            //frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
            framePerfil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //JPanel panel = new JPanel();
            //framePerfil.add(panel);
            JPanel perfil= new PlaceComponentsPerfil();
            framePerfil.add(perfil);
            framePerfil.setVisible(true);
            framePerfil.setResizable(true);

        });

        }
}