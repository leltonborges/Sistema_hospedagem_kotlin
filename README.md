# Sistema de hospedagem

## Repositorios
+ [Github](https://github.com/leltonborges/Sistema_hospedagem_kotlin)
+ [CI/CD](https://github.com/leltonborges/Sistema_hospedagem_kotlin/blob/main/.github/workflows/docker-publish.yml)
+ [Image Docker](https://hub.docker.com/r/leltondev/sistema-hospedagem)

## Pré requisitos
Ferramentas que deve está instaladas e configuradas na máquina
+ Java 11+
+ Gradle 7+

## Gerando executavel

```shell
$ git clone https://github.com/leltonborges/Sistema_hospedagem_kotlin.git
$ cd Sistema_hospedagem_kotlin
$ ./gradlew build
```
## Executando
```shell
$ cd build/libs/
$ java -jar reserva-hotel-0.0.1-SNAPSHOT.jar
```
+ Se quer especificar outra porta para aplicação
```shell
$ java -DPORT_SERVER=9000 -jar reserva-hotel-0.0.1-SNAPSHOT.jar
```

## Documentação API
Depois de suber a aplicação acesse a url `http://localhost:8090/v1/swagger-ui/index.html`

## Banco de dados
Banco de dados usado é o H2, você pode acessa o banco pelo o navegador enquanto a aplicação esta em execução através da url: `http://localhost:8090/v1/h2-console`

Dados de acesso ao bonco
+ JDBC URL: `jdbc:h2:mem:hospedagem`
+ User Name: `sa`
+ Password: 

Foi inserido automaticamente valores durante a inicialização da aplicação, usando migrations do flyway.


## Observações
+ Não há camada de seguranção com o spring security
+ Não há todas as validações
+ Não há todas as capturas de exceções
+ Eu não importei muito com a formatação das messagem de erro.

### Pontos a serem observados
+ Não é possivel remover dados (tuplas) que possuem chave estrangeira, para isso é necessario deleta suas referencias antes da mesma. 
+ Não é possível enviar dados em outros formatos como yaml ou xml, a aplicação está configurada apenas para json

### Endpoints
Nos endpoints que contém propriedades do tipo data, seu formato é `dd/MM/yy HH:mm`, exemplo:
+ Endpoint Diaria
  + `/diaria` com http metodo `POST` 
  + O formato do campo `dataEntrada` é  `dd/MM/yy HH:mm`
  ```json
  {
    "dataEntrada": "11/06/2022 11:30",
    "qtdDias": 0,
    "precoDiaria": 0
  }
  ```