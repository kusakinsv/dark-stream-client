//package ru.dark.stream;
//
//import org.springframework.stereotype.Service;
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.ContextLoaderListener;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.context.support.GenericWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRegistration;
//
//@Service
//public class SpringWebAppInitializer implements WebApplicationInitializer {
//    //
////    @Override
////    public void onStartup(ServletContext servletContext) throws ServletException {
////        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
//////        appContext.register(AppConfiguration.class);
////        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("SpringDispatcher",
////                new DispatcherServlet(appContext));
////        dispatcher.setLoadOnStartup(1);
////        dispatcher.addMapping("/");
////        dispatcher.setInitParameter("contextClass", appContext.getClass().getName());
////        servletContext.addListener(new ContextLoaderListener(appContext));
////        FilterRegistration.Dynamic fr = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
////        fr.setInitParameter("encoding", "UTF-8");
////        fr.setInitParameter("forceEncoding", "true");
////        fr.addMappingForUrlPatterns(null, true, "/*");
//    @Override
//    public void onStartup(final ServletContext sc) throws ServletException {
//
//        AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
//
//        root.scan("ru.dark.stream");
//        sc.addListener(new ContextLoaderListener(root));
//
//        ServletRegistration.Dynamic appServlet =
//                sc.addServlet("mvc", new DispatcherServlet(new GenericWebApplicationContext()));
//        appServlet.setLoadOnStartup(1);
//        appServlet.addMapping("/");
//    }
//
//}
