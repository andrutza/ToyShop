package toyshop.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@Import({ SecurityConfig.class })
public class DataConfig {

	  @Bean
	  public DataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
	    ds.setDriverClassName("com.mysql.jdbc.Driver");
	    ds.setUrl("jdbc:mysql://localhost:3306/toyshop");
	    ds.setUsername("root");
	    ds.setPassword("");
	    return ds;
	  }
	  
	  @Bean
	  public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
		  LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
		  sfb.setDataSource(dataSource);
		  sfb.setPackagesToScan(new String[] {"toyshop.model"});
		  Properties props = new Properties();
		  props.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
		  sfb.setHibernateProperties(props);
		  return sfb;
	  }
	  
	@Bean
    //@Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory)
    {
        HibernateTransactionManager htm = new HibernateTransactionManager();
        htm.setSessionFactory(sessionFactory);
        return htm;
    }
	  	
//	@Bean
//    public DataSourceTransactionManager txManager() {
//		return new DataSourceTransactionManager(dataSource());
//    }

	@Bean
	public BeanPostProcessor persistenceTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
}
