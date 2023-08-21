package com.techforb.userdashboard.dto;

import com.techforb.userdashboard.model.OptionMenu;

public class OptionMenuDTO {

    private long id;

    private String name;

    private String url;

    public OptionMenuDTO(OptionMenu optionMenu) {
        this.id = optionMenu.getId();
        this.name = optionMenu.getName();
        this.url = optionMenu.getUrl();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
