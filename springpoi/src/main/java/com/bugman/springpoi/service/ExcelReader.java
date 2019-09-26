package com.bugman.springpoi.service;


import lombok.extern.log4j.Log4j2;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;

@Service
public class ExcelReader {

    private static final Logger LOG = LoggerFactory.getLogger(ExcelReader.class);


    public XSSFWorkbook readExcel(String path) throws Exception {
        File file = new File(path);
        FileInputStream fis = null;
        try {
            if(file.exists() && file.isFile()){
                fis = new FileInputStream(file);
                XSSFWorkbook workbook = new XSSFWorkbook(fis);

                return workbook;
            }else {
                throw new Exception("文件不存在或者不符合格式");
            }
        }finally {
            if(fis!=null){
                fis.close();
            }
        }

    }

}
