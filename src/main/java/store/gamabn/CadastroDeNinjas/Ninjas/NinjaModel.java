package store.gamabn.CadastroDeNinjas.Ninjas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import store.gamabn.CadastroDeNinjas.Missoes.MissoesModel;

//JPA = java PERSISTENCE API
@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id")
    private Long id;

    @Column(name="name")
    private String nome;

    @Column(name="img_url")
    private String imgUrl;

    @Column(unique = true)
    private String email;

    @Column(name="idade")
    private int idade;

    //@ManyToOne um ninja tem uma unica missao
    @ManyToOne
    @JoinColumn(name = "missoes_id")  // Chave estrangeira
    private MissoesModel missoes;

}