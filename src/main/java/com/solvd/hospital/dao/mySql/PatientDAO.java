package com.solvd.hospital.dao.mySql;

import com.solvd.hospital.dao.connection.MyJDBC;
import com.solvd.hospital.dao.daoInterfaces.IBaseDAO;
import com.solvd.hospital.dao.daoInterfaces.IPatientDAO;
import com.solvd.hospital.model.people.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.solvd.hospital.dao.connection.MyJDBC.getConnection;

public class PatientDAO extends AbstractMySqlDAO implements IBaseDAO {

    private static Logger logger = LogManager.getLogger(PatientDAO.class);

    private final static String SQL_INSERT =    "INSERT INTO patient(name, last_name, dni, phone, address, weight, height, age, pathology) VALUES(?, ?, ?,?,?,?)";
    private final static String SQL_UPDATE =    "UPDATE patient SET name=?, last_name=?, dni=?, phone = ?, address = ?, weight = ?, height = ?, age = ?, pathology = ? WHERE id = ?";
    private final static String SQL_GET_BY_ID = "SELECT * FROM Patients WHERE id = ?";
    private final static String SQL_DELETE =    "DELETE FROM Patients WHERE id = ?";


    @Override
    public void create(Object object) {

    }

    @Override
    public Object getById(long id) throws SQLException {

        PreparedStatement ps = null;
        Connection conn = getConnection();
        ResultSet rs = null;
        Patient patient = null;
        try{
            ps = conn.prepareStatement(SQL_GET_BY_ID);
            ps.setInt(1, (int) id);
            rs = ps.executeQuery();
            while(rs.next()){
                patient = parser(rs);
            }
        }catch (Exception e){
           logger.error(e);
        }finally {
            returnConnection(conn);
            if(rs != null){
                try {
                    rs.close();
                }catch (SQLException e){
                    logger.error(e);
                }
            }
            if(ps != null){
                try{
                    ps.close();
                }catch (SQLException e){
                    logger.error(e);
                }
            }
        }

        return patient;
    }

    @Override
    public void update(Object object) {

    }

    @Override
    public void delete(long id) {

    }

    private Patient parser(ResultSet rs) throws SQLException{
        Patient p = new Patient();
        p.setId(rs.getInt("id"));
        p.setName(rs.getString("name"));
        p.setLastName(rs.getString("last_name"));
        p.setDni(rs.getInt("dni"));
        p.setPhone(rs.getString("phone"));
        p.setAddress(rs.getString("address"));
        p.setPathology(rs.getString("pathology"));
        p.setWeight(rs.getDouble("weight"));
        p.setHeight(rs.getDouble("height"));
        p.setAge(rs.getInt("age"));
        p.setRoomId(rs.getInt("rooms_id"));
        p.setRoomId(rs.getInt("doctors_id"));
        p.setRoomId(rs.getInt("medicines_id"));
        return p;
    }
}
