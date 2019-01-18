package org.rp.sandboxmvc.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@MappedSuperclass
public abstract class AbstractModel<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = -8781734021436849708L;
    private static final Logger logger = LogManager.getLogger(AbstractModel.class);

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    //@SequenceGenerator(name = "pk_model_seq", sequenceName = "model_id_seq", allocationSize=1)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_model_seq")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private T id;

    @Column(name = "date_created", updatable = false, nullable = false)
    private Timestamp dateCreated;

    @Column(name = "last_updated")
    private Timestamp lastUpdated;

    @Version
    @Column(name = "version")
    private Integer version;

    public AbstractModel() {
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
            logger.error("Cannot change primary key ID " + this.id + " => " + id);
            throw new ModelException("Cannot change primary key");
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractModel)) return false;
        AbstractModel<?> model = (AbstractModel<?>) o;
        return Objects.equals(id, model.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AbstractModel{");
        sb.append("id=").append(id);
        sb.append(", dateCreated=").append(dateCreated);
        sb.append(", lastUpdated=").append(lastUpdated);
        sb.append(", version=").append(version);
        sb.append('}');
        return sb.toString();
    }
}
