package com.utils;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class GetDispatcherServlet extends AbstractAnnotationConfigDispatcherServletInitializer{
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class[] configClass= {Config.class};
		return configClass;
	}
	@Override
	protected String[] getServletMappings() {
		String[] mapping = {"/"};
		return mapping;
	}

}
