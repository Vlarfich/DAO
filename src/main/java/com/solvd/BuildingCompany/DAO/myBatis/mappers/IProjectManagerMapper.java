package com.solvd.BuildingCompany.DAO.myBatis.mappers;

import com.solvd.BuildingCompany.hierarchy.ProjectManager;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IProjectManagerMapper {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age"),
            @Result(property = "Projects_id", column = "Projects_id")
    })
    @Select("SELECT id, name ,age, Projects_id FROM ProjectManager")
    public List<ProjectManager> readALL();

    @Select("SELECT id , name, age, Projects_id FROM ProjectManager WHERE id=#{id}")
    public ProjectManager readID(@Param("id") Integer id);

    @Delete("DELETE FROM ProjectManager WHERE id=#{id}")
    public boolean deleteID(@Param("id") Integer id);

    @Insert("INSERT INTO ProjectManager (name, age, Projects_id) VALUES (#{name}, #{age}, #{Projects_id});")
    public boolean create_(ProjectManager entity);

    @Update("UPDATE ProjectManager set name = #{name}, age = #{age}, Projects_id = #{Projects_id} WHERE id=#{id}")
    public boolean update_(ProjectManager entity);
}