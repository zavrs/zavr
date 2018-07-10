package com.zavr.usercenterservice.mapper;

import com.github.pagehelper.Page;
import com.zavr.usercenterservice.pojos.Agent;

/**
 * @Auther: jingpan
 * @Date: 2018/7/2 09:21
 * 持久层接口
 */
public interface AgentMapper {
    /**
     * 新增,注册代理
     *
     * @param agent 代理对象
     * @author: jingpan
     * @returns java.lang.Integer
     * @date 2018/7/2 9:26
     */
    Integer addAgent(Agent agent);

    /**
     * 查询指定代理信息
     *
     * @param agent 代理对象
     * @author: jingpan
     * @returns com.zavr.usercenter.model.Agent
     * @date 2018/7/2 9:29
     */
    Agent queryAgent(Agent agent);

    /**
     * 注册代理（状态：待审核）
     *
     * @param agent 代理对象
     * @author: jingpan
     * @returns com.zavr.usercenter.model.Agent
     * @date 2018/7/2 15:40
     */
    Agent RegistAgent(Agent agent);

    /**
     * 修改代理状态
     *
     * @param id 代理编号 status 代理状态
     * @author: jingpan
     * @returns java.lang.Integer
     * @date 2018/7/2 16:18
     */
    Integer updateStatus(Integer id, Integer status);

    /**
     * 修改代理信息
     *
     * @param agent 修改的代理对象
     * @author: jingpan
     * @returns java.lang.Integer
     * @date 2018/7/2 17:03
     */
    Integer updateAgent(Agent agent);

    /**
     * 分页查询
     *
     * @param agent 代理对象
     * @author: jingpan
     * @returns com.github.pagehelper.Page<com.zavr.usercenter.model.Agent>
     * @date 2018/7/5 17:24
     */
    Page<Agent> pageQuery(Agent agent);
}