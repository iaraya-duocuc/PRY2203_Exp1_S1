package cl.speedfast.model;

import cl.speedfast.config.AppConfig;

public class PedidoEncomienda extends Pedido {

    private double peso;
    private boolean embalajeCorrecto;

    public PedidoEncomienda(int id, String direccion, double peso, boolean embalajeCorrecto, double distanciaKm) {
        super(id, direccion, AppConfig.TipoPedido.ENCOMIENDA, distanciaKm);
        this.peso = peso;
        this.embalajeCorrecto = embalajeCorrecto;
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("Pedido Encomienda: validando peso y embalaje...");
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        if (peso <= 20 && embalajeCorrecto) {
            setRepartidorAsignado(nombreRepartidor);
            System.out.println("Repartidor " + getRepartidorAsignado() +
                    " asignado a encomienda (peso y embalaje válidos).");
        } else {
            System.out.println("ERROR: encomienda inválida para asignación.");
        }
    }

    @Override
    public int calcularTiempoEntrega() {
        return 20 + (int) Math.round(1.5 * getDistanciaKm());
    }

    @Override
    public void despachar() {
        if (!getCancelado()) {
            System.out.println("Pedido Encomienda despachado correctamente.");
            registrarDespacho();
        } else {
            System.out.println("No se puede despachar un pedido cancelado.");
        }
    }

    @Override
    public void cancelar() {
        setCancelado(true);
        System.out.println("Cancelando Pedido Encomienda #" + getIdPedido() + "... \nPedido cancelado exitosamente.");
    }
}
