package es.makigas.ejemplos.rest.resources;

import es.makigas.ejemplos.rest.dto.AlumnoPayload;
import es.makigas.ejemplos.rest.models.Alumno;
import es.makigas.ejemplos.rest.services.AlumnoService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;

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
    
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Transactional
    public Alumno insert(@Valid AlumnoPayload alu) {
        Alumno a = new Alumno();
        alu.enrich(a);
        return this.alumnos.insert(a);
    }
    
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response retrieve(@PathParam(value = "id") Integer id) {
    	return this.alumnos.get(id)
    		.map((alu) -> Response.ok(alu).build())
    		.orElse(Response.status(Response.Status.NOT_FOUND).build());
    }
    
    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam(value = "id") Integer id) {
    	this.alumnos.get(id).ifPresent(alu -> this.alumnos.delete(alu));
    	return Response.noContent().build();
    }
    
    @PUT
    @Path("/{id}")
    @Produces("application/json")
    @Transactional
    public Response update(@PathParam(value = "id") Integer id, @Valid AlumnoPayload payload) {
    	return this.alumnos.get(id)
    		.map(alu -> {
    			payload.enrich(alu);
    			this.alumnos.update(alu);
    			return Response.ok(alu).build();
    		})
    		.orElse(Response.status(Response.Status.NOT_FOUND).build());
    }
}
