package com.example.demo.mapper;

import com.example.demo.entity.Mould;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MouldMapper {
    @Select("show tables")
    List<String> getID();

    @Select("select * from ${ID}")
    List<Mould> getAll(@Param("ID") String ID);

    @Select("select * from ${ID} where DtTm between (now() - interval 7 day) and now()")
    List<Mould> getWeek(@Param("ID") String ID);

    @Select("select * from ${ID} where DtTm between #{start} and #{end}")
    List<Mould> getBetween(@Param("ID") String ID, @Param("start") String start, @Param("end") String end);

    @Select("select * from ${ID} where DtTm between (now() - interval 24 hour) and now()")
    List<Mould> getDay(@Param("ID") String ID);

    @Select("select * from ${ID} where DtTm between #{start} and #{end} order by DtTm desc limit 1")
    List<Mould> getLatest(@Param("ID") String ID, @Param("start") String start, @Param("end") String end );

    @Select("select * from ${ID} where ApChange = 'Changed' order by DtTm desc")
    List<Mould> getIpChange(@Param("ID") String ID);

    @Select("select * from ${ID} where Dis = 'Removed' order by DtTm desc")
    List<Mould> getRemoved(@Param("ID") String ID);
}

