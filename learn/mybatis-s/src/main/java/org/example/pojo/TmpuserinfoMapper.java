package org.example.pojo;

import java.util.List;

public interface TmpuserinfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TMPUSERINFO
     *
     * @mbggenerated Sat Jan 23 17:08:31 GMT+08:00 2021
     */
    int insert(Tmpuserinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TMPUSERINFO
     *
     * @mbggenerated Sat Jan 23 17:08:31 GMT+08:00 2021
     */
    int insertSelective(Tmpuserinfo record);


    List<Tmpuserinfo> selectAll(String name);
}