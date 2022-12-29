package icai.dtc.isw.ui;

import icai.dtc.isw.dao.CustomerDAO;
import icai.dtc.isw.domain.Comida;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelMenu extends JPanel {

    private JVentana jVentanaMadrimentate;

    public PanelMenu(JVentana jVentanaMadrimentate) {
        this.jVentanaMadrimentate = jVentanaMadrimentate;

        this.setSize(200, 800);
        this.setLayout(new BorderLayout());





        //por cada restaurante con el mismo id tendra un menu con el mismo id que el restaurante (mismo id por cada producto)
        ArrayList<Comida> menu;
        menu = jVentanaMadrimentate.getgRestaurantes().buscarIdRest(1);
        ArrayList<Comida> comida;
        comida = jVentanaMadrimentate.getgRestaurantes().buscarIdMenu(1,2);
        System.out.println(comida);




        ArrayList<Comida> prueba2;
        prueba2 = CustomerDAO.fetchComidas();
        //System.out.println(prueba2);



    }


    public void mostrarMenu(int idRest){
        ArrayList<Comida> menu;
        menu = jVentanaMadrimentate.getgRestaurantes().buscarIdRest(idRest);
        for(int i=0;i<menu.size();i++){
            JPanel pnlProducto = new JPanel(new FlowLayout());
            ArrayList<Comida> ccc;
            ccc = jVentanaMadrimentate.getgRestaurantes().buscarIdMenu(idRest,i);
            System.out.println(ccc);
            JTextField txtnumero = new JTextField();






        }

    }
}




/*package icai.dtc.isw.ui;

import icai.dtc.isw.dao.ConnectionDAO;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PanelMenuHamburguesa extends JPanel implements Serializable {


    public PanelMenuHamburguesa() {

        this.setLayout(null);
        this.setBackground(Color.darkGray);

        //insertar imagen
        /* ¿POR QUÑE EN ESTE CASO NO PUEDO INSERTAR LA IMAGEN CORRECTAMENTE?
        JLabel imgMenu = new JLabel(" ");
        ImageIcon ImagenM = new ImageIcon("src/main/resources/images/pizarramenuredimensionada.jpg");
        imgMenu.setIcon(ImagenM);
        imgMenu.setSize(900, 639);
        imgMenu.setLocation(0, 0);
        imgMenu.setVisible(true);
        this.add(imgMenu);*/

