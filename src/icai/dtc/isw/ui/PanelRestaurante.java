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
            JPanel espana = new PlaceComponentsEsp();
            frameEsp.add(espana);
            frameEsp.setVisible(true);
            frameEsp.setResizable(true);
        });

        btnAsiatico.addActionListener(actionEvent -> {
            JFrame frameAsi = new JFrame("Comida Asiática");
            frameEsp.setSize(800, 900);
            frameEsp.setBackground(Color.lightGray);
            frameEsp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameEsp.setLocationRelativeTo(null);
            JPanel asia = new PlaceComponentsAsi();
            frameEsp.add(espana);
            frameEsp.setVisible(true);
            frameEsp.setResizable(true);
        });

        btnPizza.addActionListener(actionEvent -> {
            JFrame framePizza = new JFrame("Comida Italiana");
            frameEsp.setSize(800, 900);
            frameEsp.setBackground(Color.lightGray);
            frameEsp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameEsp.setLocationRelativeTo(null);
            JPanel pizza = new PlaceComponentsEsp();
            frameEsp.add(espana);
            frameEsp.setVisible(true);
            frameEsp.setResizable(true);
        });

        btnHamburguesa.addActionListener(actionEvent -> {
            JFrame frameHamb = new JFrame("Comida Americana");
            frameEsp.setSize(800, 900);
            frameEsp.setBackground(Color.lightGray);
            frameEsp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameEsp.setLocationRelativeTo(null);
            JPanel hamburg = new PlaceComponentsHamb();
            frameEsp.add(espana);
            frameEsp.setVisible(true);
            frameEsp.setResizable(true);
        });

        btnBuscarRestauranteLupa.addActionListener(actionEvent -> {
            JFrame frameBL = new JFrame("RESTAURANTE BUSCADO");
            frameEsp.setSize(800, 900);
            frameEsp.setBackground(Color.lightGray);
            frameEsp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameEsp.setLocationRelativeTo(null);
            JPanel buscador = new PlaceComponentsEsp();
            frameEsp.add(espana);
            frameEsp.setVisible(true);
            frameEsp.setResizable(true);
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
