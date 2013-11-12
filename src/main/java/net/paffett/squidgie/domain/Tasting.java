package net.paffett.squidgie.domain;

public class Tasting {

    private long tastingId;
    private Taster taster;
    private Beer beer;

    public long getTastingId() {
        return tastingId;
    }

    public void setTastingId(long tastingId) {
        this.tastingId = tastingId;
    }

    public Taster getTaster() {
        return taster;
    }

    public void setTaster(Taster taster) {
        this.taster = taster;
    }

    public Beer getBeer() {
        return beer;
    }

    public void setBeer(Beer beer) {
        this.beer = beer;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((beer == null) ? 0 : beer.hashCode());
        result = prime * result + ((taster == null) ? 0 : taster.hashCode());
        result = prime * result + (int) (tastingId ^ (tastingId >>> 32));
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
        Tasting other = (Tasting) obj;
        if (beer == null) {
            if (other.beer != null)
                return false;
        } else if (!beer.equals(other.beer))
            return false;
        if (taster == null) {
            if (other.taster != null)
                return false;
        } else if (!taster.equals(other.taster))
            return false;
        if (tastingId != other.tastingId)
            return false;
        return true;
    }

}
