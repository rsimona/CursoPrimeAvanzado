/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsimona.controller;

import com.rsimona.ejb.MenuFacadeLocal;
import com.rsimona.model.Menu;
import com.rsimona.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author Ramon
 */
@Named
@SessionScoped
public class MenuController implements Serializable {

    @EJB
    private MenuFacadeLocal EJBMenu;

    private List<Menu> lista;
    private MenuModel model;

    @PostConstruct
    public void init() {
        this.listarMenus();
        model = new DefaultMenuModel();
        this.establecerPermisos();
    }
    
        public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    public void listarMenus() {
        try {
            lista = EJBMenu.findAll();
        } catch (Exception e) {
            // mensaje jsf
        }

    }

    public void establecerPermisos() {
        Usuario us = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        
        for (Menu m : lista) {
            if (m.getTipo().equals("S") && m.getTipoUsuario().equals(us.getTipo())) {
                DefaultSubMenu firstSubMenu = new DefaultSubMenu(m.getNombre());
                for (Menu i : lista) {
                    Menu submenu = i.getSubmenu();
                    if (submenu != null) {
                        if (submenu.getCodigo() == m.getCodigo()) {
                            DefaultMenuItem item = new DefaultMenuItem(i.getNombre());
                            item.setUrl(i.getUrl());
                            firstSubMenu.addElement(item);
                        }
                    }
                }
                model.addElement(firstSubMenu);
            } else if (m.getSubmenu() == null && m.getTipoUsuario().equals(us.getTipo())) {
                DefaultMenuItem item = new DefaultMenuItem(m.getNombre());
                item.setUrl(m.getUrl());
                model.addElement(item);
            }
        }
    }

    public void cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

}
