package org.example.pojo;

public class Tmpuserinfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TMPUSERINFO.USERNAME
     *
     * @mbggenerated Sat Jan 23 17:08:31 GMT+08:00 2021
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TMPUSERINFO.AGE
     *
     * @mbggenerated Sat Jan 23 17:08:31 GMT+08:00 2021
     */
    private Integer age;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TMPUSERINFO.ADDR
     *
     * @mbggenerated Sat Jan 23 17:08:31 GMT+08:00 2021
     */
    private String addr;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TMPUSERINFO.USERNAME
     *
     * @return the value of TMPUSERINFO.USERNAME
     *
     * @mbggenerated Sat Jan 23 17:08:31 GMT+08:00 2021
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TMPUSERINFO.USERNAME
     *
     * @param username the value for TMPUSERINFO.USERNAME
     *
     * @mbggenerated Sat Jan 23 17:08:31 GMT+08:00 2021
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TMPUSERINFO.AGE
     *
     * @return the value of TMPUSERINFO.AGE
     *
     * @mbggenerated Sat Jan 23 17:08:31 GMT+08:00 2021
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TMPUSERINFO.AGE
     *
     * @param age the value for TMPUSERINFO.AGE
     *
     * @mbggenerated Sat Jan 23 17:08:31 GMT+08:00 2021
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TMPUSERINFO.ADDR
     *
     * @return the value of TMPUSERINFO.ADDR
     *
     * @mbggenerated Sat Jan 23 17:08:31 GMT+08:00 2021
     */
    public String getAddr() {
        return addr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TMPUSERINFO.ADDR
     *
     * @param addr the value for TMPUSERINFO.ADDR
     *
     * @mbggenerated Sat Jan 23 17:08:31 GMT+08:00 2021
     */
    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }
}