import java.io.Serializable;

public class Cube implements Serializable {
    private String color;
    private Double width;
    private Double height;
    private Double depth;

    public Cube(String color, Double width, Double height, Double depth) {
        this.color = color;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getDepth() {
        return depth;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }
}
