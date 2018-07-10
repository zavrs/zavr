package com.zavr.usercenterservice.userService;

import com.zavr.usercenterservice.pojos.Agent;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public interface AgentService {
    /**
     * 新增代理
     * @author: jingpan
     * @param agent 代理对象
     * @returns java.lang.String
     * @date 2018/7/2 9:23
     */
    String CreateAgent(Agent agent);
    /**
     *查询指定代理信息
     * @author: jingpan
     * @param agent 代理对象
     * @returns java.lang.Integer
     * @date 2018/7/2 10:18
     */
    Agent queryAgent(Agent agent);
    /**
     * 新注册的代理，是待审核状态
     * @author: jingpan
     * @param agent 代理对象
     * @returns com.zavr.usercenter.model.Agent
     * @date 2018/7/2 15:44
     */
    String RegistAgent(Agent agent);
    /**
     * 修改代理信息
     * @author: jingpan
     * @param id 代理编号 status 代理状态
     * @returns java.lang.Integer
     * @date 2018/7/2 16:25
     */
    String SetAgentState(Integer id,Integer status);
    /**
     * 此接口用于修改代理的基本信息。
     * 仅提供给平台系统调用，其他系统无权调用。
     * @author: jingpan
     * @param agent 修改的代理对象
     * @returns java.lang.Integer
     * @date 2018/7/2 17:03
     */
    String SetAgent(Agent agent);
    /**
     * 此接口用于获取一个代理的基本信息。
     * @author: jingpan
     * @param id 代理ID
     * @returns com.zavr.usercenter.model.Agent
     * @date 2018/7/2 17:54
     */
    String GetAgent(Integer id);
    /**
     * 此接口用于根据分页查询条件，查询符合的代理列表。
     * 仅提供给平台系统调用，其他系统无权调用。
     * @author: jingpan
     * @param jsonPage 分页信息
     * @returns com.github.pagehelper.Page<com.zavr.usercenter.model.Agent>
     * @date 2018/7/5 11:30
     */
    String QueryAgents(JSONObject jsonPage);

}
