package DAO.myBatis.mappers;

import hierarchy.VehSupplier;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IVehSupplierMapper {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "Buildings_id", column = "Buildings_id"),
    })
    @Select("SELECT id, name, Buildings_id FROM VehSuppliers")
    public abstract List<VehSupplier> readALL();

    @Select("SELECT id, name, Buildings_id FROM VehSuppliers WHERE id=#{id}")
    public abstract VehSupplier readID(@Param("id") Integer id);

    @Delete("DELETE FROM VehSuppliers WHERE id=#{id}")
    public abstract boolean deleteID(@Param("id") Integer id);

    @Insert("INSERT INTO VehSuppliers (name, Buildings_id) VALUES (#{name}, #{Building_id});")
    public abstract boolean create_(VehSupplier entity);

    @Update("UPDATE VehSuppliers set name = #{name}, Buildings_id = #{Buildings_id} WHERE id=#{id}")
    public abstract boolean update_(VehSupplier entity);
}
