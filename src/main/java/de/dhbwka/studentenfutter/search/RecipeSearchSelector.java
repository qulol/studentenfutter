package de.dhbwka.studentenfutter.search;

import de.dhbwka.studentenfutter.bean.data.RecipeCardBean;
import de.dhbwka.studentenfutter.database.DatabaseAccess;

import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.List;
import java.util.regex.Pattern;

public abstract class RecipeSearchSelector {
    private final Pattern matchPattern;
    private final String column;
    private final String prettyColumnName;

    public RecipeSearchSelector(String matchPattern, String column, String prettyColumnName) {
        this.matchPattern = Pattern.compile(matchPattern);
        this.column = column;
        this.prettyColumnName = prettyColumnName;
    }

    public boolean matches(String search) {
        return matchPattern.matcher(search).matches();
    }

    protected abstract String toSQLPattern(String search);

    public abstract int getPriority();

    public List<RecipeCardBean> select(DatabaseAccess dataAccess, String search) {
        //wrap to rte due stream.foreach()
        try {
            return dataAccess
                    .query(getSQL())
                    .withParam(toSQLPattern(search))
                    .collectAs(RecipeCardBean.class)
                    .getList();
        } catch (SQLException e) {
            throw new RuntimeException("Cannot select RecipeCardBean from database.", e);
        }
    }

    private String getSQL() {
        //need dynamic format --> preparedStatement don't support var column params
        return MessageFormat
                .format("select id_recipe, name, author, short_description from recipe where {0} like ?", column);
    }

    public String getPrettyColumnName() {
        return prettyColumnName;
    }
}
