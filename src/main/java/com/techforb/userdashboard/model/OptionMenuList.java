package com.techforb.userdashboard.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Entity
public class OptionMenuList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String category;

    @OneToMany(mappedBy="option_menu_list", fetch=FetchType.EAGER)
    private List<OptionMenu> options_menu = new ArrayList<>();

    public OptionMenuList() {
    }

    public OptionMenuList(String category) {
        this.category = category;
    }

    public long getId() {
        return id;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<OptionMenu> getOptions_menu() {
        return options_menu;
    }

    public void setOptions_menu(List<OptionMenu> options_menu) {
        this.options_menu = options_menu;
    }

    public void addOptionMenu(OptionMenu optionMenu){

       optionMenu.setOption_menu_list(this);
        this.options_menu.add(optionMenu);
    }
}
