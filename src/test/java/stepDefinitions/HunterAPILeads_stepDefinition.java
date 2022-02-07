
package stepDefinitions;

import static org.hamcrest.Matchers.lessThan;

import java.util.concurrent.TimeUnit;

import org.json.JSONObject;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.HunterController;

public class HunterAPILeads_stepDefinition extends HunterController {

	@Given("que seja enviado soment os campos obrigatorios {string} preenchidos")
	public void que_seja_enviado_soment_os_campos_obrigatorios_preenchidos(String email) {
		setBody("{\r\n    \"email\": \"" + gerarAleatorio(10, "email")
				+ "@gmail.com\",\r\n    \"company\":\"Accenture\",\r\n    \"confidence_score\": 100\r\n}");

	}

	@Given("preencha o campo confident_score com o {int}")
	public void preencha_o_campo_confident_score_com_o(Integer int1) {
		setBody("{\r\n    \"email\": \"" + gerarAleatorio(10, "email")
				+ "@gmail.com\",\r\n    \"company\":\"Accenture\",\r\n    \"confidence_score\": 100\r\n}");

	}

	@When("executar uma requisicao {string}")
	public void executar_uma_requisicao(String retorno) {

		String URI = HunterController.urlBase + HunterController.endPoint + "?" + HunterController.token;

		if (retorno.toUpperCase().contains("POST")) {
			HunterController.response = HunterController.request.body(getBody()).when().post(URI).andReturn();

		} else {

			System.out.println("O valor selecionado nao e um verbo HTTP valido para o teste!");
			Assert.fail("O valor selecionado nao e um verbo HTTP valido para o teste!");
		}

	}

	@Then("espero que o codigo HTTP de retorno seja {int}")
	public void espero_que_o_codigo_http_de_retorno_seja(int code) {

		try {
			String URI = HunterController.urlBase + HunterController.endPoint + "?" + HunterController.token;
			Assert.assertTrue("Retorno 201", code == 201);

		} catch (Exception e) {
			Assert.fail("O status code retornado foi diferente do status code esperado: " + code);
		}

	}

	@Then("espero que o tempo de resposta seja menor que {long} segundos")
	public void espero_que_o_tempo_de_resposta_seja_menor_que_segundos(long tempo) {
		try {
			HunterController.response.then().time(lessThan(tempo), TimeUnit.SECONDS);
		} catch (Exception e) {
			Assert.fail(" O tempo para resposta expirou em: " + tempo + "segundos");
		}
	}

	@Then("espero que a estrutura de response body esteja igual ao documento")
	public void espero_que_a_estrutura_de_response_body_esteja_igual_ao_documento() {

		JSONObject responseBody = new JSONObject(HunterController.response.body().asString());
		JSONObject nodeData = responseBody.getJSONObject("data");
		int id = nodeData.getInt("id");

		String campoId = Integer.toString(id);
		Assert.assertTrue(campoId.matches("^\\d+$"));

		String email = nodeData.getString("email");
		Assert.assertTrue(email.matches("^\\S+@\\S+\\.\\S+$"));

		Object company = nodeData.get("company");
		Assert.assertTrue(company.toString().matches("^\\w+$"));

		int confidence = nodeData.getInt("confidence_score");
		String campoConfidence = Integer.toString(confidence);
		Assert.assertTrue(campoConfidence.matches("^\\d+$"));

	}

	
}
