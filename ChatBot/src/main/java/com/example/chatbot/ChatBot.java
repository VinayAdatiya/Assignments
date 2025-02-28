package main.java.com.example.chatbot;// Folder Structure:
// src/
//   main/
//     java/
//       com/
//         example/
//           chatbot/
//             main.java.com.example.chatbot.Chatbot.java
//             DatabaseManager.java
//             User.java
//             UserManager.java
//           util/
//             InputUtil.java // For cleaner console input
//     resources/
//       application.properties // MongoDB connection details

// pom.xml (Dependencies - MongoDB driver, slf4j)

import main.java.com.example.chatbot.util.InputUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatBot {

    private DatabaseManager dbManager;
    private User currentUser;

    public ChatBot() {
        dbManager = new DatabaseManager();
    }

    public void start() {
        while (true) {
            System.out.println("\n1. Signup\n2. Login\n3. Exit");
            int choice = InputUtil.getInt("Enter your choice: ");

            try {
                switch (choice) {
                    case 1:
                        signup();
                        break;
                    case 2:
                        login();
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }

                if (currentUser != null) {
                    chatMenu();
                }

            } catch (Exception e) {
                System.err.println("An error occurred: " + e.getMessage());
            }
        }
    }


    private void signup() throws Exception{
        String username = InputUtil.getString("Enter username: ");
        String password = InputUtil.getString("Enter password: ");

        User newUser = new User(username, password);
        UserManager userManager = new UserManager(dbManager);
        userManager.createUser(newUser);
        System.out.println("Signup successful!");
    }

    private void login() throws Exception{
        String username = InputUtil.getString("Enter username: ");
        String password = InputUtil.getString("Enter password: ");
        UserManager userManager = new UserManager(dbManager);
        currentUser = userManager.loginUser(username, password);

        if (currentUser != null) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private void chatMenu() throws Exception {
        while (true) {
            System.out.println("\n1. New Chat\n2. View Chat History\n3. Update Chat History\n4. Delete Chat History\n5. Logout");
            int choice = InputUtil.getInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    newChat();
                    break;
                case 2:
                    viewChatHistory();
                    break;
                case 3:
                    updateChatHistory();
                    break;
                case 4:
                    deleteChatHistory();
                    break;
                case 5:
                    currentUser = null;
                    System.out.println("Logged out.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void newChat() throws Exception {
        List<String> chatHistory = new ArrayList<>();
        while (true) {
            String userInput = InputUtil.getString("You: ");
            if (userInput.equalsIgnoreCase("exit")) {
                break;
            }

            chatHistory.add("You: " + userInput);

            String botResponse = getBotResponse(userInput);
            chatHistory.add("Bot: " + botResponse);
            System.out.println("Bot: " + botResponse);
        }
        dbManager.saveChatHistory(currentUser.getUsername(), chatHistory);
    }

    private String getBotResponse(String userInput) {
        // Example regex for a live event (e.g., a concert)
        Pattern concertPattern = Pattern.compile("concert|music|band|live", Pattern.CASE_INSENSITIVE);
        Matcher concertMatcher = concertPattern.matcher(userInput);

        if (concertMatcher.find()) {
            return "I love live music! What kind of concerts do you enjoy?";
        }

        // Add more regex patterns for other topics/events
        return "I'm still learning. Tell me more!";
    }

    private void viewChatHistory() throws Exception {
        List<String> history = dbManager.getChatHistory(currentUser.getUsername());
        if (history.isEmpty()) {
            System.out.println("No chat history found.");
        } else {
            for (String message : history) {
                System.out.println(message);
            }
        }
    }

    private void updateChatHistory() throws Exception {
        viewChatHistory();
        int indexToUpdate = InputUtil.getInt("Enter the index of the message to update: ");
        List<String> history = dbManager.getChatHistory(currentUser.getUsername());
        if (indexToUpdate >= 0 && indexToUpdate < history.size()) {
            String newMessage = InputUtil.getString("Enter the new message: ");
            history.set(indexToUpdate, newMessage);
            dbManager.saveChatHistory(currentUser.getUsername(), history);
            System.out.println("Chat history updated.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    private void deleteChatHistory() throws Exception {
        dbManager.deleteChatHistory(currentUser.getUsername());
        System.out.println("Chat history deleted.");
    }

    public static void main(String[] args) {
        ChatBot chatbot = new ChatBot();
        chatbot.start();
    }
}


// DatabaseManager.java (MongoDB interaction)
// UserManager.java (User-related operations)
// User.java (User object)
// InputUtil.java (Console input handling)

// application.properties (MongoDB connection string)