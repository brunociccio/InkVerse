package br.com.inkverse.inkverse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        private Long Id;
        private String nome;
        private String email;
        private String senha;
}