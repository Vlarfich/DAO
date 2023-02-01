package DAO.myBatis.mappers;

import hierarchy.ProjectManager;
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
    public abstract List<ProjectManager> readALL();

    @Select("SELECT id , name, age, Projects_id FROM ProjectManager WHERE id=#{id}")
    public abstract ProjectManager readID(@Param("id") Integer id);

    @Delete("DELETE FROM ProjectManager WHERE id=#{id}")
    public abstract boolean deleteID(@Param("id") Integer id);

    @Insert("INSERT INTO ProjectManager (name, age, Projects_id) VALUES (#{name}, #{age}, #{Projects_id});")
    public abstract boolean create_(ProjectManager entity);

    @Update("UPDATE ProjectManager set name = #{name}, age = #{age}, Projects_id = #{Projects_id} WHERE id=#{id}")
    public abstract ProjectManager update_(ProjectManager entity);
}