package com.example.server02.mapper;


import com.example.server02.pojo.po.TbUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @ClassName TbUserMapper
 * @Description TODO
 * @Author Scorpio
 * @Date 2019/12/9 17:43
 */

@Mapper
@Component
public interface TbUserMapper extends BaseMapper<TbUser> {
}