# Dificultades

1. [x] no podia acceder a la consola h2 ni a la documentacion swagger Aplique excepciones a seguridad para poder acceder a swagger y h2 sin tener aun la capa de autenticacion, esto lo logre implementando SecurityConfig, esto es solo para facilitar el desarrollo en ningun caso deberia llegar algo asi a produccion y espero quitarlo cuando tenga una capa de autenticacion.

2. [x] Utilizando mapstruct no me generaba los beans de los mappers al compilar lo resolvi agregando
```
<dependency>
    <groupId>org.mapstruct</groupId>
    <artifactId>mapstruct-processor</artifactId>
    <version>1.5.5.Final</version>
    <scope>provided</scope>
</dependency>
```
