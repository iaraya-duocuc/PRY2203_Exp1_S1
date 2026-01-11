package cl.speedfast.ui;

import cl.speedfast.model.Pedido;
import cl.speedfast.model.PedidoComida;
import cl.speedfast.model.PedidoEncomienda;
import cl.speedfast.model.PedidoExpress;

public class Main {
    public static void main(String[] args) {

        Pedido comida = new PedidoComida(1, "Av. Central 123", true);
        Pedido encomienda = new PedidoEncomienda(2, "Calle Sur 456", 10, true);
        Pedido express = new PedidoExpress(3, "Los Pinos 789", false);

        // Override & overload
        comida.asignarRepartidor();
        comida.asignarRepartidor("Carlos");
        System.out.println();
        encomienda.asignarRepartidor();
        encomienda.asignarRepartidor("María");
        System.out.println();
        express.asignarRepartidor();
        express.asignarRepartidor("Pedro");

    }
}
