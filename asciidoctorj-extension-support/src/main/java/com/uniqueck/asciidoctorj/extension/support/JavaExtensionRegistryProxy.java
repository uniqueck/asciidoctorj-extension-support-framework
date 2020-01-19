package com.uniqueck.asciidoctorj.extension.support;

import org.asciidoctor.extension.*;

import java.lang.annotation.Annotation;

class JavaExtensionRegistryProxy implements JavaExtensionRegistry {

    private final JavaExtensionRegistry realJavaExtensionRegistry;
    private final AnnotationProcessor annotationProcessor;

    JavaExtensionRegistryProxy(JavaExtensionRegistry realJavaExtensionRegistry) {
        this.realJavaExtensionRegistry = realJavaExtensionRegistry;
        annotationProcessor = new AnnotationProcessor();
    }

    public <T extends Annotation> void registerAnnotationHandler(Class<T> annotation, AnnotationHandler<T> handler) {
        this.annotationProcessor.register(annotation, handler);
    }


    @Override
    public JavaExtensionRegistry docinfoProcessor(Class<? extends DocinfoProcessor> docInfoProcessor) {
        this.realJavaExtensionRegistry.docinfoProcessor(docInfoProcessor);
        return callAnnotationProcessortAndReturnThis(docInfoProcessor);
    }

    @Override
    public JavaExtensionRegistry docinfoProcessor(DocinfoProcessor docInfoProcessor) {
        this.realJavaExtensionRegistry.docinfoProcessor(docInfoProcessor);
        return callAnnotationProcessortAndReturnThis(docInfoProcessor.getClass());
    }

    @Override
    public JavaExtensionRegistry docinfoProcessor(String docInfoProcessor) {
        this.realJavaExtensionRegistry.docinfoProcessor(docInfoProcessor);
        return callAnnotationProcessortAndReturnThis(docInfoProcessor);
    }

    @Override
    public JavaExtensionRegistry preprocessor(Class<? extends Preprocessor> preprocessor) {
        this.realJavaExtensionRegistry.preprocessor(preprocessor);
        return callAnnotationProcessortAndReturnThis(preprocessor);
    }

    @Override
    public JavaExtensionRegistry preprocessor(Preprocessor preprocessor) {
        this.realJavaExtensionRegistry.preprocessor(preprocessor);
        return callAnnotationProcessortAndReturnThis(preprocessor.getClass());
    }

    @Override
    public JavaExtensionRegistry preprocessor(String preprocessor) {
        this.realJavaExtensionRegistry.preprocessor(preprocessor);
        return callAnnotationProcessortAndReturnThis(preprocessor);
    }

    @Override
    public JavaExtensionRegistry postprocessor(String postprocessor) {
        this.realJavaExtensionRegistry.postprocessor(postprocessor);
        return callAnnotationProcessortAndReturnThis(postprocessor);
    }

    @Override
    public JavaExtensionRegistry postprocessor(Class<? extends Postprocessor> postprocessor) {
        this.realJavaExtensionRegistry.postprocessor(postprocessor);
        return callAnnotationProcessortAndReturnThis(postprocessor);
    }

    @Override
    public JavaExtensionRegistry postprocessor(Postprocessor postprocessor) {
        this.realJavaExtensionRegistry.postprocessor(postprocessor);
        return callAnnotationProcessortAndReturnThis(postprocessor.getClass());
    }

    @Override
    public JavaExtensionRegistry includeProcessor(String includeProcessor) {
        this.realJavaExtensionRegistry.includeProcessor(includeProcessor);
        return callAnnotationProcessortAndReturnThis(includeProcessor);
    }

    @Override
    public JavaExtensionRegistry includeProcessor(Class<? extends IncludeProcessor> includeProcessor) {
        this.realJavaExtensionRegistry.includeProcessor(includeProcessor);
        return callAnnotationProcessortAndReturnThis(includeProcessor);
    }

    @Override
    public JavaExtensionRegistry includeProcessor(IncludeProcessor includeProcessor) {
        this.realJavaExtensionRegistry.includeProcessor(includeProcessor);
        return callAnnotationProcessortAndReturnThis(includeProcessor.getClass());
    }

    @Override
    public JavaExtensionRegistry treeprocessor(Treeprocessor treeprocessor) {
        this.realJavaExtensionRegistry.treeprocessor(treeprocessor);
        return callAnnotationProcessortAndReturnThis(treeprocessor.getClass());
    }

    @Override
    public JavaExtensionRegistry treeprocessor(Class<? extends Treeprocessor> abstractTreeProcessor) {
        this.realJavaExtensionRegistry.treeprocessor(abstractTreeProcessor);
        return callAnnotationProcessortAndReturnThis(abstractTreeProcessor);
    }

    @Override
    public JavaExtensionRegistry treeprocessor(String treeProcessor) {
        this.realJavaExtensionRegistry.treeprocessor(treeProcessor);
        return callAnnotationProcessortAndReturnThis(treeProcessor);
    }

    @Override
    public JavaExtensionRegistry block(String blockName, String blockProcessor) {
        this.realJavaExtensionRegistry.block(blockName, blockProcessor);
        return callAnnotationProcessortAndReturnThis(blockProcessor);
    }

