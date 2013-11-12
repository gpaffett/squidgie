/**
 * 
 */
package net.paffett.squidgie.data;

import java.util.List;

import net.paffett.squidgie.domain.Beer;

/**
 * @author gpaffett
 *
 */
public interface BeerDAO {
	
	public Beer add(Beer beer);

	public Beer findByName(String name);
	
	public List<Beer> findByDescription(String desc);
	
	public List<Beer> getAll();
	
	public int update(Beer beer);
	
	public int remove(long id);
	
}
