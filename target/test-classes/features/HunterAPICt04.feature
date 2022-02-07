@leads
Feature: HunterIO_APILeads
  API com um CRUD para leads da Hunter.io na parte de UPDATE
 
 @Ct04
  Scenario Template: Requisição para editar a empresa em um lead ja existente na base de dados 
    Given que possua um lead cadastrado no sistema
    And preencher o campo <company>
    When executar uma requisicao HTTP <Metodo>
    Then espero que o codigo HTTP de retorno seja <StatusCode>
    And espero que o tempo para a resposta seja menor que <Segundos> segundos
    
    
      Examples: 
   	 |company  |Metodo		|StatusCode  |Segundos|
     |"Nubank" |"PUT"			|204			 	 |5				|