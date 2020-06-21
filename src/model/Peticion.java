package model;

import dto.EstadoEnumDTO;
import dto.EstadoHabilitacionEnumDTO;
import dto.PeticionDTO;
import dto.PracticaDTO;


public class Peticion {
	
	private String peticionID;
	private String sucursalID;
	private String pacienteID;
	private String obraSocial;
	private String fchEntrega;
	private String fchCarga;
	private EstadoEnumDTO estado;
	//Falta poner estos como lista asociado a las practicas y resultados creados
	private String practicasAsociadas;
	private String resultados;

	

	public Peticion(String peticionID, String sucursalID, String pacienteID, String obraSocial, String fchEntrega, String fchCarga, EstadoEnumDTO estado, String practicasAsociados, String resultados)
	{
		this.peticionID = peticionID;
		this.sucursalID = sucursalID;
		this.pacienteID = pacienteID;
		this.obraSocial = obraSocial;
		this.fchEntrega = fchEntrega;
		this.fchCarga = fchCarga;
		this.estado = estado;
		this.practicasAsociadas = practicasAsociadas;
		this.resultados = resultados;
	}
	
	public Peticion(PeticionDTO peticionDTO)
	{

		this.setPeticionID(peticionDTO.getPeticionID());
		this.setSucursalID(peticionDTO.getSucursalID());
		this.setPacienteID(peticionDTO.getPacienteID());
		this.setObraSocial(peticionDTO.getObraSocial());
		this.setFchEntrega(peticionDTO.getFchEntrega());
		this.setFchCarga(peticionDTO.getFchCarga());
		this.setEstado(peticionDTO.getEstado());
		this.setPracticasAsociadas(peticionDTO.getPracticasAsociadas());
		this.setResultados(peticionDTO.getResultados());
		
	}
	
	public PeticionDTO toDTO() {
		
		PeticionDTO peticion = new PeticionDTO();
		peticion.setPeticionID(this.getPeticionID());
		peticion.setSucursalID(this.getSucursalID());
		peticion.setPacienteID(this.getPacienteID());
		peticion.setObraSocial(this.getObraSocial());
		peticion.setFchEntrega(this.getFchEntrega());
		peticion.setFchCarga(this.getFchCarga());
		peticion.setEstado(this.getEstado());
		peticion.setPracticasAsociadas(this.getPracticasAsociadas());
		peticion.setResultados(this.getResultados());
	
		return peticion;
	}
	
	public Peticion() {
		// TODO Auto-generated constructor stub
	}

	public String getPeticionID() {
		return peticionID;
	}

	public void setPeticionID(String peticionID) {
		this.peticionID = peticionID;
	}

	public String getSucursalID() {
		return sucursalID;
	}

	public void setSucursalID(String sucursalID) {
		this.sucursalID = sucursalID;
	}

	public String getPacienteID() {
		return pacienteID;
	}

	public void setPacienteID(String pacienteID) {
		this.pacienteID = pacienteID;
	}

	public String getObraSocial() {
		return obraSocial;
	}

	public void setObraSocial(String obraSocial) {
		this.obraSocial = obraSocial;
	}

	public String getFchEntrega() {
		return fchEntrega;
	}

	public void setFchEntrega(String fchEntrega) {
		this.fchEntrega = fchEntrega;
	}

	public String getFchCarga() {
		return fchCarga;
	}

	public void setFchCarga(String fchCarga) {
		this.fchCarga = fchCarga;
	}

	public EstadoEnumDTO getEstado() {
		return estado;
	}

	public void setEstado(EstadoEnumDTO estado) {
		this.estado = estado;
	}

	public String getPracticasAsociadas() {
		return practicasAsociadas;
	}

	public void setPracticasAsociadas(String practicasAsociadas) {
		this.practicasAsociadas = practicasAsociadas;
	}

	public String getResultados() {
		return resultados;
	}

	public void setResultados(String resultados) {
		this.resultados = resultados;
	}

	

}
