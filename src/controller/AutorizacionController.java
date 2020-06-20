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

import dto.UsuarioDTO;
import model.Usuario;

public class AutorizacionController {

	private ArrayList<Usuario> datos;
	
	public AutorizacionController()
	{
		datos = leer();
		
	}
	public ArrayList<UsuarioDTO> getUsuarioListDTO()
	{
		ArrayList<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();
		for (Usuario usuario: datos)
			lista.add(usuario.toDTO());
		return lista;
		
	}
	public ArrayList<Usuario> getUsuarioList()
	{
		return datos;
	}
	
	public boolean addUsuario (UsuarioDTO usuarioDTO){
		datos.add(new Usuario(usuarioDTO));
		return true;
	}
	
	public boolean deleteUsuario (UsuarioDTO usuarioDTO){
		datos.remove(this.getUsuarioByID(usuarioDTO.getUsuarioID()));
		return true;
	}	

	public boolean modifyUsuario (UsuarioDTO usuarioDTO){
		Usuario usuarioViejo = this.getUsuarioByID(usuarioDTO.getUsuarioID());
		datos.remove(usuarioViejo);
		datos.add(new Usuario(usuarioDTO));
		return true;
	}	
	
	private Usuario getUsuarioByID(String usuarioID)
	{
		for (Usuario usuario: datos)
			if (usuario.getUsuarioID().equals(usuarioID)) {
				return usuario;
			}
		return null;
	}
		
	public UsuarioDTO getUsuarioDTO(int index)
	{
		return datos.get(index).toDTO();
	}
	
	public void grabar() {
		File archivo = new File("./usuarios.txt");
		FileWriter fileWriter; 
		BufferedWriter bwEscritor; 
		String texto;
		Gson g = new Gson();
		texto = g.toJson(datos);
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
	
    private ArrayList<Usuario> leer() {
    	ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        String cadena;
        File archivo = new File("./usuarios.txt");
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
    	        	usuarios.add(g.fromJson(js, Usuario.class));
    	        
    	        b.close();
    	        
    	        //for(Object o : aux)
    	        //	scores.add((Score) o);
    	        return usuarios;
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }
		return usuarios;
		
    }
}
