package sample.com.au;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sample.com.au.service.AutoGeneralService;

@SpringBootApplication
public class Application
{
    public static void main( String[] args )
    {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public AutoGeneralService autoGeneralService() {
        return new AutoGeneralService();
    }
}
