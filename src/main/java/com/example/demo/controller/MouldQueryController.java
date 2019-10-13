package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.MouldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mould")
public class MouldQueryController {

    @RequestMapping("/getUser")
    public User getUser(){
        User user = new User();
        user.setUserName("ResultLv");
        user.setPassWord("123456");
        return user;
    }

    @Autowired
    private MouldService mouldService;

    @RequestMapping("/getID")
    public Object getID(){
        return mouldService.getID();
    }

    @RequestMapping("/getAll")
    public Object getAll(@RequestParam String ID,
                         @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                         @RequestParam(value = "limit", required = false, defaultValue = "0") int limit){
//        List<Mould> dataList;
//        ID = "`" + ID;
//        ID = ID + "`";
//
//        JsonResult jsonResult = null;
//        dataList =  mouldMapper.getAll(ID);
//        if(dataList != null){
//            jsonResult = new JsonResult("200", "成功", dataList.size(), dataList);
//        }
//        return jsonResult;
        return mouldService.getAll(ID, page, limit);
    }

    @RequestMapping("/getWeek")
    public Object getWeek(@RequestParam String ID,
                          @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                          @RequestParam(value = "limit", required = false, defaultValue = "0") int limit){
//        List<Mould> dataList;
//        ID = "`" + ID;
//        ID = ID + "`";
//
//        JsonResult jsonResult = null;
//        dataList =  mouldMapper.getWeek(ID);
//        if(dataList != null){
//            jsonResult = new JsonResult("200", "成功", dataList.size(), dataList);
//        }
//        return jsonResult;
        return mouldService.getWeek(ID, page, limit);
    }

    @RequestMapping("/getBetween")
    public Object getBetween(@RequestParam String ID, @RequestParam String starttime, @RequestParam String endtime,
                             @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                             @RequestParam(value = "limit", required = false, defaultValue = "0") int limit){
//        List<Mould> dataList;
//        ID = "`" + ID;
//        ID = ID + "`";
//
//        JsonResult jsonResult = null;
//        dataList =  mouldMapper.getBetween(ID, start, end);
//        if(dataList != null){
//            jsonResult = new JsonResult("200", "成功", dataList.size(), dataList);
//        }
//        return jsonResult;
        return mouldService.getBetween(ID, starttime, endtime, page, limit);
    }

    @RequestMapping("/getLatest")
    public Object getLatest(@RequestParam String ID,
                            @RequestParam(value = "date", required = false, defaultValue = "2000-01-01") String date){
        return mouldService.getLatest(ID, date);
    }

    @RequestMapping("/getDay")
    public Object getDay(@RequestParam String ID,
                         @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                         @RequestParam(value = "limit", required = false, defaultValue = "0") int limit){
        return mouldService.getDay(ID, page, limit);
    }

    @RequestMapping("/getIpChange")
    public Object getIpChanged(@RequestParam String ID,
                         @RequestParam(value = "latest", required = false, defaultValue = "99999999") int latest,
                         @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                         @RequestParam(value = "limit", required = false, defaultValue = "0") int limit){
        return mouldService.getIpChanged(ID, page, limit, latest);
    }

    @RequestMapping("/getRemoved")
    public Object getRemoved(@RequestParam String ID,
                               @RequestParam(value = "latest", required = false, defaultValue = "99999999") int latest,
                               @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                               @RequestParam(value = "limit", required = false, defaultValue = "0") int limit){
        return mouldService.getRemoved(ID, page, limit, latest);
    }
}


