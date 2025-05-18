package br.com.afreitas;

import java.lang.annotation.*;

/**
 * @author arthur.freitas
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Tabela {

    String[] value();
}
