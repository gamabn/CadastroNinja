package store.gamabn.CadastroDeNinjas.Ninjas.Controller.Service;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import store.gamabn.CadastroDeNinjas.Missoes.Controller.MissoesModel;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

//JPA = java PERSISTENCE API
@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;

    //@ManyToOne um ninja tem uma unica missao
    @ManyToOne
    @JoinColumn(name = "missoes_id")  // Chave estrangeira
    private MissoesModel missoes;

}