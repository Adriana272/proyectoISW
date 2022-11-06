package icai.dtc.isw.ui;

import icai.dtc.isw.domain.DeliveryDeliveroo;
import icai.dtc.isw.domain.DeliveryGlovo;
import icai.dtc.isw.domain.DeliveryUberEats;

import javax.swing.*;

public class PanelDeliveryRestaurante extends JPanel{
    public JVentana jVentanaMadrimentate;

    public DeliveryGlovo deliveryGlovo;
    public DeliveryDeliveroo deliveryDeliveroo;
    public DeliveryUberEats deliveryUberEats;




    public  PanelDeliveryRestaurante(JVentana jVentanaMadrimentate) {
        JPanel panelprincipal = new JPanel();
        JLabel lblservicio = new JLabel("servicio de Delivery");
        JButton btnmenu = new JButton();

        JPanel panelOpciones = new JPanel();
        JLabel lblglovo = new JLabel(deliveryGlovo.toString());
        JLabel lbldeliveroo = new JLabel(deliveryDeliveroo.toString());
        JLabel lblubereats = new JLabel(deliveryUberEats.toString());

        JButton btnglovo = new JButton();
        JButton btndeliveroo = new JButton();
        JButton btnubereats = new JButton();
    }
}
