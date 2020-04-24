package APIRepo;

import Utilities.CommonData;
import Utilities.PropertySetter;
import Utilities.RequestMethod;
import io.restassured.path.json.JsonPath;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Employee {

    PropertySetter propSet = new PropertySetter();
    RequestMethod request;
    CommonData commonHeaders = new CommonData();
    HashMap<String, String> headers = commonHeaders.getHeader();

    public Employee(String baseURI){
        request = new RequestMethod(baseURI);
    }

    public void getAllEmployee() {
        JsonPath path = request.callGETAll(propSet.getAllEmployees());
        //path.prettyPrint();
        ArrayList allEmployees = path.get("data");
        for(int i=0;i<allEmployees.size();i++){
            Map employeeDetail = (Map)allEmployees.get(i);
            System.out.println(employeeDetail.get("id")+" "+employeeDetail.get("employee_name")
                +" "+employeeDetail.get("employee_salary")+" "+employeeDetail.get("employee_age"));
        }
    }

    public void getEmployeeById(String id){
        JsonPath path = request.callGET(propSet.getEmployeeById(),id);
        path.prettyPrint();
    }

    public String addEmployee(){
        JSONObject requestParams = propSet.getEmployeeDetails();
        JsonPath path = request.callPOST(headers,propSet.addEmployee(),requestParams);
        //path.prettyPrint();
        Map employeeDetails = (Map)path.get("data");
        String newID = (String) employeeDetails.get("id");
        return newID;
    }

    public void updateEmployee(String id){
        JSONObject requestParams = propSet.getEmployeeDetails();
        JsonPath path = request.callPUT(headers,propSet.updateEmployee(),id, requestParams);
        path.prettyPrint();
    }
}