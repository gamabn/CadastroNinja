package store.gamabn.CadastroDeNinjas.Ninjas;

import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
@Service
public class NinjaService {

    private NinjaRepository ninjaRepository ;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Listar todos so meus ninjas
    public List<NinjaModel> ListarNinjas(){
        return ninjaRepository.findAll();
    }

    public NinjaModel NinjaPorId(Long id){
        Optional <NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }
    public NinjaDTO CriarNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    public void deletarNinjaPoId( Long id){
        ninjaRepository.deleteById(id);
    }

    public NinjaModel atualizarNinja( long id, NinjaModel ninjaAtualizado){
      if(ninjaRepository.existsById(id)) {
          ninjaAtualizado.setId(id);
          return ninjaRepository.save(ninjaAtualizado);
      }
      return null;
    }
}

