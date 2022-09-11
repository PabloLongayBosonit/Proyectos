package com.crud1.crud1.infraestructure.persona;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




public record PersonaInputDto (
    String nombre,
    String apellido,
    String username)
            {
}
