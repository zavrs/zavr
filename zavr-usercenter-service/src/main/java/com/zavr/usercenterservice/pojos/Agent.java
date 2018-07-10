package com.zavr.usercenterservice.pojos;

import java.util.Date;

/**
 * @Auther: jingpan
 * @Date: 2018/7/2 09:21
 * 代理基本信息
 */
public class Agent{
    private Integer id; //编号

    private String name; // 代理名称

    private String pwd;//密码

    private String simplename; //代理简称

    private Date opendatetime; //开通时间

    private Date applydatetime; //声请开通时间

    private String province;//所在省份

    private String city; //所在城市

    private String region; //所在区域

    private String address;//详细地址

    private Integer level; // 代理级别    1：普通代理 2：Vip代理（购买过某个产品功能） 3：钻石代理（包月） 4：至尊代理（包年）

    private String linkman; // 联系人

    private String linkmobilephone; //联系手机

    private String linktelephone;//联系座机

    private String email; //联系邮箱

    private Integer status; //状态   '1：申请中 2：正常3：禁用  4：删除';

    private Date modifytime; //修改时间戳

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSimplename() {
        return simplename;
    }

    public void setSimplename(String simplename) {
        this.simplename = simplename;
    }

    public Date getOpendatetime() {
        return opendatetime;
    }

    public void setOpendatetime(Date opendatetime) {
        this.opendatetime = opendatetime;
    }

    public Date getApplydatetime() {
        return applydatetime;
    }

    public void setApplydatetime(Date applydatetime) {
        this.applydatetime = applydatetime;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getLinkmobilephone() {
        return linkmobilephone;
    }

    public void setLinkmobilephone(String linkmobilephone) {
        this.linkmobilephone = linkmobilephone;
    }

    public String getLinktelephone() {
        return linktelephone;
    }

    public void setLinktelephone(String linktelephone) {
        this.linktelephone = linktelephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", simplename='" + simplename + '\'' +
                ", opendatetime=" + opendatetime +
                ", applydatetime=" + applydatetime +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", address='" + address + '\'' +
                ", level=" + level +
                ", linkman='" + linkman + '\'' +
                ", linkmobilephone='" + linkmobilephone + '\'' +
                ", linktelephone='" + linktelephone + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", modifytime=" + modifytime +
                '}';
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}