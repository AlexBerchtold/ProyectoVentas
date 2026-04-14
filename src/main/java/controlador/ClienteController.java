package controlador;

import interfaces.InterfaceABM;
import vista.ClienteVista;

public class ClienteController implements InterfaceABM {
	
	private ClienteVista vista;

	public ClienteController(ClienteVista clienteVista) {
		super();
		this.vista = clienteVista;
		this.vista.setInterfaceABM(this);
	}

	@Override
	public void nuevo() {
		System.out.println("Nuevo");
	}

	@Override
	public void editar() {
		System.out.println("editar");
		
	}

	@Override
	public void guardar() {
		System.out.println("Guardar");
		
	}

	@Override
	public void eliminar() {
		System.out.println("Eliminar");
	}

	@Override
	public void cancelar() {
		System.out.println("cancelar");
	}

	@Override
	public void buscar() {
		System.out.println("Buscar");
	}

}
