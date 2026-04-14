package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import componentes.JButtonAccesoDirecto;
import componentes.JMenuIntemPersonalizado;
import componentes.JPanelPersonalizado;

public class PantallaPrincipalVista extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanelPersonalizado panelPersonalizado = new JPanelPersonalizado("fondo_pantalla.jpg");
	private JMenuIntemPersonalizado mCategorias;
	private JMenuIntemPersonalizado mClientes;
	private JMenuIntemPersonalizado mMarcas;
	private JMenuIntemPersonalizado mProductos;
	private JMenuIntemPersonalizado mProveedores;
	private JMenuIntemPersonalizado mVentas;
	private JButtonAccesoDirecto btnCliente;
	private JButtonAccesoDirecto btnProducto;
	private JButtonAccesoDirecto btnVentas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPrincipalVista frame = new PantallaPrincipalVista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaPrincipalVista() {
		setBounds(100, 100, 1920, 1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Registros");
		menuBar.add(mnNewMenu);
		
		mCategorias = new JMenuIntemPersonalizado();
		mCategorias.setText("Categorias");
		mnNewMenu.add(mCategorias);
		
		mClientes = new JMenuIntemPersonalizado();
		mClientes.setText("Clientes");
		mnNewMenu.add(mClientes);
		
		mMarcas = new JMenuIntemPersonalizado();
		mMarcas.setText("Marcas");
		mnNewMenu.add(mMarcas);
		
		mProductos = new JMenuIntemPersonalizado();
		mProductos.setText("Productos");
		mnNewMenu.add(mProductos);
		
		mProveedores = new JMenuIntemPersonalizado();
		mProveedores.setText("Proveedores");
		mnNewMenu.add(mProveedores);
		
		JMenu mnNewMenu_1 = new JMenu("Movimiento");
		menuBar.add(mnNewMenu_1);
		
		mVentas = new JMenuIntemPersonalizado();
		mVentas.setText("Ventas");
		mnNewMenu_1.add(mVentas);
		
		JMenu mnNewMenu_2 = new JMenu("Listados");
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("Informes");
		menuBar.add(mnNewMenu_3);
		
		JMenu mnNewMenu_4 = new JMenu("Utilidades");
		menuBar.add(mnNewMenu_4);
		
		setContentPane(panelPersonalizado);
		panelPersonalizado.setLayout(null);
		
		btnCliente = new JButtonAccesoDirecto();
		btnCliente.setText("Clientes");
		btnCliente.setBounds(25, 45, 140, 140);
		panelPersonalizado.add(btnCliente);
		
		btnProducto = new JButtonAccesoDirecto();
		btnProducto.setText("Productos");
		btnProducto.setBounds(221, 45, 140, 140);
		panelPersonalizado.add(btnProducto);
		
		btnVentas = new JButtonAccesoDirecto();
		btnVentas.setText("Ventas");
		btnVentas.setBounds(429, 45, 140, 140);
		panelPersonalizado.add(btnVentas);

	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JPanelPersonalizado getPanelPersonalizado() {
		return panelPersonalizado;
	}

	public JMenuIntemPersonalizado getmCategorias() {
		return mCategorias;
	}

	public JMenuIntemPersonalizado getmClientes() {
		return mClientes;
	}

	public JMenuIntemPersonalizado getmMarcas() {
		return mMarcas;
	}

	public JMenuIntemPersonalizado getmProductos() {
		return mProductos;
	}

	public JMenuIntemPersonalizado getmProveedores() {
		return mProveedores;
	}

	public JMenuIntemPersonalizado getmVentas() {
		return mVentas;
	}

	public JButtonAccesoDirecto getBtnCliente() {
		return btnCliente;
	}

	public JButtonAccesoDirecto getBtnProducto() {
		return btnProducto;
	}

	public JButtonAccesoDirecto getBtnVentas() {
		return btnVentas;
	}
	
}
