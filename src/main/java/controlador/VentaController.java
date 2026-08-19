package controlador;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import dao.ClienteDAO;
import dao.ProductoDAO;
import modelo.ClienteModelo;
import modelo.DetalleVentaModelo;
import modelo.ProductoModelo;
import tablas.ModeloTablaVentaDetalle;
import util.FechaUtil;
import vista.VentaVista;

public class VentaController {

	private VentaVista vista;
	private ModeloTablaVentaDetalle modeloTabla;
	private ClienteDAO clienteDAO;
	private ClienteModelo cliente;
	private ProductoDAO productoDAO;
	private ProductoModelo producto;
	private List<DetalleVentaModelo> detallesVenta;
	
	public VentaController(VentaVista ventaVista) {
		super();
		this.vista = ventaVista;
		modeloTabla = new ModeloTablaVentaDetalle();
		this.vista.getTable().setModel(modeloTabla);
		estadoInicial();
		setUpEventos();
		clienteDAO = new ClienteDAO();
		productoDAO = new ProductoDAO();
	}
	
	private void estadoInicial() {
		vista.getTfCodigo().setEditable(false);
		vista.getTfFecha().setText(FechaUtil.fechaHoraAString(LocalDateTime.now()));
		detallesVenta = new ArrayList<DetalleVentaModelo>();
	}
	
	private void setUpEventos() {
		vista.getTfCiRuc().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER) {
					buscarClientePorCedula();
				}
			}
		});
		
		vista.getTfCodigoProducto().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER) {
					buscarProductoPorCodigo();
				}
			}
		});
		
		vista.getTfCantidad().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER) {
					vista.getTfPrecioVenta().requestFocus();
					vista.getTfPrecioVenta().selectAll();
				}
			}
		});
		
		vista.getTfPrecioVenta().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER) {
					agregarProducto();
				}
			}
		});
	}
	
	private void buscarClientePorCedula() {
		cliente = clienteDAO.buscarClientePorCedula(vista.getTfCiRuc().getText());
		if(cliente==null) {
			JOptionPane.showMessageDialog(vista, "No se encontro el cliente");
			vista.getTfRazonSocial().setText("");
			vista.getTfContacto().setText("");
		}else {
			vista.getTfRazonSocial().setText(cliente.getNombre()+" "+cliente.getApellido());
			vista.getTfContacto().setText(cliente.getTelefono());
			vista.getTfCodigoProducto().requestFocus();
		}
	}
	
	private void buscarProductoPorCodigo() {
		producto = productoDAO.buscarProductoPorCodigo(vista.getTfCodigoProducto().getText());
		if(producto == null) {
			JOptionPane.showMessageDialog(vista, "No se encontro el producto");
			vista.getTfProducto().setText("");
			vista.getTfCantidad().setText("");
			vista.getTfPrecioVenta().setText("");
		}else {
			vista.getTfProducto().setText(producto.getDescripcion()+" - "
					+producto.getMarca().getNombre());
			vista.getTfCantidad().setText("1");
			vista.getTfPrecioVenta().setText(producto.getPrecioVenta()+"");
			vista.getTfCantidad().requestFocus();
			vista.getTfCantidad().selectAll();
		}
	}
	
	private void agregarProducto() {
		//Cargamos el objeto de detalle
		DetalleVentaModelo detalle = new DetalleVentaModelo();
		detalle.setCantidad(Double.parseDouble(vista.getTfCantidad().getText()));
		detalle.setPrecio(Double.parseDouble(vista.getTfPrecioVenta().getText()));
		detalle.setProducto(producto);
		// pasamos el objeto a la lista
		detallesVenta.add(detalle);
		modeloTabla.setLista(detallesVenta);
		double total = 0;
		for (int i = 0; i < detallesVenta.size(); i++) {
			total = (detallesVenta.get(i).getCantidad()*detallesVenta.get(i).getPrecio()) + total;
		}
		vista.getLblTotal().setText("TOTAL: "+total);
	}
	
	

}
