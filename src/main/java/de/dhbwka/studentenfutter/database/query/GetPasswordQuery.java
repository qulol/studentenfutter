package de.dhbwka.studentenfutter.database.query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetPasswordQuery extends Query<String> {
    private final int userId;

    public GetPasswordQuery(int userId) {
        this.userId = userId;
    }

    @Override
    public String getSQLAddress() {
        return "select/SelectPassword.sql";
    }

    @Override
    public boolean useCache() {
        return true;
    }

    @Override
    protected void prepareStatement(PreparedStatement statement) throws SQLException {
        statement.setInt(0, userId);
    }

    @Override
    protected String map(ResultSet result) throws SQLException {
        result.next();
        return result.getString(1);
    }
}
