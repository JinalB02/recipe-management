package com.abnamro.recipe.api.response;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class GenericResponse {

    private final String message;

}
