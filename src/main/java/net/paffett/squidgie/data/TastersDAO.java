/**
 * 
 */
package net.paffett.squidgie.data;

import java.util.List;

import net.paffett.squidgie.domain.Name;
import net.paffett.squidgie.domain.Taster;

/**
 * @author gpaffett
 * 
 */
public interface TastersDAO {

    public Taster add(Taster taster);

    public int update(Taster taster);

    public int delete(long tasterId);

    public List<Taster> findTasterByName(Name name);

    public Taster findTastingById(long tasterId);

}
