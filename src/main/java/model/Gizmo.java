package model;

import physics.Circle;
import physics.LineSegment;
import physics.Vect;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by baird on 06/02/2016.
 */
abstract public class Gizmo implements IElement{

    protected Vect origin, bound;
    private Gizmo trigger;
    private Color color;
    private Color[] colors;
    private List<LineSegment> lines;
    private List<Circle> circles;
    protected int rotation;
    private int reflection;
    private String name;

    protected Gizmo(Vect origin, String name) {
        lines = new ArrayList<>();
        circles = new ArrayList<>();
        this.origin = origin;
        colors = new Color[]{Color.red, Color.green, Color.blue};
        rotation = 0;
        this.name = name;
        color = colors[0];

        // TODO: set the bounds correctly according to which gizmo it is
        bound = new Vect(origin.x() + 1, origin.y() + 1);
        //bound = calculateBound();
    }

    @Override
    public Vect getOrigin() {
        return origin;
    }

    @Override
    public Vect getBound() {
        return bound;
    }

    public Gizmo getTrigger(){
        return trigger;
    }

    public void setTrigger(Gizmo trigger){
        this.trigger = trigger;
    }

    @Override
    public Color getColor(){
        return color;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public abstract void rotate();

    public int getReflectionCoefficient(){
        return reflection;
    }

    public abstract Vect calculateBound();

    @Override
    public List<LineSegment> getLines() {
        return lines;
    }

    @Override
    public List<Circle> getCircles() {
        return circles;
    }

    protected void setLines(List<LineSegment> lines) {
        this.lines = lines;
    }

    protected void setCircles(List<Circle> circles) {
        this.circles = circles;
    }

    protected void setBound(Vect bound) {
        this.bound = bound;
    }





}
