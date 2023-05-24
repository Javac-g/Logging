package Model;

import DTO.User;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Model {
    private List<User> userList = new ArrayList<>();
    private static final Logger logger = Logger.getLogger(Model.class.getName());
    private Predicate<User> predicate = Objects::nonNull;


    public void filelog(String type,User user){
        byte[] data =(type + "\nName: " + user.getName() + "\nAge: " + user.getAge()).getBytes();

        try(ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            FileOutputStream fileOutputStream = new FileOutputStream("logger.dat");
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)){

            byteArrayOutputStream.write(data);
            byteArrayOutputStream.writeTo(fileOutputStream);
            dataOutputStream.writeUTF("***************");


        }catch (Exception e){
            logger.log(Level.INFO,"Method: " + type,e);
        }

    }

    public User addUser(String name,Integer age,Integer id){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        userList.add(user);
        filelog("Added user",user);
        return user;
    }
    public User findUser(Integer id){
        for (User x: userList){
            if (x.getId().equals(id)){
                filelog("Searched: ",x);
                return x;
            }
        }
        return null;
    }

    public User updateUser(Integer id,Integer nid,String nname,Integer age){
        User x = findUser(id);
        if (predicate.test(x)){
            x.setId(nid);
            x.setAge(age);
            x.setName(nname);
            filelog("Update",x);
            return x;
        }
        return null;
    }

    public Integer deleteUser(Integer id){
        int index = -1;
        for (int i = 0; i < userList.size();i++){
            if (userList.get(i).getId().equals(id)){
                index = i;
            }
        }
        if (index != -1){
            userList.remove(index);
            return index;
        }
        return null;
    }
}
