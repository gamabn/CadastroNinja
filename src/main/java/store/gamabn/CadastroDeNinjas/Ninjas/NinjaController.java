package store.gamabn.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService service;

    public NinjaController(NinjaService service) {
        this.service = service;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa e minha primeira mensagem nessa rota";
    }

    //Adicionar ninja (CREATE)
    @PostMapping("/adicionar")
    public String criarNinja(){
        return "Ninja criado";
    }


    //Mostrar todos os ninjas (READ)
    @GetMapping ("/todos")
    public List<NinjaModel> mostrarTodos(){
        return service.ListarNinjas();
    }

    //Mostrar ninja por Id (READ)
    @GetMapping("/todosId")
    public String mostrarTodosOsNinjas(){
        return "Ninja do Id";
    }

    //Alterar dados dos Ninjas (UPDATE)
    @PutMapping("/atualizarId")
    public String atualizarNInja(){
        return "Atualizar ninja por id";
    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletarId")
    public String deletarNinhaId(){
        return "Ninja deletado por ID";
    }
}

