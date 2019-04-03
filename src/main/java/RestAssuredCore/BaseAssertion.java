package RestAssuredCore;

import io.restassured.response.Response;
import org.testng.Assert;
import utils.TestUtils;

public class BaseAssertion {

	public static void verifyStatusCode(Response response, int status){
		Assert.assertEquals(TestUtils.getStatusCode(response), status);
	}

}
