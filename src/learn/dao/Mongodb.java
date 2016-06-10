package learn.dao;

import com.mongodb.DB;
import com.mongodb.MongoClient;


public class Mongodb {
    private MongoClient mongoClient;
    private DB db;
    
    public Mongodb() {
        mongoClient = new MongoClient("localhost" , 27017);
        db = mongoClient.getDB("test");
    }
    
    public MongoClient getMongoClient() {
        return mongoClient;
    }
    
    public DB getDb() {
        return db;
    }
    
    
    
}
