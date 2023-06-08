package es.makigas.ejemplos.rest.services;

import es.makigas.ejemplos.rest.models.Matricula;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class MatriculaService extends DatabaseService<Matricula>
{
    public MatriculaService() {
        super(Matricula.class, "Matricula");
    }
}
