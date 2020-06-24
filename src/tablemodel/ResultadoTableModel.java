package tablemodel;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import controller.LaboratorioController;
import controller.PeticionController;
import dto.PeticionDTO;
import dto.PracticaDTO;
import dto.ResultadoDTO;

public class ResultadoTableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<ResultadoDTO> lista;
	private LaboratorioController laboratorioController;

	protected String[] columnNames = new String[] { "Resultado ID", "Peticion ID", "Valor", "Descripcion", "Estado" };
	protected Class[] columnClasses = new Class[] { String.class, String.class, String.class, String.class,
			String.class };

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Class getColumnClass(int col) {
		return columnClasses[col];
	}

	public ResultadoTableModel() {
		laboratorioController = new LaboratorioController();
		lista = laboratorioController.getResultadoListDTO();
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
	public boolean isCellEditable(int row, int column) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return lista.get(rowIndex).getResultadoID();
		case 1:
			return lista.get(rowIndex).getPeticionID();
		case 2:
			return lista.get(rowIndex).getValor();
		case 3:
			return lista.get(rowIndex).getDescripcion();
		case 4:
			return lista.get(rowIndex).getEstado();
		default:
			return null;
		}
	}
	
	public ResultadoDTO getResultadoDTO(int index)
	{
		return lista.get(index);
	}
	
	public void agregar(ResultadoDTO resultado)
	{
		if (laboratorioController.addResultado(resultado)) {
			lista.add(resultado);			
		}
		fireTableDataChanged();
	}
	
	public void modificar(ResultadoDTO resultado) {
		if (laboratorioController.modifyResultado(resultado)) {
			lista.remove(resultado);
			lista.add(resultado);		
		}
		fireTableDataChanged();
	}
	
	public void eliminar(int fila)
	{
		ResultadoDTO resultado =  lista.get(fila);
		if (laboratorioController.deleteResultado(resultado)) {
			lista.remove(resultado);
		}
		fireTableDataChanged();
	}
	
	public void eliminar(ResultadoDTO resultado)
	{
		eliminar(lista.indexOf(resultado));
	}	
	
	public void grabar ()
	{
		laboratorioController.grabarResultado();
	}

}
