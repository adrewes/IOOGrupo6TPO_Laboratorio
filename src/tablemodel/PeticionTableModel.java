package tablemodel;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import collections.PeticionCollection;
import controller.ParametrosController;
import controller.PeticionController;
import dto.PeticionDTO;
import dto.PracticaDTO;;

public class PeticionTableModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<PeticionDTO> lista;
	PeticionController peticionController;
	
	protected String[] columnNames = new String[] { "Peticion ID", "Sucursal ID", "Paciente ID", "Obra Social", "Fecha de Entrega", "Fecha de Carga", "Practicas Asociadas", "Resultados"}; 
	protected Class[] columnClasses = new Class[] { String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class}; 


	public String getColumnName(int col) { return columnNames[col]; } 
	public Class getColumnClass(int col) { return columnClasses[col]; } 
	
	public PeticionTableModel()
	{
		peticionController = new PeticionController();
		lista = peticionController.getPeticionListDTO();
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
			case 0: return lista.get(rowIndex).getPeticionID(); 
			case 1: return lista.get(rowIndex).getSucursalID(); 
			case 2: return lista.get(rowIndex).getPacienteID();
			case 3: return lista.get(rowIndex).getObraSocial();
			case 4: return lista.get(rowIndex).getFchEntrega();
			case 5: return lista.get(rowIndex).getFchCarga(); 
			case 6: return lista.get(rowIndex).getPracticasAsociadas();
			case 7: return lista.get(rowIndex).getResultados();
			default: return null; 
		}
	}
	
	public PeticionDTO getPeticionDTO(int index)
	{
		return lista.get(index);
	}
	
	public void agregar(PeticionDTO peticion)
	{
		if (peticionController.addPeticion(peticion)) {
			lista.add(peticion);			
		}
		fireTableDataChanged();
	}
	
	public void modificar(PeticionDTO peticion) {
		if (peticionController.modifyPeticion(peticion)) {
			lista.remove(peticion);
			lista.add(peticion);		
		}
		fireTableDataChanged();
	}
	
	public void eliminar(int fila)
	{
		PeticionDTO peticion =  lista.get(fila);
		if (peticionController.deletePeticion(peticion)) {
			lista.remove(peticion);
		}
		fireTableDataChanged();
	}
	
	public void eliminar(PracticaDTO peticion)
	{
		eliminar(lista.indexOf(peticion));
	}	
	
	public void grabar ()
	{
		peticionController.grabarPeticion();
	}


}
