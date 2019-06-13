package com.hello.service.impl;

import com.hello.model.Article;
import com.hello.service.WeChatService;
import com.hello.util.CommonUtil;
import net.sf.json.JSONObject;
import org.dom4j.DocumentException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zane on 2017/1/19.
 */
@Service("weChatService")
public class WeChatServiceImpl implements WeChatService {

    /**
     * 获取永久素材
     */
    public Article getPermanentMaterial(String media_id) {
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN";
        String accessToken = CommonUtil.getToken("wx2944dc90563f2cdc", "b333b67c6c7f506bee72de7760d46c90").getAccessToken();
        String requestUrl2 = requestUrl.replace("ACCESS_TOKEN", accessToken);

        String requestJson = "{"+
                "\"media_id\":\""+media_id+"\""+
                "}";
        JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl2, "POST", requestJson);
        System.out.println("jsonObject"+jsonObject.toString());
        String news_item = jsonObject.getString("news_item");
        System.out.println("(description)"+news_item);

        String regex = "\\{(.*)\\}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(news_item);
        List articles = new ArrayList();
        while (matcher.find()) {
            String article = matcher.group();
            JSONObject jsonObject1 = JSONObject.fromObject(article);
            articles.add(jsonObject1);
        }

        if (articles.size() == 1) {
            JSONObject object = (JSONObject) articles.get(0);

            Article article = new Article();
            article.setTitle(object.getString("title"));
            article.setDescription(object.getString("digest"));
            article.setPicUrl(object.getString("thumb_url"));
            article.setUrl(object.getString("url"));
            return article;
        }
        return null;
    }


}
