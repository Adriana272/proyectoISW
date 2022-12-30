package icai.dtc.isw.ui;

import icai.dtc.isw.dao.CustomerDAO;
import icai.dtc.isw.domain.Restaurante;
import icai.dtc.isw.ui.JVentana;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

public class PanelRestaurante extends JPanel implements Serializable {

    private JButton btnAsiatico = new JButton();
    private JButton btnHamburguesa = new JButton(new ImageIcon("imagen-archivo-hamburguesas_98.webp"));
    private JButton btnPizza = new JButton(new ImageIcon("papa-johns-pizza.webp"));
    private JButton btnEspaniol = new JButton(new ImageIcon("p15_restaurantes_de_comida_espanola_en_espana_120_orig.jpg"));

    private JButton btnBuscarRestauranteLupa = new JButton("BUSCAR");
    JTextField txtRest = new JTextField(("nombredelrestaurante, tipo"));

    private JVentana jVentanaMadrimentate;
    private ArrayList<Restaurante> restaurantes;
    private PanelTipoRestaurante panelEncontrado;

    private PlaceComponentsPerfil jPerfil;


    public ArrayList<Restaurante> restencesp;
    public ArrayList<String> relespaniola = new ArrayList();

    public int idrestaurantebl;


    public PanelRestaurante(JVentana jVentanaMadrimentate) {

        this.setLayout(null);

        this.jVentanaMadrimentate = jVentanaMadrimentate;
        this.jPerfil = jPerfil;
        this.panelEncontrado = panelEncontrado;
        this.setPreferredSize(new Dimension(200, 800));
        this.setBackground(Color.orange);
        this.setLayout(new BorderLayout());

        // JPanel panelPrincipal = new JPanel();
        JPanel panelNorte = new JPanel();
        JLabel madrimentate = new JLabel(new ImageIcon("main.resources.images/madrimentate.jpg"));
        panelNorte.add(madrimentate);
        this.add(panelNorte, BorderLayout.NORTH);


        JPanel panelNorte2 = new JPanel(new FlowLayout());

        setVisible(true);

        panelNorte2.add(btnBuscarRestauranteLupa);
        panelNorte2.add(txtRest);
        panelNorte.add(panelNorte2, BorderLayout.NORTH);

        JPanel panelSur = new JPanel(new GridLayout(5, 2));
        btnAsiatico.setText("Asiatico");
        btnAsiatico.setIcon(new ImageIcon("cocina_asiatica.webp"));
        btnHamburguesa.setText("Hamburgesa");
        btnPizza.setText("Pizza");
        btnEspaniol.setText("Española");


        panelSur.add(btnPizza);
        panelSur.add(btnHamburguesa);
        panelSur.add(btnEspaniol);
        panelSur.add(btnAsiatico);


        this.add(panelSur, BorderLayout.SOUTH);
        this.add(panelNorte, BorderLayout.NORTH);
        this.add(panelNorte2, BorderLayout.CENTER);

        /*btnEspaniol.addActionListener(this);
        btnAsiatico.addActionListener(this);
        btnPizza.addActionListener(this);
        btnHamburguesa.addActionListener(this);
        btnBuscarRestauranteLupa.addActionListener(this);*/

        btnEspaniol.addActionListener(actionEvent -> {
            JFrame frameEsp = new JFrame("Comida Española");
            frameEsp.setSize(800, 900);
            frameEsp.setBackground(Color.lightGray);
            frameEsp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameEsp.setLocationRelativeTo(null);
            JPanel espana = new PlaceComponentsEsp(jVentanaMadrimentate);
            frameEsp.add(espana);
            frameEsp.setVisible(true);
            frameEsp.setResizable(true);
        });

        btnAsiatico.addActionListener(actionEvent -> {
            JFrame frameAsi = new JFrame("Comida Asiática");
            frameAsi.setSize(800, 900);
            frameAsi.setBackground(Color.lightGray);
            frameAsi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameAsi.setLocationRelativeTo(null);
            JPanel asia = new PlaceComponentsAsi();
            frameAsi.add(asia);
            frameAsi.setVisible(true);
            frameAsi.setResizable(true);
        });

        btnPizza.addActionListener(actionEvent -> {
            JFrame framePizza = new JFrame("Comida Italiana");
            framePizza.setSize(800, 900);
            framePizza.setBackground(Color.lightGray);
            framePizza.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            framePizza.setLocationRelativeTo(null);
            JPanel pizza = new PlaceComponentsIta();
            framePizza.add(pizza);
            framePizza.setVisible(true);
            framePizza.setResizable(true);
        });

        btnHamburguesa.addActionListener(actionEvent -> {
            JFrame frameHamb = new JFrame("Comida Americana");
            frameHamb.setSize(800, 900);
            frameHamb.setBackground(Color.lightGray);
            frameHamb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameHamb.setLocationRelativeTo(null);
            JPanel hamburg = new PlaceComponentsAme();
            frameHamb.add(hamburg);
            frameHamb.setVisible(true);
            frameHamb.setResizable(true);
        });

        btnBuscarRestauranteLupa.addActionListener(actionEvent -> {
            JFrame frameBL = new JFrame("RESTAURANTE BUSCADO");
            frameBL.setSize(800, 900);
            frameBL.setBackground(Color.lightGray);
            frameBL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameBL.setLocationRelativeTo(null);
            JPanel buscador = new JPanel();
            ArrayList<Restaurante> restaurantebuscado;
            buscador.setLayout(null);

            restaurantebuscado = CustomerDAO.fetchRestaurantexNombre((txtRest.getText()).toUpperCase());
            System.out.println(restaurantebuscado);
            System.out.println(CustomerDAO.fetchRestaurantes());

            JLabel labelBL=new JLabel("BUSCADOR");
            labelBL.setFont(new Font("Arial Black", Font.BOLD, 30));
            labelBL.setBounds(350, 20, 400, 200);
            buscador.add(labelBL);

            final JTextArea restaurants = new JTextArea();
            restaurants.setBounds(100, 250, 600, 400);
            //platosTextField.setFont(Font.getFont(Font.SANS_SERIF));
            //restaurants.setBackground(Color.lightGray);
            //for(String cancion: relespaniola){
            System.out.println(restaurantebuscado);
            System.out.println("ATM");
            for(int i=0; i<(restaurantebuscado.toArray().length); i++) {
                restaurants.append("* " + ((restaurantebuscado.toArray())[i]).toString());
                restaurants.append("\n");
            }
            restaurants.setEditable(false);
            buscador.add(restaurants);

            JButton btnReservarBL=new JButton("Reservar Mesa");
            btnReservarBL.setFont(new Font("Arial Black", Font.BOLD, 18));
            btnReservarBL.setBounds(200, 750, 160, 60);
            btnReservarBL.setBackground(Color.white);

            btnReservarBL.addActionListener(e -> {
                JFrame Reserva=new JFrame((txtRest.getText()).toUpperCase());
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


            JButton btnPedirBL=new JButton("Pedir a domicilio");
            btnPedirBL.setFont(new Font("Arial Black", Font.BOLD, 18));
            btnPedirBL.setBounds(440, 750, 160, 60);
            btnPedirBL.setBackground(Color.white);

            btnPedirBL.addActionListener(e -> {
                JFrame Carta=new JFrame((txtRest.getText()).toUpperCase());
                Carta.setSize(800, 900);
                Carta.setBackground(Color.lightGray);
                Carta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Carta.setLocationRelativeTo(null);

                idrestaurantebl= CustomerDAO.fetchIdRestaurantexNombre((txtRest.getText()).toUpperCase());
                System.out.println(idrestaurantebl);

                JPanel c=new PanelPedirDomicilio(idrestaurantebl);
                Carta.add(c);
                //Reserva.add(jVentanaMadrimentate.inVentanaReserva());
                //this.jVentanaMadrimentate.inVentanaReserva();
                Carta.setVisible(true);
                Carta.setResizable(true);
            });

            buscador.add(btnReservarBL);
            buscador.add(btnPedirBL);

            frameBL.add(buscador);
            frameBL.setVisible(true);
            frameBL.setResizable(true);
        });


    }
}



/*
        @Override
        public void actionPerformed (ActionEvent e){
            if (e.getSource() == btnEspaniol) {
                String espaniol = "espaniola";
                ArrayList<Restaurante> restaurante = jVentanaMadrimentate.getgRestaurantes().buscarRestauranteTipo(espaniol);
                System.out.println("los restaurantes espaniol son: " + restaurante);
                if (restaurante.size() > 0) {
                    System.out.println("Restaurantes encontrados");
                    //panelEncontrado = new PanelTipoRestaurante(restaurante);
                    //jVentanaMadrimentate.inVentanaTipoRestaurante(espaniol);
                    jVentanaMadrimentate.inVentanaTipoRestaurante(espaniol);


                }
            } else if (e.getSource() == btnAsiatico) {
                String asiatico = "asiatico";
                ArrayList<Restaurante> restaurante = jVentanaMadrimentate.getgRestaurantes().buscarRestauranteTipo(asiatico);
                System.out.println(restaurante);
                if (restaurante.size() > 0) {
                    System.out.println("Restaurantes encontrados");
                    jVentanaMadrimentate.inVentanaTipoRestaurante(asiatico);


                } else {
                    JOptionPane.showMessageDialog(jVentanaMadrimentate, "No hemos encontrado restaurantes afines a tu busqueda");

                }


            } else if (e.getSource() == btnPizza) {
                String pizza = "pizza";
                ArrayList<Restaurante> restaurante = jVentanaMadrimentate.getgRestaurantes().buscarRestauranteTipo(pizza);
                System.out.println(restaurante);
                if (restaurante.size() > 0) {
                    System.out.println("Restaurantes encontrados");
                    jVentanaMadrimentate.inVentanaTipoRestaurante(pizza);

                } else {
                    JOptionPane.showMessageDialog(jVentanaMadrimentate, "No hemos encontrado restaurantes afines a tu busqueda");

                }

            } else if (e.getSource() == btnHamburguesa) {
                String hamburguesa = "hamburguesa";

                ArrayList<Restaurante> restaurante = jVentanaMadrimentate.getgRestaurantes().buscarRestauranteTipo(hamburguesa);
                System.out.println(restaurante);
                if (restaurante.size() > 0) {
                    System.out.println("Restaurantes encontrados");
                    jVentanaMadrimentate.inVentanaTipoRestaurante(hamburguesa);


                } else {
                    JOptionPane.showMessageDialog(jVentanaMadrimentate, "No hemos encontrado restaurantes afines a tu busqueda");

                }

            } else if (e.getSource() == btnBuscarRestauranteLupa) {
                String textoInsertado = txtRest.getText().trim();
                ArrayList<Restaurante> restaurante = jVentanaMadrimentate.getgRestaurantes().buscarRestaurante(textoInsertado);
                System.out.println(restaurante);
                if (restaurante.size() > 0) {
                    //panelEncontrado = new PanelTipoRestaurante(this.jVentanaMadrimentate,this,restaurante);
                    jVentanaMadrimentate.inVentanaNombreRestaurante(textoInsertado);
                } else {
                    JOptionPane.showMessageDialog(jVentanaMadrimentate, "No hemos encontrado restaurantes afines a tu busqueda");

                }
            }


        }
    }*/
