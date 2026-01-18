package cl.speedfast.ui;

import cl.speedfast.model.Pedido;
import cl.speedfast.model.PedidoComida;
import cl.speedfast.model.PedidoEncomienda;
import cl.speedfast.model.PedidoExpress;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Pedido comida = new PedidoComida(1, "Av. Central 123", true, 4.5);
        Pedido encomienda = new PedidoEncomienda(2, "Calle Sur 456", 10, true, 6.0);
        Pedido express = new PedidoExpress(3, "Los Pinos 789", false, 1.1);

        // Override & overload
        /*comida.asignarRepartidor();
        comida.asignarRepartidor("Carlos");
        System.out.println();
        encomienda.asignarRepartidor();
        encomienda.asignarRepartidor("María");
        System.out.println();
        express.asignarRepartidor();
        express.asignarRepartidor("Pedro");*/

        // Se agregan los pedidos a una colección para mayor flexibilidad
        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(comida);
        pedidos.add(encomienda);
        pedidos.add(express);

        // Se recorre colección para demostrar polimorfismo
        for (Pedido p : pedidos) {
            p.mostrarResumen();
            System.out.println("Tiempo estimado: " + p.calcularTiempoEntrega() + " minutos");
            System.out.println("-----------------------------");
        }

    }
}
