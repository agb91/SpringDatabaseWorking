package it.html.spring.book;

import java.util.Vector;
import java.util.Arrays;

public class Cosa {

	String nome;
	String eta;
	
	public String getNome() 
	{
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome=nome;
	}

	public String getEta() {
		return eta;
	}
	public void setEta(String eta) {
		this.eta=eta;
	}

	public String toString() {
		return nome + " - " + eta;
	}
}