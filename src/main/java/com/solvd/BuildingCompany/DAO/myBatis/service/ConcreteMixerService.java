package DAO.myBatis.service;

import DAO.DAO;
import DAO.myBatis.MyBatisUtil;
import DAO.myBatis.mappers.IBulldozerMapper;
import DAO.myBatis.mappers.IConcreteMixerMapper;
import hierarchy.ConcreteMixer;
import hierarchy.Worker;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ConcreteMixerService implements DAO<Integer, ConcreteMixer> {
    private final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();

    public ConcreteMixerService() {
    }

    public boolean create(ConcreteMixer worker) {
        boolean res = false;
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            IConcreteMixerMapper mapper = session.getMapper(IConcreteMixerMapper.class);
            try {
                res = mapper.create_(worker);
                session.commit();
            } catch (Exception e) {
                session.rollback();
            }
        }
        return res;
    }

    public ConcreteMixer read(Integer id) {
        ConcreteMixer worker;
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            IConcreteMixerMapper mapper = session.getMapper(IConcreteMixerMapper.class);
            worker = mapper.readID(id);
        }
        return worker;
    }

    public List<ConcreteMixer> read() {
        List<ConcreteMixer> workers;
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            IConcreteMixerMapper mapper = session.getMapper(IConcreteMixerMapper.class);
            workers = mapper.readALL();
        }
        return workers;
    }

    public ConcreteMixer update(ConcreteMixer worker) {
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            IConcreteMixerMapper mapper = session.getMapper(IConcreteMixerMapper.class);
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
            IConcreteMixerMapper mapper = session.getMapper(IConcreteMixerMapper.class);
            try {
                res = mapper.deleteID(id);
                session.commit();
            } catch (Exception e) {
                session.rollback();
            }
        }
        return res;
    }

    public boolean delete(ConcreteMixer id) {
        return delete(id.getId());
    }
}
