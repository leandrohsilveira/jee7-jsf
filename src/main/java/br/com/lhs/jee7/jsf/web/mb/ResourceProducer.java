package br.com.lhs.jee7.jsf.web.mb;

import java.util.Locale;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.lhs.jee7.jsf.bundles.InternacionalizacaoFactory;
import br.com.lhs.jee7.jsf.bundles.Rotulos;

public class ResourceProducer {

	@Produces
	public FacesContext produceFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	@Produces
	public ExternalContext produceExternalContext() {
		FacesContext facesContext = produceFacesContext();
		return facesContext != null ? facesContext.getExternalContext() : null;
	}

	@Produces
	public HttpSession produceSession() {
		ExternalContext externalContext = produceExternalContext();
		return externalContext != null ? (HttpSession) externalContext.getSession(true) : null;
	}

	@Produces
	public Logger produceLogger(InjectionPoint injectionPoint) {
		return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
	}

	@Produces
	@Named
	@SessionScoped
	public Rotulos getRotulos() {
		return InternacionalizacaoFactory.rotulos(producesLocale());
	}

	@Produces
	public Locale producesLocale() {
		Locale locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
		if (locale == null) {
			locale = Locale.getDefault();
		}
		return locale;
	}

}
