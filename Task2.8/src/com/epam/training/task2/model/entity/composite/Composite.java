package com.epam.training.task2.model.entity.composite;

//import statements
import java.util.ArrayList;
import java.util.List;

public class Composite implements Component{
    //list of components
    private List<Component> components = new ArrayList<>();

    //the empty constructor
    public Composite(){}

    //constructor with args
    public Composite(List<Component> components) {
        this.components = components;
    }

    //getters and setters
    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public void setComponents(Component component, int i ){
        components.set(i, component);
    }

    //work with components
    @Override
    public void addComponent(Component component){
        components.add(component);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){ return true;}
        if (o == null){ return false;}
        if (getClass() != o.getClass()){ return false;}

        Composite composite = (Composite) o;
        if (null == components){ return components == composite.components;}
        else {
            if (!components.equals(composite.components)){ return false;}
        }
        return true;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        return prime * ((null == components) ? 0 : components.hashCode());
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Component component: components){
            stringBuilder.append(component);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
