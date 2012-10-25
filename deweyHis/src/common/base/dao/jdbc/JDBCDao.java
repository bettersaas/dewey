package common.base.dao.jdbc;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Component;

@Component
public class JDBCDao  {
	
	protected final Logger logger = Logger.getLogger(this.getClass());
	// JdbcDaoSupport
	
	/**
	 * 也可以在配置文件中配置
	 <!-- JDBC操作 -->
	<bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
        <property name="dataSource" ref="dataSource"/>
    </bean>
	 */
	@Autowired
	private LobHandler lobHandler;
	
	@Autowired
	protected DataSource dataSource;
	
	protected JdbcTemplate jdbcTemplate;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
	}
	
	public LobHandler getLobHandler() {
		return lobHandler;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/**
	 * Set the LobHandler to use for BLOB/CLOB access.
	 * Could use a DefaultLobHandler instance as default,
	 * but relies on a specified LobHandler here.
	 * @see org.springframework.jdbc.support.lob.DefaultLobHandler
	 */
	public void setLobHandler(LobHandler lobHandler) {
		this.lobHandler = lobHandler;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
}
