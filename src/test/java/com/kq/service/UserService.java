package com.kq.service;

/**
 * @author kq
 * 2024-06-25 00:37
 **/
public class UserService {

    private String uId;

    private String company;

    private UserDao userDao;

    private String location;

    public void queryUserInfo() {
        System.out.println("查询用户信息：" +
                "地址:" + location + "-" +
                "公司:" + company +  "-"+
                "用户名:" + userDao.queryUserName(uId));
    }

    public void test() {
        System.out.println("test message!");
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUId() {
        return uId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setUId(String uId) {
        this.uId = uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

}
