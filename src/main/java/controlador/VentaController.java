package controlador;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;

import javax.swing.JOptionPane;

import dao.ClienteDAO;
import modelo.ClienteModelo;
import tablas.ModeloTablaVentaDetalle;
import util.FechaUtil;
import vista.VentaVista;

public class VentaController {

	private VentaVista vista;
	private ModeloTablaVentaDetalle modeloTabla;
	private ClienteDAO clienteDAO;
	private ClienteModelo cliente;
	
	public VentaController(VentaVista ventaVista) {
		super();
		this.vista = ventaVista;
		modeloTabla = new ModeloTablaVentaDetalle();
		this.vista.getTable().setModel(modeloTabla);
		estadoInicial();
		setUpEventos();
		clienteDAO = new ClienteDAO();
	}
	
	private void estadoInicial() {
		vista.getTfCodigo().setEditable(false);
		vista.getTfFecha().setText(FechaUtil.fechaHoraAString(LocalDateTime.now()));
		
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
				
			}
		});
	}
	
	private void buscarClientePorCedula() {
		cliente = clienteDAO.buscarClientePorCedula(vista.getTfCiRuc().getText());
		if(cliente==null) {
			JOptionPane.showMessageDialog(vista, "No se encontro el cliente");
		}else {
			vista.getTfRazonSocial().setText(cliente.getNombre()+" "+cliente.getApellido());
			vista.getTfContacto().setText(cliente.getTelefono());
			vista.getTfCodigoProducto().requestFocus();
		}
		
	}
	
	

}
