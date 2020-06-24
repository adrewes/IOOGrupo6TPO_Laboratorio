package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import dto.EstadoEnumDTO;
import dto.PacienteDTO;
import dto.PeticionDTO;
import dto.ResultadoDTO;
import model.Paciente;
import model.Resultado;

public class LaboratorioController {

	private ArrayList<Paciente> datosPacientes;
	private ArrayList<Resultado> datosResultados;
	private PeticionController peticionController;

	public LaboratorioController() {
		datosPacientes = leerPaciente();
		datosResultados = leerResultado();
		peticionController = new PeticionController();

	}

	// ------------------ Paciente -------------------

	public ArrayList<PacienteDTO> getPacienteListDTO() {
		ArrayList<PacienteDTO> lista = new ArrayList<PacienteDTO>();
		for (Paciente paciente : datosPacientes)
			lista.add(paciente.toDTO());
		return lista;

	}

	public ArrayList<Paciente> getPacienteList() {
		return datosPacientes;
	}

	public boolean addPaciente(PacienteDTO pacienteDTO) {
		datosPacientes.add(new Paciente(pacienteDTO));
		return true;
	}

	public boolean deletePaciente(PacienteDTO pacienteDTO) {

		for (PeticionDTO peticion : peticionController.getPeticionListPorPaciente(pacienteDTO)) {
			for (Resultado resultado : datosResultados) {
				if (resultado.getPeticionID().equals(peticion.getPeticionID())
						&& resultado.getEstado().equals(EstadoEnumDTO.Finalizado)) {
					JOptionPane.showMessageDialog(null,"No se puede eliminar un paciente con peticiones con resultado 'Finalizado'");
					return false;
				}
			}
		}
		datosPacientes.remove(this.getPacienteByID(pacienteDTO.getPacienteID()));
		return true;
	}

	public boolean modifyPaciente(PacienteDTO pacienteDTO) {
		Paciente pacienteViejo = this.getPacienteByID(pacienteDTO.getPacienteID());
		datosPacientes.remove(pacienteViejo);
		datosPacientes.add(new Paciente(pacienteDTO));
		return true;
	}

	private Paciente getPacienteByID(String numero) {
		for (Paciente paciente : datosPacientes)
			if (paciente.getPacienteID().equals(numero)) {
				return paciente;
			}
		return null;
	}

	public PacienteDTO getPacienteDTO(int index) {
		return datosPacientes.get(index).toDTO();
	}

	public void grabarPaciente() {
		File archivo = new File("./pacientes.txt");
		FileWriter fileWriter;
		BufferedWriter bwEscritor;
		String texto;
		Gson g = new Gson();
		texto = g.toJson(datosPacientes);
		// grabo el String
		try {
			// Este bloque de codigo obligatoriamente debe ir dentro de un try.
			fileWriter = new FileWriter(archivo);
			fileWriter.write(texto);
			bwEscritor = new BufferedWriter(fileWriter);
			bwEscritor.close();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}

	private ArrayList<Paciente> leerPaciente() {
		ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
		String cadena;
		File archivo = new File("./pacientes.txt");
		if (archivo.exists()) {
			FileReader f;
			try {
				f = new FileReader(archivo);
				BufferedReader b = new BufferedReader(f);
				cadena = b.readLine();
				System.out.println(cadena);
				JsonParser parser = new JsonParser();
				JsonArray gsonArr = parser.parse(cadena).getAsJsonArray();
				Gson g = new Gson();
				for (JsonElement js : gsonArr) // System.out.println(js.toString());
					pacientes.add(g.fromJson(js, Paciente.class));

				b.close();

				// for(Object o : aux)
				// scores.add((Score) o);
				return pacientes;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return pacientes;

	}

	// ------------------ Resultado -------------------

	public ArrayList<ResultadoDTO> getResultadoListDTO() {
		ArrayList<ResultadoDTO> lista = new ArrayList<ResultadoDTO>();
		for (Resultado resultado : datosResultados)
			lista.add(resultado.toDTO());
		return lista;

	}

	public ArrayList<Resultado> getResultadoList() {
		return datosResultados;
	}

	public boolean addResultado(ResultadoDTO resultadoDTO) {
		datosResultados.add(new Resultado(resultadoDTO));
		return true;
	}

	public boolean deleteResultado(ResultadoDTO resultadoDTO) {
		datosResultados.remove(this.getResultadoByID(resultadoDTO.getResultadoID()));
		return true;
	}

	public boolean modifyResultado(ResultadoDTO resultadoDTO) {
		Resultado resultadoVieja = this.getResultadoByID(resultadoDTO.getResultadoID());
		datosResultados.remove(resultadoVieja);
		datosResultados.add(new Resultado(resultadoDTO));
		return true;
	}

	private Resultado getResultadoByID(String numero) {
		for (Resultado resultado : datosResultados)
			if (resultado.getResultadoID().equals(numero)) {
				return resultado;
			}
		return null;
	}

	public ResultadoDTO getResultadoDTO(int index) {
		return datosResultados.get(index).toDTO();
	}

	public void grabarResultado() {
		File archivo = new File("./resultados.txt");
		FileWriter fileWriter;
		BufferedWriter bwEscritor;
		String texto;
		Gson g = new Gson();
		texto = g.toJson(datosResultados);
		// grabo el String
		try {
			// Este bloque de codigo obligatoriamente debe ir dentro de un try.
			fileWriter = new FileWriter(archivo);
			fileWriter.write(texto);
			bwEscritor = new BufferedWriter(fileWriter);
			bwEscritor.close();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}

	private ArrayList<Resultado> leerResultado() {
		ArrayList<Resultado> resultados = new ArrayList<Resultado>();
		String cadena;
		File archivo = new File("./resultados.txt");
		if (archivo.exists()) {
			FileReader f;
			try {
				f = new FileReader(archivo);
				BufferedReader b = new BufferedReader(f);
				cadena = b.readLine();
				System.out.println(cadena);
				JsonParser parser = new JsonParser();
				JsonArray gsonArr = parser.parse(cadena).getAsJsonArray();
				Gson g = new Gson();
				for (JsonElement js : gsonArr) // System.out.println(js.toString());
					resultados.add(g.fromJson(js, Resultado.class));

				b.close();

				// for(Object o : aux)
				// scores.add((Score) o);
				return resultados;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultados;

	}
}
