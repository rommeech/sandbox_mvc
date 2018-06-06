package org.rp.sandboxmvc.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@MappedSuperclass
public abstract class Model<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = -8781734021436849708L;
    private static final Logger logger = LogManager.getLogger(Model.class);

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @SequenceGenerator(name = "pk_model_seq", sequenceName = "model_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_model_seq")
    private T id;

    @Column(name = "date_created", updatable = false, nullable = false)
    private Timestamp dateCreated;

    @Column(name = "last_updated")
    private Timestamp lastUpdated;

    public Model() {
    }

    @PrePersist
    public void setDateCreate() {
        this.dateCreated = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    public void setLastUpdate() {
        this.lastUpdated = new Timestamp(System.currentTimeMillis());
    }

    public T getId() {
        return id;
    }

    public void setId(T id) throws ModelException {
        if (this.id != null && !id.equals(this.id)) {
            logger.error("Cannot change ID " + this.id + " => " + id);
            throw new ModelException("Cannot change ID");
        }
        this.id = id;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
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
