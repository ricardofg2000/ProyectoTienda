package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import bdm.ConexionBD;
import controller.ClienteDAO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteVentana extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldUsuario;
    private JPasswordField passwordField;
    private JButton btnIniciarSesion;
    private JButton btnNuevoUsuario;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ClienteVentana frame = new ClienteVentana();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ClienteVentana() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(443, 325); // Tamaño fijo de la ventana
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(20, 11, 394, 241);
        contentPane.add(panel);
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.setLayout(null);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(53, 69, 96, 30);
        panel.add(lblUsuario);

        textFieldUsuario = new JTextField();
        textFieldUsuario.setBounds(139, 69, 187, 30);
        textFieldUsuario.setColumns(20); // Tamaño fijo del cuadro de texto
        panel.add(textFieldUsuario);

        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(53, 110, 96, 30);
        panel.add(lblContrasena);

        passwordField = new JPasswordField();
        passwordField.setBounds(139, 110, 187, 30);
        passwordField.setColumns(20); // Tamaño fijo del cuadro de texto
        panel.add(passwordField);

        JPanel panelBoton = new JPanel();
        panelBoton.setBounds(-19, 166, 428, 64);
        panelBoton.setLayout(null);

        btnIniciarSesion = new JButton("Iniciar Sesión");
        btnIniciarSesion.setBounds(167, 5, 95, 23);
        panelBoton.add(btnIniciarSesion);
        panel.add(panelBoton);

        btnNuevoUsuario = new JButton("¿Nuevo? Crea una cuenta");
        btnNuevoUsuario.setBounds(115, 41, 198, 23);
        panelBoton.add(btnNuevoUsuario);

        JLabel lblTitulo = new JLabel("INICIO DE SESIÓN");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblTitulo.setBounds(-19, 11, 428, 47);
        panel.add(lblTitulo);

        btnIniciarSesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = textFieldUsuario.getText();
                String contrasena = new String(passwordField.getPassword());

                if (ClienteDAO.validarCredenciales(usuario, contrasena)) {
                    mostrarVentanaProductos();
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Credenciales inválidas. Intente nuevamente.");
                }
            }
        });

        btnNuevoUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CrearClienteVentana crearClienteVentana = new CrearClienteVentana();
                crearClienteVentana.setVisible(true);
                dispose();
            }
        });
    }

    private void mostrarVentanaProductos() {
        // Código para mostrar la ventana de productos
        // Aquí puedes implementar la lógica necesaria para mostrar la ventana con los productos disponibles
        // Puedes utilizar una nueva clase de ventana o hacer modificaciones a esta misma clase para agregar los componentes necesarios
        // Por ejemplo, puedes crear una nueva instancia de la clase ProductosVentana y hacerla visible:
        ProductosVentana productosVentana = new ProductosVentana();
        productosVentana.setVisible(true);
        // También puedes cerrar la ventana actual si ya no es necesaria:
        dispose();
    }
}
