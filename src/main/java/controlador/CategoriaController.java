package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JOptionPane;

import dao.CategoriaDAO;
import interfaces.InterfaceABM;
import modelo.CategoriaModelo;
import tablas.ModeloTablaCategoria;
import vista.CategoriaVista;

public class CategoriaController implements InterfaceABM {

	private CategoriaVista vista;
	private CategoriaModelo categoria;
	private CategoriaDAO dao;
	private List<CategoriaModelo> categorias;
	private ModeloTablaCategoria tabla;

	public CategoriaController(CategoriaVista CategoriaVista) {
		super();
		this.vista = CategoriaVista;
		this.vista.setInterfaceABM(this);
		dao = new CategoriaDAO();
		tabla = new ModeloTablaCategoria();
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
		categorias = dao.buscarPorFiltro(filtro);
		tabla.setLista(categorias);
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
		categoria = null;

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

		// Carga el campo fecha y crea el Categoria
		categoria = new CategoriaModelo();
		
	}

	private void seleccionarRegistro() {
		int fila = this.vista.getTabla().getSelectedRow();
		if (fila < 0)
			return;
		categoria = categorias.get(fila);

		this.vista.getTfNombre().setText(categoria.getNombre());
		this.vista.getChEstado().setSelected(categoria.getEstado());
	
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

		categoria.setNombre(this.vista.getTfNombre().getText());
		categoria.setEstado(this.vista.getChEstado().isSelected());

		try {
			dao.guardar(categoria);
			cargarTabla("");
			estadoInicial();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void eliminar() {
		if (categoria == null)
			return;
		int confirmacion = JOptionPane.showConfirmDialog(null, "Estas seguro que deseas eliminar al Categoria "
				+ categoria.getNombre() + " ?", "Atención", JOptionPane.YES_NO_OPTION);
		if (confirmacion == JOptionPane.YES_OPTION) {
			try {
				dao.eliminar(categoria);
				estadoInicial();
				cargarTabla("");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void cancelar() {
		if (categoria == null)
			this.vista.dispose();
		else
			estadoInicial();
	}

	@Override
	public void buscar() {
		cargarTabla(vista.getTfBuscador().getText());
	}

}
