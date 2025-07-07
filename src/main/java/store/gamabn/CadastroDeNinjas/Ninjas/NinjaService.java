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
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository ;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Listar todos so meus ninjas
    public List<NinjaDTO> ListarNinjas(){
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
       // return ninjaRepository.findAll();
    }

    public NinjaDTO NinjaPorId(Long id){
        Optional <NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.map(ninjaMapper::map).orElse(null);

    }
    public NinjaDTO CriarNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    public void deletarNinjaPoId( Long id){
        ninjaRepository.deleteById(id);
    }

    public NinjaDTO atualizarNinja( long id, NinjaDTO ninjaDTO){
      Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
      if(ninjaExistente.isPresent()){
          NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
          ninjaAtualizado.setId(id);  //sobreescrever o Id
         NinjaModel ninjaSAlvo =  ninjaRepository.save(ninjaAtualizado);
         return ninjaMapper.map(ninjaSAlvo);
      }
      return null;
    }
}

