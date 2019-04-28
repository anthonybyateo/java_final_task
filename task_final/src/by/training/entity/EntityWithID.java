package by.training.entity;

abstract public class EntityWithID extends Entity{
    /**
     *
     */
    private int id;

    public EntityWithID() {}

    public EntityWithID(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */


    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        EntityWithID entityWithID = (EntityWithID) obj;
        return id == entityWithID.id;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        return prime * id;
    }
}
