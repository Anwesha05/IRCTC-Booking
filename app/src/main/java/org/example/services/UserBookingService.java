package org.example.services;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entities.User;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

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
}
