package icai.dtc.isw.ui;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.domain.Customer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import icai.dtc.isw.controler.GestorBD;
import icai.dtc.isw.dao.ConnectionDAO;
import icai.dtc.isw.dao.CustomerDAO;

import javax.swing.*;


public class JVentana extends javax.swing.JFrame {
    private static GestorBD gRestaurantes = new GestorBD(new CustomerDAO(ConnectionDAO.getInstance().getConnection()));
    private PanelDeliveryRestaurante pnldeliveryRestaurante2;

    private PlaceComponentsInicio pnlInicio;

    private PlaceComponentsPerfil pnlPerfil;

    private PanelEmpezar pnlEmpezar;

    private  PanelRestaurante panelRestaurante = new PanelRestaurante(this);
    private  PanelTipoRestaurante pnlTipo = new PanelTipoRestaurante(this);
    private PanelDeliveryRestaurante pnldeliveryrestauran;
    private PanelReservarMesa pnlReservar = new PanelReservarMesa(this);
    private PanelMenu pnlmenu;
    private static int id;
    private static String password;

    private static String IdUsuario;

    private JPanel pnlHome;

    private JButton start;


    //background=imagenfondo.getImage()
    private URL fondo;
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

    //PanelFondoBeg panelfondo=new PanelFondoBeg();
    public JVentana(){
        JFrame frame = new JFrame("MADRIMENTATE");
        frame.setSize(800, 900);
        //frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setBackground(Color.black);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        //JPanel panel = new JPanel();
        //frame.add(panel);
        JPanel empezar= new PanelEmpezar(this);
        frame.add(empezar);
        //frame.add(imagenFondo);
        frame.setVisible(true);
        frame.setResizable(true);
        //initComponents();
        /*PnlFondo pnlfondo=new PnlFondo();
        this.add(pnlfondo, BorderLayout.CENTER);
        this.pack();*/

        /*try{
            fondo= this.getClass().getResource("fondopantallacomida.jpg");
            imagenFondo= ImageIO.read(fondo);
        } catch(IOException ex){
            ex.printStackTrace();
            System.out.print("Imagen no cargada.");
        }*/
    }

    /*public void CrearFormulario() {
        Container contenedor = getContentPane();
        contenedor.add(panelfondo);
    }*/

    public static void main(String[] args) throws Exception{
        //new JVentana();
       JVentana jVentanaMadrimentate=new JVentana();
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
        this.add(pnlTipo);
        pnlTipo.mostrarRestauranteTipo(tipoComida);
        pnlTipo.setVisible(true);

    }

    public void inVentanaNombreRestaurante(String nombre){
        panelRestaurante.setVisible(false);
        this.add(pnlTipo);
        pnlTipo.mostrarRestauranteNombre(nombre);
        pnlTipo.setVisible(true);
    }

    public static void inVentanaTipoNombre(String nombre){};
    public static GestorBD getgRestaurantes(){
        return gRestaurantes;
    }
    public JPanel inVentanaReserva(){
        pnlTipo.setVisible(false);
        this.add(pnlReservar);
        pnlReservar.setVisible(true);
        setSize(800,800);
        this.setLocationRelativeTo(null);
        return pnlReservar;
    }
    /*
    public JPanel inVentanaInicio(){
        pnlTipo.setVisible(false);
        this.add(pnlReservar);
        pnlReservar.setVisible(true);
        setSize(800,800);
        this.setLocationRelativeTo(null);
        return pnlReservar;
    }
    */

    public JPanel inVentanaDelivery(){
        pnldeliveryrestauran.setVisible(true);
        setSize(960, 864);
        this.setLocationRelativeTo(null);
        return pnldeliveryrestauran;
    }

    public void inVentanaDelivery2(){
        pnldeliveryrestauran.setVisible(false);
        pnldeliveryRestaurante2.setVisible(true);
        this.setSize(800,900);

    }
}