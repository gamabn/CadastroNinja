package store.gamabn.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public NinjaModel map(NinjaDTO ninjaDto){
        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDto.getId());
        ninjaModel.setNome((ninjaDto.getNome()));
        ninjaModel.setEmail(ninjaDto.getEmail());
        ninjaModel.setImgUrl(ninjaDto.getImgUrl());
        ninjaModel.setMissoes(ninjaDto.getMissoes());
        ninjaModel.setDificuldade(ninjaDto.getDificuldade());
        return ninjaModel;

    }

    public NinjaDTO map(NinjaModel ninjaModel){
        NinjaDTO ninjaDto = new NinjaDTO();
        ninjaDto.setId(ninjaModel.getId());
        ninjaDto.setNome(ninjaModel.getNome());
        ninjaDto.setImgUrl(ninjaModel.getImgUrl());
        ninjaDto.setIdade(ninjaModel.getIdade());
        ninjaDto.setDificuldade(ninjaModel.getDificuldade());
        ninjaDto.setMissoes(ninjaModel.getMissoes());
        return ninjaDto;


    }
}
