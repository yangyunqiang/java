package tkmybatisgenerator.entity;

import java.util.Date;
import javax.persistence.*;

public class Student {
    @Column(name = "STUID")
    private Short stuid;

    @Column(name = "STUNAME")
    private String stuname;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "AGE")
    private Short age;

    @Column(name = "JOINDATE")
    private Date joindate;

    @Column(name = "CLASSID")
    private Short classid;

    @Column(name = "ADDRESS")
    private String address;

    /**
     * @return STUID
     */
    public Short getStuid() {
        return stuid;
    }

    /**
     * @param stuid
     */
    public void setStuid(Short stuid) {
        this.stuid = stuid;
    }

    /**
     * @return STUNAME
     */
    public String getStuname() {
        return stuname;
    }

    /**
     * @param stuname
     */
    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    /**
     * @return GENDER
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return AGE
     */
    public Short getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(Short age) {
        this.age = age;
    }

    /**
     * @return JOINDATE
     */
    public Date getJoindate() {
        return joindate;
    }

    /**
     * @param joindate
     */
    public void setJoindate(Date joindate) {
        this.joindate = joindate;
    }

    /**
     * @return CLASSID
     */
    public Short getClassid() {
        return classid;
    }

    /**
     * @param classid
     */
    public void setClassid(Short classid) {
        this.classid = classid;
    }

    /**
     * @return ADDRESS
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }
}