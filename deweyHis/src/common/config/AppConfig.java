package common.config;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
//@ImportResource("classpath:/bookstore/config/spring-beans.xml")
//@Import({BookStoreServiceConfig.class,BookStoreDaoConfig.class})
public class AppConfig {
	
	 // 容器的初始化过程和纯粹的以配置为中心的方式一致：
	 //AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class); 
	
	protected final Logger logger = Logger.getLogger(this.getClass());

	@Bean(name="sysStartDate",autowire=Autowire.BY_TYPE)
	@Scope("singleton")
	public  Date getStartDate() {
		return new Date();
	}
	
    private @Value("#{jdbcProperties.jdbcUrl}") String jdbcUrl;
    private @Value("#{jdbcProperties.jdbcUsername}") String username;
    private @Value("#{jdbcProperties.jdbcPassword}") String password;
    
    @Bean(name="jdbcUrl",autowire=Autowire.BY_TYPE)
	@Scope("singleton")
	public String getJdbcUrl() {
    	return jdbcUrl;
    }
    
    @Bean(name="jdbcUsername",autowire=Autowire.BY_TYPE)
	@Scope("singleton")
	public String getUsername() {
    	return username;
    }
    
    @Bean(name="jdbcPassword",autowire=Autowire.BY_TYPE)
	@Scope("singleton")
	public String getPassword() {
    	return password;
    }

//    @Bean
//    public SessionFactory sessionFactory() {
//        // wire up a session factory
//        AnnotationSessionFactoryBean asFactoryBean = new AnnotationSessionFactoryBean();
//        asFactoryBean.setDataSource(dataSource());
//        // additional config
//        return asFactoryBean.getObject();
//    }
//
//    @Bean
//    public DataSource dataSource() { 
//        return new DriverManagerDataSource(jdbcUrl, username, password);
//    }
}

