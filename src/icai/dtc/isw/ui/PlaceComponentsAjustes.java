package icai.dtc.isw.ui;

import icai.dtc.isw.dao.ConnectionDAO;
import icai.dtc.isw.dao.CustomerDAO;
import icai.dtc.isw.domain.Restaurante;
import icai.dtc.isw.domain.Usuario;

import javax.swing.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlaceComponentsAjustes extends JPanel implements Serializable {
/*
    public PlaceComponentsAjustes() {

        this.setLayout(null);

        final JLabel idLabelDel = new JLabel("Id");
        idLabelDel.setBounds(50, 50, 160, 40);
        this.add(idLabelDel);

        JTextField idTextDel = new JTextField(20);
        idTextDel.setBounds(170, 50, 340, 40);
        this.add(idTextDel);


        final JLabel passwordLabelDel = new JLabel("Password");
        passwordLabelDel.setBounds(50, 100, 160, 40);
        //passwordLabel.setResizable(true);
        this.add(passwordLabelDel;

        final JTextField passwordTextDel = new JPasswordField(20);
        passwordTextDel.setBounds(170, 100, 340, 40);
        //passwordText.setResizable(true);
        this.add(passwordTextDel);

        //insertar boton registro
        final JButton btnDelete = new JButton("Eliminar cuenta");
        btnDelete.setBounds(245, 220, 160, 40);
        this.add(btnDelete);

        btnDelete.addActionListener(actionEvent -> {
            try{
                ArrayList<Restaurante> restaurantes= new ArrayList<>();
                System.out.println(restaurantes);
                Connection con= ConnectionDAO.getInstance().getConnection();
                //String pizza="pizza";
                try(PreparedStatement pst=con.prepareStatement("SELECT * FROM restaurantes WHERE tipo = 'asiatico'");
                    ResultSet rs=pst.executeQuery()){
                    while (rs.next()){
                        restaurantes.add(new Restaurante(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
                        System.out.println(restaurantes);


                    }
                } catch (SQLException ex){
                    System.out.println(ex.getMessage());
                    System.out.println("No se encontraron restaurantes de comida asiática");
                }
            }
        });
 */
}
