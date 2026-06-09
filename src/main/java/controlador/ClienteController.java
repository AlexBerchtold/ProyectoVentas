package controlador;

import java.time.LocalDate;
import java.util.List;

import dao.ClienteDAO;
import interfaces.InterfaceABM;
import modelo.ClienteModelo;
import util.FechaUtil;
import vista.ClienteVista;

public class ClienteController implements InterfaceABM {

	private ClienteVista vista;
	private ClienteModelo cliente;
	private ClienteDAO dao;
	private List<ClienteModelo> clientes;

	public ClienteController(ClienteVista clienteVista) {
		super();
		this.vista = clienteVista;
		this.vista.setInterfaceABM(this);
		dao = new ClienteDAO();
		estadoInicial();
	}

	private void estadoInicial() {
		// desactiva los botones
		this.vista.getBtnNuevo().setEnabled(true);
		this.vista.getBtnEditar().setEnabled(false);
		this.vista.getBtnEliminar().setEnabled(false);
		this.vista.getBtnCancelar().setEnabled(true);
		this.vista.getBtnGuardar().setEnabled(false);

		// desactiva los textfield
		this.vista.getTfFechaRegistro().setEnabled(false);
		this.vista.getTfNombre().setEnabled(false);
		this.vista.getTfApellido().setEnabled(false);
		this.vista.getTfDocumento().setEnabled(false);
		this.vista.getTfFechaNacimiento().setEnabled(false);
		this.vista.getTfCorreo().setEnabled(false);
		this.vista.getTfDireccion().setEnabled(false);
		this.vista.getTfTelefono().setEnabled(false);

		// Limpiar los campos
		this.vista.getTfFechaRegistro().setValue(null);
		this.vista.getTfFechaNacimiento().setValue(null);
		this.vista.getTfNombre().setText("");
		this.vista.getTfApellido().setText("");
		this.vista.getTfDocumento().setText("");
		this.vista.getTfCorreo().setText("");
		this.vista.getTfDireccion().setText("");
		this.vista.getTfTelefono().setText("");
		cliente = null;

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
		this.vista.getTfFechaRegistro().setEnabled(false);
		this.vista.getTfNombre().setEnabled(true);
		this.vista.getTfApellido().setEnabled(true);
		this.vista.getTfDocumento().setEnabled(true);
		this.vista.getTfFechaNacimiento().setEnabled(true);
		this.vista.getTfCorreo().setEnabled(true);
		this.vista.getTfDireccion().setEnabled(true);
		this.vista.getTfTelefono().setEnabled(true);
		
		//Carga el campo fecha y crea el cliente
		cliente = new ClienteModelo();
		this.vista.getTfFechaRegistro().setText(FechaUtil.fechaAString(LocalDate.now()));

	}

	@Override
	public void editar() {
		System.out.println("editar");

	}

	@Override
	public void guardar() {
		
		cliente.setFechaRegistro(FechaUtil.stringAFecha(this.vista.getTfFechaRegistro().getText()));
		cliente.setFechaNacimiento(FechaUtil.stringAFecha(this.vista.getTfFechaNacimiento().getText()));
		cliente.setNombre(this.vista.getTfNombre().getText());
		cliente.setApellido(this.vista.getTfApellido().getText());
		cliente.setDocumento(this.vista.getTfDocumento().getText());
		cliente.setTelefono(this.vista.getTfTelefono().getText());
		cliente.setCorreo(this.vista.getTfCorreo().getText());
		cliente.setDireccion(this.vista.getTfDireccion().getText());
		
		try {
			dao.guardar(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

	@Override
	public void eliminar() {
		System.out.println("Eliminar");
	}

	@Override
	public void cancelar() {
		if(cliente == null) this.vista.dispose();
		else estadoInicial();
	}

	@Override
	public void buscar() {
		System.out.println("Buscar");
	}

}
