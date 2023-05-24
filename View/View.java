package View;

import DTO.User;

import java.util.Scanner;

public class View {
    private static final Scanner scanner = new Scanner(System.in);

    public String getString(String msg){
        printString(msg);
        return scanner.next();
    }
    public void printString(String msg){
        System.out.println(msg);
    }
    public Integer getInteger(String msg){
        printString(msg);
        return scanner.nextInt();
    }
    public void printMenu(){
        System.out.println(" --- MENU --- ");
        System.out.println("1 - ADD NEW USER -");
        System.out.println("2 - FIND USER -");
        System.out.println("3 - UPDATE USER -");
        System.out.println("4 - DELETE USER -");
        System.out.println("5 - EXIT -");
    }
    public void printData(User user){
        System.out.println("Name: " + user.getName());
        System.out.println("Age: " + user.getAge());
    }
}
