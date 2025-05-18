package br.com.afreitas;

import java.lang.annotation.*;

/**
 * @author arthur.freitas
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.LOCAL_VARIABLE, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.TYPE})

public @interface Tabela {

    String[] value();
}