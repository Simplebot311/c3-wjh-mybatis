package com.csa.dao;

import com.csa.domain.Student;

import java.util.List;

/**
 * @author yufeng1900
 * @create 2021-03-24 22:48
 *
 * 用户的持久层接口
 */
public interface StudentDao {

    /**
     * 查询所有操作
     * @return
     */
    List<Student> findAll();
}
