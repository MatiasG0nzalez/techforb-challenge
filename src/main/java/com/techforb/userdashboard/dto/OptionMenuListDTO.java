package com.techforb.userdashboard.dto;

import com.techforb.userdashboard.model.OptionMenuList;

import java.util.Set;
import java.util.stream.Collectors;

public class OptionMenuListDTO {

    private long id;


    private String category;


    private Set<OptionMenuDTO> options_menu;

    public OptionMenuListDTO(OptionMenuList optionMenuList) {
        this.id = optionMenuList.getId();
        this.category = optionMenuList.getCategory();
        this.options_menu = optionMenuList.getOptions_menu().stream().map(OptionMenuDTO::new).collect(Collectors.toSet());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<OptionMenuDTO> getOptions_menu() {
        return options_menu;
    }

    public void setOptions_menu(Set<OptionMenuDTO> options_menu) {
        this.options_menu = options_menu;
    }
}
