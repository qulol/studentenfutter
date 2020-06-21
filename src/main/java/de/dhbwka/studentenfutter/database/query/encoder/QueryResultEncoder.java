package de.dhbwka.studentenfutter.database.query.encoder;

import de.dhbwka.studentenfutter.database.query.QueryResult;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class QueryResultEncoder<T> implements IQueryResultEncoder<T> {
    private interface IPropertyEncoder<T> {
        T encode(ResultSet result, int index) throws SQLException;
    }

    //jdbc driver specific encoding
    private static final Map<Class<?>, IPropertyEncoder<?>> primitiveEncoders = Map.ofEntries(
            Map.entry(Boolean.class, ResultSet::getBoolean),
            Map.entry(Byte.class, ResultSet::getByte),
            Map.entry(Short.class, ResultSet::getShort),
            Map.entry(Integer.class, ResultSet::getInt),
            Map.entry(Float.class, ResultSet::getFloat),
            Map.entry(Long.class, ResultSet::getLong),
            Map.entry(Double.class, ResultSet::getDouble),
            Map.entry(String.class, ResultSet::getString),
            Map.entry(Date.class, ResultSet::getDate)
    );

    private final Class<T> clazz;

    public QueryResultEncoder(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T encode(ResultSet result) throws SQLException {
        if (isPrimitiveType()) {
            return encodeAsPrimitive(result);
        }

        T instance;
        try {
            instance = clazz.getDeclaredConstructor().newInstance();
            for (var field : clazz.getDeclaredFields()) {
                var desc = field.getDeclaredAnnotation(QueryResult.class);
                var index = desc.index();
                var type = field.getType();

                field.setAccessible(true); //reflection only
                field.set(instance, encodePrimitive(result, type, index));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null; //throw
        }
        return instance;
    }

    private boolean isPrimitiveType() {
        return primitiveEncoders.containsKey(clazz);
    }

    private T encodeAsPrimitive(ResultSet result) throws SQLException {
        return encodePrimitive(result, clazz, 1);
    }

    private <R> R encodePrimitive(ResultSet result, Class<R> clazz, int index) throws SQLException {
        return clazz.cast(primitiveEncoders.get(clazz).encode(result, index));
    }
}
