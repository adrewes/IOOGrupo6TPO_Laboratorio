package tablemodel;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import collections.PacienteCollection;
import collections.SucursalCollection;
import controller.AutorizacionController;
import controller.ParametrosController;
import dto.PacienteDTO;
import dto.SucursalDTO;
import dto.UsuarioDTO;;

public class SucursalTableModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<SucursalDTO> lista;
	ParametrosController parametrosController;
	
	protected String[] columnNames = new String[] { "Sucursal ID", "Direccion", "Responsable Tecnico (Usuario)"}; 
	protected Class[] columnClasses = new Class[] { int.class, String.class, String.class}; 


	public String getColumnName(int col) { return columnNames[col]; } 
	public Class getColumnClass(int col) { return columnClasses[col]; } 
	
	public SucursalTableModel()
	{
		parametrosController = new ParametrosController();
		lista = parametrosController.getSucursalListDTO();
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}
	
    @Override
    public boolean isCellEditable(int row, int column)
    {
    	return false;
    }
    
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) 
		{
			case 0: return lista.get(rowIndex).getNumero(); 
			case 1: return lista.get(rowIndex).getDireccion();
			case 2: return lista.get(rowIndex).getResponsableTecnico();
			default: return null; 
		}
	}
	
	public SucursalDTO getSucursalDTO(int index) {
		return lista.get(index);
	}
	
	public void agregar(SucursalDTO sucursal)
	{
		if(parametrosController.addSucursal(sucursal)) {
			lista.add(sucursal);
		}
		fireTableDataChanged();
	}
	
	public void modificar(SucursalDTO sucursal) {
		
		if (parametrosController.modifySucursal(sucursal)) {
			lista.remove(sucursal);
			lista.add(sucursal);		
		}
		fireTableDataChanged();
	}
	
	public void eliminar(int fila)
	{
		SucursalDTO sucursal =  lista.get(fila);
		if (parametrosController.deleteSucursal(sucursal)) {
			lista.remove(sucursal);
		}
		fireTableDataChanged();
	}
		
	public void eliminar(SucursalDTO sucursal)
	{
		eliminar(lista.indexOf(sucursal));
	}	
	
	public void grabar ()
	{
		parametrosController.grabarSucursal();
	}

}
