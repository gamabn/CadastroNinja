package store.gamabn.CadastroDeNinjas.Ninjas;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import store.gamabn.CadastroDeNinjas.Missoes.MissoesModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private Long id;
    private String nome;
    private String imgUrl;
    private String email;
    private int idade;
    private MissoesModel missoes;
    private String dificuldade;



}
