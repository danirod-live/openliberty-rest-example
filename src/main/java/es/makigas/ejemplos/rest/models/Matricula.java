package es.makigas.ejemplos.rest.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "matriculas")
@Data
public class Matricula {
    
    /*@Embeddable
    @Data
    public static class Key {
        @OneToOne
        @JoinColumn(name = "alumno")
        private Alumno alumno;
        
        @OneToOne
        @JoinColumn(name = "asignatura")
        private Asignatura asignatura;
        
        @Column(name = "fecha")
        private int fecha;
    }
    
    public Matricula() {
        this.key = new Key();
    }
    
    @EmbeddedId
    private Key key;*/
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matricula")
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "alumno")
    private Alumno alumno;

    @OneToOne
    @JoinColumn(name = "asignatura")
    private Asignatura asignatura;

    @Column(name = "fecha")
    private int fecha;
    
    @Column
    private int nota;
}
