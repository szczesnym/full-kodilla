package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {

    public void readFile() {
       ClassLoader classLoader = getClass().getClassLoader();
//        System.out.println(getClass().getClassLoader().findRe);
        System.out.println(classLoader.getClass().getClassLoader());
        //System.out.println(FileReader.class.getResource("/src/main/resources/names.txt"));
        File file = new File("C:\\Users\\marcins\\IdeaProjects\\kodilla-course\\kodilla-exception\\src\\main\\resources\\names.txt");
        System.out.println(file.getPath());
        Path path = Paths.get(file.getPath());
        try {
            Stream<String> fileLines = Files.lines(path);
            fileLines.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Something wrong EXceptions");
        }
    }
}
