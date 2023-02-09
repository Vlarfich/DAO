package com.solvd.BuildingCompany.DAO.myBatis.mappers;

import com.solvd.BuildingCompany.hierarchy.Project;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IProjectMapper {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
    })
    @Select("SELECT id, name FROM Projects")
    public List<Project> readALL();

    @Select("SELECT id , name FROM Projects WHERE id=#{id}")
    public Project readID(@Param("id") Integer id);

    @Delete("DELETE FROM Projects WHERE id=#{id}")
    public boolean deleteID(@Param("id") Integer id);


    @Insert("INSERT INTO Projects (name) VALUES (#{name});")
    public boolean create_(Project entity);

    @Update("UPDATE Projects set name = #{name} WHERE id=#{id}")
    public boolean update_(Project entity);
}