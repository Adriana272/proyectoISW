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

public class PanelTipoRestaurante extends JPanel implements ActionListener {
    public JButton btnReservaMesa = new JButton();
    public JButton btnADomicilio = new JButton();
    JPanel pnlTodo;


    public JVentana jVentanaMadrimentate;
    public ArrayList<Restaurante> restaurantes;
    private Restaurante restaurante;



    public PanelTipoRestaurante(ArrayList<Restaurante> restaurantes) {
        this.restaurantes = restaurantes;
        this.setVisible(true);

        mostrarRestaurantes();
    }

    public void mostrarRestaurantes(){


        restaurantes.forEach(c-> {
            JPanel pnlRest = new JPanel(new BorderLayout());


            JLabel lblNombre = new JLabel();
            JLabel txtnombre = new JLabel(String.valueOf(jVentanaMadrimentate.getgRestaurantes().getNombreRestaurantes()));

            JLabel lblTipo = new JLabel(String.valueOf(jVentanaMadrimentate.getgRestaurantes().getTipoRestaurantes()));
            JLabel lblpreciomedio = new JLabel();
            JLabel lblcalle = new JLabel();

            pnlRest.add(lblNombre, BorderLayout.CENTER);
            pnlRest.add(lblpreciomedio,BorderLayout.CENTER);
            pnlRest.add(lblTipo, BorderLayout.NORTH);
            pnlRest.add(lblcalle, BorderLayout.CENTER);
            pnlRest.add(btnADomicilio, BorderLayout.SOUTH);
            pnlRest.add(btnReservaMesa, BorderLayout.SOUTH);

            add(pnlRest);



        });


    }
    public void mostrarRestaurantes(String campo, String valorCampo) {


        restaurantes.forEach(c -> {
            boolean encontrado = false;
            if (campo.compareTo("nombre") == 0) {
                if (String.valueOf(jVentanaMadrimentate.getgRestaurantes().getNombreRestaurantes()).compareTo(campo) == 0) {
                    encontrado = true;
                }
            } else if (campo.compareTo("tipoComida") == 0) {
                if (String.valueOf(jVentanaMadrimentate.getgRestaurantes().getNombreRestaurantes()).compareTo(campo) == 0) {
                    encontrado = true;

                } else encontrado = false;
            }


            if (encontrado == true) {
                JPanel pnlRest = new JPanel(new BorderLayout());


                JLabel lblNombre = new JLabel();
                JLabel txtnombre = new JLabel(String.valueOf(jVentanaMadrimentate.getgRestaurantes().getNombreRestaurantes()));

                JLabel lblTipo = new JLabel(String.valueOf(jVentanaMadrimentate.getgRestaurantes().getTipoRestaurantes(valorCampo)));
                JLabel lblpreciomedio = new JLabel();
                JLabel lblcalle = new JLabel();

                pnlRest.add(lblNombre, BorderLayout.CENTER);
                pnlRest.add(lblpreciomedio, BorderLayout.CENTER);
                pnlRest.add(lblTipo, BorderLayout.NORTH);
                pnlRest.add(lblcalle, BorderLayout.CENTER);
                pnlRest.add(btnADomicilio, BorderLayout.SOUTH);
                pnlRest.add(btnReservaMesa, BorderLayout.SOUTH);


                add(pnlRest);
            }



        });
    }

    //por cada restaurante en la base de datos con ese nombre tengo que imprimir un minipanel "panelRest" tantas veces como haya







    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnADomicilio){

            //jVentanaMadrimentate.inVentanaDelivery();

        }
        if(e.getSource()==btnReservaMesa){
            //jVentanaMadrimentate.inVentanaReserva();

        }

    }
}
