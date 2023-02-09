package DAO.myBatis.mappers;

import hierarchy.Customer;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ICustomerMapper {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "email", column = "email"),
            @Result(property = "Projects_id", column = "Projects_id")
    })
    @Select("SELECT id, name, phone, email, Projects_id FROM Customers")
    public List<Customer> readALL();

    @Select("SELECT id , name, email, Projects_id FROM Customers WHERE id=#{id}")
    public Customer readID(@Param("id") Integer id);

    @Delete("DELETE FROM Customers WHERE id=#{id}")
    public boolean deleteID(@Param("id") Integer id);

    @Insert("INSERT INTO Customers (name, phone, email, Projects_id) VALUES (#{name}, #{phone}, #{email}, #{Projects_id});")
    public boolean create_(Customer entity);

    @Update("UPDATE Customers set name = #{name}, phone = #{phone}, email = #{email}, Projects_id = #{Projects_id} WHERE id=#{id}")
    public boolean update_(Customer entity);
}