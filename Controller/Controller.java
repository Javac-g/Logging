package Controller;

import DTO.User;
import Model.Model;
import View.View;

public class Controller {
    public void initController(){
        Model model = new Model();
        View view = new View();


        boolean b = false ;
        while (!b){
            view.printMenu();
            int choose = view.getInteger("Choose menu: ");

            b = switch (choose){
                case 1 ->{
                    view.printString("Adding new user: ");
                    User x = model.addUser(view.getString("Enter name"), view.getInteger("Enter age"), view.getInteger("Enter id") );
                    if (x != null){
                        view.printData(x);
                    }else {
                        view.printString("Nobody saved");
                    }
                    yield false;
                }
                case 2-> {
                    view.printString("Searching user");
                    User x = model.findUser(view.getInteger("Enter id to search:"));
                    if (x != null){
                        view.printString("User: ");
                        view.printData(x);
                    }else {
                        view.printString("Nobody found");
                    }
                    yield false;
                }
                case 3 -> {
                    view.printString("Updating user");
                    User x = model.updateUser(
                            view.getInteger("Enter id to update"),
                            view.getInteger("Enter new id"),
                            view.getString("Enter new name"),
                            view.getInteger("Enter new age"));
                    if (x != null){
                        view.printData(x);
                    }else {
                        view.printString("Nobody updated");
                    }
                    yield false;
                }
                case 4 -> {
                    view.printString("Deleting user");
                    Integer index = model.deleteUser(view.getInteger("Enter id to delete"));
                    if (index != -1){
                        view.printString("Was deleted user N: " + index);
                    }else {
                        view.printString("Nobody was deleted");
                    }
                    yield false;
                }
                case 5 -> {
                    view.printString("Bye bye");
                    yield true;
                }
                default -> {
                    view.printString("Wrong choose");
                    yield false;
                }
            };

        }

    }
}
