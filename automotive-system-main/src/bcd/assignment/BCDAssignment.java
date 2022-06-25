package bcd.assignment;

import automotive.db.*;
import automotive.screen.MainScreen;
import java.util.List;
import javax.swing.SpringLayout;

public class BCDAssignment {

    public static void main(String[] args) {
      MainScreen.main.setVisible(true);
    /*
    FOR EMPLOYEE
    */
//        Employee ed = new Employee();
//        ed.reset();
//        String firstName = "Kevin";
//        String lastName = "Jericho";
//        String email = "john2@doe.com";
//        String phoneNumber = "601234123";
//        String username = "kjp";
//        String password = "123";
//
//        if (ed.duplicatedUsernameID(username) == -1) {
//            ed.register(firstName, lastName, email, phoneNumber, username, password);
//            System.out.println("Registered.");
//        } else {
//            System.out.println("Not registered.");
//        }
//        
//        ed.register(firstName, lastName, email, phoneNumber, username, password);
//
//
//        System.out.println(ed.login(username, password));
//        String updatedPassword = "1234";
//        System.out.println(ed.edit(2, firstName, lastName, email, phoneNumber, username, updatedPassword));
//        System.out.println(ed.login(username, updatedPassword));
//
//
//        List<List<String>> data = ed.listEmployee(1);
//        if (data.isEmpty()){
//            System.out.println("Data Empty");
//        } else {
//            for(int i = 0;i<data.size();i++){
//                List<String> temp = data.get(i);
//                System.out.println("\n-------------------------");
//                System.out.println("Employee No: "+temp.get(0));
//                System.out.println("Username: "+temp.get(1));
//                System.out.println("Name: "+temp.get(2)+" "+ temp.get(3));
//                System.out.println("email: "+temp.get(4));
//                System.out.println("Phone: "+temp.get(5));
//            }
//        }


    /*
    FOR PRODUCT
    */
//        Product pd = new Product();
//        String manufacturer = "Toyota";
//        String model = "CRV-270";
//        int stock = 10;
//        int price = 100000;
//        int id = 2;
//          
//        pd.addProduct(manufacturer, model, stock, price);
//        pd.editProduct(id,manufacturer, model, stock, price);
//        pd.delete(1);
//        pd.reset();
//
//
//        List<List<String>> data = pd.listProduct();
//        if (data.isEmpty()){
//            System.out.println("Data Empty");
//        } else {
//            for(int i = 0;i<data.size();i++){
//                List<String> temp = data.get(i);
//                System.out.println("\n-------------------------");
//                System.out.println("Item No: "+temp.get(0));
//                System.out.println("Name: "+temp.get(1));
//                System.out.println("Model: "+temp.get(2));
//                System.out.println("Stock: "+temp.get(3));
//                System.out.println("Price: "+temp.get(4));
//            }
//        }
//        System.out.println("DONE");

    /*
    FOR CUSTOMER
    */
    
//        Customer cd = new Customer();
//
//        String first_name = "Renaldy";
//        String last_name = "Jericho";
//        String address = "Pinnacle Sri Petaling";
//        String zip = "52400";
//        String city = "Kuala Lumpur";
//        String State = "Malaysia";
//        String email = "kevjepe@gmail.com";
//        String phone_number = "0172347359";
//        int id = 1;
//        
//        cd.addCustomer(first_name, last_name, address, zip, city, State, email, phone_number);
//        cd.editCustomer(id, first_name, last_name, address, zip, city, State, email, phone_number);
//        cd.delete(1);
//        cd.reset();
//
//        List<List<String>> data = cd.listCustomer();
//        if (data.isEmpty()){
//            System.out.println("Data Empty");
//        } else {
//            for(int i = 0;i<data.size();i++){
//                List<String> temp = data.get(i);
//                System.out.println("\n-------------------------");
//                System.out.println("Customer No: "+temp.get(0));
//                System.out.println("Name: "+temp.get(1)+" "+ temp.get(2));
//                System.out.println("Address: "+temp.get(3));
//                System.out.println("Zip: "+temp.get(4));
//                System.out.println("City: "+temp.get(5));
//                System.out.println("State: "+temp.get(6));
//                System.out.println("Email: "+temp.get(7));
//                System.out.println("Phone: "+temp.get(8));
//            }
//        }
//        System.out.println("DONE");
    }
}
