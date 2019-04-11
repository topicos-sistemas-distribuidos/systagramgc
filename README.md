# SysTagram Google Cloud
Aplicação para postar fotos e receber comentários rodando em uma instância local apontando para o Bucket e Banco do Google Cloud.  

Features
---

1. Controle de autenticação (Login/Logout)
2. Dashboard de usuário de acordo com sua permissão
3. Controle de permissões (Admin/User)
4. Controle de uploads de arquivos
5. Gerenciar Fotos
6. Gerenciar Posts 
7. Gerenciar Comentários nos posts

Sobre as operações para execução da aplicação
---

1. Faça o clone do repositório.

2. Criação do Bucket no Google Cloud Storage. 
* systagram-bucket

3. Adicionar a dependência do cloud storage no nosso projeto. Para isso, vá até o pom.xml.

<dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>google-cloud-storage</artifactId>
    <version>1.14.0</version>
</dependency>

4. Criar uma classe para salvar os arquivos no Bucket criado.

5. Criar uma chave de acesso da aplicação para o projeto do Google Cloud.

Devemos configurar a chave de acesso que será utilizada pela nossa aplicação para que possamos assim salvar as imagens nesse Bucket que criamos.

Obs: Nós temos que ter as chaves de acesso com as permissões de envio de arquivos para o Bucket, precisamos fazer essa configuração na próxima etapa.

Obs: Nós precisamos de uma chave com as credenciais necessárias que será utilizada por nossa aplicação para enviar as imagens.

6. API

a) Criar Google Service Key

permitir-acesso-servicos-google-cloud

Feito isso, devemos dar o nome para essa credencial que estamos configurando, podemos dar o nome que desejarmos, por exemplo permitir-acesso-servicos-google-cloud e na permissão Role escolha que tal conta terá a possibilidade de realizar edição no projeto, sendo assim possível tanto de realizar a leitura como a escrita de dados. Escolha a opção Editor para essa conta, para finalizar, faça o download da chave no formato JSON para que nossa aplicação que ainda está no ambiente local de desenvolvimento salve as imagens no Bucket.

A criação do objeto Storage na classe FileSaver vai procurar essas credencias de acesso presentes no arquivo JSON através da variável de ambiente GOOGLE_APPLICATION_CREDENTIALS, precisamos configurar na nossa máquina essa variável de ambiente:

Para configurar a variável de ambiente no MAC:  

touch ~/.bash_profile
open -a TextEdit.app ~/.bash_profile
export GOOGLE_APPLICATION_CREDENTIALS=[Local da chave]

b) Outra opção é passar o arquivo direto no código. Veja exemplo da appspring.

7. Criar o banco de dados no Google Cloud (sql-systagramgc)
a) Criar o banco
b) Liberar o acesso de IP público. Para isso, clique em Show configuration options e na parte de redes autorizadas Authorize Networks coloque o endereço 0.0.0.0/0

Obs: nesse ponto já pode fazer um teste local apontando para o Bucket e o Banco do Google Cloud. 

8. É preciso ter o mysql 5 instalado na sua instância do Google Cloud SQL.

9. Crie o banco dbsysweb e aponte para o banco.
```
mysql> create database dbsysweb
mysql> use dbsysweb
```
10. Rode, na instância do Google Cloud SQL, o script restaura-dbsysweb.sql para criar as tabelas com os dados de exemplo.
```
mysql> source scripts/sql/restaura-dbsysweb.sql
```
11. Usuário admin (armando) tem senha armando.

12. Limpe o projeto via comando clean do maven.
```
$mvn clean
```
13. Compile o projeto via modo teste do maven. 
```
$mvn test
```
14. Execute a classe principal (SystemApplication) do projeto via maven. 
```
$mvn spring-boot:run
```
15. Para os ambientes POSIX, é possível integrar todos esses comandos no seguinte pipe:
```
$mvn clean && mvn test && mvn spring-boot:run
```
Por padrão a aplicação roda em http://localhost:8080

Characteristics
---

* Spring Boot;
* Spring Security for basic login with permissions;
* Thymeleaf para view;
* Mysql Database or others;
* Basic entity crud;
* Google Cloud Storage
* Google Cloud SQL

TODO
---

* Search in the listing;
* Model of Dialog;
* Template for sending e-mail with template;

About Spring-boot packaging
---

1. Adding Classpath Dependencies
```
$mvn dependency:tree
```

2. Running the Example
Since you used the spring-boot-starter-parent POM, you have a useful run goal that you can use to start the application
```
$mvn spring-boot:run
```
3. How to test, execute and package the application?
You have to put Classpath Dependencies
```
$mvn dependency:tree
```
3.2. If you want to run the example directly from main path source code
```
$mvn spring-boot:run
```
3.3. If you want to create .jar package application. 
The packaget application .jar are archives containing your compiled classes along with all of the jar dependencies that your code needs to run.
```
$mvn clean package
```
3.4 To run that application, use the java -jar command, as follows:
```
$java -jar target/artefactId-version.jar
```
For further details click the link below to read full article about spring-boot packaging: 
https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started-first-application.html#getting-started-first-application-pom

Special Configurations
---
For database security, datasource, jpa, thymeleaf and session configuration you have to change values in src/main/resources/sql/security.sql and src/main/resources/application.properties

References
---

[1] Spring MVC 4. Java Framework for MVC Web Applications. Available at https://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html

[2] Spring Boot 1. It is a Java Framework (based on the Spring Platform) for web applications that use inversion control container for the Java platform. Available at https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-security

[3] Thymeleaf. It is a Java / XHTML / HTML5 Java model engine that can work in both web (servlet-based) and non-web environments. It is best suited to serve XHTML / HTML5 in the MVC-based web application preview layer. Available at https://www.thymeleaf.org

[4] Bootstrap. Vision layer framework for responsive web applications. Available at https://v4-alpha.getbootstrap.com/getting-started/introduction

[5] JQuery. JavaScript Function Library. Available at https://jquery.com

[6] ORM JPA. Abstartion of data access. Available at https://docs.spring.io/spring-data/jpa/docs/current/reference/html

[7] Spring Security. It is a Java framework that provides an access control framework for Java / Java EE applications that provides authentication, authorization, and other security features for enterprise applications. Available at https://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle

[8] Maven. Management of Builds and Dependencies. Available at https://maven.apache.org

[9] Mysql 5. Database Management System. Available at https://dev.mysql.com/downloads/mysql

[10] AdminLTE. Control panel template for web applications. Available at https://adminlte.io/themes/AdminLTE/index.html

[11] Google Cloud. Available at https://console.cloud.google.com

Questions, suggestions or any kind of criticism contact us by email armando@ufpi.edu.br