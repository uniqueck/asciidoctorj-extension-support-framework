package com.uniqueck.asciidoctorj.extension.support;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.extension.JavaExtensionRegistry;
import org.asciidoctor.jruby.extension.spi.ExtensionRegistry;

public abstract class AbstractAsciidoctorjExtensionRegistry implements ExtensionRegistry {

    protected abstract void registerExtension(JavaExtensionRegistry extensionRegistry);

    @Override
    public final void register(Asciidoctor asciidoctor) {
        JavaExtensionRegistryProxy extensionRegistryProxy = new JavaExtensionRegistryProxy(asciidoctor.javaExtensionRegistry());
        extensionRegistryProxy.registerAnnotationHandler(AsciidoctorjRequiredLibrary.class, annotation -> asciidoctor.requireLibrary(annotation.value()));
        registerExtension(extensionRegistryProxy);
    }



}
