package application.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name="USER")
public class User {
    @Id
    @GeneratedValue
    @Column(name="user_id")
    private Integer id;
    @Column(name="user_name")
    private String name;
    @Min(value = 18, message = "未成年吧")
    @Column(name="user_age")
    private Integer age;
    @Column(name="user_sex")
    private String sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
