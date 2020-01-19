package com.uniqueck.asciidoctorj.extension.support;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@AsciidoctorjRequiredLibrary("asciidoctor-diagram")
public @interface RequireLibraryAsciidoctorDiagram {
}
