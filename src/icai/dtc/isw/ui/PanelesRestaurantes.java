package icai.dtc.isw.ui;

import icai.dtc.isw.dao.ConnectionDAO;
import icai.dtc.isw.dao.CustomerDAO;
import icai.dtc.isw.domain.Comida;
import icai.dtc.isw.domain.Restaurante;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.List;

public class PanelesRestaurantes  extends JPanel implements Serializable {

    public PanelesRestaurantes() {

        this.setLayout(null);


        final JButton btnRM = new JButton("RAZA MADRID");
        btnRM.setBounds(300, 50, 200, 50);
        this.add(btnRM);

        btnRM.addActionListener(e -> {

            /*
            Connection con= ConnectionDAO.getInstance().getConnection();
            //String pizza="pizza";
            try(PreparedStatement pst=con.prepareStatement("SELECT idmenu, producto, precio FROM menu WHERE idrest = 1");
                ResultSet rs=pst.executeQuery()){
                while (rs.next()){
                    idmenu.add(rs.getInt(1));
                    productos.add(rs.getString(2));
                    precio.add(rs.getInt(3));
                    System.out.println(idmenu);
                    System.out.println(productos);
                    System.out.println(precio);

                }
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
                System.out.println("No se encontraron menús de restaurantes");
            }


            ArrayList<Comida> menu;
            menu = JVentana.getgRestaurantes().buscarIdRest(1);
            ArrayList<Comida> comida;
            comida = JVentana.getgRestaurantes().buscarIdMenu(1, 2);
            System.out.println(comida);


            ArrayList<Comida> prueba2;
            prueba2 = CustomerDAO.fetchComidas();

             */





            ArrayList idmenulist=new ArrayList();
            idmenulist= CustomerDAO.getIdsComida(1);
            System.out.println("lista ids:");
            System.out.println(idmenulist);

            ArrayList nombremenulist=new ArrayList();
            nombremenulist= CustomerDAO.getNombreComida(1);
            System.out.println("lista nombres:");
            System.out.println(nombremenulist);

            ArrayList preciomenulist=new ArrayList();
            preciomenulist= CustomerDAO.getPreciosComida(1);
            System.out.println("lista precios:");
            System.out.println(preciomenulist);

            /*
            System.out.println(menu);
            System.out.println("imprimir prueba 2: ");
            System.out.println(prueba2);
            System.out.println(precio);
            */

            JFrame frame1 = new JFrame("CARTA RESTAURANTE RAZA MADRID");
            frame1.setSize(800, 900);
            frame1.setLocationRelativeTo(null);
            //frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
            frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel JPanel1 = new JPanel();

            //insertar imagen
            /*JLabel imgFondoM = new JLabel(" ");
            ImageIcon ImagenBGM = new ImageIcon("src/main/resources/images/fondopantallamenu.png");
            imgFondoM.setIcon(ImagenBGM);
            imgFondoM.setSize(800, 900);
            imgFondoM.setLocation(0, 0);
            imgFondoM.setVisible(true);
            JPanel1.add(imgFondoM);*/

            final  JTextArea platosTextField = new JTextArea();
            platosTextField.setBounds(20,20,20,25);
            //Iterator it1= idmenu.iterator();
            for (int i =0; i<(idmenulist.toArray().length-1); i++){
                platosTextField.append(((idmenulist.toArray())[i]).toString()+". ");
                platosTextField.append(((nombremenulist.toArray())[i]).toString()+" ");
                platosTextField.append(((preciomenulist.toArray())[i]).toString()+"€");
                platosTextField.append("\n");
                //i=i+1;
            }

            final JButton btnanadir=new JButton("Añadir artículo");
            btnanadir.setBounds(450,300,100,50);
            JPanel1.add(btnanadir);

            final JTextArea platosseleccionados=new JTextArea();
            platosseleccionados.setBounds(45,20,20,25);
            JPanel1.add(platosseleccionados);
            platosseleccionados.setVisible(true);

            List<Integer> precioscompra=new ArrayList<>();

            btnanadir.addActionListener(actionEvent -> {
                String infoart=JOptionPane.showInputDialog(null, "Inserte 'id producto,cantidad'");
                String[] infoarticulo= infoart.split(",");
                String idproducto= infoarticulo[0];
                String cantidad= infoarticulo[1];

                Map<Integer, Integer> listacompra=new HashMap<>();
                listacompra.put(Integer.parseInt(idproducto),Integer.parseInt(cantidad));


                int preciop=0;

                //ArrayList precioart= new ArrayList();
                int precioart=0;
                System.out.println(precioart);

                precioart=CustomerDAO.getPrecioArticulo(1, Integer.parseInt(idproducto));
                //String pizza="pizza";

                System.out.println(precioart);
                preciop=Integer.parseInt(cantidad)*precioart;

                String nombreart=null;
                nombreart=CustomerDAO.getNombreArticulo(1, Integer.parseInt(idproducto));
                System.out.println(nombreart);

                /*
                String nombreart=null;
                try(PreparedStatement pst=con.prepareStatement("SELECT producto FROM menu WHERE idrest = 1 AND idmenu = "+Integer.parseInt(idproducto));
                    ResultSet rs=pst.executeQuery()){
                    while (rs.next()){
                        nombreart=rs.getString(1);
                        System.out.println(nombreart);
                    }
                } catch (SQLException ex){
                    System.out.println(ex.getMessage());
                    System.out.println("No se encontró el nombre del artículo");
                }
                System.out.println(nombreart);
                 */

                platosseleccionados.append(cantidad+" x "+nombreart+" = "+preciop);
                platosseleccionados.append("\n");


                precioscompra.add(preciop);
                System.out.println(precioscompra);
                });



            JButton btnPedir=new JButton("Pedir");
            btnPedir.setBounds(250, 300, 100, 50);
            JPanel1.add(btnPedir);

            btnPedir.addActionListener(e1->{

                int dialogbutton=JOptionPane.showConfirmDialog(null, "Seguro que deseas proceder a realizar tu pedido?", "ATENCIÓN", JOptionPane.YES_NO_OPTION);
                if(dialogbutton==JOptionPane.YES_OPTION) {
                    JFrame frameDelivery = new JFrame("ENVÍOS");
                    frameDelivery.setSize(800, 900);
                    frameDelivery.setLocationRelativeTo(null);
                    //frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
                    frameDelivery.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    //JPanel panelHome = new PanelRestaurante();
                    JPanel panelDelivery = new PanelDeliveryRestaurante();
                    //placeComponentsAjustes(panelAj);
                    frameDelivery.add(panelDelivery);
                    frameDelivery.setVisible(true);
                    frameDelivery.setResizable(true);
                }
                if (dialogbutton == JOptionPane.NO_OPTION) { //por que en este caso también se me va al panel de envio??
                        remove(dialogbutton);
                        //System.exit(0);

                }
            });

            platosTextField.setEditable(false);
            JPanel1.add(platosTextField);
            frame1.add(JPanel1);
            frame1.setVisible(true);
            frame1.setResizable(true);

            });



            JButton btnNAP = new JButton("NAP");
            btnNAP.setBounds(300, 150, 200, 50);
            this.add(btnNAP);


            JButton btnMU = new JButton("MU!");
            btnMU.setBounds(300, 250, 200, 50);
            this.add(btnMU);


            JButton btnVB = new JButton("VIVA BURGUER");
            btnVB.setBounds(300, 350, 200, 50);
            this.add(btnVB);


            JButton btnLB = new JButton("LA BARRACA");
            btnLB.setBounds(300, 450, 200, 50);
            this.add(btnLB);


            JButton btnLP = new JButton("LA PAELLA");
            btnLP.setBounds(300, 550, 200, 50);
            this.add(btnLP);


            JButton btnFF = new JButton("FRATELLI FIGURATO");
            btnFF.setBounds(300, 650, 200, 50);
            this.add(btnFF);



            JButton btnDXO= new JButton("DIVERXO");
            btnDXO.setBounds(300, 750, 200, 50);
            this.add(btnDXO);


            JButton btnSumo = new JButton("SUMO");
            btnSumo.setBounds(300, 750, 200, 50);
            this.add(btnSumo);
        }

        public void mostrarMenu(int idRest){
            ArrayList<Comida> menu;
            menu = JVentana.getgRestaurantes().buscarIdRest(idRest);
            for (int i = 0; i < menu.size(); i++) {
                JPanel pnlProducto = new JPanel(new FlowLayout());
                ArrayList<Comida> ccc;
                ccc = JVentana.getgRestaurantes().buscarIdMenu(idRest, i);
                System.out.println(ccc);
                JTextField txtnumero = new JTextField();

            }
        }
    }