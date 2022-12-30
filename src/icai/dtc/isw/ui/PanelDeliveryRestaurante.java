package icai.dtc.isw.ui;

import icai.dtc.isw.domain.DeliveryDeliveroo;
import icai.dtc.isw.domain.DeliveryGlovo;
import icai.dtc.isw.domain.DeliveryUberEats;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelDeliveryRestaurante extends JPanel implements ActionListener {

    public JVentana jVentanaMadrimentate;

    public DeliveryGlovo deliveryGlovo;
    public DeliveryDeliveroo deliveryDeliveroo;
    public DeliveryUberEats deliveryUberEats;




    public  PanelDeliveryRestaurante(/*JVentana jVentanaMadrimentate*/){

        /*JPanel pnlNorte = new JPanel(new GridLayout(1,3));
        this.setLayout(new BorderLayout());*/

        this.setLayout(null);
        this.setBackground(Color.lightGray);

        //insertar imagen
        JLabel imgFondoAm = new JLabel(" ");
        ImageIcon ImagenAm = new ImageIcon("src/main/resources/images/fondodelivery.jpg");
        imgFondoAm.setIcon(ImagenAm);
        imgFondoAm.setSize(800, 295);
        imgFondoAm.setLocation(0, 605);
        imgFondoAm.setVisible(true);
        this.add(imgFondoAm);


        //JLabel lblservicio = new JLabel("servicio de Delivery");
        //JLabel lblglovo = new JLabel(new ImageIcon(""));
        //lblglovo.setFont(new Font("Arial",Font.PLAIN, 20));

        JLabel lblglovo= new JLabel("Glovo");
        lblglovo.setBounds(165,20,150,50);
        this.add(lblglovo);

        JLabel lbldeliveroo = new JLabel("Deliveroo");
        lbldeliveroo.setBounds(355,20,150,50);
        this.add(lbldeliveroo);

        JLabel lblubereats = new  JLabel("Uber Eats");
        lblubereats.setBounds(550,20,150,50);
        this.add(lblubereats);




        /*pnlNorte.add(lblglovo);
        pnlNorte.add(lblubereats);
        pnlNorte.add(lbldeliveroo);*/
        /*this.add(pnlNorte);
        pnlNorte.setVisible(true);*/


        //JPanel pnlMedio = new JPanel(new GridLayout(3,7));
        JButton btnglovo = new JButton("Glovo");
        btnglovo.setBounds(70,400,200,100);
        ImageIcon iconog=new ImageIcon("src/main/resources/images/glovoapp.png");
        btnglovo.setIcon(iconog);
        this.add(btnglovo);

        JButton btndeliveroo = new JButton("Deliveroo");
        btndeliveroo.setBounds(270,400,200,100);
        ImageIcon iconod=new ImageIcon("src/main/resources/images/deliverooapp.png");
        btndeliveroo.setIcon(iconod);
        this.add(btndeliveroo);

        JButton btnubereats = new JButton("UberEats");
        btnubereats.setBounds(470,400,200,100);
        ImageIcon iconoue=new ImageIcon("src/main/resources/images/ubereatsappofficial.png");
        btnubereats.setIcon(iconoue);
        this.add(btnubereats);
        /*
        JLabel lbl = new JLabel("                                                              ");
        JLabel lbln = new JLabel("                                                                ");
        JLabel lbln1 = new JLabel("                                       ");
        JLabel lbln2 = new JLabel("                                             ");*/


//tiempos
        JLabel lbltiempo = new JLabel("Tiempo:");
        lbltiempo.setBounds(10,100,90,100);
        this.add(lbltiempo);

        JLabel lbltiempog = new JLabel(String.valueOf(Math.round(DeliveryGlovo.calcularTiempo(false)))+" min.");
        lbltiempog.setBounds(120,125,90,50);
        this.add(lbltiempog);

        JLabel lbltiempogp = new JLabel(String.valueOf(Math.round(DeliveryGlovo.calcularTiempo(true)))+" min.");
        lbltiempogp.setBounds(220,125,90,50);
        this.add(lbltiempogp);

        JLabel lbltiempod = new JLabel(String.valueOf(Math.round(DeliveryDeliveroo.calcularTiempo(false)))+" min.");
        lbltiempod.setBounds(320,125,90,50);
        this.add(lbltiempod);

        JLabel lbltiempodp = new JLabel(String.valueOf(Math.round(DeliveryDeliveroo.calcularTiempo(true)))+" min.");
        lbltiempodp.setBounds(420,125,90,50);
        this.add(lbltiempodp);

        JLabel lbltiempou = new JLabel(String.valueOf(Math.round(DeliveryUberEats.calcularTiempo(false)))+" min.");
        lbltiempou.setBounds(520,125,90,50);
        this.add(lbltiempou);

        JLabel lbltiempoup = new JLabel(String.valueOf(Math.round(DeliveryUberEats.calcularTiempo(true)))+" min.");
        lbltiempoup.setBounds(620,125,90,50);
        this.add(lbltiempoup);

//precios
        JLabel lblprecio = new JLabel("Precio:");
        lblprecio.setBounds(10,250,90,50);
        this.add(lblprecio);

        JLabel lblpreciog = new JLabel(String.valueOf(DeliveryGlovo.coste(false))+"€");
        lblpreciog.setBounds(120,250,90,50);
        this.add(lblpreciog);

        JLabel lblpreciogp = new JLabel(String.valueOf(DeliveryGlovo.coste(true))+"€");
        lblpreciogp.setBounds(220,250,90,50);
        this.add(lblpreciogp);

        JLabel lblpreciod  = new JLabel(String.valueOf(DeliveryDeliveroo.coste(false))+"€");
        lblpreciod.setBounds(320,250,90,50);
        this.add(lblpreciod);

        JLabel lblpreciodp = new JLabel(String.valueOf(DeliveryGlovo.coste(true))+"€");
        lblpreciodp.setBounds(420,250,90,50);
        this.add(lblpreciodp);

        JLabel lblpreciou  = new JLabel(String.valueOf(DeliveryUberEats.coste(false))+"€");
        lblpreciou.setBounds(520,250,90,50);
        this.add(lblpreciou);

        JLabel lblprecioup = new JLabel(String.valueOf(DeliveryUberEats.coste(true))+"€");
        lblprecioup.setBounds(620,250,90,50);
        this.add(lblprecioup);


        //JLabel lblenvio = new JLabel("envioPreferente");


        //JButton envioPreferentebtn = new JButton("preferencia?");

        /*
        pnlMedio.add(lbl);
        pnlMedio.add(lbln1);*/
       /* pnlMedio.add(btnglovo);
        pnlMedio.add(btndeliveroo);
        pnlMedio.add(btnubereats);*/
        /*pnlMedio.add(lbln);
        pnlMedio.add(lbln2);*/


        /*pnlMedio.add(lbltiempo);
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
        pnlMedio.add(lblprecioup);*/

        //pnlMedio.add(lblenvio);

        //this.add(pnlMedio,BorderLayout.CENTER);


        //envioPreferentebtn.addActionListener(e->{
        //});

        // select from menu when id restaurante = id menu
        // carta de pedidos asociadas a usuarios


        btnglovo.addActionListener(e->{
            System.out.println("gracias por elegir glovo");

            JFrame frameLast = new JFrame("Confirmación pedido");
            frameLast.setSize(800, 935);
            frameLast.setBackground(Color.lightGray);
            frameLast.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameLast.setLocationRelativeTo(null);
            JPanel panell = new LastPanel();
            panell.setBackground(Color.gray);
            frameLast.add(panell);
            frameLast.setVisible(true);
            frameLast.setResizable(true);
        });

        btndeliveroo.addActionListener(e->{
            System.out.println("gracias por elegir deliveroo");

            JFrame frameLast = new JFrame("Confirmación pedido");
            frameLast.setSize(800, 935);
            frameLast.setBackground(Color.lightGray);
            frameLast.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameLast.setLocationRelativeTo(null);
            JPanel panell = new LastPanel();
            panell.setBackground(Color.gray);
            frameLast.add(panell);
            frameLast.setVisible(true);
            frameLast.setResizable(true);
        });

        btnubereats.addActionListener(e->{
            System.out.println("gracias por elegir ubereats");

            JFrame frameLast = new JFrame("Confirmación pedido");
            frameLast.setSize(800, 935);
            frameLast.setBackground(Color.lightGray);
            frameLast.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameLast.setLocationRelativeTo(null);
            JPanel panell = new LastPanel();
            panell.setBackground(Color.gray);
            frameLast.add(panell);
            frameLast.setVisible(true);
            frameLast.setResizable(true);
        });


        //SELECCIONAREMOS EL DELIVERY QUE QUERAMOS



        this.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
