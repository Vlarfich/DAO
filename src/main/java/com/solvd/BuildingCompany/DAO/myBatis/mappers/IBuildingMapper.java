package com.solvd.BuildingCompany.DAO.myBatis.mappers;

import com.solvd.BuildingCompany.hierarchy.Building;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IBuildingMapper {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "adress", column = "address"),
    })
    @Select("SELECT id, adress FROM Buildings")
    public List<Building> readALL();

    @Select("SELECT id , adress FROM Buildings WHERE id=#{id}")
    public Building readID(@Param("id") Integer id);

    @Delete("DELETE FROM Buildings WHERE id=#{id}")
    public boolean deleteID(@Param("id") Integer id);

    @Insert("INSERT INTO Buildings (adress) VALUES (#{address});")
    public boolean create_(Building entity);

    @Update("UPDATE Buildings set adress = #{address} WHERE id=#{id}")
    public boolean update_(Building entity);
}
