package com.br.projeto;

import java.util.ArrayList;
import java.util.List;

public class Container {
	private List<User> usuario = new ArrayList<User>();
	private static int id = 0;
	
	public Container() {
	}
	
	public Container(List<User> usuario) {
		super();
		this.usuario = usuario;
	}

	

	public void adicionarUsuario(User user) {
		user.setId(id);
		usuario.add(user);
		id++;
	}
	

	public void removerUsuario(int id) {
		//for(User u : usuario) {
			//if (u.getId() == id){
				usuario.remove(id);
			//} else {
				//System.out.println("NÃO EXISTE ESSE USUARIO!");
			//}
		//}
	}
	
	public List<User> buscarUsuario() {
		return usuario;
	}
	
	public User buscarUsuario(int indice) {
		return usuario.get(indice);
	}

	
	public void alterarUsuario(int id, String nome, String email, String pais) {
		User user = buscarUsuario(id);
		user.setNome(nome);
		user.setEmail(email);
		user.setPais(pais);
		
		//se deseja alterar o nome, setNome("Passar aqui o novo nome") 	
		//se deseja alterar o email, setEmail("Passar aqui o novo email") 
		//se deseja alterar o pais, setPais("Passar aqui o novo Pais") 
		
	}
	
	
	
	public List<User> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<User> usuario) {
		this.usuario = usuario;
	}
}
