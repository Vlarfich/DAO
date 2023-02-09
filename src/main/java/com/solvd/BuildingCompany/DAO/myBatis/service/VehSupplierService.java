package DAO.myBatis.service;

import DAO.DAO;
import DAO.myBatis.MyBatisUtil;
import DAO.myBatis.mappers.IMaterialSupplyCompanyMapper;
import DAO.myBatis.mappers.IVehSupplierMapper;
import hierarchy.VehSupplier;
import hierarchy.Worker;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class VehSupplierService implements DAO<Integer, VehSupplier> {
    private final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();

    public VehSupplierService() {
    }

    public boolean create(VehSupplier worker) {
        boolean res = false;
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            IVehSupplierMapper mapper = session.getMapper(IVehSupplierMapper.class);
            try {
                res = mapper.create_(worker);
                session.commit();
            } catch (Exception e) {
                session.rollback();
            }
        }
        return res;
    }

    public VehSupplier read(Integer id) {
        VehSupplier worker;
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            IVehSupplierMapper mapper = session.getMapper(IVehSupplierMapper.class);
            worker = mapper.readID(id);
        }
        return worker;
    }

    public List<VehSupplier> read() {
        List<VehSupplier> workers;
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            IVehSupplierMapper mapper = session.getMapper(IVehSupplierMapper.class);
            workers = mapper.readALL();
        }
        return workers;
    }

    public VehSupplier update(VehSupplier worker) {
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            IVehSupplierMapper mapper = session.getMapper(IVehSupplierMapper.class);
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
            IVehSupplierMapper mapper = session.getMapper(IVehSupplierMapper.class);
            try {
                res = mapper.deleteID(id);
                session.commit();
            } catch (Exception e) {
                session.rollback();
            }
        }
        return res;
    }

    public boolean delete(VehSupplier id) {
        return delete(id.getId());
    }
}
