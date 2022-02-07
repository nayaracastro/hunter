@leads
Feature: HunterIO_APILeads
  API com um CRUD para leads da Hunter.io na parte de CREATE

  @Ct02
  Scenario Template: Requisição de criaçao de leads com apenas os campos obrigatorios preenchidos 
    Given que seja enviado soment os campos obrigatorios <email> preenchidos
    And preencha o campo confident_score com o <confidentScore>
    When executar uma requisicao <Metodo>
    Then espero que o codigo HTTP de retorno seja <StatusCode>
    And espero que o tempo de resposta seja menor que <Segundos> segundos
    And espero que a estrutura de response body esteja igual ao documento

    Examples: 
 |email                 			  |confidentScore   |Metodo		|StatusCode  |Segundos|
 |"Natasha.Emard@gmail.com"     |100					    |"POST"		|201			 	 |5				|
 


 