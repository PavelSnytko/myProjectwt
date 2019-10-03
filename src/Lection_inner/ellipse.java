package Lection_inner;

import java.awt.*;

class ellipse extends Shape {
    private float firstRAdius;
    private float seconfRadius;
    public ellipse(float firstRAdius, float seconfRadius){
        super(x,y);

        this.firstRAdius =firstRAdius;
        this.seconfRadius = seconfRadius;}
        public  float getFirstRAdius(){
        return firstRAdius;
    }
        public float getSeconfRadius(){
        return  seconfRadius;

    }
@Override
public float getPerimeter() {
    return (float) (Math.PI * (this.firstRAdius + this.seconfRadius));
}

    @Override
    public float getArea() {
        return (float) (Math.PI * firstRAdius * seconfRadius);
    }

    @Override
    public String toString() {
        return String.format("эллипс с радиусами %.2f и %.2f", this.firstRAdius, this.seconfRadius);
    }
}
