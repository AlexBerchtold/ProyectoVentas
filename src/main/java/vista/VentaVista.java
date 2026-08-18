package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFormattedTextField;

import componentes.JLabelGenerico;
import componentes.JtextFieldGenerico;
import controlador.VentaController;
import util.FechaUtil;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import componentes.JButtonABM;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentaVista extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JtextFieldGenerico tfCodigo;
	private JtextFieldGenerico tfCiRuc;
	private JtextFieldGenerico tfRazonSocial;
	private JtextFieldGenerico tfContacto;
	private JButton btnRegistrarCliente;
	private JtextFieldGenerico tfCodigoProducto;
	private JtextFieldGenerico tfProducto;
	private JButton btnBuscarProducto;
	private JtextFieldGenerico tfCantidad;
	private JtextFieldGenerico tfPrecioVenta;
	private JButtonABM btnbmCancelar;
	private JButtonABM btnbmFinalizar;
	private JLabel lblTotal;
	private JFormattedTextField tfFecha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentaVista dialog = new VentaVista();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setController();
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void setController() {
		new VentaController(this);
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
		
		tfCodigo = new JtextFieldGenerico();
		tfCodigo.setBounds(80, 20, 112, 23);
		getContentPane().add(tfCodigo);
		
		JLabelGenerico lblFecha = new JLabelGenerico((String) null);
		lblFecha.setText("Fecha y Hora:");
		lblFecha.setBounds(779, 21, 97, 22);
		getContentPane().add(lblFecha);
		
		tfFecha = new JFormattedTextField(FechaUtil.getFormatoFechaHora());
		tfFecha.setBounds(886, 21, 112, 23);
		getContentPane().add(tfFecha);
		
		JLabelGenerico lblgnrcCiRuc = new JLabelGenerico((String) null);
		lblgnrcCiRuc.setText("C.I. / RUC de cliente:");
		lblgnrcCiRuc.setBounds(24, 75, 134, 22);
		getContentPane().add(lblgnrcCiRuc);
		
		tfCiRuc = new JtextFieldGenerico();
		tfCiRuc.setBounds(24, 107, 211, 23);
		getContentPane().add(tfCiRuc);
		
		JLabelGenerico lblgnrcRazonSocial = new JLabelGenerico((String) null);
		lblgnrcRazonSocial.setText("Razon Social");
		lblgnrcRazonSocial.setBounds(251, 75, 134, 22);
		getContentPane().add(lblgnrcRazonSocial);
		
		tfRazonSocial = new JtextFieldGenerico();
		tfRazonSocial.setEditable(false);
		tfRazonSocial.setBounds(251, 107, 261, 23);
		getContentPane().add(tfRazonSocial);
		
		JLabelGenerico lblgnrcContacto = new JLabelGenerico((String) null);
		lblgnrcContacto.setText("Contacto");
		lblgnrcContacto.setBounds(534, 75, 134, 22);
		getContentPane().add(lblgnrcContacto);
		
		tfContacto = new JtextFieldGenerico();
		tfContacto.setEditable(false);
		tfContacto.setBounds(534, 107, 261, 23);
		getContentPane().add(tfContacto);
		
		btnRegistrarCliente = new JButton("Registrar Cliente");
		btnRegistrarCliente.setBounds(807, 107, 131, 23);
		getContentPane().add(btnRegistrarCliente);
		
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
		
		tfCodigoProducto = new JtextFieldGenerico();
		
		tfCodigoProducto.setBounds(10, 195, 211, 23);
		getContentPane().add(tfCodigoProducto);
		
		JLabelGenerico lblgnrcDescripcinDeProducto = new JLabelGenerico((String) null);
		lblgnrcDescripcinDeProducto.setText("Descripción de Producto");
		lblgnrcDescripcinDeProducto.setBounds(231, 172, 217, 22);
		getContentPane().add(lblgnrcDescripcinDeProducto);
		
		tfProducto = new JtextFieldGenerico();
		tfProducto.setEditable(false);
		tfProducto.setBounds(231, 195, 417, 23);
		getContentPane().add(tfProducto);
		
		btnBuscarProducto = new JButton("Buscar");
		btnBuscarProducto.setBounds(658, 195, 89, 23);
		getContentPane().add(btnBuscarProducto);
		
		JLabelGenerico lblgnrcCantidad = new JLabelGenerico((String) null);
		lblgnrcCantidad.setText("Cantidad:");
		lblgnrcCantidad.setBounds(757, 172, 81, 22);
		getContentPane().add(lblgnrcCantidad);
		
		tfCantidad = new JtextFieldGenerico();
		tfCantidad.setBounds(757, 195, 81, 23);
		getContentPane().add(tfCantidad);
		
		JLabelGenerico lblgnrcPrecio = new JLabelGenerico((String) null);
		lblgnrcPrecio.setText("Precio:");
		lblgnrcPrecio.setBounds(857, 172, 81, 22);
		getContentPane().add(lblgnrcPrecio);
		
		tfPrecioVenta = new JtextFieldGenerico();
		tfPrecioVenta.setBounds(857, 195, 199, 23);
		getContentPane().add(tfPrecioVenta);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 234, 1046, 332);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnbmCancelar = new JButtonABM();
		btnbmCancelar.setText("Cancelar");
		btnbmCancelar.setBounds(10, 576, 97, 76);
		getContentPane().add(btnbmCancelar);
		
		btnbmFinalizar = new JButtonABM();
		btnbmFinalizar.setText("Guardar");
		btnbmFinalizar.setBounds(151, 576, 97, 76);
		getContentPane().add(btnbmFinalizar);
		
		lblTotal = new JLabel("Total ₲: 0");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setFont(new Font("Arial", Font.BOLD, 30));
		lblTotal.setBounds(648, 576, 408, 76);
		getContentPane().add(lblTotal);

	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JTable getTable() {
		return table;
	}

	public JtextFieldGenerico getTfCodigo() {
		return tfCodigo;
	}

	public JtextFieldGenerico getTfCiRuc() {
		return tfCiRuc;
	}

	public JtextFieldGenerico getTfRazonSocial() {
		return tfRazonSocial;
	}

	public JtextFieldGenerico getTfContacto() {
		return tfContacto;
	}

	public JButton getBtnRegistrarCliente() {
		return btnRegistrarCliente;
	}

	public JtextFieldGenerico getTfCodigoProducto() {
		return tfCodigoProducto;
	}

	public JtextFieldGenerico getTfProducto() {
		return tfProducto;
	}

	public JButton getBtnBuscarProducto() {
		return btnBuscarProducto;
	}

	public JtextFieldGenerico getTfCantidad() {
		return tfCantidad;
	}

	public JtextFieldGenerico getTfPrecioVenta() {
		return tfPrecioVenta;
	}

	public JButtonABM getBtnbmCancelar() {
		return btnbmCancelar;
	}

	public JButtonABM getBtnbmFinalizar() {
		return btnbmFinalizar;
	}

	public JLabel getLblTotal() {
		return lblTotal;
	}

	public JFormattedTextField getTfFecha() {
		return tfFecha;
	}
}
