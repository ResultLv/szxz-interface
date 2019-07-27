package com.example.demo.service;

import com.example.demo.entity.JsonResult;
import com.example.demo.entity.Mould;
import com.example.demo.mapper.MouldMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service(value = "MouldService")
public class MouldServiceImpl implements MouldService{

    @Autowired
    private MouldMapper mouldMapper;

    @Override
    public Object getID() {
        List<String> IDList;
        JsonResult jsonResult;
        IDList = mouldMapper.getID();
        jsonResult = new JsonResult("200", "成功", IDList.size(), IDList);
        return jsonResult;
    }

    @Override
    public Object getAll(String ID, int pageNum, int pageSize) {
        ID = "`" + ID;
        ID = ID + "`";

        List<Mould> dataList;
        JsonResult jsonResult;
        PageHelper.startPage(pageNum, pageSize);
        dataList = mouldMapper.getAll(ID);
        PageInfo<Mould> pageInfo = new PageInfo<>(dataList);    // 分页信息
        jsonResult = new JsonResult("200", "成功", pageInfo.getTotal(), pageNum, pageSize, dataList);
        return jsonResult;
    }

    @Override
    public Object getWeek(String ID, int pageNum, int pageSize) {
        ID = "`" + ID;
        ID = ID + "`";

        List<Mould> dataList;
        JsonResult jsonResult;
        PageHelper.startPage(pageNum, pageSize);
        dataList = mouldMapper.getWeek(ID);
        PageInfo<Mould> pageInfo = new PageInfo<>(dataList);    // 分页信息
        jsonResult = new JsonResult("200", "成功", pageInfo.getTotal(), pageNum, pageSize, dataList);
        return jsonResult;
    }

    @Override
    public Object getBetween(String ID, String start, String end, int pageNum, int pageSize) {
        ID = "`" + ID;
        ID = ID + "`";

        List<Mould> dataList;
        JsonResult jsonResult;
        PageHelper.startPage(pageNum, pageSize);
        dataList = mouldMapper.getBetween(ID, start, end);
        PageInfo<Mould> pageInfo = new PageInfo<>(dataList);    // 分页信息
        jsonResult = new JsonResult("200", "成功", pageInfo.getTotal(), pageNum, pageSize, dataList);
        return jsonResult;
    }

    @Override
    public Object getLatest(String ID, String start) {
        ID = "`" + ID;
        ID = ID + "`";

        List<Mould> dataList;
        JsonResult jsonResult;
        /**
         * 从请求中获取日期，并赋给start
         * 算出该日期的后一天，赋给end
         * 执行查询，找出当天的最新一条数据
         */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String end = "2100-01-01";
        if(!start.equals("2000-01-01")){
            Date date = null;
            try{
                date = sdf.parse(start);
            }catch (ParseException e){
                e.printStackTrace();
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            date = calendar.getTime();
            end = sdf.format(date);
        }
        dataList = mouldMapper.getLatest(ID, start, end);
        jsonResult = new JsonResult("200", "成功", dataList.size(), 1, 0, dataList);

        return jsonResult;
    }

    @Override
    public Object getDay(String ID, int pageNum, int pageSize) {
        ID = "`" + ID;
        ID = ID + "`";

        List<Mould> dataList;
        JsonResult jsonResult;
        PageHelper.startPage(pageNum, pageSize);
        dataList = mouldMapper.getDay(ID);
        PageInfo<Mould> pageInfo = new PageInfo<>(dataList);    // 分页信息
        jsonResult = new JsonResult("200", "成功", pageInfo.getTotal(), pageNum, pageSize, dataList);
        return jsonResult;
    }

    @Override
    public Object getIpChanged(String ID, int pageNum, int pageSize, int latest) {
        ID = "`" + ID;
        ID = ID + "`";

        List<Mould> dataList = new ArrayList<>();
        JsonResult jsonResult;
        PageHelper.startPage(pageNum, pageSize);
        List<Mould> temp = mouldMapper.getIpChange(ID);
        PageInfo<Mould> pageInfo = new PageInfo<>(temp);    // 分页信息

        // 取前latest条
        int len = temp.size() < latest ? temp.size() : latest;
        for (int i = 0; i < len; i++) {
            dataList.add(temp.get(i));
        }

        jsonResult = new JsonResult("200", "成功", pageInfo.getTotal(), pageNum, pageSize, dataList);
        return jsonResult;
    }

    @Override
    public Object getRemoved(String ID, int pageNum, int pageSize, int latest) {
        ID = "`" + ID;
        ID = ID + "`";

        List<Mould> dataList = new ArrayList<>();
        JsonResult jsonResult;
        PageHelper.startPage(pageNum, pageSize);
        List<Mould> temp = mouldMapper.getRemoved(ID);
        PageInfo<Mould> pageInfo = new PageInfo<>(temp);    // 分页信息

        // 取前latest条
        int len = temp.size() < latest ? temp.size() : latest;
        for (int i = 0; i < len; i++) {
            dataList.add(temp.get(i));
        }

        jsonResult = new JsonResult("200", "成功", pageInfo.getTotal(), pageNum, pageSize, dataList);
        return jsonResult;
    }
}
