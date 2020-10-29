import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: hwk
 * @date: 2020/10/29 19:54
 */

@SuppressWarnings("SpringBootApplicationSetup")
@SpringBootApplication()
@ComponentScan("com.course")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
