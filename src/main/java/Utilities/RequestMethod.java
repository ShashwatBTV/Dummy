package Utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class RequestMethod {

    String baseURI;
    RequestSpecBuilder requestSpecBuilder;
    RequestSpecification requestSpecification;
    public RequestMethod(String baseURI){
        this.baseURI = baseURI;
        requestSpecBuilder = new RequestSpecBuilder();
        requestSpecification = given();
    }

    public JsonPath callGETAll(String API) {
        requestSpecBuilder.setBaseUri(baseURI);
        requestSpecBuilder.setBasePath(API);
        requestSpecification = requestSpecBuilder.build();
        Response response = given().spec(requestSpecification).get();
        String responseString = response.getBody().asString();
        JsonPath path = new JsonPath(responseString);
        return path;
    }
    public JsonPath callGET(String API,String id) {
        requestSpecBuilder.setBaseUri(baseURI);
        requestSpecBuilder.addPathParam("id",id);
        requestSpecBuilder.setBasePath(API);
//        requestSpecification.baseUri(baseURI);
//        requestSpecification.pathParam("id",id);
//        requestSpecification.basePath(API);
        requestSpecification = requestSpecBuilder.build();
        Response response = given().spec(requestSpecification).get();
        String responseString = response.getBody().asString();
        JsonPath path = new JsonPath(responseString);
        return path;
    }
    public JsonPath callPOST(HashMap header, String API, JSONObject empDetails){
        requestSpecBuilder.setBaseUri(baseURI);
        requestSpecBuilder.setBasePath(API);
        requestSpecBuilder.setBody(empDetails.toString());
        requestSpecification = requestSpecBuilder.build();
        Response response = given().spec(requestSpecification).post();
        String responseString = response.getBody().asString();
        JsonPath path = new JsonPath(responseString);
        return path;
    }
    public JsonPath callPUT(HashMap header, String API, String id, JSONObject empDetails){
        requestSpecBuilder.setBaseUri(baseURI);
        requestSpecBuilder.setBasePath(API);
        requestSpecBuilder.addPathParam("id",id);
        requestSpecBuilder.setBody(empDetails.toString());
        requestSpecification = requestSpecBuilder.build();
        Response response = given().spec(requestSpecification).put();
        String responseString = response.getBody().asString();
        JsonPath path = new JsonPath(responseString);
        return path;
    }
}