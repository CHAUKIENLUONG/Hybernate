package pojo;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "question")
public class Question implements Serializable {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne
    private Level level;
    @OneToMany(mappedBy = "question")
    private List<Choice> choices;
    @ManyToMany
    @JoinTable(
            name = "ques_cate",
            joinColumns = {@JoinColumn(name = "question_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")}
    )
    private Set<Category> categories;

    public Question() {
    }

    public Question(String id, String content) {
        this.id = id;
        this.content = content;
    }

    // Các phương thức getter/setter của các thuộc tính
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}

