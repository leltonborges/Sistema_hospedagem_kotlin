package dev.project.reservahotel.mapper

import dev.akkinoc.spring.boot.orika.OrikaMapperFactoryConfigurer
import dev.project.reservahotel.dtos.*
import dev.project.reservahotel.entities.*
import dev.project.reservahotel.services.EnderecoService
import dev.project.reservahotel.services.HotelService
import ma.glasnost.orika.CustomMapper
import ma.glasnost.orika.MapperFactory
import ma.glasnost.orika.MappingContext
import org.springframework.context.annotation.Configuration

@Configuration
class MappingConfig: OrikaMapperFactoryConfigurer {

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
            .byDefault()
            .register();

        orikaMapperFactory.classMap(QuartoDTO::class.java, Quarto::class.java)
            .field("qtdCama", "qtdCama")
            .byDefault()
            .register();

        orikaMapperFactory.classMap(DiariasDTO::class.java, Diarias::class.java)
            .field("dataEntrada", "dataEntrada")
            .field("qtdDias", "qtdDias")
            .byDefault()
            .register();

    }
}
