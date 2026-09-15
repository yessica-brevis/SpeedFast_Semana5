import java.util.ArrayDeque;
import java.util.Queue;

// Clase que representa la zona de carga compartida.
public class ZonaDeCarga {

    // Cola que almacena los pedidos pendientes.
    private final Queue<Pedido> pedidos = new ArrayDeque<>();

    // Metodo para agregar un pedido a la zona de carga.
    // synchronized evita que dos hilos modifiquen la cola
    // al mismo tiempo.
    public synchronized void agregarPedido(Pedido p) {

        pedidos.offer(p);

        System.out.println(
                "Pedido #" + p.getId()
                        + " agregado. Destino: "
                        + p.getDireccionEntrega()
        );
    }

    // Metodo para retirar un pedido de la zona de carga.
    // synchronized garantiza que solo un repartidor
    // pueda retirar un pedido a la vez.
    public synchronized Pedido retirarPedido() {

        // poll() retira y devuelve el primer pedido.
        // Si no quedan pedidos, devuelve null.
        return pedidos.poll();
    }
}