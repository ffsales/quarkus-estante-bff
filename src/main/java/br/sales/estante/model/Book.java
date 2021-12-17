package br.sales.estante.model;

import lombok.Data;
import lombok.Getter;

import java.util.UUID;

@Data
public class Book {

    private UUID id;
    private String title;
//    private Genre genre;
//    private Publishing publishing;
//    private Publishing licensor;
//    private CreativeTeam creativeTeam;
//    private Country country;

}
