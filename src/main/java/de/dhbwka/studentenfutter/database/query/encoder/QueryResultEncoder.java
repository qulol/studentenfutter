package de.dhbwka.studentenfutter.database.query.encoder;

import de.dhbwka.studentenfutter.database.query.QueryResult;

import java.sql.ResultSet;

public class QueryResultEncoder<T> {

    public T encode(ResultSet result, Class<T> clazz) {
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
}
