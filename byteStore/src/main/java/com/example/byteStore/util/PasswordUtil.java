package main.java.com.example.byteStore.util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {
    public static String hashPassword(String senha) {
        return BCrypt.hashpw(senha, BCrypt.gensalt(12));
    }
    public static boolean checkPassword(String senha, String hash) {
        return BCrypt.checkpw(senha, hash);
    }
}
