package pl.spring.demo.web.jetty;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class EmbeddedJetty {

    private static final Logger logger = LoggerFactory.getLogger(EmbeddedJetty.class);

    private static final int DEFAULT_PORT = 9721;
    private static final String CONTEXT_PATH = "/workshop/";
    private static final String CONFIG_LOCATION = "classpath*:spring/*.xml";
    private static final String MAPPING_URL = "/*";
    private static final String DEFAULT_PROFILE = "dev";

    public static void main(String[] args) throws Exception {
        
    	new EmbeddedJetty().startJetty(DEFAULT_PORT);
//    	Server server = new Server(DEFAULT_PORT);
//    	server.start();
    	
        SwingUtilities.invokeLater(new Runnable() {
        	@Override
        	public void run() {
        		EmbeddedJetty.logger.debug("Starting application");	
        		
        		SwingApp swingApp = new SwingApp();
        		swingApp.setTitle("Simple swing application.");
        		swingApp.setSize(800, 600);
        		swingApp.setLocationRelativeTo(null);
        		swingApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		swingApp.setVisible(true);
        		
        		swingApp.addWindowListener(new WindowAdapter() {
        			@Override
        			public void windowClosing(WindowEvent e) {
        				EmbeddedJetty.logger.debug("Closing server");
//        				try {
//							server.stop();
//						} catch (Exception e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
        				//close server here
        			}
				});
        	}
        });
    }

    private void startJetty(int port) throws Exception {
        Server server = new Server(port);
        server.setHandler(getServletContextHandler(getContext()));
        server.start();
        logger.info("Server started at port {}", port);
//        server.join();
    }

    private static ServletContextHandler getServletContextHandler(WebApplicationContext context) throws IOException {
        ServletContextHandler contextHandler = new ServletContextHandler();
        contextHandler.setErrorHandler(null);
        contextHandler.setContextPath(CONTEXT_PATH);
        contextHandler.addServlet(new ServletHolder(new DispatcherServlet(context)), MAPPING_URL);
        contextHandler.addEventListener(new ContextLoaderListener(context));
        contextHandler.setResourceBase(new ClassPathResource("webapp").getURI().toString());
        return contextHandler;
    }

    private static WebApplicationContext getContext() {
        XmlWebApplicationContext context = new XmlWebApplicationContext();
        context.setConfigLocation(CONFIG_LOCATION);
        context.getEnvironment().setDefaultProfiles(DEFAULT_PROFILE);
        return context;
    }
    
//    public void registerShutDownHook() {
//    	Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
//    		@Override
//    		public void run() {
//    			close();
//    		}
//    	}));
//    }

}
