package tablas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.ProductoModelo;

public class ModeloTablaProducto extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	private String[] columnas = {"Descripcion", "Existencia", "Marca", "Categoria"};
	private List<ProductoModelo> lista = new ArrayList<ProductoModelo>();
	
	public void setLista(List<ProductoModelo> lista) {
		this.lista = lista;
		fireTableDataChanged();
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		return columnas.length;
	}
	
	@Override
	public String getColumnName(int i) {
		return columnas[i];
	}

	@Override
	public Object getValueAt(int r, int c) {
		switch (c) {
		case 0:
			return lista.get(r).getDescripcion();
		case 1:
			return lista.get(r).getStock();
		case 2:
			return lista.get(r).getMarca().getNombre();
		case 3:
			return lista.get(r).getCategoria().getNombre();
		}
		return null;
	}
}
