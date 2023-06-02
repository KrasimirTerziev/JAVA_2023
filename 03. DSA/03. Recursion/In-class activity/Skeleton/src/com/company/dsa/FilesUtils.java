package com.company.dsa;

import java.io.File;
import java.nio.file.Paths;
import java.util.*;

public class FilesUtils {

    public static void main(String[] args) {
        String path = Paths.get("demo").toAbsolutePath().toString();
        System.out.println(FilesUtils.getDirectoryStats(path));
//        System.out.println(fileExists(path, "test-3.md"));
//        System.out.println(fileExists(path, "test-2.md"));
//        FilesUtils.traverseDirectories(path);
//        System.out.println(findFiles(path, "md"));
    }

    public static void traverseDirectories(String path) {
        traverseDirectories(path, 0);
    }

    public static void traverseDirectories(String path, int indent) {
        String rootIndent = "  ".repeat(indent);
        File file = new File(path);
        System.out.println(rootIndent + file.getName());

        if (!file.exists()) {
            throw new IllegalArgumentException("Invalid Path name");
        }

        File[] files = file.listFiles();

        String contentIndent = rootIndent + "  ";
        for (File f : files) {
            if (f.isFile()) {
                System.out.println(contentIndent + f.getName());
            }
        }

        for (File d : files) {
            if (d.isDirectory()) {
                traverseDirectories(d.getAbsolutePath(), indent + 1);
            }
        }
    }


    public static List<String> findFiles(String path, String extension) {
        List<String> result = new ArrayList<>();
        File file = new File(path);
        File[] files = file.listFiles();

        if (!file.exists()) {
            throw new IllegalArgumentException("Invalid Path name");
        }

        for (File f : files) {
            if (f.isFile() && f.getName().endsWith(extension)) {
                result.add(f.getName());
            }
            if (f.isDirectory()) {
                result.addAll(findFiles(f.getAbsolutePath(), extension));
            }
        }
        return result;
    }

    public static boolean fileExists(String path, String fileName) {
        File file = new File(path);
        File[] files = file.listFiles();

        for (File f : files) {
            if (f.isFile() && f.getName().equals(fileName)) {
                return true;
            }
            if (f.isDirectory() && fileExists(f.getAbsolutePath(), fileName)) {
                return true;
            }
        }
        return false;
    }

    public static Map<String, Integer> getDirectoryStats(String path) {
        return getDirectoryStats(path, new HashMap<>());
    }

    public static Map<String, Integer> getDirectoryStats(String path, Map<String, Integer> stats) {
        File file = new File(path);
        File[] files = file.listFiles();

        for (File f : files) {
            if (f.isFile()) {
                String extension = getExtension(f.getName());
                stats.put(extension, stats.getOrDefault(extension, 0) + 1);
            }
            if (f.isDirectory()){
                getDirectoryStats(f.getAbsolutePath(), stats);
            }
        }
        return stats;
    }

    private static String getExtension(String name) {
        int index = name.lastIndexOf('.');
        if (index == - 1){
            return "Non-existing";
        }
        return name.substring(index + 1);
    }
}
