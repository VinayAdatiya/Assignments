package main.java.com.example.chatbot;

public class User {
    private String username;
    private String password; // Should be hashed!

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
