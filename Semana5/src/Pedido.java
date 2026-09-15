// Clase que representa un pedido de SpeedFast.
public class Pedido {

    // Atributos del pedido.
    private int id;
    private String direccionEntrega;
    private EstadoPedido estado;

    // Constructor.
    public Pedido(int id, String direccionEntrega) {

        this.id = id;
        this.direccionEntrega = direccionEntrega;

        // Todo pedido comienza en estado PENDIENTE.
        this.estado = EstadoPedido.PENDIENTE;
    }

    // Getter del id.
    public int getId() {
        return id;
    }

    // Setter del id.
    public void setId(int id) {
        this.id = id;
    }

    // Getter de la direccion.
    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    // Setter de la direccion.
    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    // Getter del estado.
    public synchronized EstadoPedido getEstado() {
        return estado;
    }

    // Setter del estado utilizando el enum.
    public synchronized void setEstado(EstadoPedido nuevoEstado) {
        this.estado = nuevoEstado;
    }

    // Metodo solicitado por la actividad.
    // Permite cambiar el estado utilizando un String.
    public synchronized void setEstado(String nuevoEstado) {
        this.estado = EstadoPedido.valueOf(nuevoEstado);
    }

    // Metodo toString().
    @Override
    public String toString() {

        return "Pedido #" + id
                + " - Destino: " + direccionEntrega
                + " - Estado: " + estado;
    }
}