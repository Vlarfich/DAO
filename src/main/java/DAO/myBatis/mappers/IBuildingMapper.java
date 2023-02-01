package DAO.myBatis.mappers;

import hierarchy.Building;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IBuildingMapper {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "address", column = "adress"),
    })
    @Select("SELECT id, address FROM Buildings")
    public abstract List<Building> readALL();

    @Select("SELECT id , address FROM Buildings WHERE id=#{id}")
    public abstract Building readID(@Param("id") Integer id);

    @Delete("DELETE FROM Buildings WHERE id=#{id}")
    public abstract boolean deleteID(@Param("id") Integer id);

    @Insert("INSERT INTO Buildings (address) VALUES (#{address});")
    public abstract boolean create_(Building entity);

    @Update("UPDATE Buildings set address = #{address} WHERE id=#{id}")
    public abstract Building update_(Building entity);
}
