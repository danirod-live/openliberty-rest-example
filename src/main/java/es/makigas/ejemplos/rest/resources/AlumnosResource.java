package es.makigas.ejemplos.rest.resources;

import es.makigas.ejemplos.rest.models.Alumno;
import es.makigas.ejemplos.rest.services.AlumnoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import java.util.List;

@Path("/alumnos")
public class AlumnosResource {
    
    private AlumnoService alumnos;
    
    @Inject
    public AlumnosResource(AlumnoService alumnos) {
        this.alumnos = alumnos;
    }
    
    @GET
    @Produces("application/json")
    public List<Alumno> list() {
        return this.alumnos.list().page(1).get();
    }
    
}