/*
        final  JTextArea hamburguesaEntrantes = new JTextArea(20,20);
        hamburguesaEntrantes.append("ENTRANTES");
        hamburguesaEntrantes.setBounds(25, 25, 250, 25);
        hamburguesaEntrantes.setEditable(false);
        this.add(hamburguesaEntrantes);

        final  JTextArea hamburguesaPrincipales = new JTextArea(20,10);
        hamburguesaPrincipales.append("PRINCIPALES");
        hamburguesaPrincipales.setBounds(325, 25, 250, 25);
        hamburguesaPrincipales.setEditable(false);
        this.add(hamburguesaPrincipales);

        final  JTextArea hamburguesaBebidas = new JTextArea(20,10);
        hamburguesaBebidas.append("BEBIDAS");
        hamburguesaBebidas.setBounds(625, 25, 250, 25);
        hamburguesaBebidas.setEditable(false);
        this.add(hamburguesaBebidas);

        final  JTextArea PrecioM = new JTextArea(20,10);
        PrecioM.append("Precio medio Menú");
        PrecioM.setBounds(25, 450, 200, 25);
        PrecioM.setEditable(false);
        this.add(PrecioM);

        final  JTextArea PrecioE = new JTextArea(20,10);
        PrecioE.append("Precio Menú entero");
        PrecioE.setBounds(250, 450, 200, 25);
        PrecioE.setEditable(false);
        this.add(PrecioE);


        //Crear ArrayList Restaurantes
        ArrayList rests=new ArrayList();
        System.out.println(rests);
        Connection con= ConnectionDAO.getInstance().getConnection();
        //String pizza="pizza";
        try(PreparedStatement pst=con.prepareStatement("SELECT nombre FROM menu WHERE tipo = 'hamburguesa'");
            ResultSet rs=pst.executeQuery()){
            while (rs.next()){
                rests.add(rs.getString(1));
                System.out.println(rests.toString());

            }
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("No se encontraron restaurantes de hamburguesa");
        }
        System.out.println(rests);

        final  JTextArea hamburguesaRestaurantes = new JTextArea(20,20);
        hamburguesaRestaurantes.append(rests.toString());
        hamburguesaRestaurantes.setBounds(25, 300, 850, 50);
        hamburguesaRestaurantes.setEditable(false);
        this.add(hamburguesaRestaurantes);

        //Crear ArrayList PrecioMedio
        ArrayList medio=new ArrayList();
        System.out.println(rests);
        //Connection con= ConnectionDAO.getInstance().getConnection();
        //String pizza="pizza";
        try(PreparedStatement pst=con.prepareStatement("SELECT preciomedio FROM menu WHERE tipo = 'hamburguesa'");
            ResultSet rs=pst.executeQuery()){
            while (rs.next()){
                medio.add(rs.getInt(1));
                System.out.println(medio);

            }
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("No se encontraron restaurantes de hamburguesa");
        }
        System.out.println(medio);

        final  JTextArea hamburguesaPM = new JTextArea(20,20);
        hamburguesaPM.append(medio.toString());
        hamburguesaPM.setBounds(25, 475, 200, 75);
        hamburguesaPM.setEditable(false);
        this.add(hamburguesaPM);

        //Crear ArrayList PrecioEntero
        ArrayList entero=new ArrayList();
        System.out.println(entero);
        //Connection con= ConnectionDAO.getInstance().getConnection();
        //String pizza="pizza";
        try(PreparedStatement pst=con.prepareStatement("SELECT precioentero FROM menu WHERE tipo = 'hamburguesa'");
            ResultSet rs=pst.executeQuery()){
            while (rs.next()){
                entero.add(rs.getInt(1));
                System.out.println(entero);

            }
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("No se encontraron restaurantes de hamburguesa");
        }
        System.out.println(entero);

        final  JTextArea hamburguesaPE = new JTextArea(20,20);
        hamburguesaPE.append(entero.toString());
        hamburguesaPE.setBounds(250, 475, 200, 75);
        hamburguesaPE.setEditable(false);
        this.add(hamburguesaPE);

        //Crear ArrayList Entrantes
        ArrayList entrantes= new ArrayList();
        System.out.println(entrantes);
        //Connection con= ConnectionDAO.getInstance().getConnection();
        //String pizza="pizza";
        try(PreparedStatement pst=con.prepareStatement("SELECT entrantes FROM menu WHERE tipo = 'hamburguesa'");
            ResultSet rs=pst.executeQuery()){
            while (rs.next()){
                entrantes.add(rs.getString(1));
                System.out.println(entrantes);

            }
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("No se encontraron entrantes en restaurantes de hamburguesa");
        }
        System.out.println(entrantes);

        final  JTextArea hamburguesaTextField1 = new JTextArea(20,20);
        hamburguesaTextField1.append(entrantes.toString());
        hamburguesaTextField1.setBounds(25, 70, 250, 150);
        hamburguesaTextField1.setEditable(false);
        this.add(hamburguesaTextField1);

        //Crear ArrayList Principales
        ArrayList principales= new ArrayList();
        System.out.println(principales);
        //Connection con= ConnectionDAO.getInstance().getConnection();
        //String pizza="pizza";
        try(PreparedStatement pst=con.prepareStatement("SELECT principales FROM menu WHERE tipo = 'hamburguesa'");
            ResultSet rs=pst.executeQuery()){
            while (rs.next()){
                principales.add(rs.getString(1));
                System.out.println(principales);

            }
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("No se encontraron platos principales en restaurantes de hamburguesa");
        }
        System.out.println(principales);
        //String[] cadenaseparada= principales.split(",");


        final  JTextArea hamburguesaTextField2 = new JTextArea(20,20);
        hamburguesaTextField2.append(principales.toString());
        hamburguesaTextField2.setBounds(325, 70, 250, 150);
        hamburguesaTextField2.setEditable(false);
        this.add(hamburguesaTextField2);

        //Crear ArrayList Bebidas
        ArrayList bebidas= new ArrayList();
        System.out.println(bebidas);
        //Connection con= ConnectionDAO.getInstance().getConnection();
        //String pizza="pizza";
        try(PreparedStatement pst=con.prepareStatement("SELECT bebidas FROM menu WHERE tipo = 'hamburguesa'");
            ResultSet rs=pst.executeQuery()){
            while (rs.next()){
                bebidas.add(rs.getString(1));
                System.out.println(bebidas);

            }
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("No se encontraron bebidas en restaurantes de hamburguesa");
        }
        System.out.println(bebidas);

        final  JTextArea hamburguesaTextField3 = new JTextArea(20,20);
        hamburguesaTextField3.append(bebidas.toString());
        hamburguesaTextField3.setBounds(625, 70, 250, 150);
        hamburguesaTextField3.setEditable(false);
        this.add(hamburguesaTextField3);



        final JButton btnPedir = new JButton("A domicilio");
        btnPedir.setFont(new Font("Arial Black", Font.BOLD, 11));
        btnPedir.setBounds(500, 500, 150, 50);
        //ImageIcon iconoName = new ImageIcon("src/main/resources/images/info.png");
        //btnPedir.setIcon(iconoName);
        btnPedir.setBackground(Color.white);
        this.add(btnPedir);


        final JButton btnReservar = new JButton("Reservar mesa");
        btnReservar.setFont(new Font("Arial Black", Font.BOLD, 11));
        btnReservar.setBounds(675, 500, 150, 50);
        //ImageIcon iconoName = new ImageIcon("src/main/resources/images/info.png");
        //btnPedir.setIcon(iconoName);
        btnReservar.setBackground(Color.white);
        this.add(btnReservar);
    }
}*/
