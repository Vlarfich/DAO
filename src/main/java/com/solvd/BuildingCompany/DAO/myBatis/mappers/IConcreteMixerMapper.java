package com.solvd.BuildingCompany.DAO.myBatis.mappers;

import com.solvd.BuildingCompany.hierarchy.ConcreteMixer;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IConcreteMixerMapper {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "model", column = "model"),
            @Result(property = "volume", column = "volume"),
            @Result(property = "Supplier_id", column = "Suppliers_id"),
            @Result(property = "Projects_id", column = "Projects_id"),
    })
    @Select("SELECT id, model, volume, Suppliers_id, Projects_id FROM ConcreteMixer")
    public abstract List<ConcreteMixer> readALL();

    @Select("SELECT id, model, volume, Suppliers_id, Projects_id FROM ConcreteMixer WHERE id=#{id}")
    public abstract ConcreteMixer readID(@Param("id") Integer id);

    @Delete("DELETE FROM ConcreteMixer WHERE id=#{id}")
    public abstract boolean deleteID(@Param("id") Integer id);


    @Insert("INSERT INTO ConcreteMixer (model, volume, Suppliers_id, Projects_id) VALUES (#{model}, #{volume}, " +
            "#{Suppliers_id}, #{Projects_id});")
    public abstract boolean create_(ConcreteMixer entity);

    @Update("UPDATE ConcreteMixer set model = #{model}, volume = #{volume}, Suppliers_id = #{Supplier_id}, " +
            "Projects_id = #{Projects_id} WHERE id=#{id}")
    public abstract boolean update_(ConcreteMixer entity);
}