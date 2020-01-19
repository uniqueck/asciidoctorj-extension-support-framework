package com.uniqueck.asciidoctorj.extension.support;


import org.asciidoctor.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class AbstractAsciidoctorjExtensionSupportTestHelper {

    @TempDir
    File tempDir;

    protected File getBaseDir() {
        return new File("src/test/resources");
    }

    protected File getTempDir() {
        return tempDir;
    }

    private Asciidoctor asciidoctor;

    protected Options createOptions() {
        return OptionsBuilder.options().baseDir(getBaseDir()).inPlace(true).safe(SafeMode.UNSAFE).backend("html5").toFile(false).destinationDir(tempDir.getAbsoluteFile()).attributes(AttributesBuilder.attributes().attribute("imagesdir", new File(tempDir, "images").getAbsolutePath())).get();
    }

    @BeforeEach
    void setup() {
        asciidoctor = Asciidoctor.Factory.create();
    }

    protected String convert(String content) {
        return convert(content, createOptions());
    }

    protected String convert(String content, Options options) {
        return getAsciidoctor().convert(content, options);
    }

    protected String convertFile(String fileName) {
        return getAsciidoctor().convertFile(new File(fileName), createOptions());
    }

    protected void assertTempDirectoryContainsDirectory(String directoryName) {
        assertTrue(new File(tempDir, directoryName).isDirectory());
    }

    protected void assertTempDirectoryDoNotContainsDirectory(String directoryName) {
        assertFalse(new File(tempDir, directoryName).isDirectory());
    }

    protected void assertTempDirectoryContainsFile(String relativeFilePath) {
        assertTrue(new File(tempDir, relativeFilePath).isFile());
    }

    protected void assertTempDirectoryDoNotContainsFile(String relativeFilePath) {
        assertFalse(new File(tempDir, relativeFilePath).isFile());
    }

    protected Asciidoctor getAsciidoctor() {
        return asciidoctor;
    }

}
