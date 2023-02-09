package DAO.myBatis.service;

import DAO.DAO;
import DAO.myBatis.MyBatisUtil;
import DAO.myBatis.mappers.ICraneMapper;
import DAO.myBatis.mappers.IMaterialSupplyCompanyMapper;
import hierarchy.MaterialSupplyCompany;
import hierarchy.Worker;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class MaterialSupplyService implements DAO<Integer, MaterialSupplyCompany> {
    private final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();

    public MaterialSupplyService() {
    }

    public boolean create(MaterialSupplyCompany worker) {
        boolean res = false;
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            IMaterialSupplyCompanyMapper mapper = session.getMapper(IMaterialSupplyCompanyMapper.class);
            try {
                res = mapper.create_(worker);
                session.commit();
            } catch (Exception e) {
                session.rollback();
            }
        }
        return res;
    }

    public MaterialSupplyCompany read(Integer id) {
        MaterialSupplyCompany worker;
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            IMaterialSupplyCompanyMapper mapper = session.getMapper(IMaterialSupplyCompanyMapper.class);
            worker = mapper.readID(id);
        }
        return worker;
    }

    public List<MaterialSupplyCompany> read() {
        List<MaterialSupplyCompany> workers;
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            IMaterialSupplyCompanyMapper mapper = session.getMapper(IMaterialSupplyCompanyMapper.class);
            workers = mapper.readALL();
        }
        return workers;
    }

    public MaterialSupplyCompany update(MaterialSupplyCompany worker) {
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            IMaterialSupplyCompanyMapper mapper = session.getMapper(IMaterialSupplyCompanyMapper.class);
            try {
                mapper.update_(worker);
                session.commit();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                session.rollback();
            }
        }
        return worker;
    }

    public boolean delete(Integer id) {
        boolean res = false;
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            IMaterialSupplyCompanyMapper mapper = session.getMapper(IMaterialSupplyCompanyMapper.class);
            try {
                res = mapper.deleteID(id);
                session.commit();
            } catch (Exception e) {
                session.rollback();
            }
        }
        return res;
    }

    public boolean delete(MaterialSupplyCompany id) {
        return delete(id.getId());
    }
}
