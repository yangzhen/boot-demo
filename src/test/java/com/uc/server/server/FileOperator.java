package com.uc.server.server;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import org.apache.commons.lang3.StringUtils;

/**
 * @author yangxinyan
 * @date 2019/4/23 17:28
 */
public class FileOperator {

  public static void main(String[] args) throws IOException {
    Path path = Paths.get("/Users/yangxinyan/Downloads/weixindx.sql");

    Map<String,Map<String,Map<String,String>>> allMap = new HashMap<>();
    List<String> list = Files.readAllLines(path);

    list.stream().filter(t->t.contains("where")).forEach(k -> {
      String table = StringUtils.substringBeforeLast(k,"set").split("UPDATE")[1].trim();
      if(!allMap.containsKey(table)) {
        Map<String,Map<String,String>> map = new HashMap<>();
        allMap.put(table,map);
      }
      Map<String,Map<String,String>> map = allMap.get(table);
      String where = StringUtils.substringAfterLast(k,"where").split(";")[0].trim();
      String update = StringUtils.substringBefore(StringUtils.substringAfterLast(k,"set"),"where");
      String[] arr = update.split(",");

      if(!map.containsKey(where)) {
        Map<String,String> kvmap = new LinkedHashMap<>();
        map.put(where,kvmap);
      }
      Map<String,String> kvmap = map.get(where);
      for(String str : arr) {
        String key = str.split("=")[0];
        String value = str.split("=")[1];
        kvmap.put(key,value);
      }

    });

    System.out.println(allMap);
    for(Entry<String,Map<String,Map<String,String>>> entryall : allMap.entrySet()) {
      String table = entryall.getKey();
      Map<String,Map<String,String>> map = entryall.getValue();
      Map<String,StringBuilder> sbmap = new TreeMap<>();
      for(Entry<String,Map<String,String>> entry : map.entrySet()) {
        String where = entry.getKey();
        String wherename = where.split("=")[0];
        String wherevalue = where.split("=")[1];

        Map<String,String> value = entry.getValue();
        for(Entry<String,String> mmun : value.entrySet()) {
          String unk = mmun.getKey();
          String unv = mmun.getValue();
          if(!sbmap.containsKey(unk)) {
            StringBuilder sbqw = new StringBuilder(" ").append(unk).append("= ( case ").append(" " + wherename + " ");
            sbmap.put(unk,sbqw);
          }
          StringBuilder sb = sbmap.get(unk);
          sb.append(" when ").append(wherevalue).append(" then ").append( "" + unv + " ");
        }
      }

      StringBuilder sql = new StringBuilder();
      sql.append("update " + table +  " set ");
      System.out.println("=================");
      for(Entry<String,StringBuilder> entry : sbmap.entrySet()) {
        System.out.println(entry.getKey());
        String key = entry.getKey();
        StringBuilder value = entry.getValue();
        value.append(" else ").append(key).append(" end) ");
        sql.append(value).append(",");
      }

      System.out.println(StringUtils.substringBeforeLast(sql.toString(),",")+";");
    }

  }

}
