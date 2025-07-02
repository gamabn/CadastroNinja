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
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return service.CriarNinja(ninja);
    }


    //Mostrar todos os ninjas (READ)
    @GetMapping ("/todos")
    public List<NinjaModel> mostrarTodos(){
        return service.ListarNinjas();
    }

    //Mostrar ninja por Id (READ)
    @GetMapping("/todos/{id}")
    public NinjaModel mostrarTodosOsNinjas( @PathVariable Long id){
        return service.NinjaPorId(id);
    }

    //Alterar dados dos Ninjas (UPDATE)
    @PutMapping("/atualizarId")
    public String atualizarNInja(){
        return "Atualizar ninja por id";
    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarNinhaId(@PathVariable Long id){
         service.deletarNinjaPoId(id);
    }
}

