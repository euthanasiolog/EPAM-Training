package com.epam.training.task2.model.entity.composite;

//import statements
import java.util.ArrayList;
import java.util.List;

public class Composite implements Component{
    //list of components
    private List<Component> components = new ArrayList<>();

    //the empty constructor
    public Composite(){

    }

    public Composite(List<Component> components){
        this.components = components;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public void setComponents(Component component, int i ){
        components.set(i, component);
    }

    public void addComponent(Component component){
        components.add(component);
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
