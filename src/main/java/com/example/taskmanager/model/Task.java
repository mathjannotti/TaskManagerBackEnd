package com.example.taskmanager.model;

import lombok.Data;
import java.time.LocalDate;

@Data // Esta anotação do Lombok gera automaticamente os getters, setters, e outros métodos úteis
public class Task {
    private Long id; // Certifique-se de que este campo é privado e o Lombok gerará o getter e setter
    private String name;
    private String responsible;
    private String description;
    private String status; // Valores possíveis: TODO, DOING, DONE
    private LocalDate creationDate;

    // Construtor da classe
    public Task(Long id, String name, String responsible, String description, String status) {
        this.id = id;
        this.name = name;
        this.responsible = responsible;
        this.description = description;
        this.status = status;
        this.creationDate = LocalDate.now();
    }
}
