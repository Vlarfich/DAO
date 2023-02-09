package com.solvd.BuildingCompany.DAO.myBatis.mappers;

import com.solvd.BuildingCompany.hierarchy.Crane;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ICraneMapper {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "model", column = "model"),
            @Result(property = "height", column = "heigth"),
            @Result(property = "Supplier_id", column = "Suppliers_id"),
            @Result(property = "Projects_id", column = "Projects_id"),
    })
    @Select("SELECT id, model, heigth, Suppliers_id, Projects_id FROM Cranes")
    public List<Crane> readALL();

    @Select("SELECT id, model, heigth, Suppliers_id, Projects_id FROM Cranes WHERE id=#{id}")
    public Crane readID(@Param("id") Integer id);

    @Delete("DELETE FROM Cranes WHERE id=#{id}")
    public boolean deleteID(@Param("id") Integer id);


    @Insert("INSERT INTO Cranes (model, heigth, Suppliers_id, Projects_id) VALUES (#{model}, #{height}, " +
            "#{Suppliers_id}, #{Projects_id});")
    public boolean create_(Crane entity);

    @Update("UPDATE Cranes set model = #{model}, heigth = #{height}, Suppliers_id = #{Supplier_id}, " +
            "Projects_id = #{Projects_id} WHERE id=#{id}")
    public boolean update_(Crane entity);
}
