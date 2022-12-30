package icai.dtc.isw.ui;

import icai.dtc.isw.dao.ConnectionDAO;
import icai.dtc.isw.dao.CustomerDAO;
import icai.dtc.isw.domain.Restaurante;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class PlaceComponentsAsi extends JPanel implements Serializable {


    private JVentana jVentanaMadrimentate;
    public ArrayList<Restaurante> restencasi;
    public ArrayList<String> nombresasi;

    public int idrestauranteAs;


    public PlaceComponentsAsi(/*JVentana jVentanaMadrimentate*/) {

        this.jVentanaMadrimentate = jVentanaMadrimentate;
        this.setLayout(null);
        this.setBackground(Color.lightGray);

        //insertar imagen
        JLabel imgFondoAs = new JLabel(" ");
        ImageIcon ImagenAs = new ImageIcon("src/main/resources/images/asi.jpg");
        imgFondoAs.setIcon(ImagenAs);
        imgFondoAs.setSize(800, 200);
        imgFondoAs.setLocation(0, 0);
        imgFondoAs.setVisible(true);
        this.add(imgFondoAs);

        restencasi = CustomerDAO.fetchRestaurantesxTipoComida("asiatica");
        System.out.println(restencasi);
        nombresasi = CustomerDAO.fetchNameRestaurantesxTipoComida("asiatica");
        System.out.println(nombresasi);
        System.out.println(CustomerDAO.fetchRestaurantes());

        JLabel labelAsi=new JLabel("ASIA");
        labelAsi.setFont(new Font("Arial Black", Font.BOLD, 30));
        labelAsi.setBounds(350, 20, 400, 200);
        this.add(labelAsi);

        final JTextArea restaurants = new JTextArea();
        restaurants.setBounds(100, 250, 600, 400);
        //platosTextField.setFont(Font.getFont(Font.SANS_SERIF));
        //restaurants.setBackground(Color.lightGray);
        //for(String cancion: relespaniola){
        System.out.println(restencasi);
        System.out.println("ATM");
        for(int i=0; i<(restencasi.toArray().length); i++) {
            restaurants.append("* "+((restencasi.toArray())[i]).toString());
            restaurants.append("\n");

        }
        restaurants.setEditable(false);
        this.add(restaurants);

        JButton btnReservarAs=new JButton("Reservar Mesa");
        btnReservarAs.setFont(new Font("Arial Black", Font.BOLD, 11));
        btnReservarAs.setBounds(160, 750, 200, 60);
        ImageIcon iconoRMAs=new ImageIcon("src/main/resources/images/reserva.png");
        btnReservarAs.setIcon(iconoRMAs);
        btnReservarAs.setBackground(Color.white);

        btnReservarAs.addActionListener(actionEvent -> {
            Object opcion= JOptionPane.showInputDialog(this, "¿En qué restaurante desea reservar mesa?", "Elegir", JOptionPane.QUESTION_MESSAGE, null, nombresasi.toArray(), nombresasi.toArray()[0]);
            String opcionelegida=opcion.toString();
            System.out.println(opcionelegida);

            JFrame Reserva=new JFrame(opcionelegida);
            Reserva.setSize(800, 900);
            Reserva.setBackground(Color.lightGray);
            Reserva.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Reserva.setLocationRelativeTo(null);
            JPanel r=new PanelReservarMesa();
            Reserva.add(r);
            //Reserva.add(jVentanaMadrimentate.inVentanaReserva());
            //this.jVentanaMadrimentate.inVentanaReserva();
            Reserva.setVisible(true);
            Reserva.setResizable(true);
        });


        JButton btnPedirAs=new JButton("A domicilio");
        btnPedirAs.setFont(new Font("Arial Black", Font.BOLD, 11));
        btnPedirAs.setBounds(440, 750, 200, 60);
        ImageIcon iconoADAs=new ImageIcon("src/main/resources/images/pedido.png");
        btnPedirAs.setIcon(iconoADAs);
        btnPedirAs.setBackground(Color.white);

        btnPedirAs.addActionListener(actionEvent -> {
            Object opcion= JOptionPane.showInputDialog(this, "¿En qué restaurante desea reservar mesa?", "Elegir", JOptionPane.QUESTION_MESSAGE, null, nombresasi.toArray(), nombresasi.toArray()[0]);
            String opcionelegida=opcion.toString();
            System.out.println(opcionelegida);

            idrestauranteAs= CustomerDAO.fetchIdRestaurantexNombre(opcionelegida);
            System.out.println(idrestauranteAs);

            JFrame Carta=new JFrame(opcionelegida);
            Carta.setSize(800, 900);
            Carta.setBackground(Color.lightGray);
            Carta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Carta.setLocationRelativeTo(null);
            JPanel c=new PanelPedirDomicilio(idrestauranteAs);
            Carta.add(c);
            //Reserva.add(jVentanaMadrimentate.inVentanaReserva());
            //this.jVentanaMadrimentate.inVentanaReserva();
            Carta.setVisible(true);
            Carta.setResizable(true);
        });

        this.add(btnReservarAs);
        this.add(btnPedirAs);



    }
}
