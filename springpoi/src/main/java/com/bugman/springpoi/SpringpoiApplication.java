package com.bugman.springpoi;

import com.bugman.springpoi.job.ExcelSplitJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@SpringBootApplication
public class SpringpoiApplication implements CommandLineRunner {

    @Autowired
    ExcelSplitJob excelSplitJob;

    public static void main(String[] args) {
        SpringApplication.run(SpringpoiApplication.class, args);
    }


    /**
     * /Users/zhoulinjun/Downloads/临时文件/test.xlsx
     * Sheet1 (3)
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("输入文件路径：");
        String filePath = sc.nextLine();
        System.out.print("输入sheet名：");
        String sheetName = sc.nextLine();
        System.out.print("输入处理列（数字）：");
        String dealCol = sc.nextLine();


        Map<String,String> param = new HashMap<>();
        param.put("filePath",filePath);
        param.put("sheetName",sheetName);
        param.put("dealCol",dealCol);

        System.out.println("处理中.........");
        excelSplitJob.excute(param);
        System.out.println("处理完成.......");


    }
}
