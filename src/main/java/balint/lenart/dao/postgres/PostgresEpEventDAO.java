package balint.lenart.dao.postgres;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresEpEventDAO {

    public Long count() throws SQLException {
        Statement statement = PostgresConnection.getInstance().getConnection().createStatement();
        ResultSet result = statement.executeQuery("SELECT COUNT(*) FROM log.ep_event");
        result.next();
        return result.getLong(1);
    }

}
