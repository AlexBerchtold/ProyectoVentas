package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import componentes.JLabelGenerico;
import componentes.JtextFieldGenerico;
import controlador.BuscadorCategoriaController;

public class BuscadorCategoriaVista extends JDialog {

	
	private static final long serialVersionUID = 1L;
	private JLabelGenerico lblavisos;
	private JtextFieldGenerico tfBuscador;
	private JTable table;
	private BuscadorCategoriaController controller;
	

	public void setUpController() {
		controller = new BuscadorCategoriaController(this);
	}

	/**
	 * Create the dialog.
	 */
	public BuscadorCategoriaVista() {
		getContentPane().setBackground(new Color(230, 230, 250));
		setTitle("Buscador de Categorias");
		setBounds(100, 100, 500, 500);
		setModal(true);
		setLocationRelativeTo(this);
		getContentPane().setLayout(null);
		
		JLabelGenerico lblDescripcion = new JLabelGenerico((String) null);
		lblDescripcion.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescripcion.setText("Buscar:");
		lblDescripcion.setBounds(10, 65, 50, 20);
		getContentPane().add(lblDescripcion);
		
		tfBuscador = new JtextFieldGenerico();
		tfBuscador.setBounds(60, 66, 325, 20);
		getContentPane().add(tfBuscador);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 464, 33);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblavisos = new JLabelGenerico("Aqui aparecerian los mensajes de errores, validaciones, y o consejos");
		lblavisos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblavisos.setHorizontalAlignment(SwingConstants.CENTER);
		lblavisos.setBounds(10, 5, 444, 22);
		panel.add(lblavisos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 102, 464, 348);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JLabelGenerico getLblavisos() {
		return lblavisos;
	}

	public JtextFieldGenerico getTfBuscador() {
		return tfBuscador;
	}

	public JTable getTable() {
		return table;
	}

	public BuscadorCategoriaController getController() {
		return controller;
	}
	
}
