package tablas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.CategoriaModelo;

public class ModeloTablaCategoria extends AbstractTableModel {
	
	private String[] columnas = {"Código", "Nombre", "Estado"};
	List<CategoriaModelo> lista = new ArrayList<CategoriaModelo>();
	
	
	public void setLista(List<CategoriaModelo> lista) {
		this.lista = lista;
		fireTableDataChanged();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnas.length;
	}
	
	@Override
	public String getColumnName(int posicion) {
		// TODO Auto-generated method stub
		return columnas[posicion];
	}

	@Override
	public Object getValueAt(int fila, int columna) {
		switch (columna) {
		case 0:
			return lista.get(fila).getId();
		case 1:
			return lista.get(fila).getNombre();
		case 2:
			return lista.get(fila).getEstado();
		default:
			return null;
		}
	}

}
