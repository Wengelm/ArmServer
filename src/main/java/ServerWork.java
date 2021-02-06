

import entity.Assets;
import entity.CodeAmortization;
import entity.RespPerson;
import entity.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import service.*;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ServerWork {
    UserService userService;
    CodeService codeService;
    AssetsService assetsService;
    RespPersonService respPersonService;
    private ObjectOutputStream out;
    private ObjectInputStream in;


    public ServerWork(ObjectOutputStream out, ObjectInputStream in) {
        this.out = out;
        this.in = in;
    }

    public void getId(int idOperation) throws IOException, SQLException, ClassNotFoundException {
        switch (idOperation) {
            case 1:
                signingIn();
                break;
            case 2:
                registrationUser();
                break;
            case 3:
                getUSers();
                break;
            case 4:
                deleteUser();
                break;
            case 5:
                updateUser();
                break;


        }
    }


    private void signingIn() throws IOException, SQLException, ClassNotFoundException {
        String login = (String) in.readObject();
        String password = (String) in.readObject();
        userService = new UserServiceImpl();
        User user = userService.findByLogin(login);

        boolean loginSuccefull = false;
        if (login.equals(user.getLogin()) && password.equals(user.getPassword())) {
            loginSuccefull = true;
            out.writeObject(loginSuccefull);
            out.flush();

        } else {

            out.writeObject(loginSuccefull);
            out.flush();
        }
        loginSuccefull = false;
        System.out.println(loginSuccefull);


    }

    private void registrationUser() throws IOException, SQLException, ClassNotFoundException {
        String login = (String) in.readObject();
        String password = (String) in.readObject();
        userService = new UserServiceImpl();
        User user = new User(login, password);
        userService.save(user);
        List<User> list = userService.getAllUsers();
        out.writeObject(list);
        out.flush();


    }

    private void getUSers() throws IOException {

        userService = new UserServiceImpl();
        List<User> list = userService.getAllUsers();
        out.writeObject(list);
        codeService = new CodeServiceImpl();
        List<CodeAmortization> code = codeService.getAllCodes();
        out.writeObject(code);
        respPersonService = new RespPersonServiceImpl();
        List<RespPerson> personList = respPersonService.getAllPersons();
        out.writeObject(personList);
        assetsService = new AssetsServiceImpl();
        List<Assets> assets = assetsService.getAllAssets();
        out.writeObject(assets);
        out.flush();


    }

    private void updateUser() throws IOException, ClassNotFoundException {

        userService = new UserServiceImpl();

        User user = (User) in.readObject();

        System.out.println(user);
        userService.update(user);


    }

    private void deleteUser() throws IOException, ClassNotFoundException {
        userService = new UserServiceImpl();
        Object object = in.readObject();
        User user = (User) object;
        userService.delete(user);
    }


}
