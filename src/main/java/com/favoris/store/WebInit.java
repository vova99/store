package com.favoris.store;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;


public class WebInit implements WebApplicationInitializer {
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic registration =
                servletContext
                        .addServlet("dispatcherServlet", dispatcherServlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
        registration.setMultipartConfig(
                new MultipartConfigElement("", 1000000, 1000000, 1000000)
        );

        FilterRegistration charEncodingFilterReg =
                servletContext.
                        addFilter("CharacterEncodingFilter", CharacterEncodingFilter.class);
        charEncodingFilterReg.setInitParameter("encoding", "UTF-8");
        charEncodingFilterReg.setInitParameter("forceEncoding", "true");
        charEncodingFilterReg.addMappingForUrlPatterns(null, false, "/*");
        servletContext.addFilter("characterEncodingFilter", new CharacterEncodingFilter("UTF-8"));
    }
}
