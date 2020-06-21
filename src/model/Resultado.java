package model;

import dto.EstadoEnumDTO;
import dto.EstadoHabilitacionEnumDTO;
import dto.PacienteDTO;
import dto.PeticionDTO;
import dto.PracticaDTO;
import dto.ResultadoDTO;
import dto.SexoEnumDTO;


public class Resultado {
	
	private String resultadoID;
	private String practicaID;
	private String valor;
	private String descripcion;
	private EstadoEnumDTO estado;
	

	public Resultado(String resultadoID, String practicaID, String valor, String descripcion, EstadoEnumDTO estado)
	{	
		this.resultadoID = resultadoID;
		this.practicaID = practicaID;
		this.valor = valor;
		this.descripcion = descripcion;
		this.estado = estado;
	}
	
	public Resultado(ResultadoDTO resultadoDTO)
	{
		this.setResultadoID(resultadoDTO.getResultadoID());
		this.setPracticaID(resultadoDTO.getPracticaID());
		this.setValor(resultadoDTO.getValor());
		this.setDescripcion(resultadoDTO.getDescripcion());
		this.setEstado(resultadoDTO.getEstado());
	}
	
	public ResultadoDTO toDTO() {
		
		ResultadoDTO resultado = new ResultadoDTO();
		resultado.setResultadoID(this.getResultadoID());
		resultado.setPracticaID(this.getPracticaID());
		resultado.setValor(this.getValor());
		resultado.setDescripcion(this.getDescripcion());
		resultado.setEstado(this.getEstado());
		
		return resultado;
	}
	
	public Resultado() {
		// TODO Auto-generated constructor stub
	}

	public String getResultadoID() {
		return resultadoID;
	}

	public void setResultadoID(String resultadoID) {
		this.resultadoID = resultadoID;
	}

	public String getPracticaID() {
		return practicaID;
	}

	public void setPracticaID(String practicaID) {
		this.practicaID = practicaID;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public EstadoEnumDTO getEstado() {
		return estado;
	}

	public void setEstado(EstadoEnumDTO estado) {
		this.estado = estado;
	}
	
	
}
