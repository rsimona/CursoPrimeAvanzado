/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsimona.controller;

import com.rsimona.ejb.CategoriaFacadeLocal;
import com.rsimona.model.Categoria;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Ramon
 */
@Named
@ViewScoped
public class CategoriaController implements Serializable{
    
    @EJB
    private CategoriaFacadeLocal categoriaEJB;
    
    @Inject
    private Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    @PostConstruct
    public void init(){

    }
    
    public void registrar(){
        try {
            categoriaEJB.create(categoria);
        } catch (Exception e) {
            // mensaje Growl
        }
    }
    
    
}
