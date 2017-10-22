package org.simpleemployees;

import org.simpleemployees.database.Database;
import org.simpleemployees.object.Employees;

/**
 * Copyright (c) 2017-2018 all right reserved !
 * This was created by Extends for CorePlugin
 *
 * @author Extends on 22/10/2017
 * @version 1.0.0
 */

public class SimpleEmployees {

    private Employees employees;
    private static Database database;

    public static void main(String[] args){
        database = new Database();
        database.host = "localhost";
        database.port = 3306;
        database.user = "root";
        database.password = "";
        database.database = "employees";

        database.openConnection();
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public int getSalaire(){
        return getEmployees().getSalaire();
    }

    public void setSalaire(int salaire){
        getEmployees().setSalaire(salaire);
    }

    public void removeSalaire(int salaire){
        getEmployees().removeSalaire(salaire);
    }

    public void kick(){
        getEmployees().kick();
    }

    public void recrut(){
        getEmployees().recrut();
    }

}
