package icai.dtc.isw.ui;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.domain.Customer;

import javax.swing.*;
import java.util.HashMap;


public class JVentana extends JFrame {
    private static int id;
    private static String password;

    private static String IdUsuario;


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
}