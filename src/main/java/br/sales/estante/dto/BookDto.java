package br.sales.estante.dto;

import lombok.Data;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Data
@Schema(description = "Objeto que transaciona uma representação do livro")
public class BookDto {

    private String title;
}
