package com.sqxww.generator.utils;

import java.io.File;
import java.io.IOException;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

public class FreeMarkerUtil {
	private static final Configuration CONFIGURATION;
	static{
		CONFIGURATION = new Configuration(Configuration.VERSION_2_3_23);
		CONFIGURATION.setDefaultEncoding("UTF-8");
		try {
			CONFIGURATION.setDirectoryForTemplateLoading(new File(FreeMarkerUtil.class.getClassLoader().getResource("").getPath() + "templates/hrz"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		CONFIGURATION.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
	}
	
	public static Configuration getConfiguration() {
		return CONFIGURATION;
	}
}
