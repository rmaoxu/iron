package com.example.iron.util;

import com.alibaba.fastjson2.schema.ValidateResult;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
public class CsvUtil {

    public static List<Map<String,String>> getCsvData(String filePath)throws IOException {

        BufferedReader file = new BufferedReader(new InputStreamReader(
                Files.newInputStream(Paths.get(filePath)), StandardCharsets.UTF_8));
        List<Map<String,String>> dataList = new ArrayList<>();
        //忽略第一行
        String[] titleArray = file.readLine().split(",");
        // 遍历表中的每一行
        String record; //每一行数据
        while((record = file.readLine()) != null){
            Map<String, String> dataMap = new HashMap<>();
            //csv文件的数据均以','分隔，以此为分隔，存到数组
            String[] dataArray = record.split(",");
            for (int i = 0; i < titleArray.length; i++) {
                dataMap.put(titleArray[i],dataArray[i]);
            }
            dataList.add(dataMap);
        }
        file.close();
        return dataList;
    }
    public static String jsonStrParse(String jsonTemp,Map<String, String> parseJson){
        String repJsonStr = jsonTemp;
        for (Map.Entry<String, String> map : parseJson.entrySet()) {
            repJsonStr = repJsonStr.replace("$csv{" + map.getKey() + "}", map.getValue());
        }
        return repJsonStr;
    }

}

