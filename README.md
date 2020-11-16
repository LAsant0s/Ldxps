# LDXPS

Crud básico de vendedores e seus clientes, construído com ``Java``, ``Springboot``, ``thymeleaf`` e banco de dados ``MySQL``

![image](https://user-images.githubusercontent.com/60989242/99205277-da8a3380-2796-11eb-841e-4bf5e1f1e16c.png)
![image](https://user-images.githubusercontent.com/60989242/99205877-95670100-2798-11eb-8b46-37a2df35c3ee.png)
![image](https://user-images.githubusercontent.com/60989242/99205904-add71b80-2798-11eb-81f1-f5a65c481a18.png)

O sistema possui a seguintes funcionalidades: 

  - Listagem de Vendedores
  - Listagem de Clientes relacionados a um Vendedor ou todos os Clientes cadastrados 
  - Criação e edição de Vendedores
  - Criação e edição de Clientes
  - Exclusão de Vendores e Clientes.
 
## Configuração do projeto

Para a execução do projeto, é necessário rodar o script de criação das tabelas presente no arquivo ``script-criacao.sql``;
Também é preciso preecher com as informações corretas o arquivo ``ldxps/src/main/java/com/assis/ldxps/config/FabricaDeConexao.java``
