/**
 * 
 */
package net.paffett.squidgie.data.jdbc;

import java.util.Date;
import java.util.List;

import net.paffett.squidgie.data.TastingDAO;
import net.paffett.squidgie.domain.Tasting;

/**
 * @author gpaffett
 *
 */
public class TastingJDBCDAO implements TastingDAO {

    /* (non-Javadoc)
     * @see net.paffett.squidgie.data.TastingDAO#add(net.paffett.squidgie.domain.Tasting)
     */
    @Override
    public Tasting add(Tasting tasting) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see net.paffett.squidgie.data.TastingDAO#update(net.paffett.squidgie.domain.Tasting)
     */
    @Override
    public int update(Tasting tasting) {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see net.paffett.squidgie.data.TastingDAO#delete(long)
     */
    @Override
    public int delete(long tastingId) {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see net.paffett.squidgie.data.TastingDAO#findTastingByBeer(long)
     */
    @Override
    public List<Tasting> findTastingByBeer(long beerId) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see net.paffett.squidgie.data.TastingDAO#findTastingByTaster(long)
     */
    @Override
    public List<Tasting> findTastingByTaster(long tasterId) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see net.paffett.squidgie.data.TastingDAO#findTastingByDate(java.util.Date, java.util.Date)
     */
    @Override
    public List<Tasting> findTastingByDate(Date startDate, Date endDate) {
        // TODO Auto-generated method stub
        return null;
    }

}
