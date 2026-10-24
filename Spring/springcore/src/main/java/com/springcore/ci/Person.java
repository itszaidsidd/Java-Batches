package com.springcore.ci;

import java.util.List;

public class Person {
    private String personName;
    private int personId;
    private Certi certi;
    private List<String> list;
    
    Person(String personName, int personId, Certi certi, List<String> list){
        this.personName=personName;
        this.personId=personId;
        this.certi=certi;
        this.list=list;
    }

    @Override
    public String toString() {
        return this.personName+" : "+this.personId+" : { "+certi+" } : [ "+list+" ]";
    }

    

}
