package com.rsimona.model;

import com.rsimona.model.Categoria;
import com.rsimona.model.Persona;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-10-09T09:43:07")
@StaticMetamodel(Nota.class)
public class Nota_ { 

    public static volatile SingularAttribute<Nota, Date> fecha;
    public static volatile SingularAttribute<Nota, String> comentarioAdmin;
    public static volatile SingularAttribute<Nota, Integer> codigo;
    public static volatile SingularAttribute<Nota, Persona> persona;
    public static volatile SingularAttribute<Nota, Categoria> categoria;
    public static volatile SingularAttribute<Nota, String> encabezado;
    public static volatile SingularAttribute<Nota, Short> valorizacion;
    public static volatile SingularAttribute<Nota, String> cuerpo;

}