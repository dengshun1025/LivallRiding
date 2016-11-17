package com.example.dengshun.test.Demo.Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by on 2016/3/23.
 */
public class Top5Bean {

    private String id;
    private String title;
    private String has_pic;
    private String is_essence;
    private String is_top;
    private List<String> iconType;

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

    private String getHas_pic() {
        return has_pic;
    }


    private String getIs_essence() {
        return is_essence;
    }


    private String getIs_top() {
        return is_top;
    }

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

}
