package br.com.lhs.jee7.jsf.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import br.com.lhs.jee7.jsf.model.Usuario;

@Local
public interface UsuarioDAO extends Serializable {

	void salvar(Usuario u);

	List<Usuario> listar();

	Usuario recuperar(Long id);

}
