package softuni.models.entities;

import javax.persistence.*;
import java.time.Instant;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Instant created;

    private Instant modified;

    public long getId() {
        return id;
    }

    public BaseEntity setId(long id) {
        this.id = id;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public BaseEntity setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public Instant getModified() {
        return modified;
    }

    public BaseEntity setModified(Instant modified) {
        this.modified = modified;
        return this;
    }

    @PrePersist
    public void beforeCreate() {
        this.created = Instant.now();
    }

}
