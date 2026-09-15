# SpeedFast_Semana5

# 🧠 Actividad Formativa Desarrollo Orientado a Objetos 2 – Semana 5

## 👤 Autor del proyecto

* **Nombre completo:** Yessica Ximena Brevis Garnica
* **Sección:** 002A
* **Carrera:** Analista Programador Computacional
* **Sede:** Online

---

# 📘 Descripción general del sistema

Este proyecto corresponde a la actividad formativa de la **Semana 5** de la asignatura **Desarrollo Orientado a Objetos 2**.

El sistema simula el proceso de entrega de pedidos de la empresa **SpeedFast**, utilizando programación concurrente y mecanismos de sincronización.

Se aplican conceptos como:

* Programación concurrente.
* `Runnable`.
* `Thread`.
* `ExecutorService`.
* `synchronized`.
* Uso de `enum`.
* Control de acceso a recursos compartidos.

---

# 🧱 Estructura del proyecto

```text
📁 src/

├── Main.java
│   # Clase principal que inicia el sistema y los repartidores.
│
├── Pedido.java
│   # Representa un pedido y su estado.
│
├── EstadoPedido.java
│   # Enum con los estados del pedido.
│
├── ZonaDeCarga.java
│   # Recurso compartido donde se almacenan los pedidos.
│
└── Repartidor.java
    # Representa al repartidor y ejecuta las entregas mediante Runnable.
```

📦 Pedido
La clase Pedido contiene los datos principales de cada pedido:

id
direccionEntrega
estado

El pedido puede encontrarse en los estados:

PENDIENTE
EN_REPARTO
ENTREGADO
🔄 EstadoPedido

El enum EstadoPedido permite controlar los estados de los pedidos de forma segura, evitando errores de escritura.

🚚 ZonaDeCarga

La clase ZonaDeCarga representa el recurso compartido al que acceden los repartidores.

Utiliza métodos synchronized para controlar el acceso concurrente y evitar que un mismo pedido sea retirado por más de un repartidor.

👷 Repartidor

La clase Repartidor implementa Runnable.

Cada repartidor:

Retira un pedido de la zona de carga.
Cambia su estado a EN_REPARTO.
Simula la entrega utilizando Thread.sleep().
Cambia el estado a ENTREGADO.
▶️ Ejecución

La clase Main crea la zona de carga, agrega al menos 5 pedidos y ejecuta 3 repartidores utilizando ExecutorService.

Al finalizar correctamente todas las entregas, se muestra en consola:
Todos los pedidos han sido entregados correctamente.

▶️ Instrucciones para ejecutar el proyecto
1. Clonar o descargar el repositorio desde GitHub
2.-Abrir el proyecto en IntelliJ IDEA.
3. Seleccionar **Open** y abrir la carpeta del proyecto Semana5
4. Ubicar la carpeta src.
5.-Abrir la clase:  Main.java
6.-Ejecutar el método main() utilizando el botón Run ▶.
