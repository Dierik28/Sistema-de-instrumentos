import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Sistema extends JFrame {
    //Se establecen los atributos de la clase.
    private Control control;

    //Componentes de texto para agregar palabras.
    private JTextField nombreTxt, citaTxt, autoresTxt;
    private JTextField busquedaTxt, claveAEliminarTxt, claveTxt;
    //Componente para mostrar un area de resultados.
    private JTextArea resultados;
    //Componente para mostrar opciones desplegables.
    private JComboBox<String> utilidadOpc, condicionOpc, tipoOpc;
    private JComboBox<String> consultasOpc;
    //Componente para marcar una opcion
    private JCheckBox confiableOpc;
    //Componentes para mostrar botones.
    private JButton botonAgregar, botonEliminar;
    private JButton botonConsultar;


    //Constructor de la clase.
    public Sistema() {
        control = new Control();

        setTitle("---- Sistema de instrumentos ----");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JTabbedPane pestañas = new JTabbedPane();
        pestañas.add("Agregar", panelAgregar());
        pestañas.add("Consultar", panelConsultar());
        pestañas.add("Eliminar",panelEliminar());
        pestañas.add("Salir", panelSalir());

        add(pestañas, BorderLayout.CENTER);

    }


    //Metodo para configurar y mostrar el panel de agregar.
    private JPanel panelAgregar(){
        JPanel panel = new JPanel(new GridLayout(8,2,10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        nombreTxt = new JTextField();
        citaTxt = new JTextField();
        claveTxt = new JTextField();
        utilidadOpc = new JComboBox<>(new String[]{"Manejar","Identificar"});
        condicionOpc = new JComboBox<>(new String[]{"Ansiedad","Estres", "Ambos"});
        tipoOpc = new JComboBox<>(new String[]{"Escala","Test","Cuestionario"});
        autoresTxt = new JTextField("Ingrese los autores separados por comas respectivamente");
        confiableOpc = new JCheckBox("¿Es confiable?");
        botonAgregar = new JButton("Agregar Instrumento");

        panel.add(new JLabel("Nombre:"));
        panel.add(nombreTxt);
        panel.add(new JLabel("Cita:"));
        panel.add(citaTxt);
        panel.add(new JLabel("Utilidad:"));
        panel.add(utilidadOpc);
        panel.add(new JLabel("Condición:"));
        panel.add(condicionOpc);
        panel.add(new JLabel("Tipo:"));
        panel.add(tipoOpc);
        panel.add(new JLabel("Autores:"));
        panel.add(autoresTxt);
        panel.add(new JLabel("Confiabilidad:"));
        panel.add(confiableOpc);
        panel.add(new JLabel("Agregar"));
        panel.add(botonAgregar);

        botonAgregar.addActionListener(e -> agregarInstrumento());
        return panel;
    }

    //Metodo para configurar y mostrar el panel consultar.
    private JPanel panelConsultar(){
        JPanel panel = new JPanel(new BorderLayout(10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        JPanel opciones = new JPanel();
        consultasOpc = new JComboBox<>(new String[]{
                "Por condición", "Por tipo","Por utilidad","Por autor","Por clave",
                "Ordenados por clave","Ordenados por primer autor"});
        busquedaTxt = new JTextField(15);
        botonConsultar = new JButton("Consultar");

        opciones.add(new JLabel("Tipo de consulta:"));
        opciones.add(consultasOpc);
        opciones.add(busquedaTxt);
        opciones.add(botonConsultar);

        resultados = new JTextArea();
        resultados.setEditable(false);
        JScrollPane scroll = new JScrollPane(resultados);

        panel.add(opciones, BorderLayout.NORTH);
        panel.add(scroll, BorderLayout.CENTER);

        botonConsultar.addActionListener(e -> consultar());
        return panel;
    }

    //Metodo para configurar y mostrar el panel de eliminar
    private JPanel panelEliminar() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(50,20,20,20));

        claveAEliminarTxt= new JTextField(10);
        botonEliminar = new JButton("Eliminar");

        panel.add(new JLabel("Clave del instrumento:"));
        panel.add(claveAEliminarTxt);
        panel.add(botonEliminar);
        botonEliminar.addActionListener(e -> eliminarInstrumento());
        return panel;
    }

    //Metodo para configurar y mostrar el panel de salir
    private JPanel panelSalir() {
        JPanel panel = new JPanel(new FlowLayout());
        JButton botonSalir = new JButton("Salir del sistema");
        botonSalir.addActionListener(e -> System.exit(0));
        panel.add(botonSalir);
        return panel;
    }

    //Método que sirve para poder agregar un instrumento, recuperando el valor que fue ingresado por el usuario en
    //los diferentes cuadros de texto, y a su vez creando el objeto Instrumento para después ser dado de alta en el programa.
    private void agregarInstrumento() {
        String nombre = nombreTxt.getText().toLowerCase();
        String cita = citaTxt.getText().toLowerCase();
        String utilidad = utilidadOpc.getSelectedItem().toString().toLowerCase();
        String condicion = condicionOpc.getSelectedItem().toString().toLowerCase();
        String tipo = tipoOpc.getSelectedItem().toString().toLowerCase();
        ArrayList<String> autores = new ArrayList<>();
        for (String autor : autoresTxt.getText().split(",")) {
            autores.add(autor.trim());
        }
        boolean confiabilidad = confiableOpc.isSelected();

        Instrumento instrumento = new Instrumento(nombre,autores, utilidad, tipo, condicion, cita,0, confiabilidad);
        control.altas(instrumento);
        JOptionPane.showMessageDialog(this,"Instrumento agregado");
    }

    //Método que sirve para eliminar el instrumento dependiendo de la clave que el usuario ingrese, este método se encarga
    //de buscar coincidencias en el Array de instrumentos hasta encontrar la clave, si no fue así muestra un mensaje.
    private void eliminarInstrumento() {
        try {
            int clave = Integer.parseInt(claveAEliminarTxt.getText());
            Instrumento instrumento = control.buscarPorClave(clave);
            if (instrumento != null) {
                control.eliminarInstrumento(instrumento);
                JOptionPane.showMessageDialog(this,"Instrumento eliminado");
            } else {
                JOptionPane.showMessageDialog(this,"No existe un instrumento con esa clave");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,"Ingrese un número válido");
        }
    }


    //Método para buscar según el tipo de consulta ingresado por el usuario, dependiendo del tipo de consulta
    //ingresará a un case diferente, llamando a diversos métodos que sirven para hacer la consulta respectivamente.
    private void consultar() {
        String tipoConsulta = consultasOpc.getSelectedItem().toString();
        String mensaje = "";
        switch (tipoConsulta) {
            case "Por condición":
                mensaje = control.consultarPorCondicion(busquedaTxt.getText());
                break;
            case "Por tipo":
                mensaje = control.consultarPorTipo(busquedaTxt.getText());
                break;
            case "Por utilidad":
                mensaje = control.consultarPorUtilidad(busquedaTxt.getText());
                break;
            case "Por autor":
                mensaje = control.consultarPorAutor(busquedaTxt.getText());
                break;
            case "Por clave":
                try {
                    int clave = Integer.parseInt(busquedaTxt.getText());
                    mensaje = control.consultarPorClave(clave);
                } catch (NumberFormatException ex) {
                    mensaje = "Clave inválida";
                }
                break;
            case "Ordenados por clave":
                control.ordenarPorClave();
                mensaje = control.consultarTodos();
                break;
            case "Ordenados por primer autor":
                mensaje = control.consultarTodos();
                break;
        }
        resultados.setText(mensaje);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Sistema().setVisible(true));
    }


}
