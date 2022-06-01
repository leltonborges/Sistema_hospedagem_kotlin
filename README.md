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
+ Se que especificar outra porta para aplicação
```shell
$ java -DPORT_SERVER=9000 -jar reserva-hotel-0.0.1-SNAPSHOT.jar
```