package br.com.lhs.jee7.jsf.bundles;

import java.io.Serializable;
import java.util.Locale;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Named;

public class BundleProducer implements Serializable {

	private static final long serialVersionUID = -2550075677261874309L;

	@Produces
	@Named("strings")
	@Default
	public Bundle producesStrings() {
		return BundleFactory.getBundle(producesLocale());
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
