package main.java.com.example.chatbot;

public class UserManager {

    private DatabaseManager dbManager;

    public UserManager(DatabaseManager dbManager) {
        this.dbManager = dbManager;
    }

    public void createUser(User user) throws Exception {
        // Hash the password before storing it!  (Use a strong hashing algorithm like bcrypt)
        dbManager.createUser(user);
    }

    public User loginUser(String username, String password) throws Exception {
        User user = dbManager.getUser(username);
        if (user != null && user.getPassword().equals(password) ) { // Compare hashed passwords
            return user;
        }
        return null;
    }
}
