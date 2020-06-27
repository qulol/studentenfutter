package de.dhbwka.studentenfutter.database.query.encoder;

import de.dhbwka.studentenfutter.database.query.QueryResult;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class QueryResultEncoder<T> implements IQueryResultEncoder<T> {
    private interface IPropertyEncoder<T> {
        T encode(ResultSet result, int index) throws SQLException;
    }

    //jdbc driver specific encoding
    private static final Map<Class<?>, IPropertyEncoder<?>> primitiveEncoders = Map.ofEntries(
            Map.entry(boolean.class, ResultSet::getBoolean),
            Map.entry(Boolean.class, ResultSet::getBoolean),
            Map.entry(byte.class, ResultSet::getByte),
            Map.entry(Byte.class, ResultSet::getByte),
            Map.entry(short.class, ResultSet::getShort),
            Map.entry(Short.class, ResultSet::getShort),
            Map.entry(int.class, ResultSet::getInt),
            Map.entry(Integer.class, ResultSet::getInt),
            Map.entry(float.class, ResultSet::getFloat),
            Map.entry(Float.class, ResultSet::getFloat),
            Map.entry(long.class, ResultSet::getLong),
            Map.entry(Long.class, ResultSet::getLong),
            Map.entry(double.class, ResultSet::getDouble),
            Map.entry(Double.class, ResultSet::getDouble),
            Map.entry(byte[].class, ResultSet::getBytes),
            Map.entry(Byte[].class, ResultSet::getBytes),
            Map.entry(Date.class, ResultSet::getDate),
            Map.entry(String.class, ResultSet::getString)
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

        var meta = result.getMetaData();
        var cols = meta.getColumnCount();
        Map<String, Integer> mapper = new HashMap<>();
        for (int i = 0; i < cols; i++) {
            mapper.put(meta.getColumnName(i), i);
        }

        T instance;
        try {
            instance = clazz.getDeclaredConstructor().newInstance();

            for (var field : clazz.getDeclaredFields()) {
                var desc = field.getDeclaredAnnotation(QueryResult.class);
                var column = desc.column();
                var type = field.getType();

                field.setAccessible(true); //reflection only
                field.set(instance, encodePrimitiveUntyped(result, type, mapper.get(column)));
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
        return clazz.cast(encodePrimitiveUntyped(result, clazz, index));
    }

    private <R> Object encodePrimitiveUntyped(ResultSet result, Class<R> clazz, int index) throws SQLException {
        return primitiveEncoders.get(clazz).encode(result, index);
    }
}
