//package stepDefinitions;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import utils.HunterController;
//import static org.hamcrest.Matchers.lessThan;
//
//import java.util.concurrent.TimeUnit;
//
//import org.junit.Assert;
//
///*Ricardo tentei deixar tudo em um unico step mas fica dando duplicidade por isso criei dois não soube como fazer a unificacao de ambos os steps. 
// * Por este motivo a classe esta comenta porque para rodar um a outra precisa ser comentada */
//
//
//public class HunterAPICt04_stepDefinition extends HunterController {
//	
//	
//	@Given("que possua um lead cadastrado no sistema")
//	public void que_possua_um_lead_cadastrado_no_sistema() {
//		
//		setBody("{\r\n    \"email\": \"" + gerarAleatorio(10, "email")
//		+ "@gmail.com\",\r\n    \"company\":\"Accenture\",\r\n    \"confidence_score\": 100\r\n}");
//
//	}
//
//	@Given("preencher o campo {string}")
//	public void preencher_o_campo(String empresa) {
//		setBody("{\r\n    \"company\": \"" + empresa + "\"\r\n}");
//	}
//
//	@When("executar uma requisicao HTTP {string}")
//	public void executar_uma_requisicao_http(String retorno2) {
//		
//		String URI = HunterController.urlBase + HunterController.endPoint + "?" + HunterController.token;
//
//		if (retorno2.toUpperCase().contains("PUT")) {
//			HunterController.response = HunterController.request.body(getBody()).when().put(URI).andReturn();
//
//		} else {
//
//			System.out.println("O valor selecionado nao e um verbo HTTP valido para o teste!");
//			Assert.fail("O valor selecionado nao e um verbo HTTP valido para o teste!");
//		}
//	}
//
//	@Then("espero que o codigo HTTP de retorno seja {int}")
//	public void espero_que_o_codigo_http_de_retorno_seja(Integer code2) {
//		
//		try {
//			String URI = HunterController.urlBase + HunterController.endPoint + "?" + HunterController.token;
//			Assert.assertTrue("Retorno 201", code2 == 204);
//
//		} catch (Exception e) {
//			Assert.fail("O status code retornado foi diferente do status code esperado: " + code2);
//		}
//	}
//
//	@Then("espero que o tempo para a resposta seja menor que {int} segundos")
//	public void espero_que_o_tempo_para_a_resposta_seja_menor_que_segundos(long tempo) {
//		
//		try {
//			HunterController.response.then().time(lessThan(tempo), TimeUnit.SECONDS);
//		} catch (Exception e) {
//			Assert.fail(" O tempo para resposta expirou em: " + tempo + "segundos");
//		}
//	}
//}