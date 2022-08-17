# forum-apirest

## Objetivos e Responsabilidades
#### forum.controller
Disponibilizar o acesso aos endpoints desenvolvidos.
Quando startamos a aplicação e acessamos o endpoint,
é nas classes de controller que o primeiro acesso é feito.

#### forum.service
Fazer o tratamento dos dados recebidos nas requisições.
São nas classes services que podemos incluir regras de negócio,
orquestrar chamadas para banco de dados e tratar dados para response.

#### forum.dto
Contrato (simplificado ou não) dos endpoints.
Nessas classes que definimos os campos de request e response para os endpoints.

#### forum.mapper
Fazer a transformação dos objetos DTO em models e vice versa.
Nem sempre um DTO será igual a uma model, em muitos casos o objeto a ser armazenado na aplicação 
não tem o mesmo corpo de um DTO. Para exemplificar: avalie a classe `TopicoFormMapper.kt` e a Model `Topico.kt`. 
Ambas são referentes ao mesmo objeto. O DTO possui um corpo mais simplificado pelos campos faltantes serem capturados
em uma possível base de dados, e não de um frontend.

#### forum.model
São contratos dos endpoints mas não necessariamente iguais aos DTOs.
As classes contidas em model são responsáveis por manter um contrato dos recursos a serem trabalhados
no projeto de uma maneira mais detalhada e completa. Normalmente abrangem todas as informações necessárias
para que a aplicação funcione com sucesso, sejam elas capturadas do frontend, base de dados, outras APIs, etc.

#### bean validation
Insere regras para o preenchimento dos campos. Exemplo: tamanho, se pode vir nulo ou vazio, etc.

----------------------
### Autor

<img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/37076921?v=4" width="100px;" alt=""/>

<sub><b>Bruno Durante</b></sub> 💻

Desenvolvido por Bruno Durante.
Tem algum feedback? Quer trocar uma ideia sobre o projeto?
👋🏽 Entre em contato!

[![Linkedin Badge](https://img.shields.io/badge/-Bruno-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/brunodurante/)](https://www.linkedin.com/in/brunodurante/)
[![Gmail Badge](https://img.shields.io/badge/-brunodurantec@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:brunodurantec@gmail.com)](mailto:brunodurantec@gmail.com)

