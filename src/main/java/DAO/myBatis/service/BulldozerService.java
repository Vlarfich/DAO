package DAO.myBatis.service;

import DAO.DAO;
import DAO.myBatis.MyBatisUtil;
import DAO.myBatis.mappers.IBuildingMapper;
import DAO.myBatis.mappers.IBulldozerMapper;
import DAO.myBatis.mappers.IProjectManagerMapper;
import hierarchy.Bulldozer;
import hierarchy.Worker;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BulldozerService implements DAO<Integer, Bulldozer> {
    private final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();

    public BulldozerService() {
    }

    public boolean create(Bulldozer worker) {
        boolean res = false;
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            IBulldozerMapper mapper = session.getMapper(IBulldozerMapper.class);
            try {
                res = mapper.create_(worker);
                session.commit();
            } catch (Exception e) {
                session.rollback();
            }
        }
        return res;
    }

    public Bulldozer read(Integer id) {
        Bulldozer worker;
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            IBulldozerMapper mapper = session.getMapper(IBulldozerMapper.class);
            worker = mapper.readID(id);
        }
        return worker;
    }

    public List<Bulldozer> read() {
        List<Bulldozer> workers;
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            IBulldozerMapper mapper = session.getMapper(IBulldozerMapper.class);
            workers = mapper.readALL();
        }
        return workers;
    }

    public Bulldozer update(Bulldozer worker) {
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            IBulldozerMapper mapper = session.getMapper(IBulldozerMapper.class);
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
            IBulldozerMapper mapper = session.getMapper(IBulldozerMapper.class);
            try {
                res = mapper.deleteID(id);
                session.commit();
            } catch (Exception e) {
                session.rollback();
            }
        }
        return res;
    }

    public boolean delete(Bulldozer id) {
        return delete(id.getId());
    }

}
