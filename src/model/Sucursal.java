package model;

import dto.SucursalDTO;

public class Sucursal {
	
	private int numero;
	private String direccion;
	private String responsableTecnico;

	

	public Sucursal(int numero, String direccion, String responsableTecnico)
	{
		this.numero = numero;
		this.direccion = direccion;
		this.responsableTecnico = responsableTecnico;
	}
	
	public Sucursal(SucursalDTO sucursalDTO)
	{

		this.setNumero(sucursalDTO.getNumero());
		this.setDireccion(sucursalDTO.getDireccion());
		this.setResponsableTecnico(sucursalDTO.getResponsableTecnico());
		
	}
	
	public SucursalDTO toDTO() {
		
		SucursalDTO sucursal = new SucursalDTO();
		sucursal.setNumero(this.getNumero());
		sucursal.setDireccion(this.getDireccion());
		sucursal.setResponsableTecnico(this.getResponsableTecnico());
	
		return sucursal;
	}
	
	public Sucursal() {
		// TODO Auto-generated constructor stub
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getResponsableTecnico() {
		return responsableTecnico;
	}

	public void setResponsableTecnico(String responsableTecnico) {
		this.responsableTecnico = responsableTecnico;
	}

	


}
