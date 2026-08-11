package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JOptionPane;

import dao.ProductoDAO;
import interfaces.InterfaceABM;
import interfaces.InterfaceCategoria;
import interfaces.InterfaceMarca;
import modelo.CategoriaModelo;
import modelo.MarcaModelo;
import modelo.ProductoModelo;
import tablas.ModeloTablaProducto;
import util.UtilidadesNumeros;
import vista.BuscadorCategoriaVista;
import vista.BuscadorMarcaVista;
import vista.ProductoVentana;

public class ProductoController implements InterfaceABM, InterfaceCategoria, InterfaceMarca {
	private ProductoModelo producto;
	private ProductoDAO dao;
	private List<ProductoModelo> productos;
	private ModeloTablaProducto modeloTablaProducto;
	private MarcaModelo marca;
	private CategoriaModelo categoria;
	private ProductoVentana ventana;

	public ProductoController(ProductoVentana productoVentana) {
		super();
		this.ventana = productoVentana;
		this.ventana.setInterfaceABM(this);
		modeloTablaProducto = new ModeloTablaProducto();
		ventana.getTabla().setModel(modeloTablaProducto);
		dao = new ProductoDAO();
		estadoinicial();
		consultarProductos();
		setUpEvents();
	}
	
	private void setUpEvents() {
		ventana.getTabla().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2) seleccionarRegistro(ventana.getTabla().getSelectedRow());
			}
		});
		ventana.getBtnCategoria().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				abrirBuscadorCategoria();
			}
		});
		ventana.getBtnMarca().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				abrirBuscadorMarca();
			}
		});
	}
	
	private void estadoinicial() {
		ventana.getBtnCancelar().setEnabled(false);
		ventana.getBtnEditar().setEnabled(false);
		ventana.getBtnEliminar().setEnabled(false);
		ventana.getBtnGuardar().setEnabled(false);
		ventana.getBtnNuevo().setEnabled(true);


		ventana.getRdbtnActivo().setSelected(true);
		ventana.getRdbtnActivo().setEnabled(false);
		ventana.getBtnGuardar().setText("Guardar");
		ventana.getTabla().setEnabled(true);
		
		ventana.getTfCodigo().setText("");
		ventana.getTfDescripcion().setText("");
		ventana.getRdbtnActivo().setSelected(false);
		ventana.getTfExistencia().setText("");
		ventana.getTfVenta().setText("");

		ventana.getTfCodigo().setEnabled(false);
		ventana.getTfDescripcion().setEnabled(false);
		ventana.getRdbtnActivo().setEnabled(false);
		ventana.getTfExistencia().setEnabled(false);
		ventana.getTfVenta().setEnabled(false);
		
		ventana.getBtnCategoria().setEnabled(false);
		ventana.getBtnMarca().setEnabled(false);
	}

	@Override
	public void nuevo() {
		ventana.getBtnNuevo().setEnabled(false);
		ventana.getBtnCancelar().setEnabled(false);
		ventana.getBtnGuardar().setEnabled(true);
		ventana.getBtnCancelar().setEnabled(true);
		
		ventana.getTfCodigo().setText("");
		ventana.getTfDescripcion().setText("");
		ventana.getRdbtnActivo().setSelected(false);
		ventana.getTfExistencia().setText("");
		ventana.getTfVenta().setText("");

		ventana.getTfCodigo().setEnabled(true);
		ventana.getTfDescripcion().setEnabled(true);
		ventana.getRdbtnActivo().setEnabled(true);
		ventana.getTfExistencia().setEnabled(true);
		ventana.getTfVenta().setEnabled(true);
		
		
		ventana.getRdbtnActivo().setEnabled(true);
		ventana.getTabla().setEnabled(false);
		
		ventana.getBtnCategoria().setEnabled(true);
		ventana.getBtnMarca().setEnabled(true);
	}

	@Override
	public void editar() {
		ventana.getRdbtnActivo().setEnabled(true);
		ventana.getBtnCancelar().setEnabled(true);
		ventana.getBtnGuardar().setEnabled(true);
		ventana.getBtnGuardar().setText("Actualizar");
		
		ventana.getTfCodigo().setEnabled(true);
		ventana.getTfDescripcion().setEnabled(true);
		ventana.getRdbtnActivo().setEnabled(true);
		ventana.getTfExistencia().setEnabled(true);
		ventana.getTfVenta().setEnabled(true);
		
		ventana.getBtnCategoria().setEnabled(true);
		ventana.getBtnMarca().setEnabled(true);
	}

	@Override
	public void eliminar() {
		if (producto==null) {
			JOptionPane.showMessageDialog(null, "Producto no encontrado");
			return;
		}
		int respuesta = JOptionPane.showConfirmDialog(null, "Estas deguro que desea eliminar el producto "+producto.getDescripcion(),
				"Antenci�n", JOptionPane.YES_NO_OPTION);
		if (respuesta==JOptionPane.YES_OPTION) {
			try {
				dao.eliminar(producto);
				estadoinicial();
				consultarProductos();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void cancelar() {
		estadoinicial();
	}

	@Override
	public void guardar() {
		if (!validarCampos()) return;
		producto = new ProductoModelo();
		cargarEntidad();
		try {
			dao.guardar(producto);
			consultarProductos();
			estadoinicial();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void cargarEntidad() {
		producto.setCodigo(ventana.getTfCodigo().getText());
		producto.setDescripcion(ventana.getTfDescripcion().getText());
		producto.setEstado(ventana.getRdbtnActivo().isSelected());
		producto.setStock(UtilidadesNumeros.stringADouble(ventana.getTfExistencia().getText()));
		producto.setPrecioVenta(UtilidadesNumeros.stringADouble(ventana.getTfVenta().getText()));
		
		producto.setCategoria(categoria);
		producto.setMarca(marca);
	}
	
	private void consultarProductos() {
		productos = dao.buscarPorFiltro(this.ventana.getTfBuscador().getText());
		modeloTablaProducto.setLista(productos);
	}
	
	private void seleccionarRegistro(int index) {
		if(index<0)return;
		producto = productos.get(index);
		ventana.getBtnNuevo().setEnabled(false);
		ventana.getBtnCancelar().setEnabled(false);
		ventana.getBtnEditar().setEnabled(true);
		ventana.getBtnEliminar().setEnabled(true);
		
		ventana.getTfCodigo().setText(producto.getCodigo());
		ventana.getTfDescripcion().setText(producto.getDescripcion());
		ventana.getRdbtnActivo().setSelected(producto.getEstado());
		ventana.getTfExistencia().setText(UtilidadesNumeros.doubleString(producto.getStock()));
		ventana.getTfVenta().setText(UtilidadesNumeros.doubleString(producto.getPrecioVenta()));
		
		marca=producto.getMarca();
		categoria= producto.getCategoria();
		ventana.getTfCategoria().setText(categoria.getNombre());
		ventana.getTfMarca().setText(marca.getNombre());
	}
	
	private void abrirBuscadorCategoria() {
		BuscadorCategoriaVista buscadorCategoriaVentana = new BuscadorCategoriaVista();
		buscadorCategoriaVentana.setUpController();
		buscadorCategoriaVentana.getController().setInterfaz(this);
		buscadorCategoriaVentana.setVisible(true);
	}
	
	@Override
	public void seleccionarCategoria(CategoriaModelo categoria) {
		this.categoria = categoria;
		ventana.getTfCategoria().setText(this.categoria.getNombre());
	}
	
	private void abrirBuscadorMarca() {
		BuscadorMarcaVista buscadorVista = new BuscadorMarcaVista();
		buscadorVista.setUpController();
		buscadorVista.getController().setInterfaz(this);
		buscadorVista.setVisible(true);
	}
	
	@Override
	public void seleccionarMarca(MarcaModelo marca) {
		this.marca = marca;
		ventana.getTfMarca().setText(marca.getNombre());
	}
	
	private boolean validarCampos() {
		if (ventana.getTfDescripcion().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "El campo Descripci�n es obligatorio");
			return false;
		}
		if (ventana.getTfCodigo().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "El campo c�digo es obligatorio");
			return false;
		}
		if (ventana.getTfExistencia().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "El campo existencia es obligatorio");
			return false;
		}
		if (ventana.getTfVenta().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "El campo venta es obligatorio");
			return false;
		}
		if (categoria == null) {
			JOptionPane.showMessageDialog(null, "Seleccione una categoria");
			return false;
		}
		if (marca == null) {
			JOptionPane.showMessageDialog(null, "Seleccione una marca");
			return false;
		}
		return true;
	}

	@Override
	public void buscar() {
		consultarProductos();
		
	}

	
	
	

}
