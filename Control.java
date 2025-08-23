import java.util.ArrayList;
import java.util.Comparator;

public class Control {

    private ArrayList<Instrumento> instrumentos;

    public Control() {
        instrumentos = new ArrayList<>();
    }

    //Método para registrar un nuevo instrumento.
    public void altas (Instrumento instrumento) {
        int clave = 0;
        for (int i = 0; i < instrumentos.size(); i++) {
            if(instrumentos.get(i).getClave() == clave) {
                clave +=1;
            }
        }
        instrumento.setClave(clave);
        instrumentos.add(instrumento);
    }


    //Método para eliminar del registro un instrumento.
    public Instrumento eliminarInstrumento (Instrumento instrumento) {
        instrumentos.remove(instrumento);
        return instrumento;
    }


    //Método para encontrar un instrumento dependiendo de la clave.
    public Instrumento buscarPorClave (int clave) {
        for (int i = 0; i < instrumentos.size(); i++) {
            if(instrumentos.get(i).getClave() == clave) {
                return instrumentos.get(i);
            }
        }
        return null;
    }

    //Método para consultar el instrumento dependiendo del tipo.
    public String consultarPorTipo (String tipo) {
        String mensaje = "";
        for (int i = 0; i < instrumentos.size(); i++) {
            Instrumento instrumento = instrumentos.get(i);
            if(instrumentos.get(i).getTipo().equals(tipo)) {
                mensaje += instrumento + "\n";
            }
        }
        return mensaje;
    }

    //Método para constular un instrumento dependiendo de la condicion.
    public String consultarPorCondicion (String condicion) {
        String mensaje = "";
        for (int i = 0; i < instrumentos.size(); i++) {
            Instrumento instrumento = instrumentos.get(i);
            if(instrumentos.get(i).getCondicion().equals(condicion)) {
                mensaje += instrumento + "\n";
            }
        }
        return mensaje;
    }

    //Método para constular el instrumento por su cita.
    public String consultarPorCita (String cita) {
        String mensaje = "";
        for (int i = 0; i < instrumentos.size(); i++) {
            Instrumento instrumento = instrumentos.get(i);
            if(instrumentos.get(i).getCita().equals(cita)) {
                mensaje += instrumento + "\n";
            }
        }
        return mensaje;
    }

    //Método para consultar el instrumento dependiendo de su autor.
    public String consultarPorAutor (String autor) {
        String mensaje = "";
        for (int i = 0; i < instrumentos.size(); i++) {
            Instrumento instrumento = instrumentos.get(i);
            if(instrumentos.get(i).getAutor().equals(autor)) {
                mensaje += instrumento + "\n";
            }
        }
        return mensaje;
    }

    //Método para consultar el instrumento dependiendo de la utilidad.
    public String consultarPorUtilidad (String utilidad) {
        String mensaje = "";
        for (int i = 0; i < instrumentos.size(); i++) {
            Instrumento instrumento = instrumentos.get(i);
            if(instrumentos.get(i).getUtilidad().equals(utilidad)) {
                mensaje += instrumento + "\n";
            }
        }
        return mensaje;
    }

    public String consultarPorClave (int clave) {
        String mensaje = "";
        for (int i = 0; i < instrumentos.size(); i++) {
            Instrumento instrumento = instrumentos.get(i);
            if(instrumentos.get(i).getClave() == clave) {
                mensaje += instrumento + "\n";
            }
        }
        return mensaje;
    }

    public String consultarTodos(){
        String mensaje = "";
        for (int i = 0; i < instrumentos.size(); i++) {
            Instrumento instrumento = instrumentos.get(i);
            mensaje += instrumento + "\n";
        }
        return mensaje;
    }

    public void ordenarPorClave () {
        instrumentos.sort(Comparator.comparingInt((Instrumento instrumento) -> instrumento.getClave()));
    }

    //Método getter para obtner el Array de instrumentos.
    public ArrayList<Instrumento> getInstrumentos() {
        return instrumentos;
    }
}
