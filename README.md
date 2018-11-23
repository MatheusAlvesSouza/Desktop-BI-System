# Native Human

O sistema foi criado para a administração de reservas indígenas espalhados pela ámerica. Inicialmente o projeto só está implementado para reservas indígenas no Brasil, porém foi desenvolvido de forma **escalável para outras regiões**

## Dependências

- Java 1.8
- MySQL ou MariaDB
- mysql-connector-java-5.1.47 (Modo dev). Extraído em .jar e alterar o arquivo `.classpath` com o path correto.

## Quick Start

Todos os passos são realizados dentro de um CMD/Terminal.

1. Primeiramente clone o projeto em qualquer pasta de sua preferência.

2. Dentro do console do Banco de dados digite em sequência:
    - ```sql
        create database native_human;
        ```
    - ```sql 
        use native_human;
        ```
    - ```sql 
        source [CAMINHO LOCAL ATÉ O DIRETÓRIO DO PROJETO]/src/br/unip/backupsql/dump.sql;
        ```
3. Agora fora do Banco de dados digite:
    - `` cd [CAMINHO LOCAL ATÉ O DIRETÓRIO DO PROJETO]``
    - `` java -jar ./src/br/unip/jar/native_human.jar ``

4. Com o DashBoard do projeto aberto, já é possível realizar inserções e atualizações de cadastros. As taxas de **natalidade e mortalidade** são calculadas em escalada reduzida de número de nascimentos ou falecimentos para cada **50 Habitantes**. Elas inicialmente veem zeradas, e para verificar novas taxas é só simplesmente adicionar novos índios a uma reserva ou excluí-los no menu da Reserva. O projeto está em escala inicial, mas durante o desenvolvimento do próprio, o grupo percebeu um leque de **features** que podem ser implementadas com mais tempo, como por exemplo o uso de AI para predições da quantidade de Índios no país, um relacionamento mais completo da Região aonde é registrado Denúncias com essas taxas. Enfim, é um projeto enorme que tem um enorme potêncial de uso para ONGS, Municipios e até mesmo o Governo Federal.


