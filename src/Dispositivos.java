public class Dispositivos {
    private String codigo;
    private String marca;
    private int anio;
    private int cantidad;
    private String tipo;

    public Dispositivos(String codigo, String marca, int anio, int cantidad, String tipo) {
        this.codigo = codigo;
        this.marca = marca;
        this.anio = anio;
        this.cantidad = cantidad;
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    @Override
    public String toString() {
        return "Codigo: " + codigo + ",  Marca: " + marca + ",  Año: " + anio + ",  Cantidad: " + cantidad + ",  Tipo: " + tipo;
    }
}
