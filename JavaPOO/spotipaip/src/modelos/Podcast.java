package modelos;

public class Podcast extends Audio {
    private String presentador;
    private String descripcion;

    @Override
    public int getClasificacion() {
        if (getTotalReproducciones() >= 500) {
            return 8;
        }
        return 3;
    }

    public String getPresentador() {
        return presentador;
    }

    public void setPresentador(String presentador) {
        this.presentador = presentador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
