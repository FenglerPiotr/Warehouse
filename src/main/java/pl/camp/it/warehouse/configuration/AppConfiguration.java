package pl.camp.it.warehouse.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.camp.it.warehouse.App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@ComponentScan("pl.camp.it.warehouse")
public class AppConfiguration {

    @Bean
    public Connection connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/warehouse", "root", "");
        }catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
