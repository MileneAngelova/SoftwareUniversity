package bg.softuni.ProductShop.utils.impl;

import bg.softuni.ProductShop.utils.FileIOUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.stream.Collectors;

public class FileIOUtilsImpl implements FileIOUtils {
    @Override
    public String readFileContent(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath))
                .stream()
                .filter(x -> !x.isEmpty())
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public void write(String content, String filePth) throws IOException {
        Files.write(Paths.get(filePth), Collections.singleton(content), StandardCharsets.UTF_8);
    }
}
