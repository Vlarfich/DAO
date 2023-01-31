package DAO.MyBatis;

import DAO.DAO;
import DAO.JavaSQL.WorkerDAO;
import Hierarchy.Worker;
import org.apache.ibatis.annotations.*;

import java.sql.SQLException;
import java.util.List;

public interface WorkerMapper extends DAO<Integer, Worker> {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age"),
            @Result(property = "Projects_id", column = "Projects_id")
    })
    @Select("SELECT id, name ,age, Projects_id FROM Workers")
    public abstract List<Worker> findAll();

    @Select("SELECT id as wid, name, age, Projects_id WHERE wid=#{id}")
    public abstract Worker findEntityById(@Param("id") Integer id);

    @Delete("DELETE FROM Workers WHERE id=#{id}")
    public abstract boolean delete(@Param("id") Integer id);


    @Insert("INSERT INTO Workers (name, age, Projects_id) VALUES (#{name}, #{age}, #{Projects_id});")
    public abstract boolean create(Worker entity);

    @Update("UPDATE Projects set name = #{name}, age = #{age}, #{Projects_id} WHERE id=#{id}")
    public abstract Worker update(Worker entity);
}