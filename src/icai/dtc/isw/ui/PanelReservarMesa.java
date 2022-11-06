package icai.dtc.isw.ui;

import javax.swing.*;
import icai.dtc.isw.domain.Restaurante;
import icai.dtc.isw.ui.JVentana;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static java.lang.Boolean.TRUE;
public class PanelReservarMesa extends JPanel {
    private JVentana jVentanaMadrimentate;


    public PanelReservarMesa(JVentana jVentanaMadrimentate) {
        this.jVentanaMadrimentate= jVentanaMadrimentate;

        JPanel pnlNorte = new JPanel();
        JButton btnBuscarSitio = new JButton("BuscarSitio");

        Calendar calendario = new GregorianCalendar();
        JLabel personas = new JLabel("Personas");
        JComboBox<String> npersonas = new JComboBox<String>();
        for (int i = 0; i < 10; i++) {
            npersonas.addItem(String.valueOf(i));

        }
        JLabel hora = new JLabel("Hora");
        JComboBox<String> nhora = new JComboBox<>();
        for (double i = 13.00; i < 24.00; i++) {
            nhora.addItem(String.valueOf(i));

        }
        this.setVisible(true);

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
}
