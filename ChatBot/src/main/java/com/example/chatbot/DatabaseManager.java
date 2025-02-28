package main.java.com.example.chatbot;

import com.mongodb.MongoClient;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.conversions.Bson;

import javax.swing.text.Document;

import static com.mongodb.client.model.Filters.eq;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.io.InputStream;

public class DatabaseManager {

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> userCollection;
    private MongoCollection<Document> chatCollection;

    public DatabaseManager() {
        try {
            Properties prop = new Properties();
            prop.load(new FileReader("src/main/resources/application.properties"));

            String connectionString = prop.getProperty("mongodb.connection.string");


            mongoClient = MongoClients.create(connectionString);
            database = mongoClient.getDatabase("chatbot_db"); // Database name
            userCollection = database.getCollection("users"); // Collection for users
            chatCollection = database.getCollection("chats"); // Collection for chat history
        } catch (Exception e) {
            System.err.println("Error connecting to MongoDB: " + e.getMessage());
        }
    }

    public void createUser(User user) throws Exception {
        Document doc = new Document("username", user.getUsername()).append("password", user.getPassword()); // Store hashed password
        userCollection.insertOne(doc);
    }

    public User getUser(String username) throws Exception {
        Bson filter = eq("username", username);
        FindIterable<Document> iterable = userCollection.find(filter); // Use find()
        MongoCursor<Document> cursor = iterable.iterator(); // Get a cursor

        if (cursor.hasNext()) { // Check if a document was found
            Document doc = cursor.next(); // Get the document
            return new User(doc.getString("username"), doc.getString("password"));
        } else {
            return null; // No user found
        }
    }


    public void saveChatHistory(String username, List<String> chatHistory) throws Exception {
        Document doc = new Document("username", username).append("chatHistory", chatHistory);
        chatCollection.insertOne(doc);
    }

    public List<String> getChatHistory(String username) throws Exception {
        Bson filter = eq("username", username);
        FindIterable<Document> iterable = chatCollection.find(filter);
        MongoCursor<Document> cursor = iterable.iterator();

        List<String> history = new ArrayList<>();
        while (cursor.hasNext()) {
            Document doc = cursor.next();
            history = (List<String>) doc.get("chatHistory"); // Extract history
        }

        return history; // Return the chat history
    }

    public void updateChatHistory(String username, List<String> chatHistory) throws Exception {
        chatCollection.updateOne(eq("username", username), new Document("$set", new Document("chatHistory", chatHistory)));
    }

    public void deleteChatHistory(String username) throws Exception {
        chatCollection.deleteOne(eq("username", username));
    }

    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}