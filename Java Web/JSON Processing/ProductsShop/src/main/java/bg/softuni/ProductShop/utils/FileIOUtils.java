package bg.softuni.ProductShop.utils;

import java.io.IOException;

public interface FileIOUtils {

    String readFileContent(String filePath) throws IOException;

    void write(String content, String filePth) throws IOException;
}
