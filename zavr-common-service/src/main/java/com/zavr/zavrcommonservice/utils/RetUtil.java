package com.zavr.zavrcommonservice.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class RetUtil {
    /* 不带参数返回
     * @author guozongye
     * @date 2018/6/29 15:39
     * @param [success, message]
     * @return java.lang.String
     */
    public static String param(boolean success,String message){
        JSONObject jo = new JSONObject();
        jo.put("Success",success);
        jo.put("Message",message);
        return jo.toString();
    }
    /* 带参数返回
     * @author guozongye
     * @date 2018/6/29 15:39
     * @param [success, message, param]
     * @return java.lang.String
     */
    public static String param(boolean success,String message,JSONObject param){
        JSONObject jo = new JSONObject();
        jo.put("Success",success);
        jo.put("Message",message);
        jo.put("Data",param);
        return jo.toString();
    }

    /* 分页数据返回
     * @author guozongye
     * @date 2018/6/29 15:38
     * @param [success, message, param, PageIndex, PageSize, PageCount, RecordCount]
     * @return java.lang.String
     */
    public static String Paging(boolean success, String message, JSONArray param, int PageIndex, int PageSize, int  PageCount, int RecordCount){
        JSONObject jo = new JSONObject();
        jo.put("Success",success);
        jo.put("Message",message);
        jo.put("List",param);
        jo.put("PageIndex",PageIndex);
        jo.put("PageSize",PageSize);
        jo.put("PageCount",PageCount);
        jo.put("RecordCount",RecordCount);
        return jo.toString();
    }
}
