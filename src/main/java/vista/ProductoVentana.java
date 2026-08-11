package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import componentes.JDialogGenerico;
import componentes.JtextFieldGenerico;
import controlador.ProductoController;

public class ProductoVentana extends JDialogGenerico {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JtextFieldGenerico tfCategoria;
	private JtextFieldGenerico tfMarca;
	private JButton btnMarca;
	private JButton btnCategoria;
	private JtextFieldGenerico tfCodigo;
	private JtextFieldGenerico tfDescripcion;
	private JtextFieldGenerico tfExistencia;
	private JtextFieldGenerico tfVenta;
	private JRadioButton rdbtnActivo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ProductoVentana dialog = new ProductoVentana();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setUpController();
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setUpController() {
		new ProductoController(this);
	}

	/**
	 * Create the dialog.
	 */
	public ProductoVentana() {
		setTitle("Productos");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		getPanelFormulario().setLayout(null);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategoria.setBounds(12, 13, 91, 16);
		getPanelFormulario().add(lblCategoria);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMarca.setBounds(12, 52, 91, 16);
		getPanelFormulario().add(lblMarca);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCdigo.setBounds(12, 92, 91, 16);
		getPanelFormulario().add(lblCdigo);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescripcin.setBounds(12, 136, 91, 16);
		getPanelFormulario().add(lblDescripcin);
		
		JLabel lblExistencia = new JLabel("Existencia:");
		lblExistencia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblExistencia.setBounds(12, 175, 91, 16);
		getPanelFormulario().add(lblExistencia);
		
		JLabel lblVenta = new JLabel("Venta:");
		lblVenta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVenta.setBounds(12, 226, 91, 16);
		getPanelFormulario().add(lblVenta);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstado.setBounds(12, 277, 91, 16);
		getPanelFormulario().add(lblEstado);
		
		tfCategoria = new JtextFieldGenerico();
		tfCategoria.setEditable(false);
		tfCategoria.setBounds(111, 10, 221, 22);
		getPanelFormulario().add(tfCategoria);
		tfCategoria.setColumns(10);
		
		tfMarca = new JtextFieldGenerico();
		tfMarca.setEditable(false);
		tfMarca.setColumns(10);
		tfMarca.setBounds(111, 51, 221, 22);
		getPanelFormulario().add(tfMarca);
		
		tfCodigo = new JtextFieldGenerico();
		tfCodigo.setColumns(10);
		tfCodigo.setBounds(111, 91, 277, 22);
		getPanelFormulario().add(tfCodigo);
		
		tfDescripcion = new JtextFieldGenerico();
		tfDescripcion.setColumns(10);
		tfDescripcion.setBounds(111, 135, 277, 22);
		getPanelFormulario().add(tfDescripcion);
		
		tfExistencia = new JtextFieldGenerico();
		tfExistencia.setColumns(10);
		tfExistencia.setBounds(111, 174, 116, 22);
		getPanelFormulario().add(tfExistencia);
		
		tfVenta = new JtextFieldGenerico();
		tfVenta.setColumns(10);
		tfVenta.setBounds(111, 225, 116, 22);
		getPanelFormulario().add(tfVenta);
		
		rdbtnActivo = new JRadioButton("Activo");
		rdbtnActivo.setBounds(111, 273, 127, 25);
		getPanelFormulario().add(rdbtnActivo);
		
		btnCategoria = new JButton("...");
		btnCategoria.setBounds(344, 9, 44, 25);
		getPanelFormulario().add(btnCategoria);
		
		btnMarca = new JButton("...");
		btnMarca.setBounds(344, 48, 44, 25);
		getPanelFormulario().add(btnMarca);
	}

	public JtextFieldGenerico getTfCategoria() {
		return tfCategoria;
	}

	public void setTfCategoria(JtextFieldGenerico tfCategoria) {
		this.tfCategoria = tfCategoria;
	}

	public JtextFieldGenerico getTfMarca() {
		return tfMarca;
	}

	public void setTfMarca(JtextFieldGenerico tfMarca) {
		this.tfMarca = tfMarca;
	}

	public JButton getBtnMarca() {
		return btnMarca;
	}

	public void setBtnMarca(JButton btnMarca) {
		this.btnMarca = btnMarca;
	}

	public JButton getBtnCategoria() {
		return btnCategoria;
	}

	public void setBtnCategoria(JButton btnCategoria) {
		this.btnCategoria = btnCategoria;
	}

	public JtextFieldGenerico getTfCodigo() {
		return tfCodigo;
	}

	public void setTfCodigo(JtextFieldGenerico tfCodigo) {
		this.tfCodigo = tfCodigo;
	}

	public JtextFieldGenerico getTfDescripcion() {
		return tfDescripcion;
	}

	public void setTfDescripcion(JtextFieldGenerico tfDescripcion) {
		this.tfDescripcion = tfDescripcion;
	}

	public JtextFieldGenerico getTfExistencia() {
		return tfExistencia;
	}

	public void setTfExistencia(JtextFieldGenerico tfExistencia) {
		this.tfExistencia = tfExistencia;
	}

	public JtextFieldGenerico getTfVenta() {
		return tfVenta;
	}

	public void setTfVenta(JtextFieldGenerico tfVenta) {
		this.tfVenta = tfVenta;
	}

	public JRadioButton getRdbtnActivo() {
		return rdbtnActivo;
	}

	public void setRdbtnActivo(JRadioButton rdbtnActivo) {
		this.rdbtnActivo = rdbtnActivo;
	}

	public JPanel getContentPanel() {
		return contentPanel;
	}
	
}
