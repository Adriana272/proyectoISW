package icai.dtc.isw.ui;

import icai.dtc.isw.dao.ConnectionDAO;
import icai.dtc.isw.domain.Restaurante;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PanelEdicion extends JPanel implements Serializable {

    public PanelEdicion() {

        this.setBackground(Color.white);

        //insertar imagen
        JLabel imgEd = new JLabel(" ");
        ImageIcon ImagenEd = new ImageIcon("src/main/resources/images/users.png");
        imgEd.setIcon(ImagenEd);
        imgEd.setSize(160, 160);
        imgEd.setLocation(150, 320);
        imgEd.setVisible(true);
        this.add(imgEd);


        final JButton btnNombre = new JButton("Editar Nombre");
        btnNombre.setFont(new Font("Arial Black", Font.BOLD, 18));
        btnNombre.setBounds(300, 300, 200, 70);
        ImageIcon iconoName=new ImageIcon("src/main/resources/images/info.png");
        btnNombre.setIcon(iconoName);
        btnNombre.setBackground(Color.white);
        this.add(btnNombre);

        btnNombre.addActionListener(actionEvent -> {
            String newName = JOptionPane.showInputDialog(null, "Inserte su id y su nuevo nombre: ");
            int idEdit = Integer.parseInt(newName.split(" ")[0]);
            String nameEdit = newName.split(" ")[1];
            Connection con = ConnectionDAO.getInstance().getConnection();
            try (PreparedStatement pst = con.prepareStatement("UPDATE usuarios SET nombre = '" + nameEdit + "' WHERE id = " + idEdit);
                 ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    //restaurantes.add(new Restaurante(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
                    System.out.println(idEdit + ", " + nameEdit);

                }
            } catch (
                    SQLException ex) { //me lo edita bien pero salta aquí, porque no devuelvo nada. Como hago para que eso no pase?
                System.out.println(ex.getMessage());
                System.out.println("No se ha podido editar el usuario");
            }
        });

        final JButton btnPnlEditPw = new JButton("Editar Contraseña");
        btnPnlEditPw.setFont(new Font("Arial Black", Font.BOLD, 18));
        btnPnlEditPw.setBounds(300, 450, 200, 70);
        ImageIcon iconocontra=new ImageIcon("src/main/resources/images/seguridadtransp.png");
        btnPnlEditPw.setIcon(iconocontra);
        btnPnlEditPw.setBackground(Color.white);
        this.add(btnPnlEditPw);

        btnPnlEditPw.addActionListener(actionEvent -> {
            JFrame frameEditPw = new JFrame("Edición contraseña");
            frameEditPw.setSize(800, 900);
            //frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
            frameEditPw.setBackground(Color.darkGray);
            frameEditPw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameEditPw.setLocationRelativeTo(null);
            //JPanel panel = new JPanel();
            //frame.add(panel);
            JPanel EdicionPw = new PnlEditPassword();
            frameEditPw.add(EdicionPw);
            //frame.add(imagenFondo);
            frameEditPw.setVisible(true);
            frameEditPw.setResizable(true);
        });
    }
}