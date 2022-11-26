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

    public PanelEdicion(){
        final JButton btnNombre = new JButton("Editar Nombre");
        btnNombre.setFont(new Font("Arial Black", Font.BOLD, 18));
        btnNombre.setBounds(550, 700, 160, 60);
        btnNombre.setBackground(Color.white);
        this.add(btnNombre);

        btnNombre.addActionListener(actionEvent -> {
            String newName= JOptionPane.showInputDialog(null, "Inserte su id y su nuevo nombre: ");
            int idEdit= Integer.parseInt(newName.split(" ")[0]);
            String nameEdit= newName.split(" ")[1];
            Connection con= ConnectionDAO.getInstance().getConnection();
            try(PreparedStatement pst=con.prepareStatement("UPDATE usuarios SET nombre = "+nameEdit+" WHERE id = "+idEdit);
                ResultSet rs=pst.executeQuery()){
                while (rs.next()){
                    //restaurantes.add(new Restaurante(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
                    System.out.println(idEdit+", "+nameEdit);

                }
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
                System.out.println("No se ha podido editar el usuario");
            }
        });
    }
}
