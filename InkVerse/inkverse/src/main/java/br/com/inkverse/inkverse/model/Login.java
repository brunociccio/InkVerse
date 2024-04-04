package br.com.inkverse.inkverse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Login {

        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        private String nome;
        private String email;
        private String senha;
        public void setId(Long valueOf) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'setId'");
        }

}