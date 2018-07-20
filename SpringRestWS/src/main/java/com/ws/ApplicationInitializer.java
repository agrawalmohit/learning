package com.ws;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class< ? >[] getRootConfigClasses() {
        return new Class[]{App.class};
    }

    @Override
    protected Class< ? >[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
    	System.out.println("context initiated");
        return new String[]{"/rest/*"};
    }


}
