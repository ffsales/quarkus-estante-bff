package br.sales.estante.model;

import lombok.Data;
import lombok.Getter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.UUID;

@Data
@Schema(description = "Objeto que representa o livro")
public class Book {

    @Schema(description = "Identificador do livro")
    private UUID id;
    @Schema(description = "Título do livro")
    private String title;
//    private Genre genre;
//    private Publishing publishing;
//    private Publishing licensor;
//    private CreativeTeam creativeTeam;
//    private Country country;

}
