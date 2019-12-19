
public class Animals extends Object {
    private double Run, Jump, Swim;


    String name;


    public static void Animals(String[] args) {

        double Run;
        double Jump;
        double Swim;
    }

    public void Abilities(double Run, double Jump, double Swim) {
        this.Run = Run;
        this.Jump = Jump;
        this.Swim = Swim;
    }

    public interface Object {

        boolean run(double value);

        boolean jump(double value);

        boolean swim(double value);
    }


    public Animals(String name) {

        this.name = name;
    }
    Animals (double Run, double Jump, double Swim) {
    }


    public boolean run(double value) {
        return Run > value;
    }

    public boolean jump(double value) {
        return Jump > value;
    }

    public boolean swim(double value) {
        return Swim > value;
    }
}




