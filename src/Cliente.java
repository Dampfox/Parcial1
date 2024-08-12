import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {
    private List<Reserva> reservas;
    private List<Factura> facturas;

    public Cliente(String nombre, String id) {
        super(nombre, id);
        this.reservas = new ArrayList<>();
        this.facturas = new ArrayList<>();
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void addReserva(Reserva reserva) {
        this.reservas.add(reserva);
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void addFactura(Factura factura) {
        this.facturas.add(factura);
    }
}
