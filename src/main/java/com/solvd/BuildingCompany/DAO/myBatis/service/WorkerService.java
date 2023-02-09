package com.solvd.BuildingCompany.DAO.myBatis.service;

import com.solvd.BuildingCompany.DAO.DAO;
import com.solvd.BuildingCompany.DAO.myBatis.MyBatisUtil;
import com.solvd.BuildingCompany.DAO.myBatis.mappers.IWorkerMapper;
import com.solvd.BuildingCompany.hierarchy.Worker;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class WorkerService implements DAO<Integer, Worker> {
    //private Class aClass = IWorkerMapper.class;
    private final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();

    public WorkerService() {
    }

    public boolean create(Worker worker) {
        boolean res = false;
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            IWorkerMapper mapper = session.getMapper(IWorkerMapper.class);
            try {
                res = mapper.create_(worker);
                session.commit();
            } catch (Exception e) {
                session.rollback();
            }
        }
        return res;
    }

    public Worker read(Integer id) {
        Worker worker;
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            IWorkerMapper mapper = session.getMapper(IWorkerMapper.class);
            worker = mapper.readID(id);
        }
        return worker;
    }

    public List<Worker> read() {
        List<Worker> workers;
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            IWorkerMapper mapper = session.getMapper(IWorkerMapper.class);
            workers = mapper.readALL();
        }
        return workers;
    }

    public Worker update(Worker worker) {
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            IWorkerMapper mapper = session.getMapper(IWorkerMapper.class);
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
            IWorkerMapper mapper = session.getMapper(IWorkerMapper.class);
            try {
                res = mapper.deleteID(id);
                session.commit();
            } catch (Exception e) {
                session.rollback();
            }
        }
        return res;
    }

    public boolean delete(Worker id) {
        return delete(id.getId());
    }

}