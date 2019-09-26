package com.bugman.springpoi.job;

import com.bugman.springpoi.service.ExcelReader;
import org.apache.poi.ss.usermodel.CellCopyPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

@Service
public class ExcelSplitJob {
    private static final Logger LOG = LoggerFactory.getLogger(ExcelSplitJob.class);

    @Autowired
    ExcelReader excelReader;

    public void excute(Map<String, String> param) {
        String filePath = param.get("filePath");
        Integer dealCol = Integer.valueOf(param.get("dealCol"));

        XSSFWorkbook workbook = null;
        FileOutputStream excelFileOutPutStream = null;
        try {
            workbook = excelReader.readExcel(filePath);

            XSSFSheet sheet = workbook.getSheet(param.get("sheetName"));

            if (sheet == null) {
                return;
            }

            int rowNum = 0;
            int addNum = 0;
            while (true){
                XSSFRow row = sheet.getRow(rowNum);
                if(row==null){
                    break;
                }
                XSSFCell cell = row.getCell(dealCol);
                String value="";
                try {
                    value = cell.getStringCellValue();
                }catch (Exception e){
                    LOG.error("获取单元格值失败，行数："+(rowNum+1),e);
                }
                String[] splitValues = splitValue(value);
                if(splitValues==null){
                    rowNum++;
                    continue;
                }

                cell.setCellValue(splitValues[0].trim());
                for(int j=1;j<splitValues.length;j++){
                    sheet.shiftRows(rowNum+j, sheet.getLastRowNum()+addNum+1, 1, true, false);
                    XSSFRow copyRow = sheet.createRow(rowNum + j);
                    CellCopyPolicy cellCopyPolicy = new CellCopyPolicy();
                    copyRow.copyRowFrom(row,cellCopyPolicy);
                    XSSFCell copyRowCell = copyRow.getCell(dealCol);
                    copyRowCell.setCellValue(splitValues[j].trim());
                    //12列特殊处理
                    XSSFCell copyRowCell2 = copyRow.getCell(12);
                    copyRowCell2.setCellValue(row.getCell(12).getNumericCellValue());
                    addNum++;
                }
                rowNum = rowNum+splitValues.length-1;
            }

            excelFileOutPutStream = new FileOutputStream(filePath);
            workbook.write(excelFileOutPutStream);
            excelFileOutPutStream.flush();


        } catch (Exception e) {
            LOG.error("发生异常", e);
        } finally {
            try {
                if (workbook != null) {

                    workbook.close();

                }
                if (excelFileOutPutStream != null) {
                    excelFileOutPutStream.close();
                }
            } catch (IOException e) {
                LOG.error(e.getMessage());
            }
        }


    }

    private String[] splitValue(String value) {
        if(StringUtils.isEmpty(value)){
            return null;
        }
        String[] split = value.split(",");
        if(split.length>1){
            return split;
        }
        String[] split1 = value.split("，");
        if(split1.length>1){
            return split1;
        }
        return null;

    }

}
