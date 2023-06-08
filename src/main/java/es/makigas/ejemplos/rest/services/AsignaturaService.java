package es.makigas.ejemplos.rest.services;

import es.makigas.ejemplos.rest.models.Asignatura;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class AsignaturaService extends DatabaseService<Asignatura> {

    public AsignaturaService() {
        super(Asignatura.class, "Asignatura");
    }
    
}
