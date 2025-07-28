package org.example.util;


import org.springframework.security.crypto.bcrypt.BCrypt;

public class UserServiceUtil {

    public static String hashedPassword(String plainPassword){
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }
    public static boolean checkPassword(String plainPassword, String hashedPassword){
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
