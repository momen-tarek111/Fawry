package SuperMarket;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import java.util.Date;
import java.util.Scanner;

public class Validations {
    public static String inputString(){
        Scanner input =new Scanner(System.in);
        String ans =input.nextLine();
        if(ans.equals("")){
            ans =input.nextLine();
        }
        return ans;
    }
    public static String userNameValidation( String userName){
        while(userName.length()<2){
            System.out.println("\u001B[35mUsername must contain at least 2 characters\u001B[0m");
            userName=inputString();
        }
        return userName;
    }
    public static String emailValidation( String email){
        while(!(email.contains("@gmail.com")&&email.endsWith("com"))||(email.startsWith("@"))||email.contains(" ")){
            System.out.println("\u001B[31mInvalid Email try again\u001B[0m");
            email=inputString();
        }
        return email;
    }
    public static String passwordValidation( String pass){
        while(pass.length()<4||pass.contains(" ")){
            System.out.println("\u001B[35mPassword must contain at least 4 characters with no spaces\u001B[0m");
            pass=inputString();
        }
        return pass;
    }
    public static int checkNumberValidation(String inputString) {
        Scanner input = new Scanner(System.in);
        int choice =0;
        boolean validInput = false;
        while (!validInput) {
            try {

                choice = Integer.parseInt(inputString);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("\u001B[31mInvalid choice.\u001B[0m Please enter a valid integer.");
                inputString=Validations.inputString().trim();
            }
        }
        return choice;
    }
    public static double checkDoubleValidation(String inputString) {
        double choice =0;
        boolean validInput = false;
        while (!validInput) {
            try {

                choice = Double.parseDouble(inputString);

                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("\u001B[31mInvalid choice.\u001B[0m Please enter a valid number.");
                inputString=Validations.inputString().trim();
            }
        }
        return choice;

    }
    public static LocalDate checkExpiryDate(String Date){
        LocalDate expiryDate;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        while(true){
            try{
                expiryDate = LocalDate.parse(Date.trim(), format);
                if (expiryDate.isBefore(LocalDate.now())) {
                    System.out.println("Expiry date cannot be in the past. Please try again.");
                    Date=Validations.inputString();
                } else {
                    break;
                }
            }catch (DateTimeParseException e) {
                System.out.println("Invalid date format.Please use yyyy-MM-dd.");
                Date=Validations.inputString();
            }
        }
        return expiryDate;
    }
}
