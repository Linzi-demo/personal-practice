package com.grove.skill.io.output;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Component
@Slf4j
public class FileOutputWithoutFile {

    public void start() {
        String str = "ABCDE";

        try {
            byte[] bytes = str.getBytes("utf-8");

            FileOutputStream fileOutputStream = new FileOutputStream("test.txt", true);
            fileOutputStream.write(bytes);
            fileOutputStream.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
