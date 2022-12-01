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
            //this.setBackground(Color.red);

            final JLabel userLabelLogin = new JLabel("Id");
            userLabelLogin.setBounds(150, 350, 160, 40);
            this.add(userLabelLogin);

            userTextLogin = new JTextField(20);
            userTextLogin.setBounds(320, 350, 340, 40);
            this.add(userTextLogin);
            IdUsuario = userTextLogin.getText();

            final JLabel passwordLabelLogin = new JLabel("Password");
            passwordLabelLogin.setBounds(150, 400, 160, 40);
            //passwordLabel.setResizable(true);
            this.add(passwordLabelLogin);

            final JTextField/*JPasswordField*/ passwordTextLogin = new JPasswordField(20);
            passwordTextLogin.setBounds(320, 400, 340, 40);
            //passwordText.setResizable(true);
            this.add(passwordTextLogin);

            //insertar imagen
            JLabel imgfondoi = new JLabel(" ");
            ImageIcon Imagenfondoi = new ImageIcon("src/main/resources/images/fondoiniciodefinitivo.png");
            imgfondoi.setIcon(Imagenfondoi);
            imgfondoi.setSize(800, 900);
            imgfondoi.setLocation(0, 0);
            imgfondoi.setVisible(true);
            this.add(imgfondoi);

            //insertar imagen
            JLabel img = new JLabel(" ");
            ImageIcon Imagen = new ImageIcon("src/main/resources/images/madrimentate_logo-removebg-previewBIG(1).png");
            img.setIcon(Imagen);
            img.setSize(350, 230);
            img.setLocation(225, 70);
            img.setVisible(true);
            this.add(img);

            //insertar boton registro
            final JButton btnReg = new JButton("Crear cuenta");
            btnReg.setBounds(300, 580, 200, 60);
            ImageIcon iconoregistro=new ImageIcon("src/main/resources/images/registroboton.png");
            btnReg.setIcon(iconoregistro);
            this.add(btnReg);
            //btnReg.repaint(300, 580, 200, 60);

            btnReg.addActionListener(actionEvent -> {
                JFrame frameReg = new JFrame("REGISTRO");
                frameReg.setSize(800, 900);
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
            btnInformacion.setBounds(300, 500, 200, 60);
            ImageIcon iconologin=new ImageIcon("src/main/resources/images/login.png");
            btnInformacion.setIcon(iconologin);
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
                    framePerfil.setSize(800, 900);
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

            repaint();
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