package org.example;

public class Model implements  Cloneable{
    private String name;

    private int age;

    public Model(){
        System.out.println("will new a instance");
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "CloneModel{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Model cloneModel = new Model();
        System.out.println(cloneModel.clone());
    }
}
