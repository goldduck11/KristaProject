package views;

import views.MessageBodyWriters.CategoryToJsonProvider;
import views.MessageBodyWriters.ListToJsonProvider;
import views.MessageBodyWriters.NewsDTOtoJsonProvider;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class Singleton extends Application {
    private Set<Object> singletons = new HashSet<>();

    public Singleton(){
        singletons.add(new ReaderApi());
        singletons.add(new WriterApi());
        singletons.add(new ListToJsonProvider());
        singletons.add(new NewsDTOtoJsonProvider());
        singletons.add(new CategoryToJsonProvider());
        singletons.add(new NewsDTOtoJsonProvider());
    }

    @Override
    public Set<Object> getSingletons(){
        return singletons;
    }
}
