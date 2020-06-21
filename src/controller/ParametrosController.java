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

import dto.PracticaDTO;
import dto.SucursalDTO;
import model.Practica;
import model.Sucursal;

public class ParametrosController {

	private ArrayList<Sucursal> datosSucursales;
	private ArrayList<Practica> datosPracticas;
	
	public ParametrosController()
	{
		datosSucursales = leerSucursal();
		datosPracticas = leerPractica();
		
	}
	
	// ------------------ Sucursal -------------------
	
	public ArrayList<SucursalDTO> getSucursalListDTO()
	{
		ArrayList<SucursalDTO> lista = new ArrayList<SucursalDTO>();
		for (Sucursal sucursal: datosSucursales)
			lista.add(sucursal.toDTO());
		return lista;
		
	}
	public ArrayList<Sucursal> getSucursalList()
	{
		return datosSucursales;
	}
	
	public boolean addSucursal (SucursalDTO sucursalDTO){
		datosSucursales.add(new Sucursal(sucursalDTO));
		return true;
	}
	
	public boolean deleteSucursal (SucursalDTO sucursalDTO){
		datosSucursales.remove(this.getSucursalByNumero(sucursalDTO.getNumero()));
		return true;
	}	

	public boolean modifySucursal (SucursalDTO sucursalDTO){
		Sucursal sucursalViejo = this.getSucursalByNumero(sucursalDTO.getNumero());
		datosSucursales.remove(sucursalViejo);
		datosSucursales.add(new Sucursal(sucursalDTO));
		return true;
	}	
	
	private Sucursal getSucursalByNumero(int numero)
	{
		for (Sucursal sucursal: datosSucursales)
			if (sucursal.getNumero() == numero) {
				return sucursal;
			}
		return null;
	}
		
	public SucursalDTO getSucursalDTO(int index)
	{
		return datosSucursales.get(index).toDTO();
	}
	
	public void grabarSucursal() {
		File archivo = new File("./sucursales.txt");
		FileWriter fileWriter; 
		BufferedWriter bwEscritor; 
		String texto;
		Gson g = new Gson();
		texto = g.toJson(datosSucursales);
		//grabo el String
		try{
			//Este bloque de codigo obligatoriamente debe ir dentro de un try.
			fileWriter = new FileWriter(archivo);
			fileWriter.write(texto);
			bwEscritor = new BufferedWriter(fileWriter);
			bwEscritor.close();		
		}catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
	}
	
    private ArrayList<Sucursal> leerSucursal() {
    	ArrayList<Sucursal> sucursales = new ArrayList<Sucursal>();
        String cadena;
        File archivo = new File("./sucursales.txt");
        if (archivo.exists())
        {
            FileReader f;
    		try {
    			f = new FileReader(archivo);
    	        BufferedReader b = new BufferedReader(f);
    	        cadena = b.readLine();
    	        System.out.println(cadena);
    	        JsonParser parser = new JsonParser();
    	        JsonArray gsonArr = parser.parse(cadena).getAsJsonArray();
    	        Gson g = new Gson();
    	        for(JsonElement js : gsonArr) //System.out.println(js.toString());
    	        	sucursales.add(g.fromJson(js, Sucursal.class));
    	        
    	        b.close();
    	        
    	        //for(Object o : aux)
    	        //	scores.add((Score) o);
    	        return sucursales;
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }
		return sucursales;
		
    }
    
    // ------------------ Practica -------------------
    
    public ArrayList<PracticaDTO> getPracticaListDTO()
	{
		ArrayList<PracticaDTO> lista = new ArrayList<PracticaDTO>();
		for (Practica practica: datosPracticas)
			lista.add(practica.toDTO());
		return lista;
		
	}
	public ArrayList<Practica> getPracticaList()
	{
		return datosPracticas;
	}
	
	public boolean addPractica (PracticaDTO practicaDTO){
		datosPracticas.add(new Practica(practicaDTO));
		return true;
	}
	
	public boolean deletePractica (PracticaDTO practicaDTO){
		datosPracticas.remove(this.getPracticaByID(practicaDTO.getPracticaID()));
		return true;
	}	

	public boolean modifyPractica (PracticaDTO practicaDTO){
		Practica practicaVieja = this.getPracticaByID(practicaDTO.getPracticaID());
		datosPracticas.remove(practicaVieja);
		datosPracticas.add(new Practica(practicaDTO));
		return true;
	}	
	
	private Practica getPracticaByID(String numero)
	{
		for (Practica practica: datosPracticas)
			if (practica.getPracticaID().equals(numero)) {
				return practica;
			}
		return null;
	}
		
	public PracticaDTO getPracticaDTO(int index)
	{
		return datosPracticas.get(index).toDTO();
	}
	
	public void grabarPractica() {
		File archivo = new File("./practicas.txt");
		FileWriter fileWriter; 
		BufferedWriter bwEscritor; 
		String texto;
		Gson g = new Gson();
		texto = g.toJson(datosPracticas);
		//grabo el String
		try{
			//Este bloque de codigo obligatoriamente debe ir dentro de un try.
			fileWriter = new FileWriter(archivo);
			fileWriter.write(texto);
			bwEscritor = new BufferedWriter(fileWriter);
			bwEscritor.close();		
		}catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
	}
	
    private ArrayList<Practica> leerPractica() {
    	ArrayList<Practica> practicas = new ArrayList<Practica>();
        String cadena;
        File archivo = new File("./practicas.txt");
        if (archivo.exists())
        {
            FileReader f;
    		try {
    			f = new FileReader(archivo);
    	        BufferedReader b = new BufferedReader(f);
    	        cadena = b.readLine();
    	        System.out.println(cadena);
    	        JsonParser parser = new JsonParser();
    	        JsonArray gsonArr = parser.parse(cadena).getAsJsonArray();
    	        Gson g = new Gson();
    	        for(JsonElement js : gsonArr) //System.out.println(js.toString());
    	        	practicas.add(g.fromJson(js, Practica.class));
    	        
    	        b.close();
    	        
    	        //for(Object o : aux)
    	        //	scores.add((Score) o);
    	        return practicas;
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }
		return practicas;
		
    }
}
