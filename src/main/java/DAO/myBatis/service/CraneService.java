package DAO.myBatis.service;

import DAO.DAO;
import DAO.myBatis.MyBatisUtil;
import DAO.myBatis.mappers.IConcreteMixerMapper;
import DAO.myBatis.mappers.ICraneMapper;
import hierarchy.Crane;
import hierarchy.Worker;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CraneService implements DAO<Integer, Crane> {
    private final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();

    public CraneService() {
    }

    public boolean create(Crane worker) {
        boolean res = false;
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            ICraneMapper mapper = session.getMapper(ICraneMapper.class);
            try {
                res = mapper.create_(worker);
                session.commit();
            } catch (Exception e) {
                session.rollback();
            }
        }
        return res;
    }

    public Crane read(Integer id) {
        Crane worker;
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            ICraneMapper mapper = session.getMapper(ICraneMapper.class);
            worker = mapper.readID(id);
        }
        return worker;
    }

    public List<Crane> read() {
        List<Crane> workers;
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            ICraneMapper mapper = session.getMapper(ICraneMapper.class);
            workers = mapper.readALL();
        }
        return workers;
    }

    public Crane update(Crane worker) {
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            ICraneMapper mapper = session.getMapper(ICraneMapper.class);
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
            ICraneMapper mapper = session.getMapper(ICraneMapper.class);
            try {
                res = mapper.deleteID(id);
                session.commit();
            } catch (Exception e) {
                session.rollback();
            }
        }
        return res;
    }

    public boolean delete(Crane id) {
        return delete(id.getId());
    }
}
