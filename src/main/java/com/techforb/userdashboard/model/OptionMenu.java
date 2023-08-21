package com.techforb.userdashboard.model;

import javax.persistence.*;

@Entity
public class OptionMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private long id;
    private String name;

    private String url;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="option_menu_list_id")
    private OptionMenuList option_menu_list;

    public OptionMenu() {
    }

    public OptionMenu(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public long getId() {
        return id;
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

    public OptionMenuList getOption_menu_list() {
        return option_menu_list;
    }

    public void setOption_menu_list(OptionMenuList option_menu_list) {
        this.option_menu_list = option_menu_list;
    }
}
