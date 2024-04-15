package org.example.DDT;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDT {

 // ddt --> DATA DRIVEN TESTING
 // Read XL-file-> Apache POI,
 // FILLO Library

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password){
        System.out.println("Username--> "+username+" Password--> "+password);
    }

    @DataProvider(name = "loginData")
    public String[][] getData(){
        String loginData[][]= {
                {"Username", "Passw@rd"},
                {"uSERNAME", "pASSW@RD"},
                {"UsErNaMe", "P@ssw@rd"}
        };
        return loginData;
    }



}