package pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "level")
public class Level implements Serializable {
    @Id
    @Column(name="id")
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    public Level() {
    }

    public Level(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Các phương thức getter/setter của các thuộc tính
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
