
import Module1.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> x = new ArrayList<Integer>();

        for(int i = 0; i < 10; i++){
            x.addToFront(i);
        }

        ArrayList<Integer> y = new ArrayList<>();
        y.addToFront(0);
        y.removeFromBack();
        y.addToBack(0);
        y.addToBack(1);
        y.removeFromFront();
        y.removeFromFront();

        for(int i = 0; i < 10; i++){
            y.addToFront(i);
            y.addToBack(i);
        }

        for(int i = 0; i < 10; i++){
            y.removeFromFront();
            y.removeFromBack();
        }

        ArrayList<Integer> z = new ArrayList<>();

        for(int i = 0;i<9;i++){
            z.addToBack(i);
        }

        for(int i = 0; i<9; i++){
            z.removeFromFront();
        }
    }
}


