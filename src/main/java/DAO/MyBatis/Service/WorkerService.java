package DAO.MyBatis.Service;

import DAO.DAO;
import DAO.MyBatis.MyBatisUtil;
import DAO.MyBatis.WorkerMapper;
import Hierarchy.Worker;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class WorkerService implements DAO<Integer, Worker> {
    public WorkerService()  {
    }

    public boolean create(Worker worker) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        WorkerMapper mapper = session.getMapper(WorkerMapper.class);
        boolean res = mapper.create(worker);
        session.commit();
        session.close();
        return res;
    }
    public Worker read(Integer id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        WorkerMapper mapper = session.getMapper(WorkerMapper.class);
        Worker worker = mapper.read(id);
        session.close();
        return worker;
    }

    public List<Worker> read() {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        WorkerMapper mapper = session.getMapper(WorkerMapper.class);
        List<Worker> workers = mapper.read();
        session.close();
        return workers;
    }
    public Worker update(Worker village) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        WorkerMapper mapper = session.getMapper(WorkerMapper.class);
        Worker res = mapper.update(village);
        session.commit();
        session.close();
        return res;
    }

    public boolean delete(Integer id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        WorkerMapper mapper = session.getMapper(WorkerMapper.class);
        boolean res = mapper.delete(id);
        session.commit();
        session.close();
        return res;
    }

    public boolean delete(Worker id) {
        return delete(id.getId());
    }

}