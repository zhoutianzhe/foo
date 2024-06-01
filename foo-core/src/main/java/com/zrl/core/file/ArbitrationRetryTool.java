package com.zrl.core.file;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.List;
import java.util.Set;

/**
 * @date 2018-10-25
 * 按行读取文件
 *
 */
public class ArbitrationRetryTool {

    public static void main(String[] args) throws IOException {

        String inputFileName = "/Users/zhouriliang/Desktop/ids.txt";


        input(inputFileName);

    }

    private static void input(String inputFileName) throws IOException {
        FileReader fileReader = new FileReader(inputFileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        Set<String> ids = Sets.newHashSet();
        List<String> orderCodes = Lists.newArrayList();
        String lineText = null;
        while(StringUtils.isNotBlank(lineText = bufferedReader.readLine())){
            String[] arr = lineText.split("\t");
            String idStr = arr[0].trim();
            String orderCodeStr = arr[1].trim();
            if(idStr.startsWith("100")){
                ids.add(idStr);
            }else{
                orderCodes.add(orderCodeStr);
            }

        }

        bufferedReader.close();

        System.out.println(ids);
        StringBuilder sb = new StringBuilder();
        for(String orderCode : orderCodes){
            sb.append("\"").append(orderCode).append("\"").append(", ");
        }
        String orderCodeJoin = sb.toString();
        orderCodeJoin = orderCodeJoin.substring(0, orderCodeJoin.length()-2);
        System.out.println(orderCodeJoin);

    }

}
