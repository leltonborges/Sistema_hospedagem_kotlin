# Sistema de hospedagem

## Pré requisitos
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

Foi inserido automaticamente valores durante a inicialização da aplicação.
