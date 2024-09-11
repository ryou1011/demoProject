import java.io.*;
import java.nio.file.*;

public class MyFileWriter {

    public static void main(String[] args) throws IOException {
        String hiddenFileName = ".secretpassword.txt";
        String password = "SuperSecretPassword123!";
        String hiddenFolder = ".classified";
        String regularFileName = "confidential.dat";
        String secretData = "Top Secret Data: Highly Confidential.";

        // Write to hidden file
        try (FileWriter hiddenFileWriter = new FileWriter(hiddenFileName)) {
            hiddenFileWriter.write(password);
        }

        // Create hidden folder
        Path hiddenFolderPath = Paths.get(hiddenFolder);
        Files.createDirectory(hiddenFolderPath);

        // Write to regular file inside the hidden folder
        try (FileWriter regularFileWriter = new FileWriter(hiddenFolder + "/" + regularFileName)) {
            regularFileWriter.write(secretData);
        }

        printFileSize(hiddenFileName);
        printFileSize(hiddenFolder + "/" + regularFileName);
    }

    private static void printFileSize(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            System.out.println("File size of " + fileName + ": " + file.length() + " bytes.");
        } else {
            System.out.println("File " + fileName + " does not exist.");
        }
    }

    private static void printTotalFileSize(String... fileNames) {
        long totalSize = 0;
        for (String fileName : fileNames) {
            File file = new File(fileName);
            if (file.exists()) {
                totalSize += file.length();
            }
        }
        System.out.println("Total size of all files: " + totalSize + " bytes");
    }
}
