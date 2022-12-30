package icai.dtc.isw.ui;

import icai.dtc.isw.dao.CustomerDAO;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PanelPedirDomicilio extends JPanel implements Serializable {

    public String nombrerest;

    public PanelPedirDomicilio(int idrestaurante){
        this.setLayout(null);


        ArrayList idmenulist=new ArrayList();
        idmenulist= CustomerDAO.getIdsComida(idrestaurante);
        System.out.println("lista ids:");
        System.out.println(idmenulist);

        ArrayList nombremenulist=new ArrayList();
        nombremenulist= CustomerDAO.getNombreComida(idrestaurante);
        System.out.println("lista nombres:");
        System.out.println(nombremenulist);

        ArrayList preciomenulist=new ArrayList();
        preciomenulist= CustomerDAO.getPreciosComida(idrestaurante);
        System.out.println("lista precios:");
        System.out.println(preciomenulist);

        this.setBackground(Color.gray);

        //insertar imagen
        JLabel imgFondoM = new JLabel(" ");
        ImageIcon ImagenBGM = new ImageIcon("src/main/resources/images/razamadrid.jpg");
        imgFondoM.setIcon(ImagenBGM);
        imgFondoM.setSize(800, 200);
        imgFondoM.setLocation(0, 0);
        imgFondoM.setVisible(true);
        this.add(imgFondoM);


        final  JTextArea platosTextField = new JTextArea();
        platosTextField.setBounds(50,250,300,200);
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
        platosTextField.setVisible(true);
        this.add(platosTextField);

        final JButton btnanadir=new JButton("Añadir artículo");
        btnanadir.setBounds(170,500,200,55);
        ImageIcon iconoadd=new ImageIcon("src/main/resources/images/anadircestaicon.png");
        btnanadir.setIcon(iconoadd);
        this.add(btnanadir);

        final JTextArea platosseleccionados=new JTextArea();
        platosseleccionados.setBounds(450,250,300,200);
        platosseleccionados.setBackground(Color.lightGray);
        this.add(platosseleccionados);
        platosseleccionados.setVisible(true);

        final JTextArea pt=new JTextArea();
        pt.setBounds(250,600,300,200);
        pt.setBackground(Color.lightGray);
        pt.append("PRECIOS PARCIALES COMPRA-> ");
        this.add(pt);
        pt.setVisible(true);

        ArrayList<Integer> precioscompra=new ArrayList<>();


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

            precioart=CustomerDAO.getPrecioArticulo(idrestaurante, Integer.parseInt(idproducto));
            //String pizza="pizza";

            System.out.println(precioart);
            preciop=Integer.parseInt(cantidad)*precioart;

            String nombreart=null;
            nombreart=CustomerDAO.getNombreArticulo(idrestaurante, Integer.parseInt(idproducto));
            System.out.println(nombreart);


            platosseleccionados.append(cantidad+" x "+nombreart+" = "+preciop+"€");
            platosseleccionados.append("\n");


            precioscompra.add(preciop);
            System.out.println(precioscompra);


            int preciototal=0;

            for (int i=0; i<precioscompra.toArray().length; i++){
                preciototal=preciototal+(Integer)(precioscompra.toArray()[i]);
            }

            //preciototal=preciototal+preciop;
            System.out.println(preciototal);
            /*JLabel pt= new JLabel("Precio= "+preciototal);
            pt.setBounds(700,700,50,50);
            this.add(pt);*/

            pt.append("\n");
            pt.append("Nuevo precio total compra: ");
            pt.append(String.valueOf(preciototal)+"€");


        });



        JButton btnPedir=new JButton("Pedir");
        btnPedir.setBounds(430, 500, 200, 55);
        ImageIcon iconoorder=new ImageIcon("src/main/resources/images/iconopedir.png");
        btnPedir.setIcon(iconoorder);
        this.add(btnPedir);

        btnPedir.addActionListener(e1->{

            int dialogbutton=JOptionPane.showConfirmDialog(null, "¿Seguro que deseas proceder a realizar tu pedido?", "ATENCIÓN", JOptionPane.YES_NO_OPTION);
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

    }
}