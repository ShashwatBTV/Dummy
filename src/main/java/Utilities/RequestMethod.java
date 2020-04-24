package Utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.json.JSONString;

import java.util.HashMap;
import static io.restassured.RestAssured.given;

public class RequestMethod {

    String baseURI;
//    RequestSpecBuilder requestSpecBuilder;
    public static RequestSpecification requestSpecification;
    public RequestMethod(String baseURI){
        this.baseURI = baseURI;
        requestSpecification = new RequestSpecBuilder().build();
//        requestSpecBuilder = new RequestSpecBuilder();
    }

//    public JsonPath callGETAll(String API) {
//        requestSpecBuilder.setBaseUri(baseURI);
//        requestSpecBuilder.setBasePath(API);
//        requestSpecification = requestSpecBuilder.build();
//        Response response = given().spec(requestSpecification).get();
//        String responseString = response.getBody().asString();
//        JsonPath path = new JsonPath(responseString);
//        return path;
//    }
    public JsonPath callGET(String API,String id) {
//        requestSpecBuilder.setBaseUri(baseURI);
//        requestSpecBuilder.addPathParam("id",id);
//        requestSpecBuilder.setBasePath(API);
        requestSpecification.baseUri(baseURI);
        requestSpecification.pathParam("id",id);
        requestSpecification.basePath(API);
//        requestSpecification = requestSpecBuilder.build();
        Response response = given().spec(requestSpecification).get();
        String responseString = response.getBody().asString();
        JsonPath path = new JsonPath(responseString);
        return path;
    }
    public JsonPath callPOST(HashMap header, String API, JSONObject empDetails){
        Response response = given().headers(header).
                body(empDetails).
                when().post(API).
                then().extract().response();
        String responseString = response.getBody().asString();
        JsonPath path = new JsonPath(responseString);
        return path;
    }
    public JsonPath callPUT(HashMap header, String API, String id, JSONObject empDetails){
        Response response = given().headers(header).
                with().pathParam("id",id).
                body(empDetails).
                when().put(API).
                then().extract().response();
        String responseString = response.getBody().asString();
        JsonPath path = new JsonPath(responseString);
        return path;
    }
}