# Dependencias #
- Java 8.
 
# Como executar #
- Na raiz do projeto conceder permissão de execução para install.sh e executar. Esse script vai compilar
e instalar o sistema. 
```shell
$ chmod +x install.sh
$ ./install.sh
```
- Executar o jar passando nome do arquivo por parametro no shell.
 Isso vai iniciar a Interface console(Terminal) e Api(localhost:8080/api/route)
```shell
$ java -jar target/viagem.jar input-routes.csv
```

# Testes #
```shell
$ ./mvnw test
```

# Estrutura #

```
 --raiz
   --src
        --main.java.com.bexs.viagem (Pacote de Implementação)
             --dao
                 --RouteDAO.java
             --file
                 --LoadFile.java
                 --ReadFile.java
                 --WriteFile.java
             --model
                 --Route.java
                 --Viagem.java
             --util
                 --BestRouteImpl.java
                 --BestRouteInterface.java
             --Console.java (Interface Console)
             --RouteAPI.java (Interface Rest)
             --ViagemApplication.java
        --test.java.com.bexs.viagem (Pacote de Tests)
             --dao
                 --RouteDAOTest.java
             --file
                 --LoadFileTest.java
                 --ReadFileTest.java
                 --WriteFileTest.java
             --model
                 --RouteTest.java
                 --ViagemTest.java
             --util
                 --BestRouteImplTest.java
             --ConsoleTest.java
   --input-routes.csv
   --install.sh
   --pom.xml
   --README.md (como executar a aplicacao)
```
# Design #
1. Utilizei MVC: (Model - Route, Viagem)
 (View - Console,RouteAPI)
  (Controller - RouteDAO,BestRouteImpl) 
2. Solid: Separei as responsabilidades que cada classe vai desempenhar no sistema
3. Solid: Cada metodo tem somente uma responsabilidade
4. Solid: Criei as classes para serem facilmente testadas
5. API: Utilizei Spring boot para expor um rest


# API #
- 1- Consulta de melhor rota entre dois pontos.
```
GET
localhost:8080/api/route/{de}/{para}

EXEMPLO: localhost:8080/api/route/GRU/CDG

RETORNO application/text: GRU - BRC - SCL - ORL - CDG > $40.0
```
- 2- Registro de novas rotas. persistidas no arquivo csv input-routes.csv.
```
POST
localhost:8080/api/route

BODY: application/json 

EXEMPLO: { 
         	"from":"GRU",
         	"to":"BRH",
         	"val":33
         }

RETORNO void
```



