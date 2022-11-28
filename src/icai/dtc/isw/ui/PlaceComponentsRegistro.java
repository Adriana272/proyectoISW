package icai.dtc.isw.ui;

import icai.dtc.isw.dao.CustomerDAO;
import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.Usuario;

import java.awt.*;
import java.io.Serializable;
import javax.swing.*;

public class PlaceComponentsRegistro extends JPanel implements Serializable {


    public PlaceComponentsRegistro() {

        this.setLayout(null);
        this.setBackground(Color.white);

        //insertar imagen
        JLabel imgreg = new JLabel(" ");
        ImageIcon Imagenreg = new ImageIcon("src/main/resources/images/registro.png");
        imgreg.setIcon(Imagenreg);
        imgreg.setSize(160,160);
        imgreg.setLocation(320,100);
        imgreg.setVisible(true);
        this.add(imgreg);

        final JLabel idLabelReg = new JLabel("Id");
        idLabelReg.setBounds(150, 350, 160, 40);
        this.add(idLabelReg);

        JTextField idTextReg = new JTextField(20);
        idTextReg.setBounds(350, 350, 340, 40);
        this.add(idTextReg);

        final JLabel userLabelReg = new JLabel("Nombre");
        userLabelReg.setBounds(150, 400, 160, 40);
        this.add(userLabelReg);

        JTextField userTextReg = new JTextField(20);
        userTextReg.setBounds(320, 400, 340, 40);
        this.add(userTextReg);

        final JLabel passwordLabelReg = new JLabel("Password");
        passwordLabelReg.setBounds(150, 450, 160, 40);
        //passwordLabel.setResizable(true);
        this.add(passwordLabelReg);

        final JTextField passwordTextReg = new JPasswordField(20);
        passwordTextReg.setBounds(320, 450, 340, 40);
        //passwordText.setResizable(true);
        this.add(passwordTextReg);

        //insertar boton registro
        final JButton btnReg2 = new JButton("Guardar datos");
        btnReg2.setBounds(300, 550, 200, 60);
        ImageIcon iconosave=new ImageIcon("src/main/resources/images/save.png");
        btnReg2.setIcon(iconosave);
        this.add(btnReg2);

        btnReg2.addActionListener(actionEvent -> {
            try{
                CustomerDAO.addUsuario(new Usuario(Integer.parseInt(idTextReg.getText()), userTextReg.getText(), passwordTextReg.getText()));
            } catch (Exception e){
                JOptionPane.showMessageDialog(null,"No ha sido posible registrar al usuario");
            }
        });
    }
}