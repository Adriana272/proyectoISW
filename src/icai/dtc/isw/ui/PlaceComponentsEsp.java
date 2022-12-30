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

public class PlaceComponentsEsp extends JPanel implements Serializable {


    private JVentana jVentanaMadrimentate;
    public ArrayList<Restaurante> restencesp;
    public ArrayList<String> nombresesp;

    public int idrestauranteE;


    public PlaceComponentsEsp(JVentana jVentanaMadrimentate) {

        this.jVentanaMadrimentate = jVentanaMadrimentate;
        this.setLayout(null);

        restencesp = CustomerDAO.fetchRestaurantesxTipoComida("espaniola");
        System.out.println(restencesp);
        nombresesp= CustomerDAO.fetchNameRestaurantesxTipoComida("espaniola");
        System.out.println(nombresesp);
        System.out.println(CustomerDAO.fetchRestaurantes());

        JLabel labelEsp=new JLabel("ESPAÑA");
        labelEsp.setFont(new Font("Arial Black", Font.BOLD, 30));
        labelEsp.setBounds(350, 20, 400, 200);
        this.add(labelEsp);

        final JTextArea restaurants = new JTextArea();
        restaurants.setBounds(100, 250, 600, 400);
        //platosTextField.setFont(Font.getFont(Font.SANS_SERIF));
        //restaurants.setBackground(Color.lightGray);
        //for(String cancion: relespaniola){

        System.out.println(restencesp);
        System.out.println("ATM");
        for(int i=0; i<(restencesp.toArray().length); i++) {
            restaurants.append("* "+((restencesp.toArray())[i]).toString());
            restaurants.append("\n");

        }
        restaurants.setEditable(false);
        this.add(restaurants);

        JButton btnReservarE=new JButton("Reservar Mesa");
        btnReservarE.setFont(new Font("Arial Black", Font.BOLD, 18));
        btnReservarE.setBounds(200, 750, 160, 60);
        btnReservarE.setBackground(Color.white);
        btnReservarE.addActionListener(actionEvent -> {
            Object opcion= JOptionPane.showInputDialog(this, "¿En qué restaurante desea reservar mesa?", "Elegir", JOptionPane.QUESTION_MESSAGE, null, nombresesp.toArray(), nombresesp.toArray()[0]);
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

        JButton btnPedirE=new JButton("Pedir a domicilio");
        btnPedirE.setFont(new Font("Arial Black", Font.BOLD, 18));
        btnPedirE.setBounds(440, 750, 160, 60);
        btnPedirE.setBackground(Color.white);

        btnPedirE.addActionListener(actionEvent -> {
            Object opcion= JOptionPane.showInputDialog(this, "¿En qué restaurante desea reservar mesa?", "Elegir", JOptionPane.QUESTION_MESSAGE, null, nombresesp.toArray(), nombresesp.toArray()[0]);
            String opcionelegida=opcion.toString();
            System.out.println(opcionelegida);

            idrestauranteE= CustomerDAO.fetchIdRestaurantexNombre(opcionelegida);
            System.out.println(idrestauranteE);

            JFrame Carta=new JFrame(opcionelegida);
            Carta.setSize(800, 900);
            Carta.setBackground(Color.lightGray);
            Carta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Carta.setLocationRelativeTo(null);
            JPanel c=new PanelPedirDomicilio(idrestauranteE);
            Carta.add(c);
            //Reserva.add(jVentanaMadrimentate.inVentanaReserva());
            //this.jVentanaMadrimentate.inVentanaReserva();
            Carta.setVisible(true);
            Carta.setResizable(true);
        });

        this.add(btnReservarE);
        this.add(btnPedirE);



    }
}