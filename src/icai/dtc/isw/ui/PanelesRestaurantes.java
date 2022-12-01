package icai.dtc.isw.ui;

import icai.dtc.isw.dao.ConnectionDAO;
import icai.dtc.isw.dao.CustomerDAO;
import icai.dtc.isw.domain.Comida;
import icai.dtc.isw.domain.Restaurante;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.List;

public class PanelesRestaurantes  extends JPanel implements Serializable {

    //private Image imagen=new ImageIcon(getClass().getResource("fondopantallamenu.png")).getImage();

    public BufferedImage image;

    public PanelesRestaurantes() {

        this.setLayout(null);

        final JButton btnRM = new JButton();
        btnRM.setBounds(250, 50, 300, 60);
        btnRM.setBackground(Color.darkGray);
        ImageIcon iconoRM=new ImageIcon("src/main/resources/images/LA-RAZA-LOGO.png");
        btnRM.setIcon(iconoRM);
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
            frame1.setBackground(Color.gray);
            frame1.setLocationRelativeTo(null);
            //frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
            frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel JPanel1 = new JPanel();
            JPanel1.setBackground(Color.gray);

            //insertar imagen
            JLabel imgFondoM = new JLabel(" ");
            ImageIcon ImagenBGM = new ImageIcon("src/main/resources/images/razamadrid.jpg");
            imgFondoM.setIcon(ImagenBGM);
            imgFondoM.setSize(800, 200);
            imgFondoM.setLocation(0, 0);
            imgFondoM.setVisible(true);
            JPanel1.add(imgFondoM);


            final  JTextArea platosTextField = new JTextArea();
            platosTextField.setBounds(20,20,20,25);
            //platosTextField.setFont(Font.getFont(Font.SANS_SERIF));
            platosTextField.setBackground(Color.lightGray);
            //Iterator it1= idmenu.iterator();
            for (int i =0; i<(idmenulist.toArray().length-1); i++){
                platosTextField.append(((idmenulist.toArray())[i]).toString()+". ");
                platosTextField.append(((nombremenulist.toArray())[i]).toString()+" ");
                platosTextField.append(((preciomenulist.toArray())[i]).toString()+"€");
                platosTextField.append("\n");
                //i=i+1;
            }
            JPanel1.add(platosTextField);

            final JButton btnanadir=new JButton("Añadir artículo");
            btnanadir.setBounds(450,300,100,55);
            ImageIcon iconoadd=new ImageIcon("src/main/resources/images/anadircestaicon.png");
            btnanadir.setIcon(iconoadd);
            JPanel1.add(btnanadir);

            final JTextArea platosseleccionados=new JTextArea();
            platosseleccionados.setBounds(45,20,20,25);
            platosseleccionados.setBackground(Color.lightGray);
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
            btnPedir.setBounds(250, 300, 100, 55);
            ImageIcon iconoorder=new ImageIcon("src/main/resources/images/iconopedir.png");
            btnPedir.setIcon(iconoorder);
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
            //JPanel1.add(platosTextField);
            frame1.add(JPanel1);
            frame1.setVisible(true);
            frame1.setResizable(true);

            });


            JButton btnNAP = new JButton("NAP");
            btnNAP.setBounds(250, 150, 300, 60);
            btnNAP.setBackground(Color.white);
            ImageIcon iconoNAP=new ImageIcon("src/main/resources/images/naplogo.png");
            btnNAP.setIcon(iconoNAP);
            this.add(btnNAP);


            JButton btnMU = new JButton("MU!");
            btnMU.setBounds(250, 250, 300, 60);
            btnMU.setBackground(Color.darkGray);
            ImageIcon iconoMU=new ImageIcon("src/main/resources/images/logo_muu.png");
            btnMU.setIcon(iconoMU);
            this.add(btnMU);

            JButton btnLB = new JButton("LA BARRACA");
            btnLB.setBounds(250, 350, 300, 60);
            btnLB.setBackground(Color.white);
            ImageIcon iconoLB=new ImageIcon("src/main/resources/images/Logo-La-Barraca.png");
            btnLB.setIcon(iconoLB);
            this.add(btnLB);


            JButton btnVB = new JButton("VIVA BURGUER");
            btnVB.setBounds(250, 450, 300, 60);
            btnVB.setBackground(Color.darkGray);
            btnVB.setForeground(Color.white);
            ImageIcon iconoVB=new ImageIcon("src/main/resources/images/vivaburguer.png");
            btnVB.setIcon(iconoVB);
            this.add(btnVB);



            JButton btnLP = new JButton();
            btnLP.setBounds(250, 550, 300, 60);
            btnLP.setBackground(Color.white);
            ImageIcon iconoLP=new ImageIcon("src/main/resources/images/paella-de-la-reina.png");
            btnLP.setIcon(iconoLP);
            this.add(btnLP);

            JButton btnSumo = new JButton("SUMO");
            btnSumo.setBounds(250, 650, 300, 60);
            btnSumo.setBackground(Color.darkGray);
            btnSumo.setForeground(Color.white);
            ImageIcon iconoSumo=new ImageIcon("src/main/resources/images/sumo-logo.png");
            btnSumo.setIcon(iconoSumo);
            this.add(btnSumo);

            JButton btnFF = new JButton("FRATELLI FIGURATO");
            btnFF.setBounds(250, 750, 300, 60);
            btnFF.setBackground(Color.white);
            ImageIcon iconoFF=new ImageIcon("src/main/resources/images/fratelli_figurato_logo.png");
            btnFF.setIcon(iconoFF);
            this.add(btnFF);


            /*
            JButton btnDXO= new JButton("DIVERXO");
            btnDXO.setBounds(300, 750, 200, 50);
            this.add(btnDXO);
            */

        }

        /*
        public void paint(Graphics g){
            g.drawImage(imagen, 0,0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
        */
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