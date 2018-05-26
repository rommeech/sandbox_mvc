package org.rp.sandboxmvc.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@MappedSuperclass
public abstract class Model<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = -8781734021436849708L;
    private static final Logger logger = LogManager.getLogger(Model.class);

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private T id;

    @Column(name = "date_created", updatable = false, nullable = false)
    private Date dateCreated;

    @Column(name = "last_updated")
    private Date lastUpdated;

    public Model() {
    }

    public T getId() {
        return id;
    }

    public void setId(T id) throws ModelException {
        if (this.id != null || !id.equals(this.id)) {
            logger.error("Cannot change ID");
            throw new ModelException("Cannot change ID");
        }
        this.id = id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Model)) return false;
        Model<?> model = (Model<?>) o;
        return Objects.equals(id, model.id) &&
                Objects.equals(dateCreated, model.dateCreated) &&
                Objects.equals(lastUpdated, model.lastUpdated);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, dateCreated, lastUpdated);
    }
}
