import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel Examen;
    private JTextField codigo;
    private JTextField marca;
    private JTextField cantidad;
    private JComboBox cboTipo;
    private JButton btnEncolar;
    private JButton btnDesencolar;
    private JTextArea txtDispositivos;
    private JLabel codigoLabel;
    private JLabel marcaLabel;
    private JLabel anioLabel;
    private JTextField anio;
    private JLabel cantidadLabel;
    private JLabel tipoLabel;
    private JLabel Titulo;
    Cola cola=new Cola();

    public Ventana(){
        cola.valoresPredefinidos();
        txtDispositivos.setText(cola.toString());
        btnEncolar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (codigo.getText().isEmpty() || marca.getText().isEmpty() || anio.getText().isEmpty() || cantidad.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Dispositivos dispositivo= new Dispositivos(codigo.getText(),marca.getText(),
                        Integer.parseInt(anio.getText()),Integer.parseInt(cantidad.getText()),cboTipo.getSelectedItem().toString());
                try {
                    cola.encolarDispositivos(dispositivo);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                txtDispositivos.setText(cola.toString());
            }

        });

        btnDesencolar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (codigo.getText().isEmpty() || cantidad.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, complete los campos de código y cantidad.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    cola.desencolarDispositivos(codigo.getText(),Integer.parseInt(cantidad.getText()));
                } catch (Exception E) {
                    JOptionPane.showMessageDialog(null, E.getMessage());
                }
                txtDispositivos.setText(cola.toString());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().Examen);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
