/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsimona.controller;

import com.rsimona.ejb.UsuarioFacadeLocal;
import com.rsimona.model.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;

import javax.inject.Named;
import org.primefaces.component.selectonemenu.SelectOneMenu;

/**
 *
 * @author Ramon
 */
@Named("indexController")
@ViewScoped
public class IndexController implements Serializable {

    @EJB
    private UsuarioFacadeLocal EJBUsuario;

    private Usuario usuario;
    private String idSeleccio;
    private SelectOneMenu oneMenu;

    @PostConstruct
    public void init() {
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getIdSeleccio() {
        return idSeleccio;
    }

    public void setIdSeleccio(String idSeleccio) {
        this.idSeleccio = idSeleccio;
    }

    public SelectOneMenu getOneMenu() {
        return oneMenu;
    }

    public void setOneMenu(SelectOneMenu oneMenu) {
        this.oneMenu = oneMenu;
    }

    public void pintar(final AjaxBehaviorEvent event) {
        System.out.println(((SelectOneMenu) event.getComponent()).getValue());
    }

    public void pintar2(final AjaxBehaviorEvent event) {
        System.out.println("primer" + ((SelectOneMenu) event.getComponent()).getValue());
    }

    public String iniciarSesion() {
        Usuario us;
        String redireccion = null;

        System.out.println("sessio: " + idSeleccio);

        try {
            us = EJBUsuario.iniciarSesion(usuario);
            if (us != null) {
                // Almacenar en la sesión de JSF
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
                redireccion = "/protegido/principal?faces-redirect=true";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "El usuario o contraseña no son correctos"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Error al iniciar la sesión"));
        }
        return redireccion;
    }

}
