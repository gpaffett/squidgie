/**
 * 
 */
package net.paffett.squidgie.domain;

/**
 * @author gpaffett
 * 
 */
public class Taster {

    private long tasterId;
    private Name name;
    private String comments;

    public long getTasterId() {
        return tasterId;
    }

    public void setTasterId(long tasterId) {
        this.tasterId = tasterId;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + (int) (tasterId ^ (tasterId >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Taster other = (Taster) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (tasterId != other.tasterId)
            return false;
        return true;
    }

}
