/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persona;

public class Person {
    private String id;

    public Person(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public boolean isMatch(String id) {
        return this.id.equals(id);
    }

    public Object getPersonId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPersonId'");
    }
}
