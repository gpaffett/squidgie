package net.paffett.squidgie.data.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import net.paffett.squidgie.data.BeerDAO;
import net.paffett.squidgie.domain.Beer;
import net.paffett.squidgie.domain.Brewery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeerJDBCDAO implements BeerDAO {

    Logger log = LoggerFactory.getLogger(BeerJDBCDAO.class);

    private DataSource ds;
    private String INSERT_STATEMENT = "INSERT INTO beers "
            + "(name, brewery, style, description) " + " VALUES (?,?,?,?)";

    private String SELECT_BY_NAME = "SELECT beer_id, name, brewery, style, description "
            + "FROM beers " + "WHERE name = ? ";

    private String SELECT_BY_DESC = "SELECT beer_id, name, brewery, style, description "
            + "FROM BEERS " + "WHERE desc LIKE = ? ";

    private String SELECT_ALL = "SELECT beer_id, name, brewery, style, description "
            + "FROM BEERS ";

    private String UPDATE_STATEMENT = "UPDATE BEERS SET name = ?, brewery = ?, style = ?, "
            + "description = ? WHERE berr_id = ?";

    private String DELETE_STATEMENT = "DELETE FROM BEERS WHERE beer_id = ?";

    public BeerJDBCDAO(DataSource ds) {
        this.ds = ds;
    }

    public Beer add(Beer beer) {
        Connection conn = null;
        PreparedStatement ps = null;

        if (log.isInfoEnabled()) {
            log.info("Adding " + beer + " to the database");
        }

        try {
            conn = ds.getConnection();

            ps = conn.prepareStatement(INSERT_STATEMENT);
            ps.setString(1, beer.getName());
            ps.setLong(2, beer.getBrewery().getId());
            ps.setString(3, beer.getStyle());
            ps.setString(4, beer.getDescription());

            ps.executeUpdate();
            conn.commit();

            if (log.isDebugEnabled()) {
                log.debug(beer + " has been commited to the database");
            }

        } catch (SQLException se) {
            log.error("Exception in adding beer " + beer + " Message: "
                    + se.getMessage(), se);
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException excep) {
                    log.error("Error rolling back " + beer + " add. Message: "
                            + excep.getMessage(), excep);
                }
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    conn.close();
                } catch (SQLException excep) {
                    log.error("Error closing database resources. Message: "
                            + excep.getMessage(), excep);
                }
            }
        }

        return findByName(beer.getName());
    }

    public Beer findByName(String name) {

        Connection conn = null;
        PreparedStatement ps = null;

        List<Beer> beers = new ArrayList<Beer>();

        if (log.isInfoEnabled()) {
            log.info("Looking for beer by name: " + name + " in database");
        }

        try {
            conn = ds.getConnection();

            ps = conn.prepareStatement(SELECT_BY_NAME);
            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Beer beer = new Beer();
                beer.setId(rs.getLong("beer_id"));
                beer.setName(rs.getString("name"));
                beer.setStyle(rs.getString("style"));
                Brewery brewery = new Brewery();
                brewery.setId(rs.getLong("brewery"));
                beer.setBrewery(brewery);
                beer.setDescription(rs.getString("description"));
                beers.add(beer);
            }

            conn.commit();

            if (log.isDebugEnabled()) {
                log.debug("Found " + beers.size() + " that match name: " + name);
            }

        } catch (SQLException se) {
            log.error("Exception in finding beers by name " + name + " Message: "
                    + se.getMessage(), se);
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException excep) {
                    // TODO Log this and move on.
                }
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    conn.close();
                } catch (SQLException excep) {
                    // TODO log and move on
                }
            }
        }

        return beers.isEmpty() ? null : beers.get(0);
    }

    public List<Beer> findByDescription(String desc) {
        Connection conn = null;
        PreparedStatement ps = null;

        List<Beer> beers = new ArrayList<Beer>();

        if (log.isInfoEnabled()) {
            log.info("Looking for beer by description: " + desc
                    + " in database");
        }

        try {
            conn = ds.getConnection();

            ps = conn.prepareStatement(SELECT_BY_DESC);
            ps.setString(1, "%" + desc + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Beer beer = new Beer();
                beer.setId(rs.getLong("beer_id"));
                beer.setName(rs.getString("name"));
                beer.setStyle(rs.getString("style"));
                Brewery brewery = new Brewery();
                brewery.setId(rs.getLong("brewery"));
                beer.setBrewery(brewery);
                beer.setDescription(rs.getString("description"));
                beers.add(beer);
            }

            conn.commit();
            if (log.isDebugEnabled()) {
                log.debug("Found " + beers.size() + " that match description: "
                        + desc);
            }

        } catch (SQLException se) {
            log.error("Exception in finding beers by description" + desc + " Message: "
                    + se.getMessage(), se);
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException excep) {
                    // TODO Log this and move on.
                }
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    conn.close();
                } catch (SQLException excep) {
                    // TODO log and move on
                }
            }
        }

        return beers;
    }

    public List<Beer> getAll() {
        Connection conn = null;
        PreparedStatement ps = null;

        List<Beer> beers = new ArrayList<Beer>();

        if (log.isInfoEnabled()) {
            log.info("Fetching all beers in database");
        }

        try {
            conn = ds.getConnection();

            ps = conn.prepareStatement(SELECT_ALL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Beer beer = new Beer();
                beer.setId(rs.getLong("beer_id"));
                beer.setName(rs.getString("name"));
                beer.setStyle(rs.getString("style"));
                Brewery brewery = new Brewery();
                brewery.setId(rs.getLong("brewery"));
                beer.setBrewery(brewery);
                beer.setDescription(rs.getString("description"));
                beers.add(beer);
            }

            conn.commit();
            if (log.isDebugEnabled()) {
                log.debug("Found " + beers.size() + " in database.");
            }

        } catch (SQLException se) {
            log.error("Exception getting all beers. Message: "
                    + se.getMessage(), se);
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException excep) {
                    // TODO Log this and move on.
                }
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    conn.close();
                } catch (SQLException excep) {
                    // TODO log and move on
                }
            }
        }

        return beers;
    }

    public int update(Beer beer) {
        Connection conn = null;
        PreparedStatement ps = null;

        int rowsAffected = 0;

        if (log.isInfoEnabled()) {
            log.info("Updating beer: " + beer + " in database");
        }

        try {
            conn = ds.getConnection();

            ps = conn.prepareStatement(UPDATE_STATEMENT);
            ps.setString(1, beer.getName());
            ps.setLong(2, beer.getBrewery().getId());
            ps.setString(3, beer.getStyle());
            ps.setString(4, beer.getDescription());
            ps.setLong(5, beer.getId());

            rowsAffected = ps.executeUpdate();

            conn.commit();
            if (log.isDebugEnabled()) {
                log.debug("Updated " + rowsAffected + " that match id: "
                        + beer.getId() + " Values: " + beer);
            }

        } catch (SQLException se) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException excep) {
                    // TODO Log this and move on.
                }
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    conn.close();
                } catch (SQLException excep) {
                    // TODO log and move on
                }
            }
        }

        return rowsAffected;
    }

    public int remove(long id) {
        Connection conn = null;
        PreparedStatement ps = null;

        int rowsAffected = 0;

        if (log.isInfoEnabled()) {
            log.info("Removing beer: " + id + " in database");
        }

        try {
            conn = ds.getConnection();

            ps = conn.prepareStatement(DELETE_STATEMENT);
            ps.setLong(1, id);

            rowsAffected = ps.executeUpdate();

            conn.commit();
            if (log.isDebugEnabled()) {
                log.debug("Remove " + rowsAffected + " that match id: " + id);
            }

        } catch (SQLException se) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException excep) {
                    // TODO Log this and move on.
                }
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    conn.close();
                } catch (SQLException excep) {
                    // TODO log and move on
                }
            }
        }

        return rowsAffected;
    }

}
