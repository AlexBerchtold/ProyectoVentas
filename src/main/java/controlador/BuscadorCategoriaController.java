package controlador;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import dao.CategoriaDAO;
import interfaces.InterfaceCategoria;
import modelo.CategoriaModelo;
import tablas.ModeloTablaCategoria;
import vista.BuscadorCategoriaVista;

public class BuscadorCategoriaController {
	
	private ModeloTablaCategoria modeloTablaCategoria;
	private List<CategoriaModelo> categorias;
	private CategoriaDAO dao;
	private BuscadorCategoriaVista ventana;
	private InterfaceCategoria interfaz;
	
	public void setInterfaz(InterfaceCategoria interfazCategoria) {
		this.interfaz = interfazCategoria;
	}

	public BuscadorCategoriaController(BuscadorCategoriaVista buscadorCategoriaVentana) {
		super();
		this.ventana= buscadorCategoriaVentana;
		dao = new CategoriaDAO();
		inicializarTabla();
		setUpEvents();
		ventana.getLblavisos().setText("Permite la busqueda por c�digo, descripci�n y estado");
	}
	
	private void inicializarTabla() {
		modeloTablaCategoria = new ModeloTablaCategoria();
		ventana.getTable().setModel(modeloTablaCategoria);
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
		categorias = dao.buscarPorFiltro(ventana.getTfBuscador().getText());
		modeloTablaCategoria.setLista(categorias);
	}
	
	private void seleccionarRegistro() {
		if (ventana.getTable().getSelectedRow() < 0) return;
		interfaz.seleccionarCategoria(categorias.get(ventana.getTable().getSelectedRow()));
		ventana.dispose();
	}

}
