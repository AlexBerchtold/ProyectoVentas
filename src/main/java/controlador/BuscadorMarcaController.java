package controlador;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import dao.MarcaDAO;
import interfaces.InterfaceMarca;
import modelo.MarcaModelo;
import tablas.ModeloTablaMarca;
import vista.BuscadorMarcaVista;

public class BuscadorMarcaController {
	
	private ModeloTablaMarca modeloTablaMarca;
	private List<MarcaModelo> marcas;
	private MarcaDAO dao;
	private BuscadorMarcaVista ventana;
	private InterfaceMarca interfaz;
	
	public void setInterfaz(InterfaceMarca interfazMarca) {
		this.interfaz = interfazMarca;
	}

	public BuscadorMarcaController(BuscadorMarcaVista buscadorCategoriaVentana) {
		super();
		this.ventana= buscadorCategoriaVentana;
		dao = new MarcaDAO();
		inicializarTabla();
		setUpEvents();
		ventana.getLblavisos().setText("Permite la busqueda por c�digo, descripci�n y estado");
	}
	
	private void inicializarTabla() {
		modeloTablaMarca = new ModeloTablaMarca();
		ventana.getTable().setModel(modeloTablaMarca);
		this.ventana.getTable().getColumnModel().getColumn(0).setPreferredWidth(10);
		this.ventana.getTable().getColumnModel().getColumn(1).setPreferredWidth(250);
		this.ventana.getTable().getColumnModel().getColumn(2).setPreferredWidth(10);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		this.ventana.getTable().getColumnModel().getColumn(0).setCellRenderer(tcr);
		this.ventana.getTable().getColumnModel().getColumn(2).setCellRenderer(tcr);
	}
	
	private void setUpEvents() {
		ventana.getTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount()==2) seleccionarRegistro();
			}
		});
		ventana.getTfBuscador().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					filtrarRegistros();
				}
			}
		});
	}
	
	private void filtrarRegistros() {
		marcas = dao.buscarPorFiltro(ventana.getTfBuscador().getText());
		modeloTablaMarca.setLista(marcas);
	}
	
	private void seleccionarRegistro() {
		if (ventana.getTable().getSelectedRow() < 0) return;
		interfaz.seleccionarMarca(marcas.get(ventana.getTable().getSelectedRow()));
		ventana.dispose();
	}

}
