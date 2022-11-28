package icai.dtc.isw.ui;

import icai.dtc.isw.dao.ConnectionDAO;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PnlEditPassword extends JPanel implements Serializable {

    public PnlEditPassword(){

        //insertar imagen
        JLabel imgSec = new JLabel(" ");
        ImageIcon ImagenSec = new ImageIcon("src/main/resources/images/securityfirewall.jpeg");
        imgSec.setIcon(ImagenSec);
        imgSec.setSize(160, 160);
        imgSec.setLocation(320, 150);
        imgSec.setVisible(true);
        this.add(imgSec);

        final JButton btnPw = new JButton("Editar Contraseña");
        btnPw.setFont(new Font("Arial Black", Font.BOLD, 18));
        btnPw.setBounds(300, 600, 200, 70);
        btnPw.setBackground(Color.white);
        this.add(btnPw);

        final JLabel passwordLabelEdit = new JLabel("Old password: ");
        passwordLabelEdit.setBounds(150, 300, 200, 70);
        //passwordLabel.setResizable(true);
        this.add(passwordLabelEdit);

        final JTextField passwordTextEdit = new JTextField(20);
        passwordTextEdit.setBounds(300, 300, 200, 70);
        //passwordText.setResizable(true);
        this.add(passwordTextEdit);

        final JLabel passwordLabelNEW = new JLabel("New password: ");
        passwordLabelNEW.setBounds(150, 450, 200, 70);
        //passwordLabel.setResizable(true);
        this.add(passwordLabelNEW);

        final JTextField passwordTextNEW = new JTextField(20);
        passwordTextNEW.setBounds(300, 450, 200, 70);
        //passwordText.setResizable(true);
        this.add(passwordTextNEW);

        btnPw.addActionListener(actionEvent -> {
            //String newName= JOptionPane.showInputDialog(null, "Inserte su id y su nuevo nombre: ");
            //int idEdit= Integer.parseInt(newName.split(" ")[0]);
            //String nameEdit= newName.split(" ")[1];
            Connection con= ConnectionDAO.getInstance().getConnection();
            try(PreparedStatement pst=con.prepareStatement("UPDATE usuarios SET password = '"+passwordTextNEW.getText()+"' WHERE password = '"+passwordTextEdit.getText()+"'");
                ResultSet rs=pst.executeQuery()){
                while (rs.next()){
                    //restaurantes.add(new Restaurante(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
                    JOptionPane.showConfirmDialog(null, "Contraseña actualizada, su nueva contraseña es: "+passwordTextNEW.getText());
                    System.out.println(passwordTextNEW.getText()+", "+passwordTextEdit.getText());

                }
            } catch (SQLException ex){ //me lo edita bien pero salta aquí, porque no devuelvo nada. Como hago para que eso no pase?
                System.out.println(ex.getMessage());
                System.out.println("No se ha podido editar la contraseña");
            }
        });
    }
}
