package com.solvd.BuildingCompany.DAO.myBatis.mappers;

import com.solvd.BuildingCompany.hierarchy.Bulldozer;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IBulldozerMapper {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "model", column = "model"),
            @Result(property = "Supplier_id", column = "Suppliers_id"),
            @Result(property = "Projects_id", column = "Projects_id"),
    })
    @Select("SELECT id, model, Suppliers_id, Projects_id FROM Bulldozers")
    public abstract List<Bulldozer> readALL();

    @Select("SELECT id, model, Suppliers_id, Projects_id FROM Bulldozers WHERE id=#{id}")
    public abstract Bulldozer readID(@Param("id") Integer id);

    @Delete("DELETE FROM Bulldozers WHERE id=#{id}")
    public abstract boolean deleteID(@Param("id") Integer id);


    @Insert("INSERT INTO Bulldozers (model, Suppliers_id, Projects_id) VALUES (#{model}, #{Suppliers_id}, #{Projects_id});")
    public abstract boolean create_(Bulldozer entity);

    @Update("UPDATE Bulldozers set model = #{model}, Suppliers_id = #{Supplier_id}, Projects_id = #{Projects_id} WHERE id=#{id}")
    public abstract boolean update_(Bulldozer entity);
}