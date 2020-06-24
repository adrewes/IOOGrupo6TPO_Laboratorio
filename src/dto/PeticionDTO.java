package dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PeticionDTO {
	private String peticionID;
	private String sucursalID;
	private String pacienteID;
	private String obraSocial;
	private String fchEntrega;
	private String fchCarga;
	private EstadoEnumDTO estado;
	
	
	public PeticionDTO(String peticionID, String sucursalID, String pacienteID, String obraSocial, String fchEntrega,
			String fchCarga, EstadoEnumDTO estado) {
		super();
		this.peticionID = peticionID;
		this.sucursalID = sucursalID;
		this.pacienteID = pacienteID;
		this.obraSocial = obraSocial;
		this.fchEntrega = fchEntrega;
		this.fchCarga = fchCarga;
		this.estado = estado;
	}
	
	public PeticionDTO() {
		super();
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
