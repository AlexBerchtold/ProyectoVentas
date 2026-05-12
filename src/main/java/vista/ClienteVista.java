package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

import componentes.JDialogGenerico;
import controlador.ClienteController;
import util.FechaUtil;

public class ClienteVista extends JDialogGenerico {

	private static final long serialVersionUID = 1L;
	private JFormattedTextField tfFecha;
	private JFormattedTextField tfHora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteVista dialog = new ClienteVista();
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
		new ClienteController(this);
	}

	/**
	 * Create the dialog.
	 */
	public ClienteVista() {
		
		JLabel lblNewLabel = new JLabel("Fecha:");
		lblNewLabel.setBounds(20, 23, 87, 18);
		getPanelFormulario().add(lblNewLabel);
		
		tfFecha = new JFormattedTextField(FechaUtil.getFormatoFecha());
		tfFecha.setBounds(128, 23, 87, 29);
		getPanelFormulario().add(tfFecha);
		tfFecha.setColumns(10);
		
		tfHora = new JFormattedTextField(FechaUtil.getFormatoHora());
		tfHora.setColumns(10);
		tfHora.setBounds(270, 23, 87, 29);
		getPanelFormulario().add(tfHora);
		

	}

	public JFormattedTextField getTfFecha() {
		return tfFecha;
	}

	public void setTfFecha(JFormattedTextField tfFecha) {
		this.tfFecha = tfFecha;
	}

	public JFormattedTextField getTfHora() {
		return tfHora;
	}

	public void setTfHora(JFormattedTextField tfHora) {
		this.tfHora = tfHora;
	}
}
