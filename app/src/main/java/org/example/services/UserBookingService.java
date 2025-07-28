package org.example.services;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entities.User;
import org.example.util.UserServiceUtil;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

public class UserBookingService {
    private User user;
    private ObjectMapper objectMapper=new ObjectMapper(); //used for serializing and deserializing the users.json
    private List<User> userList;
    private static final String USERS_PATH="app/src/main/java/org/example/LocalDB/users.json";
    /*final-> nobody can change
    * static->it is needed in the memory without this users can't be fetched */


    public UserBookingService(User user1) throws IOException {
        this.user=user1;
        File users= new File(USERS_PATH);

        userList= objectMapper.readValue(users, new TypeReference<List<User>>() {});
    }

    public Boolean loginUser(){
        Optional<User> foundUser=userList.stream().filter(user1 -> {
            return user1.getName().equals(user.getName()) && UserServiceUtil.checkPassword(user.getPassword(), user1.getHashedPassword());
        }).findFirst();
        return foundUser.isPresent();
    }

    public Boolean signUp(User user1){
        try{
            userList.add(user1);
            saveUserListToFile();
            return Boolean.TRUE;
        }catch (IOException ex){
            return Boolean.FALSE;
        }
    }

    private void saveUserListToFile() throws IOException{ //serializing the user data, whoever signs up the data gets stored in the localDB
        File usersFile= new File(USERS_PATH);
        objectMapper.writeValue(usersFile, userList);
    }
}
