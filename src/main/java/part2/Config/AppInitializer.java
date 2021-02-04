package part2.Config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class AppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext container) throws ServletException {
        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext  rootContext  = new AnnotationConfigWebApplicationContext();
        rootContext.register(ApplicationConfig.class);
        // We bind the application context with the Servlet context.
        rootContext.setServletContext(container);

        // Manage the lifecycle of the root application context
//        container.addListener(new ContextLoaderListener(rootContext));

        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic appServlet = container.addServlet("dispatcher", new DispatcherServlet(rootContext));
        appServlet.setLoadOnStartup(1);
        appServlet.addMapping("/");

    }
}
