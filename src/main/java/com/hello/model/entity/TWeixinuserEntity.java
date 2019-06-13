package com.hello.model.entity;


/**
 * Created by zane on 2017/1/8.
 */
public class TWeixinuserEntity {
    private String openId;
    private String nickname;
    private Integer sex;
    private String province;
    private String city;
    private String country;
    private String headimgur;
    private String privilege;
    private String unionid;
    private String loginDate;
    private Integer myInfoFinish;
    private Integer shootInfoFinish;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadimgur() {
        return headimgur;
    }

    public void setHeadimgur(String headimgur) {
        this.headimgur = headimgur;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(String loginDate) {
        this.loginDate = loginDate;
    }

    public Integer getMyInfoFinish() {
        return myInfoFinish;
    }

    public void setMyInfoFinish(Integer myInfoFinish) {
        this.myInfoFinish = myInfoFinish;
    }

    public Integer getShootInfoFinish() {
        return shootInfoFinish;
    }

    public void setShootInfoFinish(Integer shootInfoFinish) {
        this.shootInfoFinish = shootInfoFinish;
    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        TWeixinuserEntity that = (TWeixinuserEntity) o;
//
//        if (openId != null ? !openId.equals(that.openId) : that.openId != null) return false;
//        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
//        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
//        if (province != null ? !province.equals(that.province) : that.province != null) return false;
//        if (city != null ? !city.equals(that.city) : that.city != null) return false;
//        if (country != null ? !country.equals(that.country) : that.country != null) return false;
//        if (headimgur != null ? !headimgur.equals(that.headimgur) : that.headimgur != null) return false;
//        if (privilege != null ? !privilege.equals(that.privilege) : that.privilege != null) return false;
//        if (unionid != null ? !unionid.equals(that.unionid) : that.unionid != null) return false;
//        if (loginDate != null ? !loginDate.equals(that.loginDate) : that.loginDate != null) return false;
//        if (myInfoFinish != null ? !myInfoFinish.equals(that.myInfoFinish) : that.myInfoFinish != null) return false;
//        if (shootInfoFinish != null ? !shootInfoFinish.equals(that.shootInfoFinish) : that.shootInfoFinish != null)
//            return false;
//
//        return true;
//    }

    @Override
    public int hashCode() {
        int result = openId != null ? openId.hashCode() : 0;
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (headimgur != null ? headimgur.hashCode() : 0);
        result = 31 * result + (privilege != null ? privilege.hashCode() : 0);
        result = 31 * result + (unionid != null ? unionid.hashCode() : 0);
        result = 31 * result + (loginDate != null ? loginDate.hashCode() : 0);
        result = 31 * result + (myInfoFinish != null ? myInfoFinish.hashCode() : 0);
        result = 31 * result + (shootInfoFinish != null ? shootInfoFinish.hashCode() : 0);
        return result;
    }
}
