import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;

/**
 * Created by Wangxy on 2017/11/29.
 */
@SpringBootApplication(scanBasePackages = "com.wangxy.*")
public class Application {

    private static  final SpringApplication APP=new SpringApplication(Application.class);

    public static void main(String[] args){
        APP.run(args);
//        SpringApplication.run(Application.class,args);
    }

}
