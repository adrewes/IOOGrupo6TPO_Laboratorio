package model;

import dto.EstadoEnumDTO;
import dto.EstadoHabilitacionEnumDTO;
import dto.PacienteDTO;
import dto.PeticionDTO;
import dto.PracticaDTO;
import dto.SexoEnumDTO;


public class Paciente {
	
	private String pacienteID;
	private String nombre;
	private String dni;
	private String domicilio;
	private String mail;
	private SexoEnumDTO sexo;
	private String fechaNacimiento;

	

	public Paciente(String pacienteID, String nombre, String dni, String domicilio, String mail, SexoEnumDTO sexo, String fechaNacimiento)
	{	
		this.pacienteID = pacienteID;
		this.nombre = nombre;
		this.dni = dni;
		this.domicilio = domicilio;
		this.mail = mail;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Paciente(PacienteDTO pacienteDTO)
	{

		this.setPacienteID(pacienteDTO.getPacienteID());
		this.setNombre(pacienteDTO.getNombre());
		this.setDni(pacienteDTO.getDni());
		this.setDomicilio(pacienteDTO.getDomicilio());
		this.setMail(pacienteDTO.getMail());
		this.setSexo(pacienteDTO.getSexo());
		this.setFechaNacimiento(pacienteDTO.getFechaNacimiento());
		
	}
	
	public PacienteDTO toDTO() {
		
		PacienteDTO paciente = new PacienteDTO();
		paciente.setPacienteID(this.getPacienteID());
		paciente.setNombre(this.getNombre());
		paciente.setDni(this.getDni());
		paciente.setDomicilio(this.getDomicilio());
		paciente.setMail(this.getMail());
		paciente.setSexo(this.getSexo());
		paciente.setFechaNacimiento(this.getFechaNacimiento());
	
		return paciente;
	}
	
	public Paciente() {
		// TODO Auto-generated constructor stub
	}

	public String getPacienteID() {
		return pacienteID;
	}

	public void setPacienteID(String pacienteID) {
		this.pacienteID = pacienteID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public SexoEnumDTO getSexo() {
		return sexo;
	}

	public void setSexo(SexoEnumDTO sexo) {
		this.sexo = sexo;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	
	

}
