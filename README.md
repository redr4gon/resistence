**Subindo o projeto**

Somente é necessário fazer um clone do projeto e executa-lo. Nenhuma configuração adicional é necessária.

- É necessário o Java 11 instalado. O gradle não é necessário ja que ele possui o wrapper no projeto. É possível usa-lo digitando ./gradlew <comando>
- O projeto usa o banco de dados H2 que é embutido no sistema e reinicializado a cada deploy do projeto
- Inicialmente o H2 é vazio
- O profile é default, não é necessário informar
- Para subir o projeto após clona-lo, use o comando gradle na raíz do projeto em um terminal linux: "./gradlew bootRun"

**Bons e ruims**

- O projeto não tem cobertura de testes. Tem um teste inicial de que comecei a fazer e não terminei.
- Os endpoints foram todos testados. O que foi menos testado é o de trocas então ele pode ter algum problema ou falta de validação.
- Os itens poderiam ser cadastrados no banco de dados. Devido ao tempo dispónível que tenho, achei mais simples e rápido coloca-los como constantes.
- A documentação deveria ser criada com spring docs ou swagger mas o tempo disponível não permitia criar os testes para o primeiro ou as annotations para o segundo.
- Tentei criar divisões e separações ao máximo no projeto mas poderiam estar melhores. O relatório poderia estar melhor trabalhado também.
- O maior inimigo foi o tempo. O projeto é complexo para quem tem pouco tempo disponível.

**Endpoints**

Domain: local -> localhost:9090

1. Cadastrar rebelde - Cria um rebelde na base
   POST: /resistence/rebel

REQUEST

    {
    "name": "abc",
    "age": 21,
    "genre": "MALE",
    "localization": {
        "galaxyName" : "SPACE X",
        "latitude" : "12456",
        "longitude" : "123456"
    },
    "inventories": [
        {
            "inventoryType" : "GUN",
            "quantity" : 1
        }
    ]}



2. Alterar localização de um rebelde
   PUT - /resistence/rebel/{idRebelde}/localization

REQUEST

    {
        "galaxyName" : "SPACE X",
        "latitude" : "567890",
        "longitude" : "123456"
    }

3. Denunciar rebelde - adiciona 1 ponto de black force ao rebelde
   PUT - /resistence/rebel/{idRebelde}/black-force

4. Trocar itens - troca de itens entre rebeldes - personagens do lado negro nao podem trocar
   PUT - /resistence/inventory

REQUEST

    {
    "from" : {
        "rebelId" : 1,
        "items" : [
            {
                "inventoryType" : "GUN",
                "quantity" : 1
            }
        ]
    },
    "to" : {
        "rebelId" : 2,
        "items" : [
            {
                "inventoryType" : "GUN",
                "quantity" : 1
            }
        ]
    }
}


5. Relatórios
   Os relatórios são todos GET nos seguintes endpoints:
   /resistence/report/rebels - Para exibir todos os rebeldes em percentual
   /resistence/report/black-force - Para exibir todos os rebeldes que foram para o lado negro em percentual
   /resistence/report/points - Para exibir a contagem de pontuação de todos os itens de todos os rebeldes
   /resistence/report/inventory - Média dos itens dos rebeldes para cada rebelde e cada item
