package store.gamabn.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
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
    public String boasVindas() {
        return "Essa e minha primeira mensagem nessa rota";
    }

    //Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = service.CriarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + "(ID)" + novoNinja.getId());
    }


    //Mostrar todos os ninjas (READ)
    @GetMapping("/todos")
    public ResponseEntity<List<NinjaDTO>> mostrarTodos() {
        List<NinjaDTO> ninjas = service.ListarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    //Mostrar ninja por Id (READ)
    @GetMapping("/todos/{id}")
    public ResponseEntity<?> mostrarTodosOsNinjas(@PathVariable Long id) {
        NinjaDTO ninjaId = service.NinjaPorId(id);

        if(ninjaId !=null){
            return ResponseEntity.ok(ninjaId);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NInja do " + id + " Nao encontrado");
        }
//=========================================================================
       // if(service.NinjaPorId(id) != null){
        //    NinjaDTO ninjaId =  service.NinjaPorId(id);
           //return  ResponseEntity.status(HttpStatus.OK).body("ninja encontrado");
        //}else{
        //    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja nao emconrado");
       // }
//==================================================================================================
    }

    //Alterar dados dos Ninjas (UPDATE)
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarNInja(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        NinjaDTO ninja = service.atualizarNinja(id, ninjaAtualizado);

        if(ninja != null){
            return  ResponseEntity.ok(ninja);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja nao emconrado");
        }

    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinhaId(@PathVariable Long id) {

        if (service.NinjaPorId(id) != null) {
            service.deletarNinjaPoId(id);
           return  ResponseEntity.ok("Ninja com " + id + " Deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id do ninja nao encontrado");
        }
    }
}

