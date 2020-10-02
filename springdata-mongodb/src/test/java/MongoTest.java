import com.alibaba.fastjson.JSON;
import com.mongodb.Block;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Test;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * @author bingkun_zhang
 * @date 2020/7/7
 */
public class MongoTest {
    /*
    http://mongodb.github.io/mongo-java-driver/4.0/driver/tutorials/authentication/
     */
    @Test
    public void mongoClientTest() {
        MongoClient mongoClient = MongoClients.create("mongodb://192.168.22.111:27017");
        MongoDatabase database = mongoClient.getDatabase("test_bk");
//        MongoClient mongoClient = MongoClients.create("mongodb://user1:pwd1@host1@localhost/?authSource=finance&ssl=false");
//        MongoDatabase database = mongoClient.getDatabase("finance");
        MongoCollection<Document> collection = database.getCollection("log");
//        Block<Document> printBlock = new Block<Document>() {
//            @Override
//            public void apply(final Document document) {
//                System.out.println(document.toJson());
//            }
//        };
//        collection.find().forEach(printBlock);
        Consumer<Document> c = t -> System.out.println(t.toJson());
        Document d = new Document();
        d.put("ab", 1);
        d.put("c", 11);
        d.put("d", Arrays.asList(5, 8, 9, 1));
        Document d2 = JSON.parseObject(JSON.toJSONString(d), Document.class);
        Document d3 = JSON.parseObject(JSON.toJSONString(d), Document.class);
//        collection.insertOne(d);
        collection.insertMany(Arrays.asList(d, d2, d3));
        collection.find().forEach(c);

        mongoClient.close();
    }


}
