package icai.dtc.isw.ui;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

import static icai.dtc.isw.ui.PlaceComponentsInicio.recuperarInformacion;


public class PlaceComponentsPerfil extends JPanel implements Serializable {

     private  int id;
     private  String password;
     private  String IdUsuario;


     public PlaceComponentsPerfil() {

        JPanel panelperfilcentro = new JPanel();
        panelperfilcentro.toString();

        panelperfilcentro.setLayout(new BoxLayout(panelperfilcentro, BoxLayout.Y_AXIS));
        JPanel panelperfilsur= new JPanel(new GridLayout());
        panelperfilsur.setLayout(new java.awt.GridLayout(1,3));

        JPanel panelperfilnorte = new JPanel();
        panelperfilnorte.toString();


        final JLabel idLabelPerfil = new JLabel("Id:");
        idLabelPerfil.setBounds(50, 220, 160, 40);
        panelperfilcentro.add(idLabelPerfil);

        final JTextField idTextPerfil = new JTextField(20);
        //idTextPerfil.setBounds(260, 220, 340, 40);
         int idperfil = recuperarInformacion().getId();
        idTextPerfil.setText(Integer.toString(idperfil));
        idTextPerfil.setEditable(false);
        panelperfilcentro.add(idTextPerfil);


        final  JLabel userLabelPerfil = new JLabel("Nombre:");
        //userLabelPerfil.setBounds(50, 270, 160, 40);
        //passwordLabel.setResizable(true);
        panelperfilcentro.add(userLabelPerfil);

        final  JTextField userTextPerfil = new JTextField(20);
        //userTextPerfil.setBounds(260, 270, 340, 40);
        userTextPerfil.setText(recuperarInformacion().getPw());
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

        this.add(panelperfilnorte, BorderLayout.NORTH);
        this.add(panelperfilcentro, BorderLayout.CENTER);
        this.add(panelperfilsur, BorderLayout.SOUTH);
   }
}
