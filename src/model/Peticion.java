package model;

import java.util.List;

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

	

	public Peticion(String peticionID, String sucursalID, String pacienteID, String obraSocial, String fchEntrega, String fchCarga, EstadoEnumDTO estado)
	{
		this.peticionID = peticionID;
		this.sucursalID = sucursalID;
		this.pacienteID = pacienteID;
		this.obraSocial = obraSocial;
		this.fchEntrega = fchEntrega;
		this.fchCarga = fchCarga;
		this.estado = estado;
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

}
