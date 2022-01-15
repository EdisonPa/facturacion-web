package edu.ucacue.controller;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ucacue.modelo.Producto;

@RestController
@RequestMapping("/api")
public class ProductoRestController extends AbstractTableModel {


	private static final long serialVersionUID = 1L;
	private List<Producto> productos;
	private static final String[] COLUMN_NAMES = {"Nombre", "Descripcion","Precio", "Stock"};

	public ProductoRestController(List<Producto> productos) {

		this.productos = productos;

	}

	@Override
	public int getRowCount() {
		return productos.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		Object value = "??";
		Producto producto = productos.get(rowIndex);
		switch (columnIndex) {
		case 0:
			value = producto.getNombre();
			break;
		case 1:
			value = producto.getDescripcion();
			break;
		case 2:
			value = producto.getPrecio();
			break;
		
		case 3:
			value = producto.getStock();
			break;
		}

		return value;

	}

	@Override
    public Class<?> getColumnClass(int columnIndex) {
        return Producto.class;
    }
	
    //the column header
    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

	/*
	 * Override this if you want the values to be editable...
	 * 
	 * @Override public void setValueAt(Object aValue, int rowIndex, int
	 * columnIndex) { //.... }
	 */

	/**
	 * This will return the user at the specified row...
	 * 
	 * @param row
	 * @return
	 */
	public Producto getPersonaAt(int row) {
		return productos.get(row);
	}

}