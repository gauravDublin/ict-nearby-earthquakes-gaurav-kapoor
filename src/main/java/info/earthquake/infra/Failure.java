package info.earthquake.infra;

import java.lang.annotation.*;

/**
 * {@code Failure} provides metadata for error handling
 * in the presentation layer
 */
@Documented
@Target({ElementType.TYPE, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Failure {

    int responseCode() default 500;

    String internalCode() default "";

    String value() default "";
}

