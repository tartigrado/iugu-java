package com.iugu.components.rsa;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

@SuperBuilder
@Getter
public class FilePrivateKeyProvider extends StringPrivateKeyProvider {

    public FilePrivateKeyProvider(File privateKey) throws IOException {
        super(Files.readString(privateKey.toPath(), StandardCharsets.UTF_8));
    }

    public FilePrivateKeyProvider(Path path) throws IOException {
        this(path.toFile());
    }
}
