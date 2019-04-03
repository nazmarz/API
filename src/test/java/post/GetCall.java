package post;

import RestAssuredCore.BaseAssertion;
import RestAssuredCore.RESTCalls;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestUtils;
import utils.URL;

public class GetCall {
    @Test
    public void getCall(){

        //Making GET on /comments endpoint
        Response response = RESTCalls.GETRequest("https://jsonplaceholder.typicode.com/comments");

        //Asserting the response code
        BaseAssertion.verifyStatusCode(response,200);

        //Asserting that the number of comments is 500 (greater than 0)
        int sizeOfList = response.body().path("list.size()");;
        Assert.assertEquals(sizeOfList,500);

        //Asserting that the body has comment with email: "Jayne_Kuhic@sydney.com"

        String bodyStringValue = TestUtils.getResposeString(response);
        Assert.assertTrue(bodyStringValue.contains("Jayne_Kuhic@sydney.com"));
    }



    }

