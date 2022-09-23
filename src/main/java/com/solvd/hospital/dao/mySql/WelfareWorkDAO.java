package com.solvd.hospital.dao.mySql;

import com.solvd.hospital.dao.daoInterfaces.IWelfareWorksDAO;
import com.solvd.hospital.model.WelfareWork;

import java.sql.SQLException;
import java.util.List;

public class WelfareWorkDAO extends AbstractMySqlDAO implements IWelfareWorksDAO {


    @Override
    public void create(WelfareWork object) throws SQLException {

    }

    @Override
    public void update(WelfareWork object) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<WelfareWork> listAll() {
        return null;
    }

    @Override
    public WelfareWork getById(Long id) throws SQLException {
        return null;
    }
}
