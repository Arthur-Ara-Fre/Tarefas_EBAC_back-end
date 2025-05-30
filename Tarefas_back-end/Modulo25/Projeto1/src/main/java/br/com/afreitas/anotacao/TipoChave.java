package br.com.afreitas.anotacao;

import java.lang.annotation.*;

/**
 * @author arthur.freitas
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TipoChave {
    String value();
}
