// Clase que representa a un repartidor.
// Implementa Runnable para poder ejecutarse como hilo.
public class Repartidor implements Runnable {

    // Nombre del repartidor.
    private final String nombre;

    // Referencia a la zona de carga compartida.
    private final ZonaDeCarga zonaDeCarga;

    // Constructor.
    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {

        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
    }

    // Metodo que ejecutara cada hilo.
    @Override
    public void run() {

        // El repartidor continúa trabajando mientras
        // existan pedidos disponibles.
        while (true) {

            // Retira un pedido de la zona de carga.
            Pedido pedido = zonaDeCarga.retirarPedido();

            // Si no quedan pedidos, termina el hilo.
            if (pedido == null) {

                System.out.println(
                        "[Repartidor - " + nombre + "] "
                                + "No quedan pedidos."
                );

                break;
            }

            // Cambiamos el estado del pedido.
            pedido.setEstado(EstadoPedido.EN_REPARTO);

            // Mostramos que el repartidor retiró el pedido.
            System.out.println(
                    "[Repartidor - " + nombre + "] "
                            + "Retirando pedido #"
                            + pedido.getId() + "..."
            );

            // Mostramos el nuevo estado.
            System.out.println(
                    "[Repartidor - " + nombre + "] "
                            + "Estado: "
                            + pedido.getEstado()
            );

            try {

                // Simulamos el tiempo que demora la entrega.
                Thread.sleep(1000);

            } catch (InterruptedException e) {

                // Restauramos el estado de interrupción del hilo.
                Thread.currentThread().interrupt();

                return;
            }

            // Cuando termina la entrega, cambiamos el estado.
            pedido.setEstado(EstadoPedido.ENTREGADO);

            // Mostramos que el pedido fue entregado.
            System.out.println(
                    "[Repartidor - " + nombre + "] "
                            + "Entregando pedido #"
                            + pedido.getId() + "..."
            );

            // Mostramos el estado final.
            System.out.println(
                    "[Repartidor - " + nombre + "] "
                            + "Estado: "
                            + pedido.getEstado()
            );

            // Línea en blanco para separar las entregas.
            System.out.println();
        }
    }
}