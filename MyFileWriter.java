
import java.io.*;
import java.nio.file.*;

public class MyFileWriter {

    public static void main(String[] args) throws IOException {
        String hiddenFileName = ".secretpassword.txt";
        String password = "SuperSecretPassword123!";
        String hiddenFolder = ".classified";
        String regularFileName = "confidential.dat";
        String secretData = "Top Secret Data: Highly Confidential.";

        try (
                FileWriter hiddenFileWriter = new FileWriter(hiddenFileName)) {
            hiddenFileWriter.write(password);
        }

        Path hiddenFolderPath = Paths.get(hiddenFolder);
        Files.createDirectory(hiddenFolderPath);

        try (FileWriter regularFileWriter = new FileWriter(hiddenFolder + "/" + regularFileName)) {
            regularFileWriter.write(secretData);
        }
    }
}
