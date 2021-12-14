

# Api utilizando Java , Spring Boot e  MySql

Detalhes de implementação:

1. Java versão 11 pom.xml

   ```xml
   	<properties>
   		<java.version>11</java.version>
   	</properties>
   ```

2. Banco de dados relacional MySql

   ```XML
   		<dependency>
   			<groupId>mysql</groupId>
   			<artifactId>mysql-connector-java</artifactId>
   			<scope>runtime</scope>
   		</dependency>
   ```

3. Api documentada com Swagger:

   Endpoints no swagger através do link: http://localhost:8080/swagger-ui/

   <div align="center"><img src="https://i.imgur.com/q5h9axJ.png" title="source: imgur.com" /></div>

4. Teste unitáro com Junit:

   <div align="center"><img src="https://i.imgur.com/WO6NrXL.png" title="source: imgur.com" /></div>

5. Endpoint /listagem paginado:

   <div align="center"><img src="https://i.imgur.com/TnHAl6C.png" title="source: imgur.com" /></div>



