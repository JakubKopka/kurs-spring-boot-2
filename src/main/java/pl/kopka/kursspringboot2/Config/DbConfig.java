package pl.kopka.kursspringboot2.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import pl.kopka.kursspringboot2.Client.ClientController;
import pl.kopka.kursspringboot2.Client.Mapper;
import pl.kopka.kursspringboot2.Dao.NewsDaoImp;
import pl.kopka.kursspringboot2.Model.Client.NewsApi;
import pl.kopka.kursspringboot2.Model.News;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class DbConfig {

    private  DataSource dataSource;

    @Autowired
    public DbConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(dataSource);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init(){
//        String sql = "CREATE table news(id varchar(255), title varchar(255), " +
//                "description varchar(1025), url varchar(255), author varchar(255), " +
//                "image varchar(1025), published varchar(255), primary key (id))";
//        getJdbcTemplate().update(sql);
    }
}
