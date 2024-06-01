package com.zrl.core.file;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.util.*;

/**
 * @date 2018-10-25
 * 按行读取文件
 *
 */
public class FileReadWrite {




    public static void main(String[] args) throws IOException {

        String inputFileName = "/Users/zhouriliang/Desktop/network";

        String outputFileName = "/Users/zhouriliang/Desktop/network";

        List<String> datas = input(inputFileName);
        //if(!CollectionUtils.isEmpty(datas)){
        //    output(outputFileName, datas);
        //}
        input(inputFileName);
    }


    private static void input() throws IOException {
        String inputFileName = "/Users/zhouriliang/Desktop/liuyuan_guoguo_cmpt.txt";

        String inputFileName2 = "/Users/zhouriliang/Desktop/xx.txt";

        String outputFileName = "/Users/zhouriliang/Desktop/output.txt";

        FileReader fileReader = new FileReader(inputFileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Set<String> orderCodes = new HashSet<>(1500000);
        String lineText = null;
        while(StringUtils.isNotBlank(lineText = bufferedReader.readLine())){
            orderCodes.add(lineText.trim());
        }


        FileReader fileReader2 = new FileReader(inputFileName2);
        BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
        String lineText2 = null;
        Map<String, List<String>> maps = new HashMap<>(100000);
        while(StringUtils.isNotBlank(lineText2 = bufferedReader2.readLine())){
            String[] arr = lineText2.split("\t");
            String orderCode = arr[1].trim();
            List<String> list = maps.get(orderCode);
            if(list == null){
                list = Lists.newArrayList();
                list.add(lineText2);
                maps.put(orderCode, list);
            }else{
                list.add(lineText2);
            }
        }

        List<String> list = new LinkedList<String>();
        for(Map.Entry<String, List<String>> entry : maps.entrySet()){
            if(orderCodes.contains(entry.getKey())){
                list.addAll(entry.getValue());
            }
        }



        File outputFile = new File(outputFileName);
        FileWriter fileWriter = new FileWriter(outputFile);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for(String data : list){
            bufferedWriter.write(data);
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();
        bufferedWriter.close();

        bufferedReader.close();
        bufferedReader2.close();
    }



    private static List<String> input(String inputFileName) throws IOException {
        FileReader fileReader = new FileReader(inputFileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        Set<String> ids = Sets.newHashSet();
        List<String> orderCodes = Lists.newArrayList();
        String lineText = null;
        while(StringUtils.isNotBlank(lineText = bufferedReader.readLine())){
            String[] arr = lineText.split(",");
            String codex = arr[1];

            orderCodes.add(codex);
        }



        StringBuilder sb = new StringBuilder();
        for(String orderCode : orderCodes){
            sb.append("'").append(orderCode.trim()).append("'").append(",");
        }

        Set set = new HashSet(orderCodes);

        System.out.println(orderCodes.size());
        System.out.println(set.size());

        System.out.println(sb.toString());



        bufferedReader.close();

        return orderCodes;
    }

    private static void output(String outputFileName, List<String> datas) throws IOException {
        File outputFile = new File(outputFileName);
        FileWriter fileWriter = new FileWriter(outputFile);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for(String data : datas){
            bufferedWriter.write(data + ";");
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }

}
