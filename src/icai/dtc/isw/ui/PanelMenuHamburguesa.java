package icai.dtc.isw.ui;

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
        /*
        JLabel imgMenu = new JLabel(" ");
        ImageIcon ImagenM = new ImageIcon("src/main/resources/images/pizarramenuredimensionada.jpg");
        imgMenu.setIcon(ImagenM);
        imgMenu.setSize(900, 639);
        imgMenu.setLocation(0, 0);
        imgMenu.setVisible(true);
        this.add(imgMenu);
        */

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

        final  JTextArea hamburguesaRestaurantes = new JTextArea(20,20);
        hamburguesaRestaurantes.append(rests.toString());
        hamburguesaRestaurantes.setBounds(25, 300, 850, 50);
        hamburguesaRestaurantes.setEditable(false);
        this.add(hamburguesaRestaurantes);


        final JButton btnPedir = new JButton("A domicilio");
        btnPedir.setFont(new Font("Arial Black", Font.BOLD, 18));
        btnPedir.setBounds(225, 400, 200, 50);
        //ImageIcon iconoName = new ImageIcon("src/main/resources/images/info.png");
        //btnPedir.setIcon(iconoName);
        btnPedir.setBackground(Color.white);
        this.add(btnPedir);


        final JButton btnReservar = new JButton("Reservar mesa");
        btnReservar.setFont(new Font("Arial Black", Font.BOLD, 18));
        btnReservar.setBounds(475, 400, 200, 50);
        //ImageIcon iconoName = new ImageIcon("src/main/resources/images/info.png");
        //btnPedir.setIcon(iconoName);
        btnReservar.setBackground(Color.white);
        this.add(btnReservar);
    }
}