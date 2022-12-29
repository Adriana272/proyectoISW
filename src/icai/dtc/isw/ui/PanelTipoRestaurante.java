package icai.dtc.isw.ui;

import icai.dtc.isw.dao.CustomerDAO;
import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.Restaurante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class PanelTipoRestaurante extends JPanel     {

    private JVentana jVentanaMadrimentate;

    public ArrayList<Restaurante> restauranteslistencontrados;
    private Restaurante restaurante;
    private ArrayList<Restaurante> restaurantes;
    private PanelRestaurante panelr;


/*    private String nombre;
    private String tipoComida;*/



    public PanelTipoRestaurante(JVentana jVentanaMadrimentate){
        this.setSize(200,800);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.jVentanaMadrimentate=jVentanaMadrimentate ;
        restaurantes = new ArrayList<Restaurante>();
        System.out.println(restaurantes.toString());
        this.panelr=panelr;

        restauranteslistencontrados = CustomerDAO.fetchRestaurantes();
        System.out.println(restauranteslistencontrados);
        System.out.println(CustomerDAO.fetchRestaurantes());



    }

    public void mostrarRestauranteNombre(String nombre){


        restauranteslistencontrados.forEach(c -> {
            boolean encontradouno = true;
            if (c.getNombre().contains(nombre)) {
                System.out.println(c.getNombre().contains(nombre) + "VERDADERO");
                encontradouno = true;

            } else encontradouno = false;
            //}



            if (encontradouno == true) {
                JPanel pnlRest = new JPanel(new BorderLayout());
                JPanel pnlNorte = new JPanel(new FlowLayout());
                pnlRest.setSize(200,200);

                JLabel txtnombre = new JLabel(c.getNombre());



                pnlNorte.add(txtnombre);




                JLabel lblTipo = new JLabel("tipo");
                JLabel lblpreciomedio = new JLabel("precio medio : ");
                JLabel lblcalle = new JLabel("calle: ");

                JPanel pnlSur = new JPanel(new FlowLayout());
                JButton btnReservaMesa = new JButton("Reservar mesa");
                JButton btnADomicilio = new JButton("A domicilio");


                btnReservaMesa.addActionListener(e->{

                    this.jVentanaMadrimentate.inVentanaReserva();
                });

                btnADomicilio.addActionListener(e->{
                    this.jVentanaMadrimentate.inVentanaDelivery();
                });

                pnlSur.add(btnReservaMesa);
                pnlSur.add(btnADomicilio);


                pnlNorte.add(lblpreciomedio);
                pnlNorte.add(lblTipo);
                pnlNorte.add(lblcalle);


                this.add(pnlRest);


                pnlRest.add(pnlNorte, BorderLayout.NORTH);
                pnlRest.add(pnlSur, BorderLayout.SOUTH);



            }
            //else{

            //}


        });


    }
    public void mostrarRestauranteTipo(String tipoComida) {

        restauranteslistencontrados.forEach(c -> {
            boolean encontradodos;
            if (c.getTipoComida().contains(tipoComida)) {
                encontradodos = true;
                System.out.println(c.getNombre().contains(tipoComida) + "VERDADERO");


            } else {
                encontradodos = false;
            }
            //}


            if (encontradodos == true) {
                System.out.println("in");
                JPanel pnlRest = new JPanel(new BorderLayout());
                JPanel pnlNorte = new JPanel(new FlowLayout());
                pnlRest.setSize(200, 200);

                JLabel txtnombre = new JLabel(c.getNombre());


                pnlNorte.add(txtnombre);


                JLabel lblTipo = new JLabel("tipo");
                JLabel lblpreciomedio = new JLabel("precio medio : ");
                JLabel lblcalle = new JLabel("calle: ");

                JPanel pnlSur = new JPanel(new FlowLayout());
                JButton btnReservaMesa = new JButton("Reservar mesa");
                JButton btnADomicilio = new JButton("A domicilio");


                btnReservaMesa.addActionListener(e -> {

                    this.jVentanaMadrimentate.inVentanaReserva();
                });

                btnADomicilio.addActionListener(e -> {
                    this.jVentanaMadrimentate.inVentanaDelivery();
                });

                pnlSur.add(btnReservaMesa);
                pnlSur.add(btnADomicilio);


                pnlNorte.add(lblpreciomedio);
                pnlNorte.add(lblTipo);
                pnlNorte.add(lblcalle);



                System.out.println("in2");

                pnlRest.add(pnlNorte, BorderLayout.NORTH);
                pnlRest.add(pnlSur, BorderLayout.SOUTH);
                //this.add(pnlRest);
                this.add(pnlRest);
                this.setVisible(true);
                this.repaint();
                JFrame f= new JFrame();
                f.setVisible(true);
                f.add(this);
               // jVentanaMadrimentate.add(this);
                System.out.println("in3");

            }


        });


//por cada restaurante en la base de datos con ese nombre tengo que imprimir un minipanel "panelRest" tantas veces como haya

    }}