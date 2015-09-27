package com.project.managedBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.project.managedBeans.settings.theme.Theme;

@ManagedBean(name = "theme")
public class ThemeSwitcherView {
 
    private List<Theme> themes;
     
    @ManagedProperty("#{themeService}")
    private ThemeServiceBean service;
 
    @PostConstruct
    public void init() {
        themes = service.getThemes();
    }
     
    public List<Theme> getThemes() {
        return themes;
    } 
 
    public void setService(ThemeServiceBean service) {
        this.service = service;
    }
}
