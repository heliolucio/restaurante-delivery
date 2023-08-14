**Sistema de Controle de Restaurante Delivery**

Sistema que consiste realizar consulta, cadastro, alteração e deletar cliente, pedido e entrega de um restaurante.

**Requisitos Técnicos para utlizar o sistema:**
- Java 8
- Spring boot 2
- Maven
- Banco de Dados Firebird
- IDE utilizada STS
- Postman
  
  **OBS:**
  - Utilizado a seguinte versão do maven: 3.9.4
  - Utilizado o JDK 1.8.0_202.
  - Anexado o arquivo RESTAURANTE.FDB, contendo as tabelas utlizadas.
  - Utilizado postman para realização dos testes das API's.
 
  **Instalação**
  
  Realizar o clone ou download do código que se encontra na branch master e importar como projeto maven na IDE de sua escolha.
  
  Mover o arquivo RESTAURANTE.FDB que está na branch master, após o clone ou download, em um diretório de sua escolha e atualizar o path no arquivo application.properties.
  
  OBS: Usuário e senha de acesso a database, consta no arquivo application.properties.

  **Execução**

  Após importar o código, ir na classa Application.java, e executar a aplicação (botão direito -> debug as -> Spring boot App).
  Com o sistema inicializado acessar a seguinte URL:
  
  http://localhost:8080/swagger-ui/index.html
  
  Na URL acima contém a documentação dos end-points utlizados e realizar os testes.


