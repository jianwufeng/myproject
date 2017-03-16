package com.crm.util.export.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class BulidFile {

    public static boolean buildFile(List<String> fileContent, String fileName) {

        if (fileContent == null || fileContent.size() <= 0 || StringUtils.isEmpty(fileName)) {
            return false;
        }

        File file = new File(fileName);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        FileWriter fw = null;
        BufferedWriter writer = null;

        try {
            fw = new FileWriter(file);
            writer = new BufferedWriter(fw);
            for (String line : fileContent) {
                writer.write(line);
                writer.newLine();// 换行
            }
            writer.flush();

            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }

                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    public static List<String> readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        List<String> fileContentList = new ArrayList<String>();
        try {
            reader = new BufferedReader(new FileReader(file));
            String lineString = null;

            // 一次读入一行，直到读入null为文件结束
            while ((lineString = reader.readLine()) != null) {
                fileContentList.add(lineString);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }

        return fileContentList;
    }

}
