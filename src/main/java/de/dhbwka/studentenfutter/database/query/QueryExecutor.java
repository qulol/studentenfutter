package de.dhbwka.studentenfutter.database.query;

import de.dhbwka.studentenfutter.database.query.encoder.IQueryResultEncoder;
import de.dhbwka.studentenfutter.database.query.encoder.QueryResultEncoder;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class QueryExecutor<T> {
    private static final Map<Class<?>, IQueryResultEncoder<?>> primitiveEncoders = Map.ofEntries(
            Map.entry(Boolean.class, (IQueryResultEncoder<Boolean>) set -> set.getBoolean(1)),
            Map.entry(Byte.class, (IQueryResultEncoder<Byte>) set -> set.getByte(1)),
            Map.entry(Short.class, (IQueryResultEncoder<Short>) set -> set.getShort(1)),
            Map.entry(Integer.class, (IQueryResultEncoder<Integer>) set -> set.getInt(1)),
            Map.entry(Float.class, (IQueryResultEncoder<Float>) set -> set.getFloat(1)),
            Map.entry(Long.class, (IQueryResultEncoder<Long>) set -> set.getLong(1)),
            Map.entry(Double.class, (IQueryResultEncoder<Double>) set -> set.getDouble(1)),
            Map.entry(String.class, (IQueryResultEncoder<String>) set -> set.getString(1)),
            Map.entry(Date.class, (IQueryResultEncoder<Date>) set -> set.getDate(1))
    );

    public final Query query;
    public Class<T> clazz;

    public QueryExecutor(Query query, Class<T> clazz) {
        this.query = query;
        this.clazz = clazz;
    }

    public List<T> getList() throws SQLException {
        List<T> list = new ArrayList<>();
        query.execute(result -> {
            while (result.next()) {
                list.add(encode(result));
            }
        });
        return list;
    }

    public Optional<T> get() throws SQLException {
        return query.execute(result -> {
            if(result.next()) {
                return Optional.of(encode(result));
            }
            return Optional.empty();
        });
    }

    private T encode(ResultSet result) throws SQLException {
        if (primitiveEncoders.containsKey(clazz)) {
            return clazz.cast(primitiveEncoders.get(clazz).encode(result));
        }
        return new QueryResultEncoder<T>().encode(result, clazz);
    }
}
