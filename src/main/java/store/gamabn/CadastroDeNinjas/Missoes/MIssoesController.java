package store.gamabn.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MIssoesController {

    MissoesService missoesService;

    public MIssoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @PostMapping("/criar")
    public String cadastrarMissoes(){
        return "Missao cadastrada";
    }
    @GetMapping("/listar")
    public List<MissoesModel> ListarMissoes(){
        return missoesService.listarMissoes();

    }
    @GetMapping("listarId")
    public String ListarId(){
        return "Missao de um Id";
    }

    @PutMapping("/alterarId")
    public String alterarMissao(){
        return "MIssao alterada";
    }

    @DeleteMapping("deletarId")
    public String Deletar(){
        return "Missao deletada";
    }
}
