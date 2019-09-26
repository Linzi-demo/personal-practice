package com.bugman.springpoi.pojo;

import lombok.Data;

import java.util.List;

@Data
public class ExcelPo<T> {

    private List<String> titles;

    private List<T> datas;

}
