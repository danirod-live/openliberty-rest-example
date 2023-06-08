package es.makigas.ejemplos.rest.dto;

import es.makigas.ejemplos.rest.models.Alumno;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Getter;

import java.time.LocalDate;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public record AlumnoPayload(
        @Schema @NotNull @NotBlank @Getter String firstName,
        @Schema @NotNull @NotBlank String lastName,
        @Schema @NotNull @Past LocalDate birthday
    ) {
    public void enrich(Alumno alu) {
        alu.setNombre(firstName);
        alu.setApellidos(lastName);
        alu.setFechaNacimiento(birthday);
    }
}
