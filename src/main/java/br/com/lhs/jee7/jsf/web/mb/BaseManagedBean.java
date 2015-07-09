package br.com.lhs.jee7.jsf.web.mb;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public abstract class BaseManagedBean implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -7696238382131979619L;

	protected abstract Logger getLogger();

	@PostConstruct
	protected void postConstruct() {
		getLogger().info(getLogger().getName() + ".postConstruct()\n");
	}

	@PreDestroy
	protected void preDestroy() {
		getLogger().info(getLogger().getName() + ".preDestroy()\n");
	}

}
