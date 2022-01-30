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
		usuario.remove(id);
	}
	
	public List<User> buscarUsuario() {
		return usuario;
	}
	
	public User buscarUsuario(int id) {
		return usuario.get(id);
	}

	
	public void alterarUsuario(int id, String nome, String email, String pais) {
		User u = buscarUsuario(id);
		u.setNome(nome);
		u.setEmail(email);
		u.setPais(pais);
		
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
