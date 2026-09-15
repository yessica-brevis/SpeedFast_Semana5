import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Clase principal del programa.
public class Main {

    public static void main(String[] args) {

        System.out.println("=== SPEEDFAST ===");
        System.out.println();
        System.out.println("[Zona de carga inicializada]");
        System.out.println();

        // Creamos la zona de carga compartida.
        ZonaDeCarga zonaDeCarga = new ZonaDeCarga();

        // Agregamos los pedidos.
        zonaDeCarga.agregarPedido(
                new Pedido(1, "Santiago Centro")
        );

        zonaDeCarga.agregarPedido(
                new Pedido(2, "Providencia")
        );

        zonaDeCarga.agregarPedido(
                new Pedido(3, "Las Condes")
        );

        zonaDeCarga.agregarPedido(
                new Pedido(4, "Recoleta")
        );

        zonaDeCarga.agregarPedido(
                new Pedido(5, "Las Dehesa")
        );

        System.out.println();

        // Creamos un ExecutorService con 3 hilos.
        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        // Creamos los tres repartidores.
        executor.submit(
                new Repartidor("Martin", zonaDeCarga)
        );

        executor.submit(
                new Repartidor("Ximena", zonaDeCarga)
        );

        executor.submit(
                new Repartidor("Carolina", zonaDeCarga)
        );

        // Indicamos que no se agregarán más tareas.
        executor.shutdown();

        try {

            // Esperamos que terminen los repartidores.
            boolean finalizaron =
                    executor.awaitTermination(
                            30,
                            TimeUnit.SECONDS
                    );

            if (finalizaron) {

                System.out.println(
                        "[Zona de carga vacía]"
                );

                System.out.println();

                System.out.println(
                        "Todos los pedidos han sido "
                                + "entregados correctamente"
                );

            } else {

                System.out.println(
                        "Se agotó el tiempo de espera."
                );
            }

        } catch (InterruptedException e) {

            // Restauramos la interrupción del hilo.
            Thread.currentThread().interrupt();

            // Detenemos los hilos.
            executor.shutdownNow();
        }
    }
}