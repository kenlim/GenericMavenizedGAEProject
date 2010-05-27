package namespace.models;

import siena.*;

@Table("losgenericos")
public class ElGenerico {
    @Id
    public Long id;

    @Column("name")
    public String name;

    public static Query<ElGenerico> all() {
        return Model.all(ElGenerico.class);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
