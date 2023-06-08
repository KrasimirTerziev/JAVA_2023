package com.company.dsa;

import java.io.File;

public class CountFiles {

    public static void main(String[] args) {
        System.out.println(countTxtFiles(new File("C:\\ExamplePath\\")));
    }

    public static int countTxtFiles(File dir) {
        File[] files = dir.listFiles();
        if (files == null) {
            return 0;
        }

        if (files.length == 0) {
            return 0;
        }

        int count = 0;
        for (File file : files) {
            if (file.isFile()) {
                if (file.getName().endsWith(".txt")) {
                    count++;
                }
            } else {
                count += countTxtFiles(file);
            }
        }

        return count;
    }
}
