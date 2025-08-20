public class Instrumento {

    //Inicialización de las variables que se usarán en esta clase.
    private String nombre;
    private String autor;
    private String utilidad;
    private String tipo;
    private String condicion;
    private String cita;
    private boolean confiabilidad;
    private boolean validez;
    private int clave;

    //Se establece un constructor para la creacion del objeto de tipo instrumento, el cual será usado en otra clase.
    public Instrumento(String nombre, String autor, String utilidad, String tipo, String condicion, String cita,
                       int clave, boolean confiabilidad, boolean validez) {
        this.nombre = nombre;
        this.autor = autor;
        this.utilidad = utilidad;
        this.tipo = tipo;
        this.condicion = condicion;
        this.cita = cita;
        this.validez = validez;
        this.confiabilidad = confiabilidad;
        this.clave = clave;
    }

    //Se agregan los setters, los cuales ayudarán para poder modificar los valores del objeto.

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setUtilidad(String utilidad) {
        this.utilidad = utilidad;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }
    public void setCita(String cita) {
        this.cita = cita;
    }
    public void setConfiabilidad(boolean confiabilidad) {
        this.confiabilidad = confiabilidad;
    }
    public void setValidez(boolean validez) {
        this.validez = validez;
    }
    public void setClave(int clave) {
        this.clave = clave;
    }


    //Se agregan getters para poder obtener los valores del objeto.

    public String getNombre() {
        return nombre;
    }
    public String getAutor() {
        return autor;
    }
    public String getUtilidad() {
        return utilidad;
    }
    public String getTipo() {
        return tipo;
    }
    public String getCondicion() {
        return condicion;
    }
    public String getCita() {
        return cita;
    }
    public boolean tieneConfiabilidad() {
        return confiabilidad;
    }
    public boolean tieneValidez() {
        return validez;
    }
    public int getClave() {
        return clave;
    }

}
