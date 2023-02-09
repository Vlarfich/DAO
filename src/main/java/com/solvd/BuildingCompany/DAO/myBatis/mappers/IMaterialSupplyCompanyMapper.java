package com.solvd.BuildingCompany.DAO.myBatis.mappers;

import com.solvd.BuildingCompany.hierarchy.MaterialSupplyCompany;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IMaterialSupplyCompanyMapper {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "email", column = "email"),
            @Result(property = "Projects_id", column = "Projects_id"),
            @Result(property = "Buildings_id", column = "Buildings_id")
    })
    @Select("SELECT id, name, phone, email, Buildings_id, Projects_id FROM MaterialSupplyCompany")
    public List<MaterialSupplyCompany> readALL();

    @Select("SELECT id , name, email, Buildings_id, Projects_id FROM MaterialSupplyCompany WHERE id=#{id}")
    public MaterialSupplyCompany readID(@Param("id") Integer id);

    @Delete("DELETE FROM MaterialSupplyCompany WHERE id=#{id}")
    public boolean deleteID(@Param("id") Integer id);

    @Insert("INSERT INTO MaterialSupplyCompany (name, phone, email, Buildings_id, Projects_id) " +
            "VALUES (#{name}, #{phone}, #{email}, #{Buildings_id}, #{Projects_id});")
    public boolean create_(MaterialSupplyCompany entity);

    @Update("UPDATE MaterialSupplyCompany set name = #{name}, phone = #{phone}, email = #{email}, " +
            "Buildings_id = #{Buildings_id}, Projects_id = #{Projects_id} WHERE id=#{id}")
    public boolean update_(MaterialSupplyCompany entity);
}
