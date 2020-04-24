package Utilities;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class PropertySetter {

    public static Properties prop;

    public PropertySetter() {
        prop = new Properties();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader("src/main/resources/Api_Data.properties"));
            prop.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getAllEmployees(){
        String API_PATH = prop.getProperty("API_GETALL");
        return API_PATH;
    }
    public String getEmployeeById(){
        String API_PATH = prop.getProperty("API_GET");
        return API_PATH;
    }
    public String addEmployee(){
        String API_PATH = prop.getProperty("API_POST");
        return API_PATH;
    }
    public JSONObject getEmployeeDetails(){
        JSONObject employeeDetails = new JSONObject();
        employeeDetails.put("employee_name",prop.getProperty("Name"));
        employeeDetails.put("employee_salary",prop.getProperty("Salary"));
        employeeDetails.put("employee_age",prop.getProperty("Age"));
        return employeeDetails;
    }
    public String updateEmployee(){
        String API_PATH = prop.getProperty("API_PUT");
        return API_PATH;
    }
}