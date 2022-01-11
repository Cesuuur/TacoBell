package com.cesar.tacobell;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Data // getters, setters, el constructor y algún otro método como equals, canEquals, hashCode y toString.
@RequiredArgsConstructor // constructor con cada uno de los atributos final no inicializados (Lo necesita @Data)
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true) //  generará el constructor sin parámetros (final no se inicializan lo forzamos) -> Lo necesita JPA...
// https://www.javatutoriales.com/2019/03/lombok-escribiendo-menos-codigo-y.html
@Entity // entidad de Spring JPA -> tabla Ingredient
public class Ingredient {

    @Id // no necesita auto id porque ya se lo ponemos en la tabla
    private final String id;
    private final String name;

    @Enumerated(value = EnumType.STRING)
    private final Ingredient.Type type;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}