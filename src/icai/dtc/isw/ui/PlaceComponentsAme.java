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

public class PlaceComponentsAme extends JPanel implements Serializable {


    private JVentana jVentanaMadrimentate;
    public ArrayList<Restaurante> restencame;
    public ArrayList<String> nombresame;
    public int idrestauranteAm;


    public PlaceComponentsAme(/*JVentana jVentanaMadrimentate*/) {

        this.jVentanaMadrimentate = jVentanaMadrimentate;
        this.setLayout(null);

        restencame = CustomerDAO.fetchRestaurantesxTipoComida("americana");
        System.out.println(restencame);
        nombresame = CustomerDAO.fetchNameRestaurantesxTipoComida("americana");
        System.out.println(nombresame);
        System.out.println(CustomerDAO.fetchRestaurantes());

        JLabel labelAme=new JLabel("AMERICA");
        labelAme.setFont(new Font("Arial Black", Font.BOLD, 30));
        labelAme.setBounds(350, 20, 400, 200);
        this.add(labelAme);

        final JTextArea restaurants = new JTextArea();
        restaurants.setBounds(100, 250, 600, 400);
        //platosTextField.setFont(Font.getFont(Font.SANS_SERIF));
        //restaurants.setBackground(Color.lightGray);
        //for(String cancion: relespaniola){
        System.out.println(restencame);
        System.out.println("ATM");
        for(int i=0; i<(restencame.toArray().length); i++) {
            restaurants.append("* "+((restencame.toArray())[i]).toString());
            restaurants.append("\n");

        }
        restaurants.setEditable(false);
        this.add(restaurants);

        JButton btnReservarAm=new JButton("Reservar Mesa");
        btnReservarAm.setFont(new Font("Arial Black", Font.BOLD, 18));
        btnReservarAm.setBounds(200, 750, 160, 60);
        btnReservarAm.setBackground(Color.white);

        btnReservarAm.addActionListener(actionEvent -> {
            Object opcion= JOptionPane.showInputDialog(this, "¿En qué restaurante desea reservar mesa?", "Elegir", JOptionPane.QUESTION_MESSAGE, null, nombresame.toArray(), nombresame.toArray()[0]);
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


        JButton btnPedirAm=new JButton("Pedir a domicilio");
        btnPedirAm.setFont(new Font("Arial Black", Font.BOLD, 18));
        btnPedirAm.setBounds(440, 750, 160, 60);
        btnPedirAm.setBackground(Color.white);

        btnPedirAm.addActionListener(actionEvent -> {
            Object opcion= JOptionPane.showInputDialog(this, "¿En qué restaurante desea reservar mesa?", "Elegir", JOptionPane.QUESTION_MESSAGE, null, nombresame.toArray(), nombresame.toArray()[0]);
            String opcionelegida=opcion.toString();
            System.out.println(opcionelegida);

            idrestauranteAm= CustomerDAO.fetchIdRestaurantexNombre(opcionelegida);
            System.out.println(idrestauranteAm);

            JFrame Carta=new JFrame(opcionelegida);
            Carta.setSize(800, 900);
            Carta.setBackground(Color.lightGray);
            Carta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Carta.setLocationRelativeTo(null);
            JPanel c=new PanelPedirDomicilio(idrestauranteAm);
            Carta.add(c);
            //Reserva.add(jVentanaMadrimentate.inVentanaReserva());
            //this.jVentanaMadrimentate.inVentanaReserva();
            Carta.setVisible(true);
            Carta.setResizable(true);
        });

        this.add(btnReservarAm);
        this.add(btnPedirAm);



    }
}
