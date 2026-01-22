package cl.speedfast.config;

/**
 * Clase de configuración general de la aplicación.
 * <p>
 * Contiene definiciones y enumeraciones utilizadas en el sistema.
 * </p>
 */
public class AppConfig {

    /**
     * Enumeración que representa los tipos de pedidos dentro del sistema.
     */
    public enum TipoPedido {
        EXPRESS("Express"),
        COMIDA("Comida"),
        ENCOMIENDA("Encomienda");

        private final String nombre;

        /**
         * Constructor que asigna el nombre legible al tipo de pedido.
         *
         * @param nombre Nombre descriptivo del tipo de pedido.
         */
        TipoPedido(String nombre) {
            this.nombre = nombre;
        }

        /**
         * Retorna el nombre legible del tipo de pedido.
         *
         * @return Nombre del tipo de pedido.
         */
        public String obtenerNombre() {
            return nombre;
        }
    }
}
