package com.example.dengshun.test.Demo.Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created 2016/3/23.
 */
public class TopicsBean {


    private String id;//帖子ID
    private String title;//标题
    private String has_pic;//是否有图片
    private String is_essence;//是否精华
    private String is_top;//是否置顶
    private String cdate;//发布时间
    private String views_count;//浏览数
    private String reply_count;//回复数
    private String creator;//楼主
    private List<String> iconType;

    public List<String> getIconType() {
        iconType = new ArrayList<>();
        if ("1".equals(is_top))//顶
            iconType.add("1");
        if ("1".equals(is_essence))//精
            iconType.add("2");
//        if ("0".equals())//路
//        iconType.add("3");
        if ("1".equals(has_pic))//图
            iconType.add("4");
//        if ("0".equals())//游
//        iconType.add("5");

        return iconType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHas_pic() {
        return has_pic;
    }


    public String getIs_essence() {
        return is_essence;
    }


    public String getIs_top() {
        return is_top;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    public String getViews_count() {
        return views_count;
    }

    public void setViews_count(String views_count) {
        this.views_count = views_count;
    }

    public String getReply_count() {
        return reply_count;
    }

    public void setReply_count(String reply_count) {
        this.reply_count = reply_count;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}
