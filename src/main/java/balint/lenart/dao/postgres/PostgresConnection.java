package balint.lenart.dao.postgres;

import balint.lenart.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection {

    private static PostgresConnection instance;
    private Connection connection;

    protected PostgresConnection() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:postgresql://" + Configuration.get("postgres.connection.host") + ":" + Configuration.get("postgres.connection.port") + "/"
                        + Configuration.get("postgres.connection.database"),
                Configuration.get("postgres.connection.username"),
                Configuration.get("postgres.connection.password")
        );
    }

    public static PostgresConnection getInstance() throws SQLException {
        if( instance == null ) {
            instance = new PostgresConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        connection.close();
    }
}
