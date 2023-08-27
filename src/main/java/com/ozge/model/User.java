package com.ozge.model;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "gender")
    private String gender;

    @Column(name = "note")
    private String note;

    @Column(name = "profession")
    private String profession;
    @Column(name = "name")
    private String name;

    @Column(name = "birthday")
    private String birthday;
    @Column(name = "married")
    private boolean married;




    public User(String email, String password, String gender, String note, String profession, String name, String birthday) {
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.note = note;
        this.profession = profession;
        this.name = name;
        this.birthday = birthday;
    }

    public long getId() {
        return id;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public User() {
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return "User[id = " + id + ", email = " + email + ", password = " + password + ", gender = " + gender + ", note = " + note + ", profession = " + profession + ", name = " + name + ", birthday = " + birthday + ", married = " + married + "]";

    }
}
