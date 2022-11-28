package icai.dtc.isw.ui;

import icai.dtc.isw.domain.DeliveryDeliveroo;
import icai.dtc.isw.domain.DeliveryGlovo;
import icai.dtc.isw.domain.DeliveryUberEats;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelDeliveryRestaurante extends JPanel implements ActionListener {

    //public JVentanaMadrimentate jVentanaMadrimentate;

    public DeliveryGlovo deliveryGlovo;
    public DeliveryDeliveroo deliveryDeliveroo;
    public DeliveryUberEats deliveryUberEats;




    public  PanelDeliveryRestaurante(/*JVentanaMadrimentate jVentanaMadrimentate*/){

        JPanel pnlNorte = new JPanel(new GridLayout(1,3));
        this.setLayout(new BorderLayout());


        JLabel lblservicio = new JLabel("servicio de Delivery");
        JLabel lblglovo = new JLabel(new ImageIcon(""));
        lblglovo.setText("glovo");
        lblglovo.setFont(new Font("Arial",Font.PLAIN, 20));

        JLabel lbldeliveroo = new JLabel("Deliveroo");
        JLabel lblubereats = new  JLabel("Uber Eats");
        pnlNorte.add(lblglovo);
        pnlNorte.add(lblubereats);

        pnlNorte.add(lbldeliveroo);
        this.add(pnlNorte);
        pnlNorte.setVisible(true);


        JPanel pnlMedio = new JPanel(new GridLayout(3,7));
        JButton btnglovo = new JButton("Glovo");
        JButton btndeliveroo = new JButton("Deliveroo");
        JButton btnubereats = new JButton("UberEats");

        JLabel lbl = new JLabel("                                                              ");
        JLabel lbln = new JLabel("                                                                ");
        JLabel lbln1 = new JLabel("                                       ");
        JLabel lbln2 = new JLabel("                                             ");

        JLabel lbltiempo = new JLabel("tiempo envío");
        JLabel lbltiempog = new JLabel(String.valueOf(DeliveryGlovo.calcularTiempo(false)));
        JLabel lbltiempogp = new JLabel(String.valueOf(DeliveryGlovo.calcularTiempo(true)));
        JLabel lbltiempod = new JLabel(String.valueOf(DeliveryDeliveroo.calcularTiempo(false)));
        JLabel lbltiempodp = new JLabel(String.valueOf(DeliveryDeliveroo.calcularTiempo(true)));
        JLabel lbltiempou = new JLabel(String.valueOf(DeliveryUberEats.calcularTiempo(false)));
        JLabel lbltiempoup = new JLabel(String.valueOf(DeliveryUberEats.calcularTiempo(true)));

        JLabel lblpreciog = new JLabel(String.valueOf(DeliveryGlovo.coste(false)));
        JLabel lblpreciogp = new JLabel(String.valueOf(DeliveryGlovo.coste(true)));
        JLabel lblpreciod  = new JLabel(String.valueOf(DeliveryDeliveroo.coste(false)));
        JLabel lblpreciodp = new JLabel(String.valueOf(DeliveryGlovo.coste(true)));
        JLabel lblpreciou  = new JLabel(String.valueOf(DeliveryUberEats.coste(false)));
        JLabel lblprecioup = new JLabel(String.valueOf(DeliveryUberEats.coste(true)));

        JLabel lblprecio = new JLabel("precio envío");
        //JLabel lblenvio = new JLabel("envioPreferente");


        JButton envioPreferentebtn = new JButton("preferencia?");

        pnlMedio.add(lbl);
        pnlMedio.add(lbln1);
        pnlMedio.add(btnglovo);
        pnlMedio.add(btndeliveroo);
        pnlMedio.add(btnubereats);
        pnlMedio.add(lbln);
        pnlMedio.add(lbln2);


        pnlMedio.add(lbltiempo);
        pnlMedio.add(lbltiempog);
        pnlMedio.add(lbltiempogp);
        pnlMedio.add(lbltiempod);
        pnlMedio.add(lbltiempodp);
        pnlMedio.add(lbltiempou);
        pnlMedio.add(lbltiempoup);

        pnlMedio.add(lblprecio);
        pnlMedio.add(lblpreciog);
        pnlMedio.add(lblpreciogp);
        pnlMedio.add(lblpreciod);
        pnlMedio.add(lblpreciodp);
        pnlMedio.add(lblpreciou);
        pnlMedio.add(lblprecioup);

        //pnlMedio.add(lblenvio);

        this.add(pnlMedio,BorderLayout.CENTER);


        envioPreferentebtn.addActionListener(e->{
        });

        // select from menu when id restaurante = id menu
        // carta de pedidos asociadas a usuarios


        btnglovo.addActionListener(e->{


        });


        //SELECCIONAREMOS EL DELIVERY QUE QUERAMOS



        this.setVisible(true);












    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
