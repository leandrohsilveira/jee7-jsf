package br.com.lhs.jee7.jsf.bundles;

import java.util.Locale;

public class StringsEnUs implements Bundle {

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

}
