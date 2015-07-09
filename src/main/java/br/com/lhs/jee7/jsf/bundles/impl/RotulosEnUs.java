package br.com.lhs.jee7.jsf.bundles.impl;

import java.util.Locale;

import br.com.lhs.jee7.jsf.bundles.Rotulos;

public class RotulosEnUs implements Rotulos {

	/**
	 *
	 */
	private static final long serialVersionUID = 6673296457036876284L;
	private static final Locale LOCALE = new Locale("en", "US");

	@Override
	public Locale getLocale() {
		return LOCALE;
	}

	@Override
	public String olaMundo() {
		return "Hello world!";
	}

	@Override
	public String salvar() {
		return "Save";
	}

	@Override
	public String nome() {
		return "Name";
	}

	@Override
	public String pesquisarUsuariosPorId() {
		return "Find an user by ID";
	}

}
