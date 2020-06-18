package de.dhbwka.studentenfutter.database.query;

import de.dhbwka.studentenfutter.database.query.encoder.IPropertyEncoder;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface QueryResult {
    int index();
    Class<? extends IPropertyEncoder> encoder() default IPropertyEncoder.class;
}
