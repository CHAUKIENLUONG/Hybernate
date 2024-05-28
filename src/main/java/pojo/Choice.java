package pojo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "choice")
public class Choice implements Serializable {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "content",length = 255, nullable = false)
    private String content;
    @Column(name = "is_correct")
    private boolean correct;

    @ManyToOne
    @JoinColumn(name =  "question_id")
    private Question question;

    public Choice() {
    }

    public Choice(String id, String content, boolean correct, Question question) {
        this.id = id;
        this.content = content;
        this.correct = correct;
        this.question = question;
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

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
