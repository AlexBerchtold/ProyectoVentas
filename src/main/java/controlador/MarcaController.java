package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JOptionPane;

import dao.MarcaDAO;
import interfaces.InterfaceABM;
import modelo.MarcaModelo;
import tablas.ModeloTablaMarca;
import vista.MarcaVista;

public class MarcaController implements InterfaceABM {

	private MarcaVista vista;
	private MarcaModelo marca;
	private MarcaDAO dao;
	private List<MarcaModelo> marcas;
	private ModeloTablaMarca tabla;

	public MarcaController(MarcaVista MarcaVista) {
		super();
		this.vista = MarcaVista;
		this.vista.setInterfaceABM(this);
		dao = new MarcaDAO();
		tabla = new ModeloTablaMarca();
		this.vista.getTabla().setModel(tabla);
		estadoInicial();
		cargarTabla("");
		setAcciones();
	}

	private void setAcciones() {
		this.vista.getTabla().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2)
					seleccionarRegistro();
			}
		});

	}

	private void cargarTabla(String filtro) {
		marcas = dao.buscarPorFiltro(filtro);
		tabla.setLista(marcas);
	}

	private void estadoInicial() {
		// desactiva los botones
		this.vista.getBtnNuevo().setEnabled(true);
		this.vista.getBtnEditar().setEnabled(false);
		this.vista.getBtnEliminar().setEnabled(false);
		this.vista.getBtnCancelar().setEnabled(true);
		this.vista.getBtnGuardar().setEnabled(false);

		// desactiva los textfield
		this.vista.getTfNombre().setEnabled(false);
		this.vista.getChEstado().setEnabled(false);

		// Limpiar los campos
		this.vista.getTfNombre().setText("");
		this.vista.getChEstado().setSelected(true);
		marca = null;

	}

	@Override
	public void nuevo() {
		// desactiva los botones
		this.vista.getBtnNuevo().setEnabled(false);
		this.vista.getBtnEditar().setEnabled(false);
		this.vista.getBtnEliminar().setEnabled(false);
		this.vista.getBtnCancelar().setEnabled(true);
		this.vista.getBtnGuardar().setEnabled(true);

		// desactiva los textfield
		this.vista.getTfNombre().setEnabled(true);
		this.vista.getChEstado().setEnabled(true);

		// Carga el campo fecha y crea el Marca
		marca = new MarcaModelo();
		
	}

	private void seleccionarRegistro() {
		int fila = this.vista.getTabla().getSelectedRow();
		if (fila < 0)
			return;
		marca = marcas.get(fila);

		this.vista.getTfNombre().setText(marca.getNombre());
		this.vista.getChEstado().setSelected(marca.getEstado());
	
		this.vista.getBtnNuevo().setEnabled(false);
		this.vista.getBtnEditar().setEnabled(true);
		this.vista.getBtnEliminar().setEnabled(true);

	}

	@Override
	public void editar() {
		this.vista.getTfNombre().setEnabled(true);
		this.vista.getChEstado().setEnabled(true);
		
		this.vista.getBtnNuevo().setEnabled(false);
		this.vista.getBtnEditar().setEnabled(false);
		this.vista.getBtnGuardar().setEnabled(true);
		this.vista.getBtnEliminar().setEnabled(false);
		
	}

	@Override
	public void guardar() {
		
		if(this.vista.getTfNombre().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "El nombre es un campo obligatorio");
			return;
		}

		marca.setNombre(this.vista.getTfNombre().getText());
		marca.setEstado(this.vista.getChEstado().isSelected());

		try {
			dao.guardar(marca);
			cargarTabla("");
			estadoInicial();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void eliminar() {
		if (marca == null)
			return;
		int confirmacion = JOptionPane.showConfirmDialog(null, "Estas seguro que deseas eliminar al Marca "
				+ marca.getNombre() + " ?", "Atención", JOptionPane.YES_NO_OPTION);
		if (confirmacion == JOptionPane.YES_OPTION) {
			try {
				dao.eliminar(marca);
				estadoInicial();
				cargarTabla("");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void cancelar() {
		if (marca == null)
			this.vista.dispose();
		else
			estadoInicial();
	}

	@Override
	public void buscar() {
		cargarTabla(vista.getTfBuscador().getText());
	}

}
