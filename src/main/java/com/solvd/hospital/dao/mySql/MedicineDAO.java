package com.solvd.hospital.dao.mySql;
import com.solvd.hospital.dao.daoInterfaces.IMedicineDAO;
import com.solvd.hospital.model.Medicine;
import com.solvd.hospital.model.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static com.solvd.hospital.dao.connection.MyJDBC.getConnection;

public class MedicineDAO extends AbstractMySqlDAO implements IMedicineDAO {

    private static Logger logger = LogManager.getLogger(PatientDAO.class);

    private final static String SQL_INSERT =    "INSERT INTO Medicines(name, description) VALUES(?, ?)";
    private final static String SQL_UPDATE =    "UPDATE Medicines SET name=?, description=?";
    private final static String SQL_GET_BY_ID = "SELECT * FROM Medicines WHERE id = ?";
    private final static String SQL_DELETE =    "DELETE FROM Medicines WHERE id = ?";

    private final static String SQL_GETALL = "SELECT idMedicine, name, description FROM Medicines";




    @Override
    public void create(Medicine m) throws SQLException {
        PreparedStatement stat = null;
        Connection conn = getConnection();
        try {
            stat = conn.prepareStatement(SQL_INSERT);
            stat.setString(1, m.getName());
            stat.setString(2, m.getDescription());

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
    public void update(Medicine m) throws DAOException, ConnectException, SQLException {

        PreparedStatement stat = null;
        Connection conn = getConnection();
        try {
            stat = conn.prepareStatement(SQL_UPDATE);

            stat.setString(1, m.getName());
            stat.setString(2, m.getDescription());

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
    public void delete(Long id) throws SQLException {

    }

    @Override
    public List<Medicine> listAll() throws SQLException {
        return null;
    }

    @Override
    public Medicine getById(Long id) throws SQLException {
        return null;
    }
}
