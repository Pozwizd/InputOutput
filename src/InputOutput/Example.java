package InputOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.util.Scanner;
import java.util.UUID;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Example {

    public static void main(String[] args) throws IOException {

        // 3.1
        File docsDir = new File("uploaded/docs");
        docsDir.mkdirs();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите имя файла (или stop для выхода): ");
            String input = scanner.nextLine();
            if (input.equals("stop")) {
                break;
            }

            String uuid = UUID.randomUUID().toString();
            String fileName = uuid + "_" + input + ".txt";

            File file = new File(docsDir, fileName);
            System.out.print("Введите текст для файла " + fileName + ": ");
            String content = scanner.nextLine();

            Files.write(file.toPath(), content.getBytes());
            System.out.println("Файл " + fileName + " создан");
        }

        System.out.print("Введите слово для поиска: ");
        String keyword = scanner.nextLine();

        File[] files = docsDir.listFiles((dir, name) -> name.endsWith(".txt"));
        for (File file : files) {
            if (Files.readString(file.toPath()).contains(keyword)) {
                System.out.println("Найден файл: " + file.getName());
            }
        }

        // 3.2
        File usersFile = new File("users.txt");
       System.out.print("Введите имена через пробел: ");
        String names = scanner.nextLine();
        Files.writeString(usersFile.toPath(), names);

        // 3.3
        String users = Files.readString(usersFile.toPath());
        String[] namesArray = users.split(" ");
        System.out.println(Arrays.toString(namesArray));

        // 3.4
        File file1 = new File("file1.txt");
        Files.write(file1.toPath(), "Roman".getBytes());
        File file2 = new File("file2.txt");
        Files.write(file1.toPath(), "Roman".getBytes());
        Files.copy(file1.toPath(), file2.toPath());

        boolean equal = Arrays.equals(Files.readAllBytes(file1.toPath()),
                Files.readAllBytes(file2.toPath()));
        System.out.println("Файлы " + (equal ? "равны" : "не равны"));

        // 3.5
        File tempDir = new File("temp");
        tempDir.mkdir();
        File[] tempFiles = tempDir.listFiles();
        for (File f : tempFiles) {
            Files.delete(f.toPath());
            System.out.println("Удален файл " + f.getName());
        }

        // 3.6
        String ext = ".txt";
        File folder = new File(".");
        File[] found = folder.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(ext);
            }
        });
        System.out.println(Arrays.toString(found));

    }

}