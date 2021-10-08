package com.globant.vet.config;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.globant.vet.exception.BootstrapException;
import com.globant.vet.util.constants.Constants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppProperties {
	private static Properties props = null;
	private FileReader fr = null;

	private AppProperties() {
		try {
			fr = new FileReader(Constants.PATH_PROPERTIES);
			props = new Properties();
			props.load(fr);
		} catch (IOException e) {
			log.error(Constants.PROPERTIES_NOT_FOUND);
			throw new BootstrapException(Constants.PROPERTIES_NOT_FOUND);
		}
	}

	static {
		if (props == null) {
			new AppProperties();
		}
	}

	public static String getProperty(String propertyKey) {
		if (propertyKey == null || propertyKey.isEmpty() || !props.containsKey(propertyKey)) {
			log.error(Constants.PROPERTY_NOT_FOUND);
			throw new BootstrapException(Constants.PROPERTY_NOT_FOUND);
		}
		return props.getProperty(propertyKey);
	}

	public static Map<String, String> getProperties() {
		Map<String, String> propsMap = new HashMap<>();
		for (String propertyKey : props.stringPropertyNames()) {
			propsMap.put(propertyKey, props.getProperty(propertyKey));
		}
		return propsMap;
	}
}
