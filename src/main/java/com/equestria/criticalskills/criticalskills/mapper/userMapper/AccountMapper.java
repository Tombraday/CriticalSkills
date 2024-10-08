package com.equestria.criticalskills.criticalskills.mapper.userMapper;

import com.equestria.criticalskills.criticalskills.pojo.userPojo.userEntity.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AccountMapper {


    @Select("select email from account  where email=#{email}")
    String findEmail(String email);

    @Select("select * from account where username=#{username}")
    Account selectByUsername(String username);

    @Insert("insert into account(username, password, email, security_ask, security_ans, role, create_time, update_time) "+
            "VALUES(#{username},#{password},#{email},#{securityAsk},#{securityAns},#{role},#{createTime},#{updateTime})")
    void insertAccount(Account account);

    @Update("update account set password=#{password} where username=#{username}")
    void updatePassword(String username,String password);

}
