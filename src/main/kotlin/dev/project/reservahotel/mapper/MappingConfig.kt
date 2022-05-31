package dev.project.reservahotel.mapper

import dev.akkinoc.spring.boot.orika.OrikaMapperFactoryConfigurer
import dev.project.reservahotel.dtos.EnderecoDTO
import dev.project.reservahotel.dtos.QuartoDTO
import dev.project.reservahotel.dtos.TelefoneDTO
import dev.project.reservahotel.entities.Endereco
import dev.project.reservahotel.entities.Quarto
import dev.project.reservahotel.entities.Telefone
import ma.glasnost.orika.CustomMapper
import ma.glasnost.orika.MapperFactory
import ma.glasnost.orika.MappingContext
import org.springframework.context.annotation.Configuration

@Configuration
class MappingConfig : OrikaMapperFactoryConfigurer {

    override fun configure(orikaMapperFactory: MapperFactory) {
        orikaMapperFactory.classMap(TelefoneDTO::class.java, Telefone::class.java)
            .field("numero", "numero")
            .field("ddd", "ddd")
            .byDefault()
            .register();

        orikaMapperFactory.classMap(EnderecoDTO::class.java, Endereco::class.java)
            .field("logradouro", "logradouro")
            .field("numero", "numero")
            .field("cidade", "cidade")
//            .customize(customField)
            .byDefault()
            .register();

        orikaMapperFactory.classMap(QuartoDTO::class.java, Quarto::class.java)
            .field("qtdCama", "qtdCama")
            .byDefault()
            .register();
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
