package com.solvd.BuildingCompany.DAO.myBatis.service;


import com.solvd.BuildingCompany.DAO.DAO;
import com.solvd.BuildingCompany.DAO.myBatis.MyBatisUtil;
import com.solvd.BuildingCompany.DAO.myBatis.mappers.IProjectManagerMapper;
import com.solvd.BuildingCompany.hierarchy.ProjectManager;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ProjectManagerService implements DAO<Integer, ProjectManager> {
    private final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();

    public ProjectManagerService() {
    }

    public boolean create(ProjectManager worker) {
        boolean res = false;
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            IProjectManagerMapper mapper = session.getMapper(IProjectManagerMapper.class);
            try {
                res = mapper.create_(worker);
                session.commit();
            } catch (Exception e) {
                session.rollback();
            }
        }
        return res;
    }

    public ProjectManager read(Integer id) {
        ProjectManager worker;
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            IProjectManagerMapper mapper = session.getMapper(IProjectManagerMapper.class);
            worker = mapper.readID(id);
        }
        return worker;
    }

    public List<ProjectManager> read() {
        List<ProjectManager> workers;
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            IProjectManagerMapper mapper = session.getMapper(IProjectManagerMapper.class);
            workers = mapper.readALL();
        }
        return workers;
    }

    public ProjectManager update(ProjectManager worker) {
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            IProjectManagerMapper mapper = session.getMapper(IProjectManagerMapper.class);
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
            IProjectManagerMapper mapper = session.getMapper(IProjectManagerMapper.class);
            try {
                res = mapper.deleteID(id);
                session.commit();
            } catch (Exception e) {
                session.rollback();
            }
        }
        return res;
    }

    public boolean delete(ProjectManager id) {
        return delete(id.getId());
    }

}
