package cl.speedfast.model;

import cl.speedfast.config.AppConfig;

public class PedidoExpress extends Pedido {

    private boolean hayRepartidorDisponible;

    public PedidoExpress(int id, String direccion, boolean disponible, double distanciaKm) {
        super(id, direccion, AppConfig.TipoPedido.EXPRESS, distanciaKm);
        this.hayRepartidorDisponible = disponible;
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("Pedido Express: buscando repartidor más cercano disponible...");
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        if (hayRepartidorDisponible) {
            System.out.println("Repartidor " + nombreRepartidor +
                    " asignado por cercanía inmediata.");
        } else {
            System.out.println("ERROR: no hay repartidor cercano disponible.");
        }
    }

    @Override
    public int calcularTiempoEntrega() {
        int tiempo = 10;
        if (getDistanciaKm() > 5) {
            tiempo += 5;
        }
        return tiempo;
    }
}

