package icai.dtc.isw.ui;

import icai.dtc.isw.dao.ConnectionDAO;
import icai.dtc.isw.domain.Restaurante;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PanelRestaurante extends JPanel{
    private JButton btnAsiatico = new JButton();
    private JButton btnHamburguesa = new JButton();
    private JButton btnPizza = new JButton();
    private JButton btnEspaniol = new JButton();
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
        JButton buscarRestaurantelupa = new JButton("Buscar");
        buscarRestaurantelupa.setIcon(new ImageIcon("src/main/resources/images/lupa.png"));
        JTextField txtRest = new JTextField(("Inserte restaurante..."));
        setVisible(true);


        /*buscarRestaurantelupa.addActionListener(e -> {
            String textoInsertado = txtRest.getText().trim();
            ArrayList<Restaurante> restaurante = jVentanaMadrimentate.getgRestaurantes().buscarRestaurante(textoInsertado);
            if (restaurante.size() > 0) {
                System.out.println("Restaurantes encontrados");
                panelEncontrado = new PanelTipoRestaurante(restaurante);
                panelEncontrado.setVisible(true);


            } else {
                JOptionPane.showMessageDialog(jVentanaMadrimentate, "No hemos encontrado restaurantes afines a tu busqueda");

            }

        });*/

        buscarRestaurantelupa.addActionListener(e -> {
            String textoInsertado = txtRest.getText().trim();
            ArrayList<Restaurante> restaurantes= new ArrayList<>();
            System.out.println(textoInsertado);
            Connection con= ConnectionDAO.getInstance().getConnection();

            try(PreparedStatement pst=con.prepareStatement("SELECT * FROM restaurantes WHERE nombre = "+textoInsertado);
                ResultSet rs=pst.executeQuery()) {
                while (rs.next()) {
                    restaurantes.add(new Restaurante(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
                    System.out.println(restaurantes);


                }
            }catch (SQLException exception){
                    System.out.println(exception.getMessage());
                    JOptionPane.showMessageDialog(jVentanaMadrimentate, "No hemos encontrado restaurantes afines a tu busqueda");

                }
            JFrame frameBuscador = new JFrame("RESTAURANTE BUSCADO");
            frameBuscador.setSize(750, 300);
            frameBuscador.setLocationRelativeTo(null);
            //frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
            frameBuscador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //JPanel panel = new JPanel();
            //framePerfil.add(panel);
            JPanel JBuscador = new JPanel();
            final JTextArea buscadorTextField = new JTextArea(20, 20);
            buscadorTextField.append(restaurantes.toString());
            //userTextPerfil.setBounds(260, 270, 340, 40);
            buscadorTextField.setEditable(false);
            JBuscador.add(buscadorTextField);
            frameBuscador.add(JBuscador);
            frameBuscador.setVisible(true);
            frameBuscador.setResizable(true);
            });


        panelNorte2.add(buscarRestaurantelupa);
        panelNorte2.add(txtRest);
        panelNorte.add(panelNorte2, BorderLayout.NORTH);

        JPanel panelSur = new JPanel(new GridLayout(5, 2));
        btnAsiatico.setText("Asiatico");
        btnAsiatico.setIcon(new ImageIcon("src/main/resources/images/asiatica.png"));
        btnHamburguesa.setText("Hamburguesa");
        btnHamburguesa.setIcon(new ImageIcon("src/main/resources/images/hamburguesa.png"));
        btnPizza.setText("Pizza");
        btnPizza.setIcon(new ImageIcon("src/main/resources/images/pizza.png"));
        btnEspaniol.setText("Española");
        btnEspaniol.setIcon(new ImageIcon("src/main/resources/images/paella.png"));

        /*btnHamburguesa.addActionListener(e -> {
            String hamburguesa = "hamburguesa";

            ArrayList<Restaurante> restaurante = jVentanaMadrimentate.getgRestaurantes().buscarRestauranteTipo(hamburguesa);
            if (restaurante.size() > 0) {
                System.out.println("Restaurantes encontrados");
                panelEncontrado = new PanelTipoRestaurante(restaurante);

            } else {
                JOptionPane.showMessageDialog(jVentanaMadrimentate, "No hemos encontrado restaurantes afines a tu busqueda");

            }

        });*/

        btnHamburguesa.addActionListener(e -> {
            ArrayList<Restaurante> restaurantes= new ArrayList<>();
            System.out.println(restaurantes);
            Connection con= ConnectionDAO.getInstance().getConnection();
            //String pizza="pizza";
            try(PreparedStatement pst=con.prepareStatement("SELECT * FROM restaurantes WHERE tipo = 'hamburguesa'");
                ResultSet rs=pst.executeQuery()){
                while (rs.next()){
                    restaurantes.add(new Restaurante(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
                    System.out.println(restaurantes);

                }
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
                System.out.println("No se encontraron restaurantes de hamburguesa");
            }
            System.out.println(restaurantes);
            JFrame frameHamburguesa = new JFrame("RESTAURANTES HAMBURGUESA");
            frameHamburguesa.setSize(750, 400);
            frameHamburguesa.setLocationRelativeTo(null);
            //frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
            frameHamburguesa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //JPanel panel = new JPanel();
            //framePerfil.add(panel);
            JPanel JHamburguesa = new JPanel();
            /*Iterator it=restaurantes.iterator();
            int i=0;
            while (it.hasNext()){
                i=i+1;
                System.out.println(it.next());
                System.out.println("valor i: "+i);
               // String nombre=(it.next()).toString();
                String iStr= String.valueOf(i);
                System.out.println("valor iStr: "+iStr);
                JButton btnRest= new JButton();
                btnRest.setText("Restaurante"+iStr);
                JHamburguesa.add(btnRest);
                btnRest.addActionListener(e ->{
                    JPanel ("Menu "+iStr)=new JPanel("Menu Restaurante "+iStr);
                    frameHamburguesa.add(("Menu "+iStr));
                });
            }*/
            final  JTextArea hamburguesaTextField = new JTextArea(20,20);
            hamburguesaTextField.append(restaurantes.toString());
            //userTextPerfil.setBounds(260, 270, 340, 40);
            hamburguesaTextField.setEditable(false);
            JHamburguesa.add(hamburguesaTextField);
            frameHamburguesa.add(JHamburguesa);
            frameHamburguesa.setVisible(true);
            frameHamburguesa.setResizable(true);

            JButton btnMenu=new JButton();
            btnMenu.setText("MENUS");
            JHamburguesa.add(btnMenu);
            btnMenu.addActionListener(actionEvent-> {
                JFrame frameMH = new JFrame("Menus Restaurantes Hamburguesa");
                frameMH.setSize(900, 700);
                frameMH.setLocationRelativeTo(null);
                //frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
                frameMH.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //JPanel panel = new JPanel();
                //framePerfil.add(panel);
                JPanel JMenuHamb = new PanelMenuHamburguesa();
                frameMH.add(JMenuHamb);
                frameMH.setVisible(true);
                frameMH.setResizable(true);
            });

        });

        /*
        btnEspaniol.addActionListener(e-> {
            String espaniol= "espaniol";
            ArrayList<Restaurante> restaurante = jVentanaMadrimentate.getgRestaurantes().buscarRestauranteTipo(espaniol);
            if (restaurante.size() > 0) {
                System.out.println("Restaurantes encontrados");
                panelEncontrado = new PanelTipoRestaurante(restaurante);

            } else {
                JOptionPane.showMessageDialog(jVentanaMadrimentate, "No hemos encontrado restaurantes afines a tu busqueda");

            }


        });*/

        btnEspaniol.addActionListener(e -> {
            ArrayList<Restaurante> restaurantes= new ArrayList<>();
            System.out.println(restaurantes);
            Connection con= ConnectionDAO.getInstance().getConnection();
            //String pizza="pizza";
            try(PreparedStatement pst=con.prepareStatement("SELECT * FROM restaurantes WHERE tipo = 'espaniola'");
                ResultSet rs=pst.executeQuery()){
                while (rs.next()){
                    restaurantes.add(new Restaurante(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
                    System.out.println(restaurantes);


                }
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
                System.out.println("No se encontraron restaurantes de comida española");
            }
            System.out.println(restaurantes);
            JFrame frameEsp = new JFrame("RESTAURANTES COMIDA ESPAÑOLA");
            frameEsp.setSize(750, 300);
            frameEsp.setLocationRelativeTo(null);
            //frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
            frameEsp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //JPanel panel = new JPanel();
            //framePerfil.add(panel);
            JPanel JEspaniola = new JPanel();
            final  JTextArea espTextField = new JTextArea(20,20);
            espTextField.append(restaurantes.toString());
            //userTextPerfil.setBounds(260, 270, 340, 40);
            espTextField.setEditable(false);
            JEspaniola.add(espTextField);
            frameEsp.add(JEspaniola);
            frameEsp.setVisible(true);
            frameEsp.setResizable(true);
        });

        /*btnPizza.addActionListener(e -> {
            String pizza= "pizza";
            ArrayList<Restaurante> restaurante = jVentanaMadrimentate.getgRestaurantes().buscarRestauranteTipo(pizza);
            if (restaurante.size() > 0) {
                System.out.println("Restaurantes encontrados");
                panelEncontrado = new PanelTipoRestaurante(restaurante);

            } else {
                JOptionPane.showMessageDialog(jVentanaMadrimentate, "No hemos encontrado restaurantes afines a tu busqueda");

            }


        });*/

        btnPizza.addActionListener(e -> {
            ArrayList<Restaurante> restaurantes= new ArrayList<>();
            System.out.println(restaurantes);
            Connection con= ConnectionDAO.getInstance().getConnection();
            //String pizza="pizza";
            try(PreparedStatement pst=con.prepareStatement("SELECT * FROM restaurantes WHERE tipo = 'pizza'");
                ResultSet rs=pst.executeQuery()){
                while (rs.next()){
                    restaurantes.add(new Restaurante(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
                    System.out.println(restaurantes);


                }
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
                System.out.println("No se encontraron restaurantes de pizza");
            }
            System.out.println(restaurantes);
            JFrame framePizza = new JFrame("RESTAURANTES PIZZA");
            framePizza.setSize(750, 400);
            framePizza.setLocationRelativeTo(null);
            //frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
            framePizza.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //JPanel panel = new JPanel();
            //framePerfil.add(panel);
            JPanel JPizza = new JPanel();
            System.out.println(restaurantes);
            final  JTextArea pizzaTextField = new JTextArea(20,20);
            pizzaTextField.append(restaurantes.toString());
            //userTextPerfil.setBounds(260, 270, 340, 40);
            //pizzaTextField.setText(restaurantes.toString());
            pizzaTextField.setEditable(false);
            JPizza.add(pizzaTextField);
            framePizza.add(JPizza);
            framePizza.setVisible(true);
            framePizza.setResizable(true);
        });

        /*btnAsiatico.addActionListener(e -> {
            String asiatico= "asiatico";
            ArrayList<Restaurante> restaurante = jVentanaMadrimentate.getgRestaurantes().buscarRestauranteTipo(asiatico);
            if (restaurante.size() > 0) {
                System.out.println("Restaurantes encontrados");
                panelEncontrado = new PanelTipoRestaurante(restaurante);

            } else {
                JOptionPane.showMessageDialog(jVentanaMadrimentate, "No hemos encontrado restaurantes afines a tu busqueda");

            }


        });*/

        btnAsiatico.addActionListener(e -> {
            ArrayList<Restaurante> restaurantes= new ArrayList<>();
            System.out.println(restaurantes);
            Connection con= ConnectionDAO.getInstance().getConnection();
            //String pizza="pizza";
            try(PreparedStatement pst=con.prepareStatement("SELECT * FROM restaurantes WHERE tipo = 'asiatico'");
                ResultSet rs=pst.executeQuery()){
                while (rs.next()){
                    restaurantes.add(new Restaurante(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
                    System.out.println(restaurantes);


                }
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
                System.out.println("No se encontraron restaurantes de comida asiática");
            }
            System.out.println(restaurantes);
            JFrame frameAsiatico = new JFrame("RESTAURANTES ASIÁTICOS");
            frameAsiatico.setSize(750, 300);
            frameAsiatico.setLocationRelativeTo(null);
            //frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
            frameAsiatico.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //JPanel panel = new JPanel();
            //framePerfil.add(panel);
            JPanel JAsiatico = new JPanel();
            final  JTextArea asiaticoTextField = new JTextArea(20,20);
            asiaticoTextField.append(restaurantes.toString());
            //userTextPerfil.setBounds(260, 270, 340, 40);
            asiaticoTextField.setText(restaurantes.toString());
            asiaticoTextField.setEditable(false);
            JAsiatico.add(asiaticoTextField);
            frameAsiatico.add(JAsiatico);
            frameAsiatico.setVisible(true);
            frameAsiatico.setResizable(true);
        });




        panelSur.add(btnPizza);
        panelSur.add(btnHamburguesa);
        panelSur.add(btnEspaniol);
        panelSur.add(btnAsiatico);


        this.add(panelSur, BorderLayout.SOUTH);
        this.add(panelNorte, BorderLayout.NORTH);
        this.add(panelNorte2, BorderLayout.CENTER);


    }

    /*public static Customer recuperarInformacionRest() {
        Client cliente = new Client();
        HashMap<String, Object> session = new HashMap<>();
        String context = "/getRestaurante";
        System.out.println(userTextLogin.getText());
        session.put("id", Integer.parseInt(userTextLogin.getText()));
        session.put("password", password);
        session = cliente.sentMessage(context, session);
        Customer cu = (Customer) session.get("Customer");
        return cu;
    }*/
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

