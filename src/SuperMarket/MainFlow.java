package SuperMarket;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MainFlow {
    Scanner input =new Scanner(System.in);
    ArrayList<Customer> customers=new ArrayList<Customer>();
    ArrayList<Admin> admins=new ArrayList<Admin>(1);
    ArrayList<Product> products=new ArrayList<Product>();


    private int customerId;

    public MainFlow(){
        admins.add(new Admin("Momen Tarek","momen@gmail.com","123",true));
        products.add(new Product("TV",1000.0,5,new Shippable("TV",600.0)));
        products.add(new Product("Mobile.",3000.0,4,new Shippable("Mobile.",300.0)));
        products.add(new Product("Cheese",80.0,15,new Shippable("Cheese",100.0),new Expirable(LocalDate.of(2026,12,29))));
        products.add(new Product("Biscuits",10.0,20,new Shippable("Biscuits",50.0),new Expirable(LocalDate.of(2025,7,29))));
        products.add(new Product("Mobile scratch card",80.0,15));
        this.customerId=0;
        homePage();
    }
    private void homePage(){
        System.out.println("                                                                      ---------");
        System.out.println("                                                                     |\u001B[3m\u001B[1m\u001B[34m Welcome\u001B[0m |");
        System.out.println("                                                                      ---------");
        System.out.println("1-login");
        System.out.println("2-Sign Up");
        String ans =Validations.inputString();

        if(ans.trim().equals("1")){
            logIn();
        }
        else if(ans.trim().equals("2")){
            signUp();
        }
        else {
            System.out.println("\u001B[31mInvalid Choice\u001B[0m");
            homePage();
        }

    }
    private void logIn(){
        System.out.println("Enter Username");
        String userName=Validations.inputString();
        System.out.println("Enter Password");
        String password=Validations.inputString();
        int indexOfCustomer=checkCustomer(userName,password);
        if(indexOfCustomer>=0){
            System.out.println("                                                                \u001B[32mLogin Successfully :) \u001B[0m");
            firstPageCustomer(customers.get(indexOfCustomer));
            return;
        }
        int indexOfAdmin=checkAdmin(userName,password);
        if(indexOfAdmin>=0){
            System.out.println("                                                                \u001B[32mLogin Successfully :) \u001B[0m");
            firstPageAdmin(admins.get(indexOfAdmin));
            return;
        }
        String ans;
        System.out.println("\u001B[31mInvalid Account\u001B[0m");
        do{

            System.out.println("1- Try Again \n2- Back First Page");

            ans=Validations.inputString();

            switch (ans.trim()) {
                case "1":
                    logIn();
                    break;
                case "2":
                    homePage();
                    break;
                default:
                    System.out.println("\u001B[31mInvalid Choice\u001B[0m");
                    break;
            }
        }while(!ans.trim().equals("1")&& ! ans.trim().equals("2"));
    }
    private void signUp(){
        System.out.println("Enter Username");
        String userName=input.nextLine();
        userName =Validations.userNameValidation(userName);
        System.out.println("Enter Email (gmail)");
        String email=Validations.inputString();
        email= Validations.emailValidation(email);
        System.out.println("Enter Password");
        String pass=Validations.inputString();
        pass=Validations.passwordValidation(pass);
        System.out.println("Enter Balance");
        String balanceString=Validations.inputString();
        double balance=Validations.checkDoubleValidation(balanceString);


        for(Customer i :customers){
            if(i.getUserName().equals(userName)||i.getEmail().equals(email)){

                String ans;
                System.out.println("\u001B[35mThis Name or Email is already Exist\nPlease Try Again\u001B[0m");
                do{

                    System.out.println("1- Try Again \n2- Back First Page");

                    ans=Validations.inputString();

                    switch (ans.trim()) {
                        case "1":
                            signUp();
                            break;
                        case "2":
                            homePage();
                            break;
                        default:
                            System.out.println("\u001B[31mInvalid Choice\u001B[0m");
                            break;
                    }
                }while(!ans.trim().equals("1")&& ! ans.trim().equals("2"));

            }
        }
        for(Admin i :admins){
            if(i.getUserName().equals(userName)||i.getEmail().equals(email)){
                String ans;
                System.out.println("\u001B[35mThis Name or Email is already Exist\nPlease Try Again\u001B[0m");
                do{

                    System.out.println("1- Try Again \n2- Back First Page");

                    ans=Validations.inputString();

                    switch (ans.trim()) {
                        case "1":
                            signUp();
                            break;
                        case "2":
                            homePage();
                            break;
                        default:
                            System.out.println("\u001B[31mInvalid Choice\u001B[0m");
                            break;
                    }
                }while(!ans.trim().equals("1")&& ! ans.trim().equals("2"));
            }
        }
        System.out.println("\u001B[32mAccount is Created successfully\u001B[0m");
        customers.add(new Customer(++customerId,userName,email,pass,false,balance));
        homePage();
    }
    private  int checkCustomer(String userName,String Password){
        int indexOfCustomer=0;
        for(Customer i :customers){

            if(i.getUserName().equals(userName)&&i.getPassword().equals(Password)){
                return indexOfCustomer;
            }
            indexOfCustomer++;

        }
        return -1;
    }
    private int checkAdmin(String userName,String Password){
        int indexOfAdmin=0;
        for(Admin i :admins){
            if(i.getUserName().equals(userName)&&i.getPassword().equals(Password)){
                return indexOfAdmin;
            }
            indexOfAdmin++;

        }
        return -1;
    }
    private void firstPageCustomer(Customer customer){
        System.out.println("                                                                \u001B[32mWelcome to SuperMarket , "+customer.getUserName()+"\u001B[0m");
        System.out.println("\n \n");
        System.out.println("1-Show All Products To Buy");
        System.out.println("2-Go To Cart");
        System.out.println("3-Show Your Balance");

        System.out.println("4-Log Out");
        String ans =Validations.inputString();
        switch(ans.trim()){
            case "1":
                while (true){
                    showAllProductsForCustomer();
                    String answer ;
                    while (true){
                        System.out.println("1-Select Product");
                        System.out.println("2-Go Back");
                        answer =Validations.inputString();
                        if(answer.trim().equals("1")||answer.trim().equals("2")){
                            break;
                        }
                        System.out.println("\u001B[31mInvalid choice\u001B[0m \nTry again");
                    }
                    switch(answer.trim()){
                        case "1":
                            int productNumber;
                            while (true){
                                System.out.println("Enter Product Number :");
                                String productNumberInput =Validations.inputString();
                                productNumber=Validations.checkNumberValidation(productNumberInput);
                                if(products.size()<=productNumber||productNumber<=0){
                                    System.out.println("\u001B[31mPlease Enter an existing number \u001B[0m \n");
                                }
                                else{
                                    break;
                                }
                            }
                            Product selectedProduct=products.get(productNumber-1);
                            int productQuantity;
                            while (true){
                                System.out.println("Enter the quantity you want:");
                                String productQuantityInput =Validations.inputString();
                                productQuantity=Validations.checkNumberValidation(productQuantityInput);
                                if(selectedProduct.getQuantity()<productQuantity){
                                    System.out.println("\u001B[31mThere is no quantity available for this number. Enter a smaller quantity. \u001B[0m \n");
                                }
                                else{
                                    break;
                                }
                            }
                            if(customer.getBalance()<selectedProduct.getPrice()*productNumber){
                                System.out.println("\u001B[31mYour Balance Not Enough \u001B[0m \n");
                                System.out.println("Press on any Key To go to Home");
                                String back=Validations.inputString();
                                firstPageCustomer(customer);
                            }
                            customer.getCart().AddItem(new Item(selectedProduct,productQuantity));
                            System.out.println("                                                                \u001B[32mItem Added To Cart Successfully :) \u001B[0m");
                            System.out.println("\n\n\n\n");

                            firstPageCustomer(customer);
                            break;
                        case "2":
                            firstPageCustomer(customer);
                            break;
                    }
                    break;
                }
                break;
            case "2" :
                String answer;
                if(customer.getCart().isEmpty()){
                    System.out.println("        Cart Is Empty\n\n");

                    System.out.println("Press on any Key to go to home ");
                    answer=Validations.inputString();
                    firstPageCustomer(customer);
                    break;
                }
                System.out.println("\n\n");
                customer.getCart().displayCart();
                System.out.println("\n\n");
                while (true){
                    System.out.println("1-Check Out");
                    System.out.println("2-Go Back");
                    answer =Validations.inputString();
                    if(answer.trim().equals("1")||answer.trim().equals("2")){
                        break;
                    }
                    System.out.println("\u001B[31mInvalid choice\u001B[0m \nTry again");
                }
                switch(answer.trim()){
                    case "1":
                        System.out.println("                                                                \u001B[32mSuccessfully :) \u001B[0m");
                        System.out.println("\n\n");
                        System.out.println("-------------receipt-------------------");
                        System.out.println("\n\n");
                        System.out.println("** Shipment notice **");
                        for(Item i :customer.getCart().getItems()){
                            if(i.product.isShippable()){
                                System.out.println(i.getQuantitySold()+" * "+i.product.getName()+"                             "+i.product.getShippable().getWeight()+"g");
                            }
                        }
                        if(customer.getCart().getTotalWeight()>1000){
                            System.out.println("Total package weight "+(customer.getCart().getTotalWeight())/1000+"KG");
                        }
                        else{
                            System.out.println("Total package weight "+customer.getCart().getTotalWeight()+"G");
                        }
                        System.out.println("\n\n");

                        System.out.println("** Checkout receipt **");
                        for(Item i :customer.getCart().getItems()){

                            System.out.println(i.getQuantitySold()+" * "+i.product.getName()+"                             "+i.product.getPrice()+" $ ");


                        }
                        System.out.println("--------------------------------");
                        System.out.println("Subtotal                             "+customer.getCart().getSubTotalPrice());
                        System.out.println("Shipping                             "+customer.getCart().getShippingPrice());
                        System.out.println("Amount                             "+customer.getCart().getSubTotalPrice());

                        System.out.println("Press on any Key To go to Home");

                        String back=Validations.inputString();

                        firstPageCustomer(customer);

                        break;
                    case "2":
                        firstPageCustomer(customer);
                        break;
                }
                break;
            case "3":
                System.out.println("Your Balance is :"+ customer.getBalance());
                System.out.println("Press on any Key To go to Home");
                String back=Validations.inputString();
                firstPageCustomer(customer);
                break;
            case "4":
                String x;
                do {
                    System.out.println("1-Log out \n2-Close program\n3-Back to home page");
                    x = Validations.inputString();
                }while (!(x.trim().equals("1")||x.trim().equals("2")||x.trim().equals("3")));
                switch (x){
                    case "1" :
                        homePage();
                        break;
                    case "2" :
                        exitProgram();
                        break;
                    case "3":
                        firstPageCustomer(customer);
                        break;
                    default:
                        System.out.println("\u001B[31mInvalid Choice\u001B[0m");
                        break;
                }
                break;
            default:
                System.out.println("\u001B[31mInvalid choice\u001B[0m \nTry again");
                firstPageCustomer(customer);
                break;
        }
    }
    private void firstPageAdmin(Admin admin){
        System.out.println("                                                                \u001B[32mWelcome to Admin DashBoard , "+admin.getUserName()+"\u001B[0m");
        System.out.println("\n \n");
        System.out.println("1-Add a Product");
        System.out.println("2-Show All Products");
        System.out.println("3-Update a Product");
        System.out.println("4-Delete a Product");
        System.out.println("5-Search Product (by Id or Name)");
        System.out.println("6-Log Out ");
        String ans =Validations.inputString();
        switch(ans.trim()){

            case "1":
                String answer;
                do{
                    System.out.println("1-Are you sure to add new dish\n2-To go back to previous page");
                    answer =Validations.inputString();
                    switch(answer.trim()){
                        case "1":

                            firstPageAdmin(admin);
                            break;
                        case "2":
                            firstPageAdmin(admin);
                            break;
                        default :
                            System.out.println("\u001B[31mInvalid choice\u001B[0m");


                    }}while(!(answer.equals("1")||answer.equals("2")));
                break;
            case "2" :

                break;
            case "3" :

                break;
            case "4":

                break;
            case "5":

                break;
            case "6":
                String x;
                do {
                    System.out.println("1-Log out \n2-Close program\n3-Back to home page");
                    x = Validations.inputString();
                }while (!(x.trim().equals("1")||x.trim().equals("2")||x.trim().equals("3")));
                switch (x){
                    case "1" :
                        homePage();
                        break;
                    case "2" :
                        exitProgram();
                        break;
                    case "3":
                        firstPageAdmin(admin);
                        break;
                    default:
                        System.out.println("\u001B[31mInvalid Choice\u001B[0m");
                        break;
                }
                break;
            default:
                System.out.println("\u001B[31mInvalid choice\u001B[0m \nTry again");
                firstPageAdmin(admin);
                break;
        }
    }

    private void showAllProductsForCustomer(){
        int productId=1;
        System.out.println("*****************************************");
        for(Product i:products) {
            System.out.println("   Product " + productId + ":");
            i.displayInfo();
            System.out.println("*****************************************");
            productId++;
        }
        System.out.println("\n");
    }
    public void exitProgram (){
        System.exit(0);
    }
}
