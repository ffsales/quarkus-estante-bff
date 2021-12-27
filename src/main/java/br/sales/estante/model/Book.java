package br.sales.estante.model;

import lombok.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Objeto que representa o livro")
public class Book {

    @Schema(description = "Identificador do livro")
    private UUID id;
    @Schema(description = "Título do livro")
    private String title;
    @Schema(description = "Gênero do livro")
    private String genre;
//    private Publishing publishing;
//    private Publishing licensor;
//    private CreativeTeam creativeTeam;
    @Schema(description = "País de origem do livro")
    private String country;

}
