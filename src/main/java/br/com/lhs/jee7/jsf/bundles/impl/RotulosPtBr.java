package br.com.lhs.jee7.jsf.bundles.impl;

import java.util.Locale;

import br.com.lhs.jee7.jsf.bundles.Rotulos;

public class RotulosPtBr implements Rotulos {

	/**
	 *
	 */
	private static final long serialVersionUID = 1406053597496134827L;
	private static final Locale LOCALE = new Locale("pt", "BR");

	@Override
	public Locale getLocale() {
		return LOCALE;
	}

	@Override
	public String olaMundo() {
		return "Olá mundo!";
	}

	@Override
	public String salvar() {
		return "Salvar";
	}

	@Override
	public String nome() {
		return "Nome";
	}

	@Override
	public String pesquisarUsuariosPorId() {
		return "Filtrar usuário por ID";
	}

}
