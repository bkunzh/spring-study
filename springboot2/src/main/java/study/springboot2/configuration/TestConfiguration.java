package study.springboot2.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class TestConfiguration {
    Logger log = LoggerFactory.getLogger(TestConfiguration.class);
    @Bean
    public Object test() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        Date date = new Date();
        String dateStr = objectMapper.writeValueAsString(date);
        log.debug(dateStr);
        log.debug(objectMapper.readValue(dateStr, Date.class).toString());
        return "I am test obj";
    }
}
