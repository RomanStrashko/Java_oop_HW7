public class Presenter {


    int x, y;
    Model calculator;

    View view = new View();

    public Presenter() {
    }

    public Presenter(int x, int y) {
        this.calculator = new Model(x, y);
    }



    public int summa(){
        return this.calculator.sum();
    }

    public int subt(){
        return this.calculator.sub();
    }

    public int multi(){
        return this.calculator.mult();
    }

    public int divis(){
        return this.calculator.div();
    }

    public void printing(String title){
        view.print(title);
    }
}
