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

public class PlaceComponentsIta extends JPanel implements Serializable {


    private JVentana jVentanaMadrimentate;
    public ArrayList<Restaurante> restencita;
    public ArrayList<String> nombresita;

    public int idrestauranteI;

    public PlaceComponentsIta(/*JVentana jVentanaMadrimentate*/) {

        this.jVentanaMadrimentate = jVentanaMadrimentate;
        this.setLayout(null);

        restencita = CustomerDAO.fetchRestaurantesxTipoComida("italiana");
        System.out.println(restencita);
        nombresita= CustomerDAO.fetchNameRestaurantesxTipoComida("italiana");
        System.out.println(nombresita);
        System.out.println(CustomerDAO.fetchRestaurantes());

        JLabel labelIta=new JLabel("ITALIA");
        labelIta.setFont(new Font("Arial Black", Font.BOLD, 30));
        labelIta.setBounds(350, 20, 400, 200);
        this.add(labelIta);

        final JTextArea restaurants = new JTextArea();
        restaurants.setBounds(100, 250, 600, 400);
        //platosTextField.setFont(Font.getFont(Font.SANS_SERIF));
        //restaurants.setBackground(Color.lightGray);
        //for(String cancion: relespaniola){
        System.out.println(restencita);
        System.out.println("ATM");
        for(int i=0; i<(restencita.toArray().length); i++) {
            restaurants.append("* "+((restencita.toArray())[i]).toString());
            restaurants.append("\n");

        }
        restaurants.setEditable(false);
        this.add(restaurants);

        JButton btnReservarI=new JButton("Reservar Mesa");
        btnReservarI.setFont(new Font("Arial Black", Font.BOLD, 18));
        btnReservarI.setBounds(200, 750, 160, 60);
        btnReservarI.setBackground(Color.white);


        btnReservarI.addActionListener(actionEvent -> {
            Object opcion= JOptionPane.showInputDialog(this, "¿En qué restaurante desea reservar mesa?", "Elegir", JOptionPane.QUESTION_MESSAGE, null, nombresita.toArray(), nombresita.toArray()[0]);
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

        JButton btnPedirI=new JButton("Pedir a domicilio");
        btnPedirI.setFont(new Font("Arial Black", Font.BOLD, 18));
        btnPedirI.setBounds(440, 750, 160, 60);
        btnPedirI.setBackground(Color.white);

        btnPedirI.addActionListener(actionEvent -> {
            Object opcion= JOptionPane.showInputDialog(this, "¿En qué restaurante desea reservar mesa?", "Elegir", JOptionPane.QUESTION_MESSAGE, null, nombresita.toArray(), nombresita.toArray()[0]);
            String opcionelegida=opcion.toString();
            System.out.println(opcionelegida);

            idrestauranteI= CustomerDAO.fetchIdRestaurantexNombre(opcionelegida);
            System.out.println(idrestauranteI);

            JFrame Carta=new JFrame(opcionelegida);
            Carta.setSize(800, 900);
            Carta.setBackground(Color.lightGray);
            Carta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Carta.setLocationRelativeTo(null);
            JPanel c=new PanelPedirDomicilio(idrestauranteI);
            Carta.add(c);
            //Reserva.add(jVentanaMadrimentate.inVentanaReserva());
            //this.jVentanaMadrimentate.inVentanaReserva();
            Carta.setVisible(true);
            Carta.setResizable(true);
        });

        this.add(btnReservarI);
        this.add(btnPedirI);



    }
}
