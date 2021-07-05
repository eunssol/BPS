package listener;

import java.io.FileReader;
import java.sql.DriverManager;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class DBCPListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//String file = "D:\\java\\workspace\\web\\src\\main\\webapp\\WEB-INF\\db.properties"; // /WEB-INF/command.properties
		String file = sce.getServletContext().getInitParameter("dbPropFile");
		System.out.println(file);
		Properties prop = new Properties();
		try (FileReader fr = new FileReader(file)) {
			prop.load(fr);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		driverLoad(prop);
		initConnectionPool(prop);
		System.out.println("DBCPListener");
	}

	// 드라이버 클래스 로드
	void driverLoad(Properties prop) {
		try {
			Class.forName(prop.getProperty("jdbcDriver"));
		} catch (Exception e) {

		}
	}

	// 커넥션풀 초기화
	void initConnectionPool(Properties prop) {
		try {
			// ConnectionFactory 객체 생성
			ConnectionFactory connFactory = new DriverManagerConnectionFactory(prop.getProperty("jdbcUrl"),
					prop.getProperty("jdbcId"), prop.getProperty("jdbcPwd"));
			PoolableConnectionFactory poolableConnFactory = new PoolableConnectionFactory(connFactory, null);
			poolableConnFactory.setValidationQuery("select 1");

			// 설정
			GenericObjectPoolConfig<PoolableConnection> poolConfig = new GenericObjectPoolConfig<PoolableConnection>();
			poolConfig.setTimeBetweenEvictionRunsMillis(1000 * 60 * 3); // 유효검사시간 주기
			poolConfig.setMinIdle(5); // 최소개수
			poolConfig.setMaxTotal(100); // 최대개수
			poolConfig.setTestWhileIdle(true);

			// 풀생성
			GenericObjectPool<PoolableConnection> pool = new GenericObjectPool<PoolableConnection>(poolableConnFactory,
					poolConfig);
			poolableConnFactory.setPool(pool);

			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			// 풀등록
			driver.registerPool(prop.getProperty("poolName"), pool);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
