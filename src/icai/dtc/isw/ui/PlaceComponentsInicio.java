package icai.dtc.isw.ui;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.dao.CustomerDAO;
import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.Usuario;
import icai.dtc.isw.server.SocketServer;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.net.URL;
import java.util.HashMap;

public class PlaceComponentsInicio extends JPanel implements Serializable {

        private static int id;
        private static String password;
        private static String IdUsuario;
        private static JTextField userTextLogin;

        public Image imagenfondo;
        public URL fondo;

        public PlaceComponentsInicio() {

            this.setLayout(null);

            this.setBackground(Color.darkGray);

            final JLabel userLabelLogin = new JLabel("Id");
            userLabelLogin.setBounds(50, 220, 160, 40);
            this.add(userLabelLogin);

            userTextLogin = new JTextField(20);
            userTextLogin.setBounds(245, 220, 340, 40);
            this.add(userTextLogin);
            IdUsuario = userTextLogin.getText();

            final JLabel passwordLabelLogin = new JLabel("Password");
            passwordLabelLogin.setBounds(50, 270, 160, 40);
            //passwordLabel.setResizable(true);
            this.add(passwordLabelLogin);

            final JTextField/*JPasswordField*/ passwordTextLogin = new JPasswordField(20);
            passwordTextLogin.setBounds(245, 270, 340, 40);
            //passwordText.setResizable(true);
            this.add(passwordTextLogin);

            //insertar imagen
            JLabel img = new JLabel(" ");
            ImageIcon Imagen = new ImageIcon("src/main/resources/images/madrimentate2.jpg");
            img.setIcon(Imagen);
            img.setSize(160, 160);
            img.setLocation(245, 25);
            img.setVisible(true);
            this.add(img);

            //insertar boton registro
            final JButton btnReg = new JButton("Crear una cuenta");
            btnReg.setBounds(245, 400, 160, 40);
            this.add(btnReg);

            btnReg.addActionListener(actionEvent -> {
                JFrame frameReg = new JFrame("REGISTRO");
                frameReg.setSize(650, 500);
                frameReg.setLocationRelativeTo(null);
                //frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
                frameReg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JPanel panelReg = new JPanel();
                frameReg.add(panelReg);
                JPanel registro = new PlaceComponentsRegistro();
                frameReg.add(registro);
                frameReg.setVisible(true);
                frameReg.setResizable(true);


            });

            //frame=800, 900

            //insertar boton login
            final JButton btnInformacion = new JButton("Login");
            btnInformacion.setBounds(245, 350, 160, 40);
            this.add(btnInformacion);


            //Añado el listener al botón
            btnInformacion.addActionListener(actionEvent -> {
                Customer cu=recuperarInformacion();
                if ((cu.getId()==(Integer.parseInt(userTextLogin.getText()))/*&&(cu.getPw()== (passwordTextLogin.getText()))*/)) {
                    id = Integer.parseInt(userTextLogin.getText());
                    System.out.println("He leido este id: " + id);
                    password = (passwordTextLogin).toString();
                    System.out.println("He leido esta contraseña: " + password);
                    JFrame framePerfil = new JFrame("PERFIL " + (cu.getPw()).toUpperCase());
                    framePerfil.setSize(750, 300);
                    framePerfil.setLocationRelativeTo(null);
                    //frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
                    framePerfil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    //JPanel panel = new JPanel();
                    //framePerfil.add(panel);
                    JPanel perfil = new PlaceComponentsPerfil();
                    framePerfil.add(perfil);
                    framePerfil.setVisible(true);
                    framePerfil.setResizable(true);

                } else {
                    JOptionPane.showMessageDialog(null, "No existe ningún usuario registrado con dichas credenciales");
                }

            });
            }
            public static Customer recuperarInformacion() {
                Client cliente = new Client();
                HashMap<String, Object> session = new HashMap<>();
                String context = "/getCustomer";
                System.out.println("userRI: "+userTextLogin.getText());
                session.put("id", Integer.parseInt(userTextLogin.getText()));
                session.put("password", password);
                session = cliente.sentMessage(context, session);
                Customer cu = (Customer) session.get("Customer");
                return cu;
            }

            public void paintComponent(Graphics g){
                g.drawImage(imagenfondo, 0, 0, getWidth(), getHeight(), null);
            }


}