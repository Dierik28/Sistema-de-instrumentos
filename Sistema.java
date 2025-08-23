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

        JTabbedPane pestanas = new JTabbedPane();
        pestanas.add("Agregar", panelAgregar());
        pestanas.add("Consultar", panelConsultar());
        pestanas.add("Eliminar",panelEliminar());
        pestanas.add("Salir", panelSalir());

        add(pestanas, BorderLayout.CENTER);

    }


    //Metodo para configurar y mostrar el panel de agregar.
    private JPanel panelAgregar(){
        JPanel panel = new JPanel(new GridLayout(9,2,10,10));
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
        panel.add(new JLabel("Clave:"));
        panel.add(claveTxt);
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

        return panel;
    }

    //Metodo para configurar y mostrar el panel de salir
    private JPanel panelSalir() {
        JPanel panel = new JPanel(new FlowLayout());
        JButton botonSalir = new JButton("Salir del sistema");
        panel.add(botonSalir);
        return panel;
    }

}
