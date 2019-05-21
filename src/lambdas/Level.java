package lambdas;

public class Level {

    public OnChange onChange;
    public String greeting = "Hello";

    char[][] data;

    public Level(char[][] data) {
        this.data=data;
    }

    public void changeData(int row,int col,char c, Greeter greeter){

        data[row][col]=c;
        onChange.execute();
        greeter.greet(greeting);
    }

}
