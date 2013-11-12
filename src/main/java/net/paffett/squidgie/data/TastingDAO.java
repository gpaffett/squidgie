/**
 * 
 */
package net.paffett.squidgie.data;

import java.util.Date;
import java.util.List;

import net.paffett.squidgie.domain.Tasting;

/**
 * @author gpaffett
 * 
 */
public interface TastingDAO {

    public Tasting add(Tasting tasting);

    public int update(Tasting tasting);

    public int delete(long tastingId);

    public List<Tasting> findTastingByBeer(long beerId);

    public List<Tasting> findTastingByTaster(long tasterId);

    public List<Tasting> findTastingByDate(Date startDate, Date endDate);

}
