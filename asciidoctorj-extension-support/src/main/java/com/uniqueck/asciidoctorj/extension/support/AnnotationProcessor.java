package com.uniqueck.asciidoctorj.extension.support;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class AnnotationProcessor {

    private final Map<Class<?>, AnnotationHandler<?>> handlers;

    AnnotationProcessor() {
        handlers = new HashMap<>();
    }

    public <T extends Annotation> void register(Class<T> type, AnnotationHandler<T> handler) {
        handlers.putIfAbsent(type, handler);
    }

    public void process(Class<?> root) {
        for (Annotation annotation : root.getAnnotations()) {
            handle(annotation);
            for (Annotation subAnnotation : annotation.annotationType().getAnnotations()) {
                handle(subAnnotation);
            }
        }
    }

    private void handle(Annotation annotation) {
        Optional.ofNullable(handlers.get(annotation.annotationType())).ifPresent(h -> h.handle(annotation));
    }

}
