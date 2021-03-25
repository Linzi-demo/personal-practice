package com.grove.skill.io.file;

import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileApi {

    public void start() {
        Path path = Paths.get("E:\\workspace\\github\\personal-practice\\java-skill-pratice\\src\\main\\java\\com\\grove\\skill\\io\\file\\FileApi.java");
        System.out.println(Files.exists(path));
    }


}
