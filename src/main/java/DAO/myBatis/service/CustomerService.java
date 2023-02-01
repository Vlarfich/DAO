package DAO.myBatis.service;

import DAO.DAO;
import DAO.myBatis.MyBatisUtil;
import DAO.myBatis.mappers.ICustomerMapper;
import DAO.myBatis.mappers.IWorkerMapper;
import hierarchy.Customer;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CustomerService implements DAO<Integer, Customer> {
    private final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();

    public CustomerService() {
    }

    public boolean create(Customer worker) {
        boolean res = false;
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            ICustomerMapper mapper = session.getMapper(ICustomerMapper.class);
            try {
                res = mapper.create_(worker);
                session.commit();
            } catch (Exception e) {
                session.rollback();
            }
        }
        return res;
    }

    public Customer read(Integer id) {
        Customer worker;
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            ICustomerMapper mapper = session.getMapper(ICustomerMapper.class);
            worker = mapper.readID(id);
        }
        return worker;
    }

    public List<Customer> read() {
        List<Customer> workers;
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            ICustomerMapper mapper = session.getMapper(ICustomerMapper.class);
            workers = mapper.readALL();
        }
        return workers;
    }

    public Customer update(Customer worker) {
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            ICustomerMapper mapper = session.getMapper(ICustomerMapper.class);
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
            ICustomerMapper mapper = session.getMapper(ICustomerMapper.class);
            try {
                res = mapper.deleteID(id);
                session.commit();
            } catch (Exception e) {
                session.rollback();
            }
        }
        return res;
    }

    public boolean delete(Customer id) {
        return delete(id.getId());
    }
}