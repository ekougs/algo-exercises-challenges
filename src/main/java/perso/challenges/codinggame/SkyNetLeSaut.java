package perso.challenges.codinggame;

import java.util.*;

public class SkyNetLeSaut {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int bridgeLength = in.nextInt();
        int gapLength = in.nextInt();
        int platformLength = in.nextInt();
        int positionAfterBridge = bridgeLength + 1;
        int targetSpeed = gapLength + 1;

        while (true) {
            int speed = in.nextInt();
            int position = in.nextInt();
            if(position >= bridgeLength) {
                System.out.println("SLOW");
            }
            else if(speed + position >= positionAfterBridge){
                System.out.println("JUMP");
            }
            else if(speed < targetSpeed) {
                System.out.println("SPEED");
            }
            else if(speed > targetSpeed) {
                System.out.println("SLOW");
            }
            else {
                System.out.println("WAIT");
            }
        }
    }
}
