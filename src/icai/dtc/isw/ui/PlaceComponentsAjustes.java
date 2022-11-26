package icai.dtc.isw.ui;

import icai.dtc.isw.dao.ConnectionDAO;
import icai.dtc.isw.dao.CustomerDAO;
import icai.dtc.isw.domain.Restaurante;
import icai.dtc.isw.domain.Usuario;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static javax.security.auth.callback.ConfirmationCallback.YES;

public class PlaceComponentsAjustes extends JPanel implements Serializable {

    public PlaceComponentsAjustes() {

        this.setLayout(null);

        //insertar boton delete
        final JButton btnDelete = new JButton("Eliminar cuenta");
        btnDelete.setBounds(245, 220, 160, 40);
        this.add(btnDelete);

        btnDelete.addActionListener(actionEvent -> {
            int dialogButton = JOptionPane.showConfirmDialog(null, "Está seguro de que desea eliminar su cuenta?", "Alerta!", JOptionPane.YES_NO_OPTION);
            if (dialogButton == JOptionPane.YES_OPTION) {

                String userDel = JOptionPane.showInputDialog("Introduzca 'id,contraseña (nombre en este caso)': ");
                int idUserDel = Integer.parseInt(userDel.split(",")[0]);
                String pwUserDel = userDel.split(",")[1];
                System.out.println(userDel);
                System.out.println(idUserDel);
                System.out.println(pwUserDel);
                Connection con = ConnectionDAO.getInstance().getConnection();

                try (PreparedStatement pst = con.prepareStatement("DELETE FROM usuarios WHERE id =" + idUserDel+" password = "+pwUserDel);
                     ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        System.out.println(userDel);
                    }
                    JOptionPane.showMessageDialog(null, "Usuario eliminado con éxito!");
                    System.exit(1);
                } catch (SQLException ex) { //me elimina el usuario bien, como hago para que esto no salte
                    System.out.println(ex.getMessage());
                    System.out.println("No se ha podido eliminar el usuario");
                }

            }
        });

        //insertar boton registro
        final JButton btnEdit = new JButton("Editar datos");
        btnEdit.setBounds(265, 220, 160, 40);
        this.add(btnEdit);

        btnEdit.addActionListener(actionEvent -> {
            JFrame frameEdit = new JFrame("Edición datos");
            frameEdit.setSize(800, 900);
            //frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
            frameEdit.setBackground(Color.darkGray);
            frameEdit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameEdit.setLocationRelativeTo(null);
            //JPanel panel = new JPanel();
            //frame.add(panel);
            JPanel Edicion = new PanelEdicion();
            frameEdit.add(Edicion);
            //frame.add(imagenFondo);
            frameEdit.setVisible(true);
            frameEdit.setResizable(true);
        });
    }
}
