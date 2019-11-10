package org.btarikool.javacourse.config;

import javafx.stage.FileChooser;
import org.btarikool.javacourse.animal.Animal;
import org.btarikool.javacourse.customer.Customer;
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

    private static Logger instance = new Logger();
    private static final long LOG_CLEAR_TIME = 60000;
    private static final String SEPARATOR = "\n-----------------------------------------------------------------------\n";
    private String path = System.getProperty("user.dir").concat("\\log\\" + "%s" + "_log_".concat(String.valueOf(new Date().getTime())).concat(".log"));

    private Logger() {
    }

    public static Logger getInstance() {
        return instance;
    }

    public void logString(String message, String prefix) {
        File logPath = new File(String.format(path, prefix));
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(logPath, false), true);
            writer.write(message + SEPARATOR);
            clearLogFiles();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logList(List<Animal> list) {
        String listToString = list.stream().
                        map(animal -> animal.toString()).
                        collect(Collectors.joining(SEPARATOR));
        logString(listToString, "animals");
    }

    public void logCustomersList(List<Customer> list) {
        String listToString = list.stream().
                map(customer -> customer.toString()).
                collect(Collectors.joining(SEPARATOR));
        logString(listToString, "customers");
    }

    public String listToString(List<?> list) {
        return list.stream().
                map(a -> a.toString()).
                collect(Collectors.joining("\n"));
    }

    public void saveLogWithPathChooser(String log, String prefix) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialFileName("log_".concat(String.valueOf(new Date().getTime())).concat(".log"));
        fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("log", "log", "log"));
        File path = fileChooser.showSaveDialog(null);
        if (path != null) {
            this.path = String.format(path.getAbsolutePath(), prefix);
            logString(log, prefix);
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
