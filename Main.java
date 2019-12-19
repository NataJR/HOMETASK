

import java.util.InputMismatchException;
import java.util.Scanner;

    public class Main {

        public static void main(String[] args) throws InputMismatchException {

            AnimalCat cat;
            AnimalDog dog;
            double distance;
            try (Scanner scanner = new Scanner(System.in)) {

                double Run = Math.random() * 200;
                double Jump = Math.random() * 2;
                double Swim = Math.random() * 0;
                cat = new AnimalCat(Run, Jump, Swim);

                Run = Math.random() * 500;
                Jump = Math.random() * 0.5;
                Swim = Math.random() * 10;
                dog = new AnimalDog(Run, Jump, Swim);

                System.out.println("Distance:");
                distance = scanner.nextDouble();


                System.out.println("Cat can run " + cat.getRun() + "m");
                System.out.println("Dog can run " + dog.getRun() + " m ");

                System.out.println("Cat is runing(" + distance + "). Result: " + cat.run(distance));
                System.out.println("Dog is runing(" + distance + "). Result: " + dog.run(distance));

                System.out.println("Obstacle height:");
                distance = scanner.nextDouble();

                System.out.println("Cat can jump " + cat.getJump() + " m ");
                System.out.println("Dog can  jump " + dog.getJump() + " m ");

                System.out.println("Cat is jumping(" + distance + "). Result " + cat.jump(distance));
                System.out.println("Dog is jumping(" + distance + "). Result" + dog.jump(distance));


                System.out.println("Swimming distance:");
                distance = scanner.nextDouble();
            }

            System.out.println("Cat can't swim " + cat.getSwim());
            System.out.println("Dog can swim " + dog.getSwim() + " m ");

            System.out.println("Dog is swimig (" + distance + "). Result: " + dog.swim(distance));

        }


    }



