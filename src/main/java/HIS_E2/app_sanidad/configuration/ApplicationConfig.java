package HIS_E2.app_sanidad.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

@Configuration
@ComponentScan(basePackages = "com.technicalkeeda")
@EnableMongoRepositories({ "com.technicalkeeda.repositories" })
public class ApplicationConfig {
 
    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
    	MongoClientURI uri = new MongoClientURI(
    		    "mongodb+srv://Edulaen:<titan2005>@clusteriso-stj6s.mongodb.net/test?retryWrites=true&w=majority");
    	MongoClient mongoClient = new MongoClient(uri);
    	//MongoDatabase database = mongoClient.getDatabase("test");
        return new SimpleMongoDbFactory(mongoClient, "test");
 
    }
 
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
 
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return mongoTemplate;
 
    }
 
}