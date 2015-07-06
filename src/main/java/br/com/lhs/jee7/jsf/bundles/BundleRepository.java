package br.com.lhs.jee7.jsf.bundles;

import java.util.Locale;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

public class BundleRepository {

	@Inject
	@Named("strings")
	@RequestScoped
	Bundle bundle;

	@Inject
	@RequestScoped
	Locale locale;

}
