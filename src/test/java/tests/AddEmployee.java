package tests;

import APIRepo.Employee;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

public class AddEmployee {

    Employee employee;
    boolean stepRunStatus;

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
        stepRunStatus = employee.getAllEmployee();
        Assert.assertEquals(stepRunStatus, true,"Data not found");
    }

    @Test
    public void addNewEmployee(){
        String newEmployeeID = employee.addEmployee();
        Assert.assertNotNull(newEmployeeID, "New employee not created");
        stepRunStatus = employee.getEmployeeById(newEmployeeID);
        Assert.assertEquals(stepRunStatus, true,"Data not found");
    }

    @Test
    public void updateEmployee(){
        //employee to be updated can be picked by reading id from properties file. To-do
        stepRunStatus = employee.updateEmployee("2");
        Assert.assertEquals(stepRunStatus, true,"Data not found");
        stepRunStatus = employee.getEmployeeById("2");
        Assert.assertEquals(stepRunStatus, true,"Data not found");
    }
}
