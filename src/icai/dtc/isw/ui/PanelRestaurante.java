package icai.dtc.isw.ui;

import icai.dtc.isw.domain.Restaurante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelRestaurante extends JPanel{
    private JButton btnAsiatico = new JButton();
    private JButton btnHamburguesa = new JButton(new ImageIcon("imagen-archivo-hamburguesas_98.webp"));
    private JButton btnPizza = new JButton(new ImageIcon("papa-johns-pizza.webp"));
    private JButton btnEspaniol = new JButton(new ImageIcon("p15_restaurantes_de_comida_espanola_en_espana_120_orig.jpg"));
    private JVentana jVentanaMadrimentate;
    private PanelTipoRestaurante panelEncontrado;

    public PanelRestaurante() {
        //this.jVentanaMadrimentate = jVentanaMadrimentate;
        this.setPreferredSize(new Dimension(200, 800));
        this.setBackground(Color.orange);
        this.setLayout(new BorderLayout());

        // JPanel panelPrincipal = new JPanel();
        JPanel panelNorte = new JPanel();
        JLabel madrimentate = new JLabel(new ImageIcon("main.resources.images/madrimentate.jpg"));
        panelNorte.add(madrimentate);
        this.add(panelNorte, BorderLayout.NORTH);


        JPanel panelNorte2 = new JPanel(new FlowLayout());
        JButton buscarRestaurantelupa = new JButton("buscar");
        JTextField txtRest = new JTextField(("nombredelrestaurante, tipo"));

        setVisible(true);


        buscarRestaurantelupa.addActionListener(e -> {
            String textoInsertado = txtRest.getText().trim();
            ArrayList<Restaurante> restaurante = jVentanaMadrimentate.getgRestaurantes().buscarRestaurante(textoInsertado);
            if (restaurante.size() > 0) {
                System.out.println("Restaurantes encontrados");
                panelEncontrado = new PanelTipoRestaurante(restaurante);
                panelEncontrado.setVisible(true);


            } else {
                JOptionPane.showMessageDialog(jVentanaMadrimentate, "No hemos encontrado restaurantes afines a tu busqueda");

            }


        });


        panelNorte2.add(buscarRestaurantelupa);
        panelNorte2.add(txtRest);
        panelNorte.add(panelNorte2, BorderLayout.NORTH);

        JPanel panelSur = new JPanel(new GridLayout(5, 2));
        btnAsiatico.setText("Asiatico");
        btnAsiatico.setIcon(new ImageIcon("cocina_asiatica.webp"));
        btnHamburguesa.setText("Hamburgesa");
        btnPizza.setText("Pizza");
        btnEspaniol.setText("Española");

        btnHamburguesa.addActionListener(e -> {
            String hamburguesa = "hamburguesa";

            ArrayList<Restaurante> restaurante = jVentanaMadrimentate.getgRestaurantes().buscarRestauranteTipo(hamburguesa);
            if (restaurante.size() > 0) {
                System.out.println("Restaurantes encontrados");
                panelEncontrado = new PanelTipoRestaurante(restaurante);

            } else {
                JOptionPane.showMessageDialog(jVentanaMadrimentate, "No hemos encontrado restaurantes afines a tu busqueda");

            }

        });
        btnEspaniol.addActionListener(e-> {
            String espaniol= "espaniol";
            ArrayList<Restaurante> restaurante = jVentanaMadrimentate.getgRestaurantes().buscarRestauranteTipo(espaniol);
            if (restaurante.size() > 0) {
                System.out.println("Restaurantes encontrados");
                panelEncontrado = new PanelTipoRestaurante(restaurante);

            } else {
                JOptionPane.showMessageDialog(jVentanaMadrimentate, "No hemos encontrado restaurantes afines a tu busqueda");

            }


        });



        btnPizza.addActionListener(e -> {
            String pizza= "pizza";
            ArrayList<Restaurante> restaurante = jVentanaMadrimentate.getgRestaurantes().buscarRestauranteTipo(pizza);
            if (restaurante.size() > 0) {
                System.out.println("Restaurantes encontrados");
                panelEncontrado = new PanelTipoRestaurante(restaurante);

            } else {
                JOptionPane.showMessageDialog(jVentanaMadrimentate, "No hemos encontrado restaurantes afines a tu busqueda");

            }


        });

        btnAsiatico.addActionListener(e -> {
            String asiatico= "asiatico";
            ArrayList<Restaurante> restaurante = jVentanaMadrimentate.getgRestaurantes().buscarRestauranteTipo(asiatico);
            if (restaurante.size() > 0) {
                System.out.println("Restaurantes encontrados");
                panelEncontrado = new PanelTipoRestaurante(restaurante);

            } else {
                JOptionPane.showMessageDialog(jVentanaMadrimentate, "No hemos encontrado restaurantes afines a tu busqueda");

            }


        });




        panelSur.add(btnPizza);
        panelSur.add(btnHamburguesa);
        panelSur.add(btnEspaniol);
        panelSur.add(btnAsiatico);


        this.add(panelSur, BorderLayout.SOUTH);
        this.add(panelNorte, BorderLayout.NORTH);
        this.add(panelNorte2, BorderLayout.CENTER);


    }
}



 /*@Override
 public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.btnAsiatico){
         String asiatico= "asiatico";

         ArrayList<Restaurante> restaurante = jVentanaMadrimentate.getgRestaurantes().buscarRestauranteTipo(asiatico);
         PanelTipoRestaurante panelEncontrado = new PanelTipoRestaurante(restaurante);
        }
        if(e.getSource()==this.btnPizza){
         String pizza= "pizza";
         ArrayList<Restaurante> restaurante = jVentanaMadrimentate.getgRestaurantes().buscarRestauranteTipo(pizza);
         PanelTipoRestaurante panelEncontrado = new PanelTipoRestaurante(restaurante);      }
       if(e.getSource()==this.btnHamburguesa) {
        String hamburguesa = "hamburguesa";

        ArrayList<Restaurante> restaurante = jVentanaMadrimentate.getgRestaurantes().buscarRestauranteTipo(hamburguesa);
        if (restaurante.size() > 0) {
         System.out.println("Restaurantes encontrados");
         for (int i = 0; i < restaurante.size(); i++) {
          PanelTipoRestaurante panelEncontrado = new PanelTipoRestaurante(restaurante);
         }
        } else {
         JOptionPane.showMessageDialog(jVentanaMadrimentate, "No hemos encontrado restaurantes afines a tu busqueda");


        }
       }
       if(e.getSource()==this.btnEspaniol){
        String espaniol= "espaniol";
        ArrayList<Restaurante> restaurante = jVentanaMadrimentate.getgRestaurantes().buscarRestauranteTipo(espaniol);
        PanelTipoRestaurante panelEncontrado = new PanelTipoRestaurante(restaurante);       }

 }


}*/

