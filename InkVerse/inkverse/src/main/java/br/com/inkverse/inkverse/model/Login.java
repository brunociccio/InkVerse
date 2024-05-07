package br.com.inkverse.inkverse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Login {

        @Id 
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long IdLogin;

        @NotBlank(message = "O nome de usuário é obrigatório")
        private String usuario;

        @NotBlank(message = "A senha é obrigatória")
        private String senha;
}