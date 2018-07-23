package com.zucc.demo.dao;

import com.zucc.demo.model.BookVo;
import com.zucc.demo.model.UserVo;

public interface UserDAO {
    public UserVo addUser(UserVo user) throws Exception;
    public UserVo readUser(int userid) throws Exception;



}
