package icai.dtc.isw.ui;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.domain.Customer;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

import icai.dtc.isw.controler.GestorBD;
import icai.dtc.isw.dao.ConnectionDAO;
import icai.dtc.isw.dao.CustomerDAO;

import javax.swing.*;


public class JVentana extends javax.swing.JFrame {
    private static int id;
    private static String password;

    private static String IdUsuario;

    private GestorBD gRestaurantes = new GestorBD(new CustomerDAO(ConnectionDAO.getInstance().getConnection()));

    private PanelRestaurante panelRestaurante;
    private PanelTipoRestaurante pnlTipo;
    private JPanel pnlHome;
    private JButton start;
    private PanelDeliveryRestaurante pnldeliveryrestauran;
    private PanelReservarMesa pnlReservar;
    /*
    Image img= Toolkit.getDefaultToolkit().getImage("bin/images/fondo pantalla comida.jpg");
    public JVentana() throws IOException {
        //Image img= Toolkit.getDefaultToolkit().getImage("bin/images/fondo pantalla comida.jpg");
        this.setContentPane(new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(img,0,0,null);
            }
        });
        pack();
        setVisible(true);
    }*/

    PanelFondoBeg panelfondo=new PanelFondoBeg();
    public JVentana(){
        super();
        CrearFormulario();
    }

    public void CrearFormulario() {
        Container contenedor = getContentPane();
        contenedor.add(panelfondo);

    }
    public static void main(String[] args) throws Exception{
        //new JVentana();
        JFrame frame = new JFrame("MADRIMENTATE");
        frame.setSize(650, 550);
        //frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setBackground(Color.darkGray);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        //JPanel panel = new JPanel();
        //frame.add(panel);
        JPanel inicio= new PlaceComponentsInicio();
        frame.add(inicio);
        frame.setVisible(true);
        frame.setResizable(true);
        //frame.pack();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void inVentanaTipoRestaurante(String tipoComida){
        panelRestaurante.setVisible(false);
        pnlTipo.setVisible(true);

    }
    public GestorBD getgRestaurantes(){
        return gRestaurantes;
    }
}