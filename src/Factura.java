public class Factura {
    private Reserva reserva;
    private double montoTotal;

    public Factura(Reserva reserva) {
        this.reserva = reserva;
        this.montoTotal = reserva.calcularCostoTotal();
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }
}
