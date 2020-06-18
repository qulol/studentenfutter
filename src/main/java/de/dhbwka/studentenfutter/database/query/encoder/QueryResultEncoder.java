package de.dhbwka.studentenfutter.database.query.encoder;

import de.dhbwka.studentenfutter.database.query.QueryResult;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class QueryResultEncoder<T> implements IQueryResultEncoder<T> {
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

    private final Class<T> clazz;

    public QueryResultEncoder(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T encode(ResultSet result) throws SQLException {
        if (isPrimitiveType()) {
            return encodePrimitive(result);
        }

        T instance;
        try {
            instance = clazz.getDeclaredConstructor().newInstance();
            for (var field : clazz.getDeclaredFields()) {
                var desc = field.getDeclaredAnnotation(QueryResult.class);
                var index = desc.index();
                var type = field.getType(); //check only for primitive, casting done by jdbc :)

                field.setAccessible(true); //reflection only
                //primitive encoding
                field.set(instance, result.getObject(index));


                //todo specific encoder
//                var encoderClazz = desc.encoder();
//                var encoder = encoderClazz.getDeclaredConstructor().newInstance();
//                //todo
//                field.set(instance, encoder.encode());

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

    private T encodePrimitive(ResultSet result) throws SQLException {
        return clazz.cast(primitiveEncoders.get(clazz).encode(result));
    }
}
