package com.uniqueck.asciidoctorj.extension.support;

import java.lang.annotation.Annotation;

public interface AnnotationHandler<T extends Annotation> {

    @SuppressWarnings("unchecked")
    default void handle(Annotation annotation) {
        doHandle((T)annotation);
    }

    void doHandle(T annotation);
}
