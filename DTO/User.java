package DTO;

import java.util.Objects;

public class User {
    private String name;
    private Integer age;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash  * Objects.hashCode(this.id);
        hash = 11 * hash * Objects.hashCode(this.age);
        hash = 11 * hash * Objects.hashCode(this.name);
        return hash;
    }
}
