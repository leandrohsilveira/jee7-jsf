package br.com.lhs.jee7.jsf.bundles;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import br.com.lhs.jee7.jsf.bundles.impl.RotulosEnUs;
import br.com.lhs.jee7.jsf.bundles.impl.RotulosPtBr;

public class InternacionalizacaoFactory {

	private static final Map<Locale, Class<? extends Rotulos>> classesRotulosMap = new HashMap<Locale, Class<? extends Rotulos>>();
	private static final Map<Class<?>, Rotulos> instancesMap = new HashMap<Class<?>, Rotulos>();

	static {
		classesRotulosMap.put(new Locale("pt"), RotulosPtBr.class);
		classesRotulosMap.put(new Locale("pt", "BR"), RotulosPtBr.class);
		classesRotulosMap.put(new Locale("en"), RotulosEnUs.class);
		classesRotulosMap.put(new Locale("en", "US"), RotulosEnUs.class);
	}

	private InternacionalizacaoFactory() {
	}

	public static Rotulos rotulos(Locale locale) {
		System.out.println("rotulos");
		Class<? extends Rotulos> clazz = classesRotulosMap.getOrDefault(locale, RotulosPtBr.class);
		try {
			if (!instancesMap.containsKey(clazz)) {
				instancesMap.put(clazz, clazz.newInstance());
			}
			return instancesMap.get(clazz);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return new RotulosPtBr();
	}

}
