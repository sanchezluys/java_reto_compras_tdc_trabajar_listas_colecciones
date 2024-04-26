public class Compra {
    private double valor;
    private String descripcion;

    public Compra( String descripcion, double valor) {
        this.valor = valor;
        this.descripcion = descripcion;
    }

    public double getValor() {
        return valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "Compra Descripcion: " + descripcion + " valor: " + valor;
    }
}
