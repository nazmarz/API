package post;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.get;

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
    public void commentsDeserialization() {

        //Retrieving comments from endpoint /comments and deserializing response into the collection of objects 'Comment'
        Comment[] myDeserializedComments = get("https://jsonplaceholder.typicode.com/comments").as(Comment[].class);

        /* This is to check that the de-serialization was successful
        for(int i=0; i<myDeserializedComments.length; i++){
            System.out.println(myDeserializedComments[i].toString());
        }*/

        // Removes all comments from the collection that has postId different than 1
        Comment[] myFilteredComments = new Comment[myDeserializedComments.length];
        int j = 0;
        for (int i = 0; i < myDeserializedComments.length; i++) {
            if ((myDeserializedComments[i].getPostId()).equals("1")) {
                myFilteredComments[j++] = myDeserializedComments[i];
            }
        }

        for(int i=0; i<myFilteredComments.length; i++){
            if (myFilteredComments[i]!=null) {
                System.out.println(myFilteredComments[i].toString());
            }
        }

        //Removes all comments that do not contain word "non" in the body
        Comment[] myNonComments = new Comment[myDeserializedComments.length];
        int k = 0;
        for (int i = 0; i < myDeserializedComments.length; i++) {
            if ((myDeserializedComments[i].getBody()).contains("non")) {
                myNonComments[k++] = myDeserializedComments[i];
            }
        }

        for (int i = 0; i < myNonComments.length; i++) {
            if (myNonComments[i] != null) {
                System.out.println(myNonComments[i].toString());

            }

        }
    }
}







