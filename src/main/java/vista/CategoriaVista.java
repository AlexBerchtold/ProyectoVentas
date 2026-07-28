package vista;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JDialog;

import componentes.JDialogGenerico;
import componentes.JLabelGenerico;
import componentes.JtextFieldGenerico;
import controlador.CategoriaController;

public class CategoriaVista extends JDialogGenerico {

	private static final long serialVersionUID = 1L;
	private JtextFieldGenerico tfNombre;
	private JCheckBox chEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CategoriaVista dialog = new CategoriaVista();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setControlador();
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setControlador() {
		new CategoriaController(this);
	}

	/**
	 * Create the dialog.
	 */
	public CategoriaVista() {
		
		JLabelGenerico lblgnrcNombre = new JLabelGenerico((String) null);
		lblgnrcNombre.setText("Nombre:");
		lblgnrcNombre.setBounds(10, 74, 142, 25);
		getPanelFormulario().add(lblgnrcNombre);
		
		JLabelGenerico lblgnrcDireccin = new JLabelGenerico((String) null);
		lblgnrcDireccin.setText("Estado:");
		lblgnrcDireccin.setBounds(10, 177, 142, 25);
		getPanelFormulario().add(lblgnrcDireccin);
		
		tfNombre = new JtextFieldGenerico();
		tfNombre.setBounds(162, 74, 343, 25);
		getPanelFormulario().add(tfNombre);
		
		chEstado = new JCheckBox("Activo");
		chEstado.setFont(new Font("Tahoma", Font.BOLD, 12));
		chEstado.setBounds(162, 180, 92, 20);
		getPanelFormulario().add(chEstado);
		

	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JtextFieldGenerico getTfNombre() {
		return tfNombre;
	}

	public JCheckBox getChEstado() {
		return chEstado;
	}
}
