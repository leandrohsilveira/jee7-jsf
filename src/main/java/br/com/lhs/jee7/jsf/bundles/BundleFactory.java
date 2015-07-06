package br.com.lhs.jee7.jsf.bundles;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class BundleFactory {

	private static final Map<Locale, Class<? extends Bundle>> classesMap = new HashMap<Locale, Class<? extends Bundle>>();
	private static final Map<Class<?>, Bundle> instancesMap = new HashMap<Class<?>, Bundle>();

	static {
		classesMap.put(new Locale("pt"), StringsDefault.class);
		classesMap.put(new Locale("pt", "BR"), StringsDefault.class);
		classesMap.put(new Locale("en"), StringsEnUs.class);
		classesMap.put(new Locale("en", "US"), StringsEnUs.class);
	}

	private BundleFactory() {
	}

	public static Bundle getBundle(Locale locale) {
		Class<? extends Bundle> clazz = classesMap.getOrDefault(locale, StringsDefault.class);
		try {
			if (!instancesMap.containsKey(clazz)) {
				return instancesMap.put(clazz, clazz.newInstance());
			}
			return instancesMap.get(clazz);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return new StringsDefault();
	}

}
