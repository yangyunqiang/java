package com.example.server01.pojo.po;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.ORDER;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @ClassName TbUser
 * @Description TODO
 * @Author Scorpio
 * @Date 2019/12/9 17:43
 */
@Data
@Table(name = "Menu")
public class TbUser implements Serializable {
    private static final long serialVersionUID = -6758046790240181125L;

    @KeySql(sql = "select 1 from dual", order = ORDER.BEFORE)
    @Column(name = "id")
    private Long id;

    @Id
    @Column(name = "userid")
    private int userid;

    /**
     * 用户名
     */
    @Column(name = "username")
    private String username;


}