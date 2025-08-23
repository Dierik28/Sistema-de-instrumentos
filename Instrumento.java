import java.util.ArrayList;

public class Instrumento {

    //Inicialización de las variables que se usarán en esta clase.
    private String nombre;
    private ArrayList<String> autores;
    private String utilidad;
    private String tipo;
    private String condicion;
    private String cita;
    private boolean confiabilidad;
    private int clave;

    //Se establece un constructor para la creacion del objeto de tipo instrumento, el cual será usado en otra clase.
    public Instrumento(String nombre, ArrayList<String> autores, String utilidad, String tipo, String condicion, String cita,
                       int clave, boolean confiabilidad) {
        this.nombre = nombre;
        this.autores = autores;
        this.utilidad = utilidad;
        this.tipo = tipo;
        this.condicion = condicion;
        this.cita = cita;
        this.confiabilidad = confiabilidad;
        this.clave = clave;
    }
    public void setClave(int clave) {
        this.clave = clave;
    }

    //Se agregan getters para poder obtener los valores del objeto.

    public String getNombre() {
        return nombre;
    }
    public ArrayList<String> getAutores() {
        return autores;
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

    public int getClave() {
        return clave;
    }

    //Método toString para mostrar con formato el instrumento.
    public String toString() {
        return "Nombre: " + nombre +
                "\nClave: " + clave +
                "\nUtilidad: " + utilidad +
                "\nTipo: " + tipo +
                "\nCondición: " + condicion +
                "\nCita: " + cita +
                "\nAutores: " + String.join(", ", autores) +
                "\nConfiabilidad: " + (confiabilidad ? "Sí" : "No") +
                "\n------------------------\n";
    }
}
