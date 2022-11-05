package icai.dtc.isw.ui;

import icai.dtc.isw.dao.CustomerDAO;
import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.Usuario;

import java.io.Serializable;
import javax.swing.*;

public class PlaceComponentsRegistro extends JPanel implements Serializable {


    public PlaceComponentsRegistro() {

        this.setLayout(null);

        final JLabel idLabelReg = new JLabel("Id");
        idLabelReg.setBounds(50, 50, 160, 40);
        this.add(idLabelReg);

        JTextField idTextReg = new JTextField(20);
        idTextReg.setBounds(170, 50, 340, 40);
        this.add(idTextReg);

        final JLabel userLabelReg = new JLabel("Nombre");
        userLabelReg.setBounds(50, 100, 160, 40);
        this.add(userLabelReg);

        JTextField userTextReg = new JTextField(20);
        userTextReg.setBounds(170, 100, 340, 40);
        this.add(userTextReg);

        final JLabel passwordLabelReg = new JLabel("Password");
        passwordLabelReg.setBounds(50, 150, 160, 40);
        //passwordLabel.setResizable(true);
        this.add(passwordLabelReg);

        final JTextField passwordTextReg = new JPasswordField(20);
        passwordTextReg.setBounds(170, 150, 340, 40);
        //passwordText.setResizable(true);
        this.add(passwordTextReg);

        //insertar boton registro
        final JButton btnReg2 = new JButton("Registrarme");
        btnReg2.setBounds(245, 220, 160, 40);
        this.add(btnReg2);

        btnReg2.addActionListener(actionEvent -> {
            try{
                CustomerDAO.addUsuario(new Usuario(Integer.parseInt(idTextReg.getText()), userTextReg.getText(), passwordTextReg.getText()));
            } catch (Exception e){
                JOptionPane.showMessageDialog(null,"no va");
            }
        });
    }
}