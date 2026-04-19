package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) throws IOException {
        //Em chọn test.exe = file đề bài OOP Lab3 để chạy thử chương trình
        String filename = "D:\\OOP\\OOPLab-761938-202416842-VuLanAnh\\OtherProjects\\src\\hust\\soict\\hedspi\\garbage\\OOP-Lab03-ObjectOrientedTechniques.pdf";
        byte[] inputBytes = Files.readAllBytes(Paths.get(filename));
        long startTime = System.currentTimeMillis();

        StringBuilder outputStringBuilder = new StringBuilder();
        for (byte b : inputBytes) {
            outputStringBuilder.append((char) b);
        }

        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}