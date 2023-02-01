package DAO.MyBatis.Service;

import DAO.MyBatis.MyBatisUtil;
import DAO.MyBatis.WorkerMapper;
import Hierarchy.Worker;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

public class WorkerService implements IService<Integer, Worker>{
    public WorkerService()  {
    }

    public void create(Worker worker) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        WorkerMapper mapper = session.getMapper(WorkerMapper.class);
        mapper.create(worker);
        session.commit();
        session.close();
    }

    public void update(Worker village) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        WorkerMapper mapper = session.getMapper(WorkerMapper.class);
        mapper.update(village);
        session.commit();
        session.close();
    }

    public void delete(Integer id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        WorkerMapper mapper = session.getMapper(WorkerMapper.class);
        mapper.delete(id);
        session.commit();
        session.close();
    }

    public Worker read(Integer id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        WorkerMapper mapper = session.getMapper(WorkerMapper.class);
        Worker worker = mapper.findEntityById(id);
        session.close();
        return worker;
    }

    public List<Worker> read() {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        WorkerMapper mapper = session.getMapper(WorkerMapper.class);
        List<Worker> workers = mapper.findAll();
        session.close();
        return workers;
    }
}