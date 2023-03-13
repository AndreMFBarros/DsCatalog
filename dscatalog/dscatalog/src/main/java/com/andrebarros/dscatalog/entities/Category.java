package com.andrebarros.dscatalog.entities;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

@Getter
public class Category implements Serializable { //Para o projeto java ser convertido em bytes @Lucas, tem mesmo que usar?)

   // esperar começar a usar o db +para isto @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Category(Long id, String name) {
        this.id = id; //usando o @Id e @GenatedValue, ainda faz sentido manter isso, o equals e o hasCode?
        this.name = name;
    }

    @Override
    public boolean equals(Object o) { //compara duas categorias baseadas no id (lento, mas mais completo)
        if (this == o) return true;
        if (!(o instanceof Category category)) return false;
        return getId().equals(category.getId()) && getName().equals(category.getName());
    }

    @Override
    public int hashCode() { //compara duas categorias baseadas no hashcode (rápido)
        return Objects.hash(getId(), getName());
    }
}
