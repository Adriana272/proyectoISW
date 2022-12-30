package icai.dtc.isw.ui;

import icai.dtc.isw.domain.Restaurante;
import icai.dtc.isw.ui.JVentana;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.util.EventListener;

import static java.lang.Boolean.TRUE;

public class PanelReservarMesa extends JPanel {
    private JVentana jVentanaMadrimentate;
    private MonthPanel pnlmes1;
    private MonthPanel pnlmes2;



    public PanelReservarMesa(/*JVentana jVentanaMadrimentate*/) {
        this.jVentanaMadrimentate = jVentanaMadrimentate;
        pnlmes1 = new MonthPanel(4,2022);
        pnlmes2 = new MonthPanel(0, 2023);
        this.setSize(800,800);
        this.setBackground(Color.BLACK);
        JButton btnBuscarSitio = new JButton("BuscarSitio");
        JPanel pnlSur = new JPanel(new FlowLayout());


        pnlSur.add(btnBuscarSitio);

        this.setLayout(new BorderLayout());
        this.setVisible(true);


        pnlSur.setVisible(true);
        pnlSur.setBackground(Color.GRAY);
        this.add(pnlSur, BorderLayout.SOUTH);

        JPanel pnlNorte1 = new JPanel(new FlowLayout());
        JLabel lblReserva = new JLabel("Reservar mesa");
        pnlNorte1.add(lblReserva);


        this.add(pnlNorte1, BorderLayout.NORTH);

        JPanel pnlEast = new JPanel(new FlowLayout());
        JLabel hora = new JLabel("Hora");
        JComboBox<String> nhora = new JComboBox<>();
        for (double i = 13.00; i < 24.00; i++) {
            nhora.addItem(String.valueOf(i));

        }


        JLabel personas = new JLabel("Personas");
        JComboBox<String> npersonas = new JComboBox<String>();
        for (int i = 0; i < 10; i++) {
            npersonas.addItem(String.valueOf(i));

        }
        pnlEast.add(hora);
        pnlEast.add(nhora);
        pnlEast.add(personas);
        pnlEast.add(npersonas);

        pnlEast.setBackground(Color.GRAY);

        this.add(pnlEast, BorderLayout.EAST);


        JPanel pnlMedio = new JPanel();
        pnlMedio.setBackground(Color.GRAY);
        JButton btnDiciembre = new JButton("  Reserva para este mes: Diciembre  ");
        JButton btnEnero = new JButton("Reserva para el mes siguiente: Enero");



        JLabel dia = new JLabel("                      dia");
        JTextField diatxt = new JTextField("              ");
        JComboBox<String> mes = new JComboBox<>();
        mes.addItem("Diciembre 2022");
        mes.addItem("Enero 2023");



        pnlMedio.add(btnDiciembre);
        pnlMedio.add(pnlmes1);
        pnlMedio.add(btnEnero);
        pnlMedio.add(pnlmes2);

        pnlMedio.add(dia);
        pnlMedio.add(diatxt);
        pnlMedio.add(mes);

        //JTextArea txtreserva = new JTextArea("la reserva hecha para el dia" +diatxt.getText()+mes.getSelectedItem()+" para " + npersonas.getToolTipText() + " a la hora" + nhora.getToolTipText());
        //pnlMedio.add(txtreserva);

        this.add(pnlMedio, BorderLayout.CENTER);



        btnBuscarSitio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnBuscarSitio) {
                    //if (Restaurante.haySitio() == TRUE)
                    JOptionPane.showMessageDialog(jVentanaMadrimentate, "la reserva hecha para el dia " +diatxt.getText()+ mes.getSelectedItem()+" para " + npersonas.getSelectedItem() + " a la hora " + nhora.getSelectedItem());
                    System.out.println("la reserva hecha para" + npersonas.getToolTipText() + "a la hora" + nhora.getToolTipText());

                } //else {
                //  System.out.println("no hay hueco para ese número de personas a esa hora, por favor elija otro");
                //}

            }
        });


    }



}
/*
        JPanel pnlNorte1 = new JPanel(new FlowLayout());
        JPanel pnlSur = new JPanel(new FlowLayout());

        JButton btnBuscarSitio = new JButton("BuscarSitio");

        Calendar calendario = new GregorianCalendar();
        System.out.println(calendario);

      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        System.out.println(formatter);



        //this.add(pnlSur, BorderLayout.SOUTH);

        pnlSur.add(btnBuscarSitio);
        //pnlSur.add(personas);
        //pnlSur.add(npersonas);




        btnBuscarSitio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnBuscarSitio) {
                    if (Restaurante.haySitio() == TRUE) {
                        System.out.println("la reserva hecha para" + npersonas.getToolTipText() + "a la hora" + nhora.getToolTipText());

                    } else {
                        System.out.println("no hay hueco para ese número de personas a esa hora, por favor elija otro");
                    }

                }
            }
        });


    }
}*/



