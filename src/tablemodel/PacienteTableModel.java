package tablemodel;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import controller.LaboratorioController;
import dto.PacienteDTO;


public class PacienteTableModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<PacienteDTO> lista;
	LaboratorioController laboratorioController;
	
	protected String[] columnNames = new String[] { "Paciente ID", "Nombre", "DNI", "Domicilio", "mail", "Sexo", "Fecha Nacimiento"}; 
	protected Class[] columnClasses = new Class[] { String.class, String.class, String.class, String.class, String.class, String.class, String.class}; 


	public String getColumnName(int col) { return columnNames[col]; } 
	public Class getColumnClass(int col) { return columnClasses[col]; } 
	
	public PacienteTableModel()
	{
		laboratorioController = new LaboratorioController();
		lista = laboratorioController.getPacienteListDTO();
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
			case 0: return lista.get(rowIndex).getPacienteID(); 
			case 1: return lista.get(rowIndex).getNombre();
			case 2: return lista.get(rowIndex).getDni();
			case 3: return lista.get(rowIndex).getDomicilio();
			case 4: return lista.get(rowIndex).getMail();
			case 5: return lista.get(rowIndex).getSexo();
			case 6: return lista.get(rowIndex).getFechaNacimiento();
			default: return null; 
		}
	}
	
	public PacienteDTO getPacienteDTO(int index)
	{
		return lista.get(index);
	}
	
	public void agregar(PacienteDTO paciente)
	{
		if (laboratorioController.addPaciente(paciente)) {
			lista.add(paciente);			
		}
		fireTableDataChanged();
	}
	
	public void modificar(PacienteDTO paciente) {
		if (laboratorioController.modifyPaciente(paciente)) {
			lista.remove(paciente);
			lista.add(paciente);		
		}
		fireTableDataChanged();
	}
	
	public void eliminar(int fila)
	{
		PacienteDTO paciente =  lista.get(fila);
		if (laboratorioController.deletePaciente(paciente)) {
			lista.remove(paciente);
		}
		fireTableDataChanged();
	}
	
	public void eliminar(PacienteDTO paciente)
	{
		eliminar(lista.indexOf(paciente));
	}	
	
	public void grabar ()
	{
		laboratorioController.grabarPaciente();
	}

}
