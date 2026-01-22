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

        // Se agregan los pedidos a una colección para mayor flexibilidad
        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(comida);
        pedidos.add(encomienda);
        pedidos.add(express);

        // Pedido Comida
        comida.mostrarResumen();
        comida.asignarRepartidor("Luis Perales");
        System.out.println("Tiempo estimado: " +
                comida.calcularTiempoEntrega() + " minutos");
        comida.despachar();

        System.out.println();

        // Pedido Encomienda
        encomienda.mostrarResumen();
        encomienda.asignarRepartidor("Daniela Tapia");
        System.out.println("Tiempo estimado: " +
                encomienda.calcularTiempoEntrega() + " minutos");
        encomienda.despachar();

        System.out.println();

        // Pedido Express (ej. cancelado)
        express.mostrarResumen();
        express.asignarRepartidor("Pedro Soto");
        System.out.println("Tiempo estimado: " +
                express.calcularTiempoEntrega() + " minutos");
        express.cancelar();

        // Historial de despachos
        System.out.println();
        System.out.println("Historial:");

        for (Pedido p : pedidos) {
            for (String evento : p.verHistorial()) {
                System.out.println("- " + evento);
            }
        }

    }
}
