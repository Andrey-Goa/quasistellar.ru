package ru.quasistellar.messages;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Message {

    @Id
    @GeneratedValue
    @Column(name = "message_id")
    private  Integer id;


    @Column(name = "message_name")
    private String name;


    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @Column(name = "message_date")
    private Date date= new Date();

    @Column(name = "message_email")
    private String email;

    @Column(name = "message_tel")
    private String tel;

    @Lob
    @Type(type="org.hibernate.type.StringClobType")
    @Column(name = "message_message")
    private String content;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTel() {
        return tel;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
