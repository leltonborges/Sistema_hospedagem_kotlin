package dev.project.reservahotel.mapper

import dev.akkinoc.spring.boot.orika.OrikaMapperFactoryConfigurer
import dev.project.reservahotel.dtos.EnderecoDTO
import dev.project.reservahotel.entities.Endereco
import ma.glasnost.orika.CustomMapper
import ma.glasnost.orika.MapperFactory
import ma.glasnost.orika.MappingContext
import org.springframework.stereotype.Component

@Component
class EnderecoMapping : OrikaMapperFactoryConfigurer {

    override fun configure(orikaMapperFactory: MapperFactory) {
        orikaMapperFactory.classMap(EnderecoDTO::class.java, Endereco::class.java)
            .field("logradouro", "logradouro")
            .field("numero", "numero")
            .field("cidade", "cidade")
//            .customize(customField)
            .byDefault()
            .register()
    }

    // Example custom
    private val customField = object  : CustomMapper<EnderecoDTO, Endereco>(){
        override fun mapAtoB(dto: EnderecoDTO?, entity: Endereco?, context: MappingContext?) {
            if (entity != null && dto != null) {
                entity.logradouro = dto.logradouro
                entity.numero = dto.numero
                entity.cidade = dto.cidade
            }
        }
    }
}