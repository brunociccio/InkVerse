package br.com.inkverse.inkverse.model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cadastro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCadastrar;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @Temporal(TemporalType.DATE)
    private LocalDate dataNascimento;

    // Sexo é opcional e pode ser 'M' (masculino), 'F' (feminino), ou 'não informado'
    @Size(min = 1, max = 1)
    private String sexo;

    @NotBlank(message = "Seu estado civil é obrigatório")
    private String estadoCivil;

    @NotBlank(message = "A escolaridade é obrigatória")
    private String escolaridade;

    @NotBlank(message = "A profissão é obrigatória")
    private String profissao;

    @Positive(message = "A renda deve ser um número positivo")
    private Double renda;

}
