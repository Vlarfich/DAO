package com.solvd.BuildingCompany.DAO.myBatis.service;

import com.solvd.BuildingCompany.DAO.DAO;
import com.solvd.BuildingCompany.DAO.myBatis.MyBatisUtil;
import com.solvd.BuildingCompany.DAO.myBatis.mappers.IBuildingMapper;
import com.solvd.BuildingCompany.hierarchy.Building;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BuildingService implements DAO<Integer, Building> {
    private final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();

    public BuildingService() {
    }

    public boolean create(Building worker) {
        boolean res = false;
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            IBuildingMapper mapper = session.getMapper(IBuildingMapper.class);
            try {
                res = mapper.create_(worker);
                session.commit();
            } catch (Exception e) {
                session.rollback();
            }
        }
        return res;
    }

    public Building read(Integer id) {
        Building worker;
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            IBuildingMapper mapper = session.getMapper(IBuildingMapper.class);
            worker = mapper.readID(id);
        }
        return worker;
    }

    public List<Building> read() {
        List<Building> workers;
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            IBuildingMapper mapper = session.getMapper(IBuildingMapper.class);
            workers = mapper.readALL();
        }
        return workers;
    }

    public Building update(Building worker) {
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            IBuildingMapper mapper = session.getMapper(IBuildingMapper.class);
            try {
                mapper.update_(worker);
                session.commit();
            } catch (Exception e) {
                session.rollback();
            }
        }
        return worker;
    }

    public boolean delete(Integer id) {
        boolean res = false;
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            IBuildingMapper mapper = session.getMapper(IBuildingMapper.class);
            try {
                res = mapper.deleteID(id);
                session.commit();
            } catch (Exception e) {
                session.rollback();
            }
        }
        return res;
    }

    public boolean delete(Building id) {
        return delete(id.getId());
    }
}
