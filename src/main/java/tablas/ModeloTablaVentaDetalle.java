package tablas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.DetalleVentaModelo;

public class ModeloTablaVentaDetalle extends AbstractTableModel {
	
	private String[] columnas = {"Código", "Descripción", "Precio Venta", "Cantidad", "Sub Total"};
	List<DetalleVentaModelo> lista = new ArrayList<DetalleVentaModelo>();
	
	
	public void setLista(List<DetalleVentaModelo> lista) {
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
			return lista.get(fila).getProducto().getCodigo();
		case 1:
			return lista.get(fila).getProducto().getDescripcion() + " - "
					+lista.get(fila).getProducto().getMarca().getNombre();
		case 2:
			return lista.get(fila).getPrecio();
		case 3:
			return lista.get(fila).getCantidad();
		case 4:
			return lista.get(fila).getPrecio() * lista.get(fila).getCantidad();
		default:
			return null;
		}
	}
	
}
