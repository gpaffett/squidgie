/**
 * 
 */
package net.paffett.squidgie.data.jdbc;

import java.util.List;

import net.paffett.squidgie.data.TastersDAO;
import net.paffett.squidgie.domain.Name;
import net.paffett.squidgie.domain.Taster;

/**
 * @author gpaffett
 *
 */
public class TastersJDBCDAO implements TastersDAO {

    /* (non-Javadoc)
     * @see net.paffett.squidgie.data.TastersDAO#add(net.paffett.squidgie.domain.Taster)
     */
    @Override
    public Taster add(Taster taster) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see net.paffett.squidgie.data.TastersDAO#update(net.paffett.squidgie.domain.Taster)
     */
    @Override
    public int update(Taster taster) {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see net.paffett.squidgie.data.TastersDAO#delete(long)
     */
    @Override
    public int delete(long tasterId) {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see net.paffett.squidgie.data.TastersDAO#findTasterByName(net.paffett.squidgie.domain.Name)
     */
    @Override
    public List<Taster> findTasterByName(Name name) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see net.paffett.squidgie.data.TastersDAO#findTastingById(long)
     */
    @Override
    public Taster findTastingById(long tasterId) {
        // TODO Auto-generated method stub
        return null;
    }

}
