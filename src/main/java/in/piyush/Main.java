package in.piyush;

import in.piyush.Config.webConfig;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws LifecycleException {

        System.out.printf("hello world");

        // what to do :
        /*
                create a student entity -- controllers like post and get -- no db (use hashmap to just visualize)

         */



        //Boiler plate code --> which we have to write each time in MVC bcz here we have to up tomcat,IOC
        // and other things we dont get auto-configurations itself



        //tomcat up

        Tomcat tomcat = new Tomcat();

        tomcat.setPort(8080);
        tomcat.getConnector(); // listens on 8080

        String contextPath = "";
        String baseDoc = new File("src/main/webApp").getAbsolutePath();
 
        Context context = tomcat.addContext(contextPath , baseDoc);



        //IOC container up

        AnnotationConfigWebApplicationContext springcontext = new AnnotationConfigWebApplicationContext();
        springcontext.register(webConfig.class);


        //Dispatcher Servlet

        DispatcherServlet dispatcherServlet = new DispatcherServlet(springcontext);

        tomcat.addServlet(context , "dispatcherServlet" , dispatcherServlet); // needs (context of tomcat , name of central servlet , pass central servlet)

        context.addServletMappingDecoded("/" , "dispatcherServlet"); // all "/" starting request send to this servlet(central servlet)



        tomcat.start();

        System.out.printf("Tomcat started on port 8080");

        tomcat.getServer().await(); //keep server running
    }
}
