package wyl.com.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
//@EnableDiscoveryClient
public class OauthApplication {

    public static void main(String[] args) {
        //        SpringApplication.run(OauthApplication.class, args);
        SpringApplication sa = new SpringApplication(OauthApplication.class);
        sa.addListeners(new ApplicationPidFileWriter());
        sa.run(args);
    }

}
