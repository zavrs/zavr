package com.zavr.usercenterservice.userController;

import com.zavr.usercenterservice.pojos.Agent;
import com.zavr.usercenterservice.userService.AgentService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user/agent")
public class AgentController {
    @Autowired  //a injector for invoking other micro-services
    private RestTemplate restTemplate;

    @Autowired
    AgentService agentService;

    /**
     * 此接口用于平台系统手动创建一个代理。
     * 仅提供给平台系统调用，其他系统无权调用。
     * @author: jingpan
     * @param request 请求
     * @returns java.lang.String
     * @date 2018/7/2 16:09
     */
    @RequestMapping(value = "/CreateAgent",method = RequestMethod.POST)
    public String CreateAgent(HttpServletRequest request, HttpServletResponse response){
        //{"Name":"习近平","SimpleName":"大大","Province":"北京","City":"北京","Region":"海淀区","Address":"清河","Linkman":"彭丽媛","LinkTelePhone":"028123456","LinkMobilePhone":"150456789","Email":"tiananmen@.com"}
        String parameter = request.getParameter("parameter");
        JSONObject jsonObject = JSONObject.fromObject(parameter);
        Agent agent = new Agent();
        agent.setName(jsonObject.getString("Name"));
        agent.setSimplename(jsonObject.getString("SimpleName"));
        agent.setProvince(jsonObject.getString("Province"));
        agent.setCity(jsonObject.getString("City"));
        agent.setRegion(jsonObject.getString("Region"));
        agent.setAddress(jsonObject.getString("Address"));
        agent.setLinkman(jsonObject.getString("Linkman"));
        agent.setLinktelephone(jsonObject.getString("LinkTelePhone"));
        agent.setLinkmobilephone(jsonObject.getString("LinkMobilePhone"));
        agent.setEmail(jsonObject.getString("Email"));
        return agentService.CreateAgent(agent);
    }
    /**
     * 此接口用于 SaaS 系统代理自助注册（申请试用）。新注册的代理，是待审核
     * 状态。
     * @author: jingpan
     * @param request 请求
     * @returns java.lang.String
     * @date 2018/7/2 16:10
     */
    @RequestMapping(value = "/RegistAgent",method = RequestMethod.POST)
    public String RegistAgent(HttpServletRequest request, HttpServletResponse response){
        String parameter = request.getParameter("parameter");
        JSONObject jsonObject = JSONObject.fromObject(parameter);
        Agent agent = new Agent();
        agent.setName(jsonObject.getString("Name"));
        agent.setSimplename(jsonObject.getString("SimpleName"));
        agent.setProvince(jsonObject.getString("Province"));
        agent.setCity(jsonObject.getString("City"));
        agent.setRegion(jsonObject.getString("Region"));
        agent.setAddress(jsonObject.getString("Address"));
        agent.setLinkman(jsonObject.getString("Linkman"));
        agent.setLinktelephone(jsonObject.getString("LinkTelePhone"));
        agent.setLinkmobilephone(jsonObject.getString("LinkMobilePhone"));
        agent.setEmail(jsonObject.getString("Email"));
        return agentService.RegistAgent(agent);
    }
    /**
     * 此接口用于修改一个代理的状态。
     * 仅提供给平台系统调用，其他系统无权调用。
     * @author: jingpan
     * @param request 请求
     * @returns java.lang.String
     * @date 2018/7/2 16:14
     */
    @RequestMapping(value = "/SetAgentState",method = RequestMethod.POST)
    public String SetAgentState(HttpServletRequest request, HttpServletResponse response){
        //{"ID":13,"Status":3}
        String parameter = request.getParameter("parameter");
        JSONObject jsonObject = JSONObject.fromObject(parameter);
        Integer id = jsonObject.getInt("ID");
        Integer status = jsonObject.getInt("Status");
        return agentService.SetAgentState(id,status);
    }
    /**
     * 此接口用于修改代理的基本信息。
     * 仅提供给平台系统调用，其他系统无权调用。
     * @author: jingpan
     * @param request 请求
     * @returns java.lang.String
     * @date 2018/7/2 17:42
     */
    @RequestMapping(value = "/SetAgent",method = RequestMethod.POST)
    public String SetAgent(HttpServletRequest request, HttpServletResponse response){
        String parameter = request.getParameter("parameter");
        JSONObject jsonObject = JSONObject.fromObject(parameter);
        Agent agent = new Agent();
        agent.setId(jsonObject.getInt("ID"));
        agent.setName(jsonObject.getString("Name"));
        agent.setSimplename(jsonObject.getString("SimpleName"));
        agent.setProvince(jsonObject.getString("Province"));
        agent.setCity(jsonObject.getString("City"));
        agent.setRegion(jsonObject.getString("Region"));
        agent.setAddress(jsonObject.getString("Address"));
        agent.setLinkman(jsonObject.getString("Linkman"));
        agent.setLinktelephone(jsonObject.getString("LinkTelePhone"));
        agent.setLinkmobilephone(jsonObject.getString("LinkMobilePhone"));
        agent.setEmail(jsonObject.getString("Email"));
        return agentService.SetAgent(agent);
    }

    /**
     * 此接口用于获取一个代理的基本信息。
     * @author: jingpan
     * @param request 请求
     * @returns java.lang.String
     * @date 2018/7/2 17:59
     */
    @RequestMapping(value = "/GetAgent",method = RequestMethod.POST)
    public String GetAgent(HttpServletRequest request, HttpServletResponse response){
        String parameter = request.getParameter("parameter");
        JSONObject jsonObject = JSONObject.fromObject(parameter);
        return agentService.GetAgent(jsonObject.getInt("ID"));
    }

    /**
     * 此接口用于根据分页查询条件，查询符合的代理列表。
     * 仅提供给平台系统调用，其他系统无权调用。
     * @author: jingpan
     * @param request 请求
     * @returns java.lang.String
     * @date 2018/7/2 17:59
     */
    @RequestMapping(value = "/QueryAgents",method = RequestMethod.POST)
    public String  QueryAgents(HttpServletRequest request, HttpServletResponse response){
        String parameter = request.getParameter("parameter");
        JSONObject jsonPage = JSONObject.fromObject(parameter);
        return agentService.QueryAgents(jsonPage);
    }















    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String  test(HttpServletRequest request, HttpServletResponse response){
//        restTemplate.getForEntity("",String.class);
        return "test";
    }



}
