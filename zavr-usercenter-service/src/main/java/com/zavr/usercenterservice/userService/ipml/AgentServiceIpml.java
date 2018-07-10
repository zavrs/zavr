package com.zavr.usercenterservice.userService.ipml;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zavr.zavrcommonservice.utils.RetUtil;
import com.zavr.usercenterservice.mapper.AgentMapper;
import com.zavr.usercenterservice.pojos.Agent;
import com.zavr.usercenterservice.userService.AgentService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;

@Service
public class AgentServiceIpml implements AgentService {
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Resource
    AgentMapper agentMapper;

    @Override
    public String CreateAgent(Agent agent) {
        if(agent.getName()!=null){
            Agent queryAgent = queryAgent(agent);
            if(queryAgent==null){
                agent.setStatus(2);//后台新增代理，无需审核
                Integer integer = agentMapper.addAgent(agent);
                if(integer!=0){
                    return RetUtil.param(true,"新增成功");
                }else{
                    return RetUtil.param(false,"新增失败");
                }
            }else{
                return RetUtil.param(false,"该代理已注册");
            }
        }else{
            return RetUtil.param(false,"代理信息不详");
        }
    }

    @Override
    public Agent queryAgent(Agent agent) {
        return agentMapper.queryAgent(agent);
    }

    @Override
    public String RegistAgent(Agent agent) {
        if(agent.getName()!=null){
            Agent queryAgent = queryAgent(agent);
            if(queryAgent==null){
                agent.setStatus(1);//注册代理默认状态为申请中
                Integer integer = agentMapper.addAgent(agent);
                if(integer!=0){
                    return RetUtil.param(true,"注册成功");
                }else{
                    return RetUtil.param(false,"注册失败");
                }
            }else{
                return RetUtil.param(false,"该代理已被注册");
            }
        }else{
            return RetUtil.param(false,"没有注册信息");
        }
    }

    @Override
    public String SetAgentState(Integer id, Integer status) {
        String result = "";//返回修改结果
        Agent agent = new Agent();
        agent.setId(id);
        Agent queryAgent = queryAgent(agent);
        if(queryAgent.getStatus()!=status){
            Integer integer = agentMapper.updateStatus(id, status);
            if(integer!=0){
                result="修改成功";
            }else{
                result="修改失败";
            }
        }else{
            result="该代理状态与修改状态一致";
        }
        return result;
    }

    @Override
    public String SetAgent(Agent agent) {
        Agent queryAgent = queryAgent(agent);
        if(queryAgent==null){
            Integer integer = agentMapper.updateAgent(agent);
            if(integer!=0){
                return RetUtil.param(true,"修改成功");
            }else{
                return RetUtil.param(false,"修改失败");
            }
        }else{
            return RetUtil.param(false,"该代理名称已被注册");
        }
    }

    @Override
    public String GetAgent(Integer id) {
        if(id!=null){
            Agent agent = new Agent();
            agent.setId(id);
            Agent queryAgent = agentMapper.queryAgent(agent);
            if(queryAgent!=null){
                return RetUtil.param(true,"代理对象",JSONObject.fromObject(queryAgent));
            }else{
                return RetUtil.param(false,"没有该代理信息");
            }
        }else{
            return RetUtil.param(false,"代理ID为空");
        }
    }

    @Override
    public String QueryAgents(JSONObject jsonPage) {
        Integer pageNum = jsonPage.getInt("PageIndex");
        Integer pageSize = jsonPage.getInt("PageSize");
        try {
            JSONObject jsonAgent = JSONObject.fromObject(jsonPage.getString("Query"));
            Agent agent = new Agent();
            if(jsonAgent.get("Name")!=null){
                agent.setName(jsonAgent.getString("Name"));
            }
            if(jsonAgent.get("Linkman")!=null){
                agent.setLinkman(jsonAgent.getString("Lingkman"));
            }
            PageHelper.startPage(pageNum,pageSize);
            System.out.println(agent.getName());
            Page<Agent> agentPage = agentMapper.pageQuery(agent);
            PageInfo<Agent> pageInfo = new PageInfo<>(agentPage);
            JSONArray jsonArray = new JSONArray();
            for (int i = 0; i < pageInfo.getList().size(); i++) {
                JSONObject retInfo = JSONObject.fromObject(pageInfo.getList().get(i));
                retInfo.put("applydatetime",sdf.format(pageInfo.getList().get(i).getApplydatetime()));
                retInfo.put("opendatetime",sdf.format(pageInfo.getList().get(i).getOpendatetime()));
                retInfo.put("modifytime",sdf.format(pageInfo.getList().get(i).getModifytime()));
                jsonArray.add(retInfo);
            }
            String re = RetUtil.Paging(true,"success",jsonArray,pageNum,pageSize,pageInfo.getPages(),(int)pageInfo.getTotal());
            System.out.println(re);
            return RetUtil.Paging(true,"success",jsonArray,pageNum,pageSize,pageInfo.getPages(),(int)pageInfo.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            return RetUtil.param(false,e.getMessage());
        }
    }
}
