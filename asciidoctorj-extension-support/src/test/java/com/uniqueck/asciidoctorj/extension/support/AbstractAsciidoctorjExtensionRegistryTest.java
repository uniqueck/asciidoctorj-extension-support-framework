package com.uniqueck.asciidoctorj.extension.support;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.ast.StructuralNode;
import org.asciidoctor.extension.BlockMacroProcessor;
import org.asciidoctor.extension.JavaExtensionRegistry;
import org.asciidoctor.extension.Name;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

@ExtendWith(MockitoExtension.class)
class AbstractAsciidoctorjExtensionRegistryTest {


    @RequireLibraryAsciidoctorDiagram
    @Name("MySimple")
    private static class MySimpleExtension extends BlockMacroProcessor {

        @Override
        public Object process(StructuralNode structuralNode, String s, Map<String, Object> map) {
            return null;
        }
    }


    private static class ClassUnderTest extends AbstractAsciidoctorjExtensionRegistry {

        @Override
        protected void registerExtension(JavaExtensionRegistry extensionRegistry) {
            extensionRegistry.blockMacro(MySimpleExtension.class);
        }
    }


    @Test
    void registerBlockMacroAndRequiredLibraryWithValueAsciidoctorDiagram(@Mock Asciidoctor asciidoctor, @Mock JavaExtensionRegistry extensionRegistry) {

        Mockito.lenient().when(asciidoctor.javaExtensionRegistry()).thenReturn(extensionRegistry);

        new ClassUnderTest().register(asciidoctor);

        Mockito.verify(extensionRegistry).blockMacro(MySimpleExtension.class);
        Mockito.verify(asciidoctor).requireLibrary("asciidoctor-diagram");
    }

}