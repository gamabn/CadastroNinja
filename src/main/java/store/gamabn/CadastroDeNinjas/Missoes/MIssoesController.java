package store.gamabn.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MIssoesController {

    @PostMapping("/criar")
    public String cadastrarMissoes(){
        return "Missao cadastrada";
    }
    @GetMapping("/listar")
    public String ListarMissoes(){
        return "Missoes listadas";

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
