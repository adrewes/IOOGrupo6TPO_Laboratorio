package tablemodel;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import controller.AutorizacionController;
import dto.UsuarioDTO;;

public class UsuarioTableModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<UsuarioDTO> lista;
	AutorizacionController autorizacionController;
	
	protected String[] columnNames = new String[] {"Usuario ID", "Usuario", "E-mail", "Password", "Nombre", "Domicilio", "DNI", "Fecha de Nacimiento", "Rol"}; 
	protected Class[] columnClasses = new Class[] {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class}; 


	public String getColumnName(int col) { return columnNames[col]; } 
	public Class getColumnClass(int col) { return columnClasses[col]; } 
	
	public UsuarioTableModel()
	{
		autorizacionController = new AutorizacionController();
		lista = autorizacionController.getUsuarioListDTO();
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
			case 0: return lista.get(rowIndex).getUsuarioID();
			case 1: return lista.get(rowIndex).getNombreUsuario(); 
			case 2: return lista.get(rowIndex).getEmail();
			case 3: return lista.get(rowIndex).getPassword();
			case 4: return lista.get(rowIndex).getNombre(); 
			case 5: return lista.get(rowIndex).getDomicilio();
			case 6: return lista.get(rowIndex).getDni();
			case 7: return lista.get(rowIndex).getFchNacimiento(); 
			case 8: return lista.get(rowIndex).getRol();
			default: return null; 
		}
	}
	
	public UsuarioDTO getUsuarioDTO(int index)
	{
		return lista.get(index);
	}
	
	public void agregar(UsuarioDTO usuario)
	{
		if (autorizacionController.addUsuario(usuario)) {
			lista.add(usuario);			
		}
		fireTableDataChanged();
	}
	
	public void modificar(UsuarioDTO usuario) {
		
		if (autorizacionController.modifyUsuario(usuario)) {
			lista.remove(usuario);
			lista.add(usuario);		
		}
		fireTableDataChanged();
	}
	
	public void eliminar(int fila)
	{
		UsuarioDTO usuario =  lista.get(fila);
		if (autorizacionController.deleteUsuario(usuario)) {
			lista.remove(usuario);
		}
		fireTableDataChanged();
	}
	
	public void eliminar(UsuarioDTO usuario)
	{
		eliminar(lista.indexOf(usuario));
	}	
	
	public void grabar ()
	{
		autorizacionController.grabar();
	}

}
