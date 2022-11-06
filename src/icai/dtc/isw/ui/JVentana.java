package icai.dtc.isw.ui;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.domain.Customer;

import javax.swing.*;
import java.util.HashMap;

import icai.dtc.isw.controler.GestorBD;
import icai.dtc.isw.dao.ConnectionDAO;
import icai.dtc.isw.dao.CustomerDAO;

import javax.swing.*;


public class JVentana extends JFrame {
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
    public static void main(String[] args) {
        //new JVentana();
        JFrame frame = new JFrame("MADRIMENTATE");
        frame.setSize(650, 550);
        //frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
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