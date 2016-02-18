package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import physics.Circle;
import physics.LineSegment;
import physics.Vect;

/**
 * Created by baird on 06/02/2016.
 */
abstract public class Gizmo implements IElement {

    private Vect origin, size;
    private Gizmo trigger;
    private Color color;
    private Color[] colors;
    private List<LineSegment> lines;
    private List<Circle> circles;
    protected int rotation;
    private int reflection;
    private String name;

    protected Gizmo(Vect origin, Vect size, String name) {
        lines = new ArrayList<>();
        circles = new ArrayList<>();
        this.origin = origin;
        this.size = size;
        colors = new Color[]{Color.red, Color.green, Color.blue};
        rotation = 0;
        this.name = name;
        color = colors[0];
    }

    @Override
    public Vect getOrigin() {
        return origin;
    }

    @Override
    public Vect getBound() {
        return origin.plus(size);
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
}
