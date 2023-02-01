package DAO.myBatis.mappers;

import hierarchy.Worker;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IWorkerMapper {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age"),
            @Result(property = "Projects_id", column = "Projects_id")
    })
    @Select("SELECT id, name ,age, Projects_id FROM Workers")
    public List<Worker> readALL();

    @Select("SELECT id , name, age, Projects_id FROM Workers WHERE id=#{id}")
    public Worker readID(@Param("id") Integer id);

    @Delete("DELETE FROM Workers WHERE id=#{id}")
    public boolean deleteID(@Param("id") Integer id);


    @Insert("INSERT INTO Workers (name, age, Projects_id) VALUES (#{name}, #{age}, #{Projects_id});")
    public boolean create_(Worker entity);

    @Update("UPDATE Workers SET name = #{name} WHERE id = #{id}")
    public boolean update_(Worker entity);
}