package tablemodel;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import collections.PacienteCollection;
import collections.PracticaCollection;
import controller.AutorizacionController;
import controller.ParametrosController;
import dto.EstadoHabilitacionEnumDTO;
import dto.PracticaDTO;
import dto.UsuarioDTO;

public class PracticaTableModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<PracticaDTO> lista;
	ParametrosController parametrosController;
	
	protected String[] columnNames = new String[] { "Practica ID", "Nombre", "Grupo", "Valores Criticos", "Valores Reservados", "Tiempo Entrega", "Estado Habilitacion"}; 
	protected Class[] columnClasses = new Class[] { String.class, String.class, String.class, String.class, String.class, String.class, String.class}; 
	
	
	public String getColumnName(int col) { return columnNames[col]; } 
	public Class getColumnClass(int col) { return columnClasses[col]; } 
	
	public PracticaTableModel()
	{
		parametrosController = new ParametrosController();
		lista = parametrosController.getPracticaListDTO();
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
			case 0: return lista.get(rowIndex).getPracticaID(); 
			case 1: return lista.get(rowIndex).getNombre();
			case 2: return lista.get(rowIndex).getGrupo();
			case 3: return lista.get(rowIndex).getValoresCriticos();
			case 4: return lista.get(rowIndex).getValoresReservados();
			case 5: return lista.get(rowIndex).getTiempoEntrega();
			case 6: return lista.get(rowIndex).getEstadoHabilitacion();
			default: return null; 
		}
	}
	
	public PracticaDTO getPracticaDTO(int index)
	{
		return lista.get(index);
	}
	
	public void agregar(PracticaDTO practica)
	{
		if (parametrosController.addPractica(practica)) {
			lista.add(practica);			
		}
		fireTableDataChanged();
	}
	
	public void modificar(PracticaDTO practica) {
		if (parametrosController.modifyPractica(practica)) {
			lista.remove(practica);
			lista.add(practica);		
		}
		fireTableDataChanged();
	}
	
	public void eliminar(int fila)
	{
		PracticaDTO practica =  lista.get(fila);
		if (parametrosController.deletePractica(practica)) {
			lista.remove(practica);
		}
		fireTableDataChanged();
	}
	
	public void eliminar(PracticaDTO practica)
	{
		eliminar(lista.indexOf(practica));
	}	
	
	public void grabar ()
	{
		parametrosController.grabarPractica();
	}

}
