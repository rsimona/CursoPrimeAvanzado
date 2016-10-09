/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsimona.controller;

import com.rsimona.ejb.NotaFacadeLocal;
import com.rsimona.model.Nota;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Ramon
 */
@Named
@RequestScoped
public class ComentarController implements Serializable {

    @EJB
    private NotaFacadeLocal notaEJB;

    private List<Nota> notas;
    private Nota nota;

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    @PostConstruct
    private void init() {
        notas = notaEJB.findAll();
    }

    public void asignar(Nota nota) {
        this.nota = nota;
    }

}
