package com.company;

public class Main{
    public static void main(String []args){
        TableLamp whiteLamp = new TableLamp();
        System.out.println(whiteLamp.getColour());
        Lamp lamp = new Lamp("1");
        System.out.println(lamp.getId());
        lamp.setId("2");
        System.out.println(lamp.getId());

        System.out.println(lamp.getIsLightTurnedOn());
        lamp.turnOnOff();
        System.out.println(lamp.getIsLightTurnedOn());
    }
}
interface LightSource{
    void turnOnOff();
}
class Lamp implements LightSource{
    private boolean isLightTurnedOn;
    protected String id;
    public Lamp(){
        id = "";
        isLightTurnedOn = false;
    }
    public Lamp(String id){
        this.id = id;
        isLightTurnedOn = false;
    }
    public boolean getIsLightTurnedOn(){
        return isLightTurnedOn;
    }
    public void setIsLightTurnedOn(boolean isLightTurnedOn){
        this.isLightTurnedOn = isLightTurnedOn;
    }
    public String getId(){
        return this.id;
    }
    public void setId(String id){
        this.id = id;
    }
    public void turnOnOff(){
        if(isLightTurnedOn == true)
            isLightTurnedOn = false;
        else
            isLightTurnedOn = true;
    }
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null) return false;
        if(this.getClass() != obj.getClass())
            return false;
        Lamp other = (Lamp)obj;
        if(other.id == this.id)
            return true;
        return false;
    }
    public int hashCode(){
        int prime = 31;
        int r = 0;
        for(int i = 0; i < id.length(); ++i){
            r = r * prime + id.charAt(i);
            prime = prime * 31;
        }
        return r;
    }
}
class TableLamp extends Lamp{
    private String colour;
    public TableLamp(){
        colour = "white";
    }
    public TableLamp(String id){
        super(id);
    }
    public TableLamp(String id, String colour){
        super(id);
        this.colour = colour;
    }
    public String getColour(){
        return colour;
    }
    public void setColour(String colour){
        this.colour = colour;
    }
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null) return false;
        if(this.getClass() != obj.getClass())
            return false;
        TableLamp other = (TableLamp)obj;
        if(other.id == this.id && other.colour == this.colour)
            return true;
        return false;
    }
    public int hashCode(){
        int prime = 31;
        int r = 0;
        for(int i = 0; i < id.length(); ++i){
            r = r * prime + id.charAt(i);
            prime = prime * 31;
        }
        prime += colour.charAt(0) * prime;
        return r;
    }
}
