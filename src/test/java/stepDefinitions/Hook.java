package stepDefinitions;
import io.cucumber.java.Before;

import utils.HunterController;
import static io.restassured.RestAssured.*;

public class Hook extends HunterController {

	@Before
	public void initTest() {
		HunterController.request = given().header("Accept", "application/json")
				.header("Content-Type", "application/json");

	}

}
