package com.solvd.hospital.dao.mySql;

import com.solvd.hospital.dao.daoInterfaces.IBaseDAO;
import com.solvd.hospital.dao.daoInterfaces.IPatientDAO;
import com.solvd.hospital.model.exception.DAOException;
import com.solvd.hospital.model.people.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.hospital.dao.connection.MyJDBC.getConnection;

public class PatientDAO extends AbstractMySqlDAO implements IPatientDAO {

    private static Logger logger = LogManager.getLogger(PatientDAO.class);

    private final static String SQL_INSERT =    "INSERT INTO patient(name, last_name, dni, phone, address, weight, height, age, pathology) VALUES(?, ?, ?,?,?,?)";
    private final static String SQL_UPDATE =    "UPDATE patient SET name=?, last_name=?, dni=?, phone = ?, address = ?, weight = ?, height = ?, age = ?, pathology = ? WHERE id = ?";
    private final static String SQL_GET_BY_ID = "SELECT * FROM Patients WHERE id = ?";
    private final static String SQL_DELETE =    "DELETE FROM Patients WHERE id = ?";

    private final static String SQL_GETALL = "SELECT idPatient, name, lastName, dni, address, age, phone, pathology, " +
                                            "roomId, doctorId, medicineId FROM patient";


    @Override
    public void create(Patient p) throws SQLException {


        PreparedStatement stat = null;
        Connection conn = getConnection();
        try {
            stat = conn.prepareStatement(SQL_INSERT);
            stat.setInt(1, (int) p.getId());
            stat.setString(2, p.getName());
            stat.setString(3, p.getLastName());
            stat.setString(4, p.getAddress());
            stat.setInt(5, p.getDni());
            stat.setInt(6, p.getAge());
            stat.setString(7, p.getPhone());
            stat.setString(8, p.getPathology());
            stat.setInt(9, (int)p.getDoctorId());
            stat.setInt(10, (int)p.getMedicineId());
            stat.setInt(11, (int)p.getRoomId());

            if (stat.executeUpdate() == 0) {
                throw new DAOException("May not have been saved");
            }

        } catch (SQLException e) {
            throw new DAOException("SQL ERROR.", e);
        } finally {
            returnConnection(conn);
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new DAOException("SQL ERROR.", e);
                }
            }
        }
    }



    @Override
    public Patient getById(Long id) throws SQLException {

        PreparedStatement ps = null;
        Connection conn = getConnection();
        ResultSet rs = null;
        Patient patient = null;
        try{
            ps = conn.prepareStatement(SQL_GET_BY_ID);
            ps.setInt(1, Math.toIntExact((Long) id));
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
    public void update(Patient p) throws DAOException, ConnectException, SQLException {
        PreparedStatement stat = null;
        Connection conn = getConnection();
        try {
            stat = conn.prepareStatement(SQL_UPDATE);

            stat.setString(1, p.getName());
            stat.setString(2, p.getLastName());
            stat.setInt(3, p.getDni());
            stat.setString(4, p.getAddress());
            stat.setString(5, p.getPathology());
            stat.setInt(6, (int) p.getDoctorId());
            stat.setInt(7, p.getMedicineId());
            stat.setString(8, p.getPhone());
            stat.setInt(9, p.getAge());
            stat.setInt(10, (int) p.getRoomId());


            if (stat.executeUpdate() == 0) {
                throw new DAOException("May not have been saved");
            }

        } catch (SQLException e) {
            throw new DAOException("SQL ERROR.", e);
        } finally {
            returnConnection(conn);
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new DAOException("SQL ERROR.", e);
                }
            }
        }
    }

    @Override
    public void delete(Long id) throws DAOException, SQLException {
        PreparedStatement stat = null;
        Connection conn = getConnection();
        try {
            stat = conn.prepareStatement(SQL_DELETE);
            stat.setLong(1, id);


            if (stat.executeUpdate() == 0) {
                throw new DAOException("The task was not done");
            }

        } catch (SQLException e) {
            throw new DAOException("SQL ERROR.", e);
        } finally {
            returnConnection(conn);
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new DAOException("SQL ERROR.", e);
                }
            }
        }

    }


    @Override
    public List<Patient> listAll() throws SQLException {

        PreparedStatement stat = null;
        Connection conn = getConnection();
        ResultSet rs = null;
        List<Patient> patients = new ArrayList<>();
        try {
            stat = conn.prepareStatement(SQL_GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                patients.add(parser(rs));
            }
        } catch (SQLException e) {
            throw new DAOException("SQL ERROR.", e);
        } finally {
            returnConnection(conn);
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    new DAOException("SQL ERROR.", e);
                }
            }
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    new DAOException("SQL ERROR.", e);
                }
            }

        }
        return null;
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
