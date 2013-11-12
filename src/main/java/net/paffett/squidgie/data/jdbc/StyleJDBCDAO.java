/**
 * 
 */
package net.paffett.squidgie.data.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import net.paffett.squidgie.data.StyleDAO;
import net.paffett.squidgie.domain.Style;

/**
 * @author gpaffett
 * 
 */
public class StyleJDBCDAO implements StyleDAO {

    private DataSource ds;
    private final String ADD_STATEMENT = "INSERT INTO styles (style_id, name, aroma, appearance, flavor, mouthfeel, overall) "
            + "VALUES (?, ?, ?,?, ?, ?, ?)";

    private final String FIND_STATEMENT = "SELECT style_id, name, aroma, appearance, flavor, mouthfeel, overall "
            + "FROM styles";

    private final String UPDATE_STATEMENT = "UPDATE styles SET "
            + "name = ?, aroma = ?, appearance = ?, flavor = ?, mouthfeel = ?, overall = ?"
            + " style_id = ?";

    private final String DELETE_STATEMENT = "DELETE FROM styles WHERE style_id = ?";

    public StyleJDBCDAO(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public Style add(Style style) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = ds.getConnection();

            ps = conn.prepareStatement(ADD_STATEMENT);
            ps.setString(1, style.getStyleId());
            ps.setString(2, style.getName());
            ps.setString(3, style.getAppearance());
            ps.setString(4, style.getFlavor());
            ps.setString(5, style.getMouthfeel());
            ps.setString(6, style.getOverall());

            ps.executeUpdate();
            conn.commit();

        } catch (SQLException se) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException excep) {
                    excep.printStackTrace();
                }
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    conn.close();
                } catch (SQLException excep) {
                    excep.printStackTrace();
                }
            }
        }

        return findById(style.getStyleId());
    }

    @Override
    public Style findById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Style> findByName(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int update(Style style) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void delete(long id) {
        // TODO Auto-generated method stub

    }

}
