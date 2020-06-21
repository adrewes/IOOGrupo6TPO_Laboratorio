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


import dto.PeticionDTO;
import model.Peticion;

public class PeticionController {

	private ArrayList<Peticion> datosPeticiones;

	public PeticionController()
	{
		datosPeticiones = leerPeticion();
		
	}
	
	// ------------------ Peticion -------------------
	
	public ArrayList<PeticionDTO> getPeticionListDTO()
	{
		ArrayList<PeticionDTO> lista = new ArrayList<PeticionDTO>();
		for (Peticion peticion: datosPeticiones)
			lista.add(peticion.toDTO());
		return lista;
		
	}
	public ArrayList<Peticion> getPeticionList()
	{
		return datosPeticiones;
	}
	
	public boolean addPeticion (PeticionDTO peticionDTO){
		datosPeticiones.add(new Peticion(peticionDTO));
		return true;
	}
	
	public boolean deletePeticion (PeticionDTO peticionDTO){
		datosPeticiones.remove(this.getPeticionByID(peticionDTO.getPeticionID()));
		return true;
	}	

	public boolean modifyPeticion (PeticionDTO peticionDTO){
		Peticion peticionViejo = this.getPeticionByID(peticionDTO.getPeticionID());
		datosPeticiones.remove(peticionViejo);
		datosPeticiones.add(new Peticion(peticionDTO));
		return true;
	}	
	
	private Peticion getPeticionByID(String numero)
	{
		for (Peticion peticion: datosPeticiones)
			if (peticion.getPeticionID().equals(numero)) {
				return peticion;
			}
		return null;
	}
		
	public PeticionDTO getPeticionDTO(int index)
	{
		return datosPeticiones.get(index).toDTO();
	}
	
	public void grabarPeticion() {
		File archivo = new File("./peticiones.txt");
		FileWriter fileWriter; 
		BufferedWriter bwEscritor; 
		String texto;
		Gson g = new Gson();
		texto = g.toJson(datosPeticiones);
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
	
    private ArrayList<Peticion> leerPeticion() {
    	ArrayList<Peticion> peticiones = new ArrayList<Peticion>();
        String cadena;
        File archivo = new File("./peticiones.txt");
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
    	        	peticiones.add(g.fromJson(js, Peticion.class));
    	        
    	        b.close();
    	        
    	        //for(Object o : aux)
    	        //	scores.add((Score) o);
    	        return peticiones;
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }
		return peticiones;
		
    }

}
