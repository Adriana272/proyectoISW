package icai.dtc.isw.ui;

import icai.dtc.isw.dao.ConnectionDAO;
import icai.dtc.isw.domain.Restaurante;

import javax.swing.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class PanelesRestaurantes  extends JPanel implements Serializable {

    public PanelesRestaurantes(){
            this.setLayout(null);
            /*
            ArrayList restaurantes= new ArrayList();
            System.out.println(restaurantes);
            Connection con= ConnectionDAO.getInstance().getConnection();
            //String pizza="pizza";
            try(PreparedStatement pst=con.prepareStatement("SELECT nombre FROM restaurantes");
                ResultSet rs=pst.executeQuery()){
                while (rs.next()){
                    restaurantes.add(rs.getString(1));
                    System.out.println(restaurantes);

                }
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
                System.out.println("No se encontraron restaurantes");
            }
            System.out.println(restaurantes);
            JPanel rests=new JPanel();
            final  JTextArea restTextField = new JTextArea(20,20);
            restTextField.append(restaurantes.toString());
            //userTextPerfil.setBounds(260, 270, 340, 40);
            restTextField.setEditable(false);
            rests.add(restTextField);
            this.add(rests);
            this.setVisible(true);
            //this.setResizable(true);
*/
            final JButton btnRM= new JButton("RAZA MADRID");
            btnRM.setBounds(300, 50, 200, 50);
            this.add(btnRM);

        btnRM.addActionListener(e -> {
            ArrayList idmenu= new ArrayList();
            System.out.println(idmenu);
            ArrayList productos= new ArrayList();
            System.out.println(productos);
            ArrayList precio= new ArrayList();
            System.out.println(precio);
            Connection con= ConnectionDAO.getInstance().getConnection();
            //String pizza="pizza";
            try(PreparedStatement pst=con.prepareStatement("SELECT idmenu, producto, precio FROM menu WHERE idrest = 1");
                ResultSet rs=pst.executeQuery()){
                while (rs.next()){
                    idmenu.add(rs.getInt(1));
                    productos.add(rs.getString(2));
                    precio.add(rs.getInt(2));
                    System.out.println(idmenu);
                    System.out.println(productos);
                    System.out.println(precio);

                }
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
                System.out.println("No se encontraron restaurantes de hamburguesa");
            }
            System.out.println(idmenu);
            try(PreparedStatement pst=con.prepareStatement("SELECT idmenu FROM menu WHERE idrest = 1");
                ResultSet rs=pst.executeQuery()){
                while (rs.next()){
                    idmenu.add(rs.getInt(1));

                    System.out.println(idmenu);


                }
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
                System.out.println("No se encontraron restaurantes de hamburguesa");
            }
            System.out.println(idmenu);


            try(PreparedStatement pst=con.prepareStatement("SELECT producto FROM menu WHERE idrest = 1");
                ResultSet rs=pst.executeQuery()){
                while (rs.next()){
                    productos.add(rs.getString(1));
                    System.out.println(productos);

                }
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
                System.out.println("No se encontraron restaurantes de hamburguesa");
            }
            System.out.println(productos);

            try(PreparedStatement pst=con.prepareStatement("SELECT precio FROM menu WHERE idrest = 1");
                ResultSet rs=pst.executeQuery()){
                while (rs.next()){
                    precio.add(rs.getInt(1));

                    System.out.println(precio);

                }
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
                System.out.println("No se encontraron restaurantes de hamburguesa");
            }
            System.out.println(idmenu);

            JFrame frame1 = new JFrame("CARTA RESTAURANTE RAZA MADRID");
            frame1.setSize(750, 400);
            frame1.setLocationRelativeTo(null);
            //frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
            frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel JPanel1 = new JPanel();

            final  JTextArea platosTextField = new JTextArea(20,25);
            //Iterator it1= idmenu.iterator();
            for (int i =0; i<(idmenu.toArray().length-1); i++){
                platosTextField.append(((idmenu.toArray())[i]).toString()+". ");
                platosTextField.append(((productos.toArray())[i]).toString()+" ");
                platosTextField.append(((precio.toArray())[i]).toString()+"€");
                platosTextField.append("\n");
                //i=i+1;
            }

            //PARA SELECCIONAR INSERTAR IDMENU Y CANTIDAD Y HACER UN HASHMAP, REALIZAR EL CÁLCULO PARA CALCULAR EL PRECIO
            //AÑADIR UN JBUTTON PARA AÑADIR ARTICULO QUE ME ABRA UN JOPTIONPANE DONDE INSERTE IDMENU Y CANTIDAD
            //IR ALMACENANDO PRECIO PARCIAL HASTA QUE SE PULSE FINALIZAR PEDIDO QUE TOTAL=PARCIAL
            //TOTAL=MULTIPLICACIÓN DE LA CANTIDAD POR EL PRECIO DEL PRODUCTO Y REPAINT
            //BOTON PEDIR QUE ME LLEVE A TIPOS DE DELIVERY

            /*
            platosTextField.append(idmenu.toString());
            platosTextField.append("\n");
            platosTextField.append(productos.toString());
            platosTextField.append("\n");
            platosTextField.append(precio.toString());*/
            //userTextPerfil.setBounds(260, 270, 340, 40);
            platosTextField.setEditable(false);
            JPanel1.add(platosTextField);
            frame1.add(JPanel1);
            frame1.setVisible(true);
            frame1.setResizable(true);

            });

            JButton btnNAP= new JButton("NAP");
            btnNAP.setBounds(300, 150, 200, 50);
            this.add(btnNAP);



            JButton btnMU= new JButton("MU!");
            btnMU.setBounds(300, 250, 200, 50);
            this.add(btnMU);



            JButton btnVB= new JButton("VIVA BURGUER");
            btnVB.setBounds(300, 350, 200, 50);
            this.add(btnVB);



            JButton btnLB= new JButton("LA BARRACA");
            btnLB.setBounds(300, 450, 200, 50);
            this.add(btnLB);



            JButton btnLP= new JButton("LA PAELLA");
            btnLP.setBounds(300, 550, 200, 50);
            this.add(btnLP);



            JButton btnFF= new JButton("FRATELLI FIGURATO");
            btnFF.setBounds(300, 650, 200, 50);
            this.add(btnFF);


        /*
            JButton btnDXO= new JButton("DIVERXO");
            btnDXO.setBounds(300, 750, 200, 50);
            this.add(btnDXO);
    */


            JButton btnSumo= new JButton("SUMO");
            btnSumo.setBounds(300, 750, 200, 50);
            this.add(btnSumo);
    }
}