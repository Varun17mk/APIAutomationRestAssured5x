package org.example.DDT;

import org.testng.annotations.Test;

public class DDT01 {

    @Test(dataProvider = "getData", dataProviderClass = UTIL_EXCEL.class)
    public void testLoginData(String username, String password, String ER , String AR, String name, String ge, String phone ) {
        System.out.println("UserName - " + username);
        System.out.println("Password - " + password);
        System.out.println("ER - " + ER);

        // Login to app API


        // Write the code the Login POST request
        //

    }

}
