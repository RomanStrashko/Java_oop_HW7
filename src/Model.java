public class Model implements summation, subtraction, division, multiplication {
    private int x, y;


    public Model(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int sum() {
        return this.x + this.y;
    }

    @Override
    public int sub() {
        return this.x - this.y;
    }


    @Override
    public int div() {
        return this.x / this.y;
    }

    @Override
    public int mult() {
        return this.x * this.y;
    }
}
