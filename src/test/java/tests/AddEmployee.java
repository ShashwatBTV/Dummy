package tests;

import APIRepo.Employee;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

public class AddEmployee {

    Employee employee;

    @BeforeTest
    public void setBaseURI() throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/Api_Data.properties"));
        Properties prop = new Properties();
        prop.load(reader);
        if(prop.getProperty("environment").equalsIgnoreCase("dummy"))
            employee = new Employee("http://dummy.restapiexample.com/api/v1/");
    }

    @Test
    public void getAllEmployees(){
        //employee.getAllEmployee();
        employee.getEmployeeById("2");
        //employee.addEmployee();
    }

//    @Test
//    public void addNewEmployee(){
//        String newEmployeeID = employee.addEmployee();
//        employee.getEmployeeById(newEmployeeID);
//    }
}
