package model;

import dto.EstadoHabilitacionEnumDTO;
import dto.PracticaDTO;


public class Practica {
	
	private String practicaID;
	private String nombre;
	private String grupo;
	private String valoresCriticos;
	private String valoresReservados;
	private String tiempoEntrega;
	private EstadoHabilitacionEnumDTO estadoHabilitacion;

	

	public Practica(String practicaID, String nombre, String grupo, String valoresCriticos, String valoresReservados, String tiempoEntrega, EstadoHabilitacionEnumDTO estadoHabilitacion)
	{
		this.practicaID = practicaID;
		this.nombre = nombre;
		this.grupo = grupo;
		this.valoresCriticos = valoresCriticos;
		this.valoresReservados = valoresReservados;
		this.tiempoEntrega = tiempoEntrega;
		this.estadoHabilitacion = estadoHabilitacion;
	}
	
	public Practica(PracticaDTO practicaDTO)
	{

		this.setPracticaID(practicaDTO.getPracticaID());
		this.setNombre(practicaDTO.getNombre());
		this.setGrupo(practicaDTO.getGrupo());
		this.setValoresCriticos(practicaDTO.getValoresCriticos());
		this.setValoresReservados(practicaDTO.getValoresReservados());
		this.setTiempoEntrega(practicaDTO.getTiempoEntrega());
		this.setEstadoHabilitacion(practicaDTO.getEstadoHabilitacion());
		
	}
	
	public PracticaDTO toDTO() {
		
		PracticaDTO practica = new PracticaDTO();
		practica.setPracticaID(this.getPracticaID());
		practica.setNombre(this.getNombre());
		practica.setGrupo(this.getGrupo());
		practica.setValoresCriticos(this.getValoresCriticos());
		practica.setValoresReservados(this.getValoresReservados());
		practica.setTiempoEntrega(this.getTiempoEntrega());
		practica.setEstadoHabilitacion(this.getEstadoHabilitacion());
	
		return practica;
	}
	
	public Practica() {
		// TODO Auto-generated constructor stub
	}

	public String getPracticaID() {
		return practicaID;
	}

	public void setPracticaID(String practicaID) {
		this.practicaID = practicaID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getValoresCriticos() {
		return valoresCriticos;
	}

	public void setValoresCriticos(String valoresCriticos) {
		this.valoresCriticos = valoresCriticos;
	}

	public String getValoresReservados() {
		return valoresReservados;
	}

	public void setValoresReservados(String valoresReservados) {
		this.valoresReservados = valoresReservados;
	}

	public String getTiempoEntrega() {
		return tiempoEntrega;
	}

	public void setTiempoEntrega(String tiempoEntrega) {
		this.tiempoEntrega = tiempoEntrega;
	}

	public EstadoHabilitacionEnumDTO getEstadoHabilitacion() {
		return estadoHabilitacion;
	}

	public void setEstadoHabilitacion(EstadoHabilitacionEnumDTO estadoHabilitacion) {
		this.estadoHabilitacion = estadoHabilitacion;
	}


}
