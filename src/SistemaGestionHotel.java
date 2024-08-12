import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class SistemaGestionHotel {
    private Map<String, Habitacion> habitaciones;
    private Map<String, Cliente> clientes;
    private Map<String, Reserva> reservas;
    private Map<String, Factura> facturas;

    public SistemaGestionHotel() {
        habitaciones = new HashMap<>();
        clientes = new HashMap<>();
        reservas = new HashMap<>();
        facturas = new HashMap<>();
    }

    public void registrarHabitacion(Habitacion habitacion) {
        habitaciones.put(habitacion.getNumero(), habitacion);
    }

    public void registrarCliente(Cliente cliente) {
        clientes.put(cliente.getId(), cliente);
    }

    public void crearReserva(String clienteId, String habitacionNumero, LocalDate fechaEntrada, LocalDate fechaSalida) throws HabitacionNoDisponibleException, ClienteNoEncontradoException {
        Cliente cliente = clientes.get(clienteId);
        if (cliente == null) {
            throw new ClienteNoEncontradoException("Cliente no encontrado");
        }

        Habitacion habitacion = habitaciones.get(habitacionNumero);
        if (habitacion == null || !"disponible".equals(habitacion.getEstado())) {
            throw new HabitacionNoDisponibleException("Habitación no disponible");
        }

        Reserva reserva = new Reserva(habitacion, cliente, fechaEntrada, fechaSalida);
        reservas.put(clienteId + habitacionNumero, reserva);
        cliente.addReserva(reserva);
        habitacion.setEstado("ocupada");
    }

    public void registrarFactura(String clienteId, String habitacionNumero) throws ClienteNoEncontradoException {
        Cliente cliente = clientes.get(clienteId);
        if (cliente == null) {
            throw new ClienteNoEncontradoException("Cliente no encontrado");
        }

        Reserva reserva = reservas.get(clienteId + habitacionNumero);
        if (reserva == null) {
            throw new RuntimeException("Reserva no encontrada");
        }

        Factura factura = new Factura(reserva);
        facturas.put(clienteId + habitacionNumero, factura);
        cliente.addFactura(factura);
    }

    public void consultarInformacion() {
        System.out.println("Habitaciones:");
        habitaciones.values().forEach(h -> System.out.println(h.getNumero() + " - " + h.getTipo() + " - " + h.getEstado()));

        System.out.println("\nReservas:");
        reservas.values().forEach(r -> System.out.println("Cliente: " + r.getCliente().getNombre() + ", Habitación: " + r.getHabitacion().getNumero()));

        System.out.println("\nFacturas:");
        facturas.values().forEach(f -> System.out.println("Factura para reserva de habitación " + f.getReserva().getHabitacion().getNumero() + " - Monto: " + f.getMontoTotal()));
    }
}
