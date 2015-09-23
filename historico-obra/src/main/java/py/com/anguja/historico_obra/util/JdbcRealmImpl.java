package py.com.anguja.historico_obra.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.util.JdbcUtils;
import org.apache.shiro.util.SimpleByteSource;

public class JdbcRealmImpl extends JdbcRealm {
	
	public JdbcRealmImpl(){
		
	}
	
	protected String jndiDataSourceName;
	
	public String getJndiDataSourceName() {
		return jndiDataSourceName;
	}

	public void setJndiDataSourceName(String jndiDataSourceName) {
		this.jndiDataSourceName = jndiDataSourceName;
		this.dataSource = getDataSourceFromJNDI(jndiDataSourceName);
	}
	
	private DataSource getDataSourceFromJNDI(String jndiDataSourceName) {
		try {
			// Obtain our environment naming context
			Context initCtx = new InitialContext();
			// Look up our data source
			DataSource ds = (DataSource) initCtx.lookup(jndiDataSourceName);
			return ds;
		} catch (NamingException e) {
			//logger.error("JNDI error while retrieving " + jndiDataSourceName, e);
			throw new AuthorizationException(e);
		}
	}
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		// identify account to log to
		UsernamePasswordToken userPassToken = (UsernamePasswordToken) token;
		String username = userPassToken.getUsername();

		if (username == null) {
			//logger.debug("Username is null.");
			return null;
		}

		// read password hash and salt from db
		PasswdSalt passwdSalt = getPasswordForUser(username);

		if (passwdSalt == null) {
			//logger.debug("No account found for user [" + username + "]");
			return null;
		}

		// return salted credentials
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username,
				passwdSalt.password, getName());
		// TODO: afeltes - ver como generar passwords con salt
		info.setCredentialsSalt(new SimpleByteSource(passwdSalt.salt));
		//System.out.println("Info CRedencial " + info.getCredentials());
		//System.out.println("Nombre del real " + getName());
		return info;
	}
	
	private PasswdSalt getPasswordForUser(String username) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			statement = conn.prepareStatement(authenticationQuery);
			statement.setString(1, username);

			resultSet = statement.executeQuery();

			boolean hasAccount = resultSet.next();
			if (!hasAccount)
				return null;

			String salt = null;
			String password = resultSet.getString(1);
			//System.out.println("Pass: " + password);
			if (resultSet.getMetaData().getColumnCount() > 1)
				salt = resultSet.getString(2);

			if (resultSet.next()) {
				throw new AuthenticationException(
						"More than one user row found for user [" + username
								+ "]. Usernames must be unique.");
			}
			return new PasswdSalt(password, salt);
		} catch (SQLException e) {
			final String message = "There was a SQL error while authenticating user ["
					+ username + "]";
			throw new AuthenticationException(message, e);

		} finally {
			JdbcUtils.closeResultSet(resultSet);
			JdbcUtils.closeStatement(statement);
			JdbcUtils.closeConnection(conn);
		}
	}
}
class PasswdSalt {

	public String password;
	public String salt;

	public PasswdSalt(String password, String salt) {
		super();				
		this.password = password;
		this.salt = salt;
	}
	
}
