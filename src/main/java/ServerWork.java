

import entity.User;
import service.UserService;
import service.UserServiceImpl;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServerWork {
    UserService userService;
    private ObjectOutputStream out;
    private ObjectInputStream in;


    public ServerWork(ObjectOutputStream out, ObjectInputStream in) {
        this.out = out;
        this.in = in;
    }

    public void getId (int idOperation) throws IOException, SQLException, ClassNotFoundException {
        switch(idOperation){
            case 1:
                signingIn();
                break;
            case 2:
                registrationUser();
                break;


        }
    }

    private void signingIn() throws IOException, SQLException, ClassNotFoundException {
        String login = (String) in.readObject();
        String password = (String) in.readObject();
        
        ResultSet result;
        


    }
    
    private void registrationUser() throws IOException, SQLException, ClassNotFoundException {
        String login = (String) in.readObject();
        String password = (String) in.readObject();

        userService = new UserServiceImpl();
        User user = userService.findByLogin(login);

        if (user != null) {
            System.out.println(user);
        }


        System.out.println(user);
        System.out.println(login + password);

    }


}
