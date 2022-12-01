package icai.dtc.isw.ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.Serializable;

import static icai.dtc.isw.ui.PlaceComponentsInicio.recuperarInformacion;


public class PlaceComponentsPerfil extends JPanel implements Serializable {

     private  int id;
     private  String password;
     private  String IdUsuario;


     public PlaceComponentsPerfil() {
        this.setLayout(null);
        this.setBackground(Color.white);
        /*
        JPanel panelperfilcentro = new JPanel();
        panelperfilcentro.toString();

        //panelperfilcentro.setLayout(new BoxLayout(panelperfilcentro));
        JPanel panelperfilsur= new JPanel(new GridLayout());
        panelperfilsur.setLayout(new java.awt.GridLayout(1,3));

        JPanel panelperfilnorte = new JPanel();
        panelperfilnorte.toString();
        */


        final JLabel idLabelPerfil = new JLabel("Id:");
        idLabelPerfil.setBounds(150, 350, 160, 40);
        idLabelPerfil.setBackground(Color.white);
        idLabelPerfil.setForeground(Color.white);
        this.add(idLabelPerfil);

        final JTextField idTextPerfil = new JTextField(20);
        idTextPerfil.setBounds(320, 350, 340, 40);
        int idperfil = recuperarInformacion().getId();
        idTextPerfil.setText(Integer.toString(idperfil));
        idTextPerfil.setEditable(false);
        this.add(idTextPerfil);


        final  JLabel userLabelPerfil = new JLabel("Nombre:");
        userLabelPerfil.setBounds(150, 400, 160, 40);
        userLabelPerfil.setBackground(Color.white);
        userLabelPerfil.setForeground(Color.white);
        //passwordLabel.setResizable(true);
        this.add(userLabelPerfil);

        final  JTextField userTextPerfil = new JTextField(20);
        userTextPerfil.setBounds(320, 400, 340, 40);
        userTextPerfil.setText(recuperarInformacion().getPw());
        userTextPerfil.setEditable(false);
        this.add(userTextPerfil);


         //insertar imagen
         JLabel imgFondoP = new JLabel(" ");
         ImageIcon ImagenBGP = new ImageIcon("src/main/resources/images/fondopantallaperfil.png");
         imgFondoP.setIcon(ImagenBGP);
         imgFondoP.setSize(800, 900);
         imgFondoP.setLocation(0, 0);
         imgFondoP.setVisible(true);
         this.add(imgFondoP);

        //insertar botones home, reservas, pedidos, configuracion.
         final JButton btnHome = new JButton("Home");
         btnHome.setBounds(300, 510, 200, 60);
         ImageIcon iconohome=new ImageIcon("src/main/resources/images/home.png");
         btnHome.setIcon(iconohome);
         this.add(btnHome);

         //Action listener boton home
         btnHome.addActionListener(actionEvent -> {
             JFrame frameHome = new JFrame("RESTAURANTES");
             frameHome.setSize(800, 900);
             frameHome.setBackground(Color.gray);
             frameHome.setLocationRelativeTo(null);
             //frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
             frameHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             //JPanel panelHome = new PanelRestaurante();
             JPanel panelHome = new PanelesRestaurantes();
             panelHome.setBackground(Color.orange);
             /*
             try{
                 ((PanelesRestaurantes) panelHome).image= ImageIO.read(new File("src/main/resources/images/fondopantallamenu.png"));
             }catch(Exception e){
                 System.out.println(e);
             }*/
             //frameHome.setContentPane(panelHome);
             //placeComponentsAjustes(panelAj);
             frameHome.add(panelHome);
             frameHome.setVisible(true);
             frameHome.setResizable(true);

         });

        final JButton btnReservas = new JButton("Mis Reservas");
        btnReservas.setBounds(300, 580, 200, 60);
        ImageIcon iconoreservas=new ImageIcon("src/main/resources/images/reserva.png");
        btnReservas.setIcon(iconoreservas);
        this.add(btnReservas);

        //Action listener boton reservas
        btnReservas.addActionListener(actionEvent -> {
            JFrame frameRes = new JFrame("RESERVAS");
            frameRes.setSize(800, 900);
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
        btnPedidos.setBounds(300, 650, 200, 60);
        ImageIcon iconopedidos=new ImageIcon("src/main/resources/images/pedido.png");
        btnPedidos.setIcon(iconopedidos);
        this.add(btnPedidos);

        //Action listener boton pedidos
        btnPedidos.addActionListener(actionEvent -> {
            JFrame framePed = new JFrame("PEDIDOS");
            framePed.setSize(800, 900);
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
        btnAjustes.setBounds(300, 720, 200, 60);
        ImageIcon iconoajustes=new ImageIcon("src/main/resources/images/ajustes.png");
        btnAjustes.setIcon(iconoajustes);
        this.add(btnAjustes);

        //Action listener boton ajustes
        btnAjustes.addActionListener(actionEvent -> {
            JFrame frameAj = new JFrame("AJUSTES");
            frameAj.setSize(800, 900);
            frameAj.setLocationRelativeTo(null);
            //frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
            frameAj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panelAj = new PlaceComponentsAjustes();
            frameAj.add(panelAj);
            frameAj.setVisible(true);
            frameAj.setResizable(true);

        });

        /*
        this.add(panelperfilnorte, BorderLayout.NORTH);
        this.add(panelperfilcentro, BorderLayout.CENTER);
        this.add(panelperfilsur, BorderLayout.SOUTH);
        */
   }
}
