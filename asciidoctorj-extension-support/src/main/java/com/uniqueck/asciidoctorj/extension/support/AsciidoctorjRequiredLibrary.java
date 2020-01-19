package com.uniqueck.asciidoctorj.extension.support;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE})
@Retention(RUNTIME)
@Documented
public @interface AsciidoctorjRequiredLibrary {

    String value();
}
