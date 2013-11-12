/**
 * 
 */
package net.paffett.squidgie.data;

import java.util.List;

import net.paffett.squidgie.domain.Style;

/**
 * @author gpaffett
 *
 */
public interface StyleDAO {
    
    public Style add(Style style);
    
    public Style findById(String id);
    
    public List<Style> findByName(String name);
    
    public int update(Style style);
    
    public void delete(long id);

}
