package app.entities;

import java.time.LocalDate;
import java.util.Objects;

public class List {

    private Integer id;
    private String content;
    private LocalDate addDate;
    private Integer done;
    private Integer userId;

    public List (){ }

    public List(Integer id, String content, LocalDate addDate, Integer done, Integer userId){

        this.id = id;
        this.content = content;
        this.addDate = addDate;
        this.done = done;
        this.userId = userId;
    }

    public int getId(){return id; }

    public LocalDate getAddDate(){return addDate;}

    public String getContent(){return content;}

    public Integer getDone(){return done;}

    public Integer getUserId(){return userId;}

    public void setId(Integer id){this.id = id; }

    public void setContent(String content){this.content = content;}

    public void setAddDate(LocalDate addDate){this.addDate = addDate;}

    public void setDone(Integer done){this.done = done;}

    public void setUserId(Integer userId){this.userId = userId;}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        List list = (List) o;
        return id.equals(list.id)  &&
                content.equals(list.content) &&
                addDate.equals(list.addDate) &&
                done.equals(list.done) &&
                userId.equals(list.userId);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, addDate, done, userId);
    }


    @Override
    public String toString() {
        return "List{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ",   creation date ='" + addDate + '\'' +
                ",   status ='" + done + '\'' +
                ",   userId ='" + userId + '\'' +

                '}';
    }
}
