package com.hello.util;

import com.hello.model.WeixinOauth2Token;
import com.hello.model.entity.TWeixinuserEntity;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 有关获得网页授权凭证的相关api
 * Created by zane on 2016/11/20.
 */
public class AuthoInterface {
    private static Logger log = LoggerFactory.getLogger(AuthoInterface.class);
    /**
     * 获得页面的授权凭证
     * @param appId 公众号唯一标识
     * @param appSecret 公众号的密钥
     * @param code
     * @return
     */
    public static WeixinOauth2Token getOauth2AccessToken(String appId, String appSecret, String code) {
        WeixinOauth2Token wat = null;

        // 拼接请求地址
        String requestUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
        requestUrl = requestUrl.replace("APPID", appId);
        requestUrl = requestUrl.replace("SECRET", appSecret);
        requestUrl = requestUrl.replace("CODE", code);
        // 获取网页授权凭证
        JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
        if (null != jsonObject) {
            try {
                wat = new WeixinOauth2Token();
                wat.setAccessToken(jsonObject.getString("access_token"));
                wat.setExpiresIn(jsonObject.getInt("expires_in"));
                wat.setRefreshToken(jsonObject.getString("refresh_token"));
                wat.setOpenId(jsonObject.getString("openid"));
                wat.setScope(jsonObject.getString("scope"));
                System.out.println(wat);
            } catch (Exception e) {
                wat = null;
                int errorCode = jsonObject.getInt("errcode");
                String errorMsg = jsonObject.getString("errmsg");
                log.error("获取网页授权凭证失败 errcode:{} errmsg:{}", errorCode, errorMsg);
            }
        }
        return wat;
    }
    /**
     * 刷新网页授权凭证
     *
     * @param appId 公众账号的唯一标识
     * @param refreshToken
     * @return WeixinAouth2Token
     */
    public static WeixinOauth2Token refreshOauth2AccessToken(String appId, String refreshToken) {
        WeixinOauth2Token wat = null;
        // 拼接请求地址
        String requestUrl = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
        requestUrl = requestUrl.replace("APPID", appId);
        requestUrl = requestUrl.replace("REFRESH_TOKEN", refreshToken);
        // 刷新网页授权凭证
        JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
        if (null != jsonObject) {
            try {
                wat = new WeixinOauth2Token();
                wat.setAccessToken(jsonObject.getString("access_token"));
                wat.setExpiresIn(jsonObject.getInt("expires_in"));
                wat.setRefreshToken(jsonObject.getString("refresh_token"));
                wat.setOpenId(jsonObject.getString("openid"));
                wat.setScope(jsonObject.getString("scope"));
            } catch (Exception e) {
                wat = null;
                int errorCode = jsonObject.getInt("errcode");
                String errorMsg = jsonObject.getString("errmsg");
                log.error("刷新网页授权凭证失败 errcode:{} errmsg:{}", errorCode, errorMsg);
            }
        }
        return wat;
    }

    /**
     * 通过网页授权获取用户信息
     *
     * @param accessToken 网页授权接口调用凭证
     * @param openId 用户标识
     * @return SNSUserInfo
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static TWeixinuserEntity getWeixinUserInfo(String accessToken, String openId) throws ParseException, UnsupportedEncodingException {
        TWeixinuserEntity weixinUserInfo = null;
        // 拼接请求地址

        String requestUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
        // 通过网页授权获取用户信息
        JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);

        weixinUserInfo = new TWeixinuserEntity();
        // 用户的标识
        weixinUserInfo.setOpenId(jsonObject.getString("openid"));
        // 昵称
        weixinUserInfo.setNickname(jsonObject.getString("nickname"));
        // 性别（1是男性，2是女性，0是未知）
        weixinUserInfo.setSex(jsonObject.getInt("sex"));
        // 用户所在国家
        weixinUserInfo.setCountry(jsonObject.getString("country"));
        // 用户所在省份
        weixinUserInfo.setProvince(jsonObject.getString("province"));
        // 用户所在城市
        weixinUserInfo.setCity(jsonObject.getString("city"));
        // 用户头像
        weixinUserInfo.setHeadimgur(jsonObject.getString("headimgurl"));
        // 用户特权信息
        weixinUserInfo.setPrivilege(jsonObject.getJSONArray("privilege").toString());
//      get the now system data
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        weixinUserInfo.setLoginDate(sdf.format(new Date()));
//                是否完善个人信息
        weixinUserInfo.setMyInfoFinish(-1);
        weixinUserInfo.setUnionid(null);
        //  是否完善摄制信息
        weixinUserInfo.setShootInfoFinish(-1);

        return weixinUserInfo;
    }

}
