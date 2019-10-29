package org.btarikool.javacourse;

import javafx.stage.FileChooser;
import sun.rmi.runtime.Log;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public class Logger {

    private final static long LOG_CLEAR_TIME = 60000;
    private File logPath = new File(System.getProperty("user.dir").
            concat("\\log\\log_".concat(String.valueOf(new Date().getTime())).concat(".log")));
    private PrintWriter writer;


    public void logString(String message) {
        try {
            this.writer = new PrintWriter(new FileWriter(logPath, true), true);
            writer.write(message + "\n");
            clearLogFiles();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void logList(List<Animal> list) {
        String listToString = list.stream().
                        map(animal -> animal.toString()).
                        collect(Collectors.joining("\n"));
        logString(listToString);
    }

    public String listToString(List<Animal> list) {
        return list.stream().
                map(animal -> animal.toString()).
                collect(Collectors.joining("\n"));
    }

    public void saveLogWithPathChooser(String log) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialFileName("log_".concat(String.valueOf(new Date().getTime())).concat(".log"));
        fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("log", "log", "log"));
        File path = fileChooser.showSaveDialog(null);
        if (path != null) {
            logPath = new File(path.getAbsolutePath());
            logString(log);
        } else {
            System.out.println("Choose a path");
        }
    }

    private void clearLogFiles() {
        Path path = Paths.get(System.getProperty("user.dir").concat("\\log\\")).toAbsolutePath();
        try {
            Files.walkFileTree(path,  EnumSet.of(FileVisitOption.FOLLOW_LINKS), 1, new MyVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class MyVisitor extends SimpleFileVisitor {
        @Override
        public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
            if (attrs.isRegularFile() && attrs.creationTime().toMillis() < (new Date().getTime() - LOG_CLEAR_TIME)) {
                Files.delete(((Path)file));
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
