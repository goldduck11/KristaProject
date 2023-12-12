
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import views.Singleton;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class JaxRsApplication {
    private static UndertowJaxrsServer server = new UndertowJaxrsServer();

    public static void main(String[] args){
        String host = "localhost";
        int port = 8080;

        server.setPort(port).setHostname(host).deploy(Singleton.class);

        server.start();

        System.out.println("Undertow Server started on " + host + ":" + port);
    }
}
