import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Control {
    //Se declaran los atributos de la clase
    private ArrayList<Instrumento> instrumentos;

    //Se declara el constructor de la clase en la cual se inicializa el Array de instrumentos y llama al método
    //para recuperar el archivo de texto
    public Control() {
        instrumentos = new ArrayList<>();
        recuperarArchivo();
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
        actualizarArchivo();
    }


    //Método para eliminar del registro un instrumento.
    public Instrumento eliminarInstrumento (Instrumento instrumento) {
        instrumentos.remove(instrumento);
        actualizarArchivo();
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
            if(instrumentos.get(i).getAutores().equals(autor)) {
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

    //Método que sirve para poder recuperar un archivo una vez se cerró el programa y se volvió a ejecutar.
    public void recuperarArchivo() {
        File archivo = new File("instrumentos.txt");
        if (!archivo.exists()) {
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] caracteres = linea.split(",");
                if (caracteres.length < 8) continue;

                String nombre = caracteres[0];
                int clave = Integer.parseInt(caracteres[1]);
                String cita = caracteres[2];
                String utilidad = caracteres[3];
                String condicion = caracteres[4];
                String tipo = caracteres[5];
                boolean confiabilidad = false;

                ArrayList<String> autores = new ArrayList<>();
                if (!caracteres[7].isEmpty()) {
                    autores.addAll(Arrays.asList(caracteres[7].split(";")));
                }

                instrumentos.add(new Instrumento(nombre,autores,utilidad, tipo, condicion,cita, clave, confiabilidad));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Método para actualizar el archivo una vez que se hayan agregado nuevos instrumentos al programa.
    public void actualizarArchivo() {
        try (FileWriter escritor = new FileWriter("instrumentos.txt")) {
            for (Instrumento instrumento : instrumentos) {

                String autoresString = String.join(";", instrumento.getAutores());

                escritor.write(
                        instrumento.getNombre() + "," +
                                instrumento.getClave() + "," +
                                instrumento.getCita() + "," +
                                instrumento.getUtilidad() + "," +
                                instrumento.getCondicion() + "," +
                                instrumento.getTipo() + "," +
                                instrumento.tieneConfiabilidad() + "," +
                                autoresString + "\n"
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
