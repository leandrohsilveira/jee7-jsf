package br.com.lhs.jee7.jsf.web;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ViewController {

	@Inject
	Logger logger;

	private String diretorioView;

	@PostConstruct
	private void postConstruct() {
		diretorioView = "home";
	}

	public String getDiretorioView() {
		return diretorioView;
	}

	public void setDiretorioView(String diretorioView) {
		logger.info("Navegando para: " + diretorioView);
		this.diretorioView = diretorioView;
	}

}
