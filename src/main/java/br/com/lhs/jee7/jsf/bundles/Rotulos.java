package br.com.lhs.jee7.jsf.bundles;

import java.io.Serializable;
import java.util.Locale;

public interface Rotulos extends Serializable {

	Locale getLocale();

	String olaMundo();

	String salvar();

	String nome();

	String pesquisarUsuariosPorId();

	default String email() {
		return "E-mail";
	};

	default String id() {
		return "ID";
	}

}
