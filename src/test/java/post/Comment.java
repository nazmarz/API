package post;
import RestAssuredCore.RESTCalls;
import com.google.gson.Gson;
import  com.google.gson.GsonBuilder;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;
import utils.TestUtils;

public class Comment {

    private String postId;
    private String id;
    private String name;
    private String email;
    private String body;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Comment [postId=" + postId + ", id=" + id
                + ", name=" + name + ", email=" + email + ", body="
                + body + "]";
    }

    @Test
    public void getCall() {
        Response response = RESTCalls.GETRequest("https://jsonplaceholder.typicode.com/comments");
        String bodyStringValue = TestUtils.getResposeString(response);
        Gson gson = new GsonBuilder().create();
//        Comment comment = gson.fromJson(bodyStringValue, Comment.class);
        Comment[] comment = gson.fromJson(bodyStringValue, Comment[].class);
        System.out.println(comment);
        System.out.println("This is a test");
    }

}









