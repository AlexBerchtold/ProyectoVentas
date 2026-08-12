package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFormattedTextField;

import componentes.JLabelGenerico;
import componentes.JtextFieldGenerico;
import util.FechaUtil;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import componentes.JButtonABM;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class VentaVista extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentaVista dialog = new VentaVista();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public VentaVista() {
		setTitle("Venta de Productos");
		setBounds(100, 100, 1080, 720);
		getContentPane().setLayout(null);
		
		JLabelGenerico lblCodigo = new JLabelGenerico((String) null);
		lblCodigo.setText("Código:");
		lblCodigo.setBounds(24, 21, 70, 22);
		getContentPane().add(lblCodigo);
		
		JtextFieldGenerico tfCodigo = new JtextFieldGenerico();
		tfCodigo.setBounds(80, 20, 112, 23);
		getContentPane().add(tfCodigo);
		
		JLabelGenerico lblFecha = new JLabelGenerico((String) null);
		lblFecha.setText("Fecha y Hora:");
		lblFecha.setBounds(779, 21, 97, 22);
		getContentPane().add(lblFecha);
		
		JFormattedTextField tfFecha = new JFormattedTextField(FechaUtil.getFormatoFechaHora());
		tfFecha.setBounds(886, 21, 112, 23);
		getContentPane().add(tfFecha);
		
		JLabelGenerico lblgnrcCiRuc = new JLabelGenerico((String) null);
		lblgnrcCiRuc.setText("C.I. / RUC de cliente:");
		lblgnrcCiRuc.setBounds(24, 75, 134, 22);
		getContentPane().add(lblgnrcCiRuc);
		
		JtextFieldGenerico tfCiRuc = new JtextFieldGenerico();
		tfCiRuc.setBounds(24, 107, 211, 23);
		getContentPane().add(tfCiRuc);
		
		JLabelGenerico lblgnrcRazonSocial = new JLabelGenerico((String) null);
		lblgnrcRazonSocial.setText("Razon Social");
		lblgnrcRazonSocial.setBounds(251, 75, 134, 22);
		getContentPane().add(lblgnrcRazonSocial);
		
		JtextFieldGenerico tfCiRuc_1 = new JtextFieldGenerico();
		tfCiRuc_1.setEditable(false);
		tfCiRuc_1.setBounds(251, 107, 261, 23);
		getContentPane().add(tfCiRuc_1);
		
		JLabelGenerico lblgnrcContacto = new JLabelGenerico((String) null);
		lblgnrcContacto.setText("Contacto");
		lblgnrcContacto.setBounds(534, 75, 134, 22);
		getContentPane().add(lblgnrcContacto);
		
		JtextFieldGenerico tfCiRuc_1_1 = new JtextFieldGenerico();
		tfCiRuc_1_1.setEditable(false);
		tfCiRuc_1_1.setBounds(534, 107, 261, 23);
		getContentPane().add(tfCiRuc_1_1);
		
		JButton btnNewButton = new JButton("Registrar Cliente");
		btnNewButton.setBounds(807, 107, 131, 23);
		getContentPane().add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 151, 1046, 2);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 157, 1046, 2);
		getContentPane().add(separator_1);
		
		JLabelGenerico lblgnrcCdigoDeProducto = new JLabelGenerico((String) null);
		lblgnrcCdigoDeProducto.setText("Código de Producto");
		lblgnrcCdigoDeProducto.setBounds(10, 172, 134, 22);
		getContentPane().add(lblgnrcCdigoDeProducto);
		
		JtextFieldGenerico tfCiRuc_2 = new JtextFieldGenerico();
		tfCiRuc_2.setBounds(10, 195, 211, 23);
		getContentPane().add(tfCiRuc_2);
		
		JLabelGenerico lblgnrcDescripcinDeProducto = new JLabelGenerico((String) null);
		lblgnrcDescripcinDeProducto.setText("Descripción de Producto");
		lblgnrcDescripcinDeProducto.setBounds(231, 172, 217, 22);
		getContentPane().add(lblgnrcDescripcinDeProducto);
		
		JtextFieldGenerico tfCiRuc_2_1 = new JtextFieldGenerico();
		tfCiRuc_2_1.setBounds(231, 195, 417, 23);
		getContentPane().add(tfCiRuc_2_1);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(658, 195, 89, 23);
		getContentPane().add(btnBuscar);
		
		JLabelGenerico lblgnrcCantidad = new JLabelGenerico((String) null);
		lblgnrcCantidad.setText("Cantidad:");
		lblgnrcCantidad.setBounds(757, 172, 81, 22);
		getContentPane().add(lblgnrcCantidad);
		
		JtextFieldGenerico tfCiRuc_2_2 = new JtextFieldGenerico();
		tfCiRuc_2_2.setBounds(757, 195, 81, 23);
		getContentPane().add(tfCiRuc_2_2);
		
		JLabelGenerico lblgnrcPrecio = new JLabelGenerico((String) null);
		lblgnrcPrecio.setText("Precio:");
		lblgnrcPrecio.setBounds(857, 172, 81, 22);
		getContentPane().add(lblgnrcPrecio);
		
		JtextFieldGenerico tfCiRuc_2_2_1 = new JtextFieldGenerico();
		tfCiRuc_2_2_1.setBounds(857, 195, 199, 23);
		getContentPane().add(tfCiRuc_2_2_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 234, 1046, 332);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButtonABM btnbmCancelar = new JButtonABM();
		btnbmCancelar.setText("Cancelar");
		btnbmCancelar.setBounds(10, 576, 97, 76);
		getContentPane().add(btnbmCancelar);
		
		JButtonABM btnbmFinalizar = new JButtonABM();
		btnbmFinalizar.setText("Guardar");
		btnbmFinalizar.setBounds(151, 576, 97, 76);
		getContentPane().add(btnbmFinalizar);
		
		JLabel lblTotal = new JLabel("Total ₲: 0");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setFont(new Font("Arial", Font.BOLD, 30));
		lblTotal.setBounds(648, 576, 408, 76);
		getContentPane().add(lblTotal);

	}
}
