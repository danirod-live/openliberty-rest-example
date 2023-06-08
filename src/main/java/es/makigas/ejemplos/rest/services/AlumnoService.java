package es.makigas.ejemplos.rest.services;

import es.makigas.ejemplos.rest.models.Alumno;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class AlumnoService extends DatabaseService<Alumno> {
    
    public AlumnoService() {
        super(Alumno.class, "Alumno");
    }

}