    @Override
    public JavaExtensionRegistry block(String blockProcessor) {
        this.realJavaExtensionRegistry.block(blockProcessor);
        return callAnnotationProcessortAndReturnThis(blockProcessor);
    }

    @Override
    public JavaExtensionRegistry block(String blockName, Class<? extends BlockProcessor> blockProcessor) {
        this.realJavaExtensionRegistry.block(blockName, blockProcessor);
        return callAnnotationProcessortAndReturnThis(blockProcessor);
    }

    @Override
    public JavaExtensionRegistry block(Class<? extends BlockProcessor> blockProcessor) {
        this.realJavaExtensionRegistry.block(blockProcessor);
        return callAnnotationProcessortAndReturnThis(blockProcessor);
    }

    @Override
    public JavaExtensionRegistry block(BlockProcessor blockProcessor) {
        this.realJavaExtensionRegistry.block(blockProcessor);
        return callAnnotationProcessortAndReturnThis(blockProcessor.getClass());
    }

    @Override
    public JavaExtensionRegistry block(String blockName, BlockProcessor blockProcessor) {
        this.realJavaExtensionRegistry.block(blockName, blockProcessor);
        return callAnnotationProcessortAndReturnThis(blockProcessor.getClass());
    }

    @Override
    public JavaExtensionRegistry blockMacro(String blockName, Class<? extends BlockMacroProcessor> blockMacroProcessor) {
        realJavaExtensionRegistry.blockMacro(blockName, blockMacroProcessor);
        return callAnnotationProcessortAndReturnThis(blockMacroProcessor);
    }

    @Override
    public JavaExtensionRegistry blockMacro(Class<? extends BlockMacroProcessor> blockMacroProcessor) {
        realJavaExtensionRegistry.blockMacro(blockMacroProcessor);
        return callAnnotationProcessortAndReturnThis(blockMacroProcessor);
    }

    @Override
    public JavaExtensionRegistry blockMacro(String blockName, String blockMacroProcessor) {
        realJavaExtensionRegistry.blockMacro(blockName, blockMacroProcessor);
        return callAnnotationProcessortAndReturnThis(blockMacroProcessor);
    }

    @Override
    public JavaExtensionRegistry blockMacro(String blockMacroProcessor) {
        realJavaExtensionRegistry.blockMacro(blockMacroProcessor);
        return callAnnotationProcessortAndReturnThis(blockMacroProcessor);
    }

    @Override
    public JavaExtensionRegistry blockMacro(BlockMacroProcessor blockMacroProcessor) {
        this.realJavaExtensionRegistry.blockMacro(blockMacroProcessor);
        return callAnnotationProcessortAndReturnThis(blockMacroProcessor.getClass());
    }

    @Override
    public JavaExtensionRegistry blockMacro(String blockName, BlockMacroProcessor blockMacroProcessor) {
        this.realJavaExtensionRegistry.blockMacro(blockName, blockMacroProcessor);
        return callAnnotationProcessortAndReturnThis(blockMacroProcessor.getClass());
    }

    @Override
    public JavaExtensionRegistry inlineMacro(InlineMacroProcessor inlineMacroProcessor) {
        this.realJavaExtensionRegistry.inlineMacro(inlineMacroProcessor);
        return callAnnotationProcessortAndReturnThis(inlineMacroProcessor.getClass());
    }

    @Override
    public JavaExtensionRegistry inlineMacro(String macroName, InlineMacroProcessor inlineMacroProcessor) {
        this.realJavaExtensionRegistry.inlineMacro(macroName, inlineMacroProcessor);
        return callAnnotationProcessortAndReturnThis(inlineMacroProcessor.getClass());
    }

    @Override
    public JavaExtensionRegistry inlineMacro(String macroName, Class<? extends InlineMacroProcessor> inlineMacroProcessor) {
        this.realJavaExtensionRegistry.inlineMacro(macroName, inlineMacroProcessor);
        return callAnnotationProcessortAndReturnThis(inlineMacroProcessor);
    }

    @Override
    public JavaExtensionRegistry inlineMacro(Class<? extends InlineMacroProcessor> inlineMacroProcessor) {
        this.realJavaExtensionRegistry.inlineMacro(inlineMacroProcessor);
        return callAnnotationProcessortAndReturnThis(inlineMacroProcessor);
    }

    @Override
    public JavaExtensionRegistry inlineMacro(String blockName, String inlineMacroProcessor) {
        this.realJavaExtensionRegistry.inlineMacro(blockName, inlineMacroProcessor);
        return callAnnotationProcessortAndReturnThis(inlineMacroProcessor);
    }

    @Override
    public JavaExtensionRegistry inlineMacro(String inlineMacroProcessor) {
        this.realJavaExtensionRegistry.inlineMacro(inlineMacroProcessor);
        return callAnnotationProcessortAndReturnThis(inlineMacroProcessor);
    }


    private JavaExtensionRegistryProxy callAnnotationProcessortAndReturnThis(Class<?> root) {
        this.annotationProcessor.process(root);
        return this;
    }

    private JavaExtensionRegistryProxy callAnnotationProcessortAndReturnThis(String className) {
        try {
            return callAnnotationProcessortAndReturnThis(Class.forName(className));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
