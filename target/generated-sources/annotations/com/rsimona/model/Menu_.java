package com.rsimona.model;

import com.rsimona.model.Menu;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-10-09T18:37:30")
@StaticMetamodel(Menu.class)
public class Menu_ { 

    public static volatile SingularAttribute<Menu, Integer> codigo;
    public static volatile SingularAttribute<Menu, String> tipo;
    public static volatile SingularAttribute<Menu, Boolean> estado;
    public static volatile SingularAttribute<Menu, Menu> submenu;
    public static volatile SingularAttribute<Menu, String> tipoUsuario;
    public static volatile SingularAttribute<Menu, String> nombre;
    public static volatile SingularAttribute<Menu, String> url;

}