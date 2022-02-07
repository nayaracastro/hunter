package utils;

import java.util.Random;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HunterController {
	
	private String body;
	private static String param;
	protected static String urlBase = "https://api.hunter.io";
	private Integer id;
	protected static String endPoint = "/v2/leads";
	protected static String token = "api_key=08f07815026a4f5680d9507b200243212ef1a452";
	protected static Response response;
	protected static RequestSpecification request;
	
	
	
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public static String getParam() {
		return param;
	}
	public static void setParam(String param) {
		HunterController.param = param;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	
	
	
	public static String gerarAleatorio(int tam, String tipo) {

		char[] elementosMisto = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g',
				'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B',
				'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
				'X', 'Y', 'Z' };

		char[] elementoAlfa = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g',
				'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B',
				'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
				'X', 'Y', 'Z' };
		char[] conteudoGerado = new char[tam];
		int tamanhoArray = elementosMisto.length;
		int tamanhoArrayDominio = elementoAlfa.length;

		Random random = new Random();

		
		if (tipo == "letras") {
			for (int i = 0; i < tam; i++) {
				conteudoGerado[i] = elementoAlfa[random.nextInt(tamanhoArrayDominio)];

			}

		} else if (tipo == "email" && !tipo.isEmpty()) {
			
			for (int i = 0; i < tam; i++) {
				conteudoGerado[i] = elementosMisto[random.nextInt(tamanhoArray)];
				
			}

		}

		return new String(conteudoGerado);
	}
	
	

}
