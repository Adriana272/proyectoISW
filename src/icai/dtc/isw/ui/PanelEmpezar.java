package icai.dtc.isw.ui;

import icai.dtc.isw.domain.Customer;
import org.checkerframework.checker.units.qual.g;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.net.URL;

import static org.checkerframework.checker.units.qual.g.*;

public class PanelEmpezar extends JPanel implements Serializable {

    private static int id;
    private static String password;
    private static String IdUsuario;
    private static JTextField userTextLogin;

    //private Icon imagenFondo=new ImageIcon(getClass().getResource("src/main/resources/images/fondopantallacomida.jpg"));
    //private Image background;

    //public ImageIcon imagen= new ImageIcon("src/main/resources/images/fondopantallacomida.jpg");

    /*private URL url= getClass().getResource("src/main/resources/images/fondopantallacomida.jpg");
    Image image=new ImageIcon(url).getImage();
    ImageIcon(url).getImage();*/

    public PanelEmpezar() {

        this.setLayout(null);

        //insertar imagen
        JLabel imgFondo = new JLabel(" ");
        ImageIcon ImagenBG = new ImageIcon("src/main/resources/images/fondopantallanegro.png");
        imgFondo.setIcon(ImagenBG);
        imgFondo.setSize(800, 900);
        imgFondo.setLocation(0, 0);
        imgFondo.setVisible(true);
        this.add(imgFondo);


        //insertar boton empezar
        final JButton btnEmpezar = new JButton("EMPEZAR");
        btnEmpezar.setFont(new Font("Arial Black", Font.BOLD, 18));
        btnEmpezar.setBounds(550, 700, 160, 60);
        btnEmpezar.setBackground(Color.white);
        this.add(btnEmpezar);

        btnEmpezar.addActionListener(actionEvent -> {
            JFrame frameIni = new JFrame("Inicio");
            frameIni.setSize(800, 900);
            //frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
            frameIni.setBackground(Color.white);
            frameIni.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameIni.setLocationRelativeTo(null);
            //JPanel panel = new JPanel();
            //frame.add(panel);
            JPanel inicio = new PlaceComponentsInicio();
            frameIni.add(inicio);
            frameIni.setVisible(true);
            frameIni.setResizable(true);
        });

        /*@Override
        public void paint(Graphics g){
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            g.setOpaque(False);
            super.paint(g);
        }*/
       /* @Override
        public void paintComponent(Graphics g){
            int width = this.getSize().width;
            int height = this.getSize().height;

            if (this.background != null) {
                g.drawImage(this.background, 0, 0, width, height, null);
            }
            super.paintComponent(g);
        }

        public void setBackground(String imagePath){
            this.setOpaque(false);
            this.background = new ImageIcon(imagePath).getImage();
            repaint();
        }*/

        /*public void paint(Graphics g){
            Dimension tamanio=getSize();
            ImageIcon imagenFondo=new ImageIcon(getClass().getResource("src/main/resources/images/fondopantallacomida.jpg"));
            drawImage(imagenFondo.getImage(), 0, 0, tamanio.getWidth(), tamanio.getHeight(), null);
            setOpaque(false);

            super.paint(g);
        }*/
    }
}
