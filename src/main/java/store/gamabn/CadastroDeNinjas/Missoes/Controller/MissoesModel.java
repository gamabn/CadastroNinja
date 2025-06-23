package store.gamabn.CadastroDeNinjas.Missoes.Controller;

import jakarta.persistence.*;
import store.gamabn.CadastroDeNinjas.Ninjas.Controller.Service.NinjaModel;

import java.util.List;

@Entity
@Table(name = "tabel_missoes")
public class MissoesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String rank;
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;

}