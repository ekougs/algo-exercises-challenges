package perso.challenges.codinggame;

import java.util.*;

public class KirksQuestLaDescente {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int tour = 0;
        boolean canShoot = true;

        while (true) {
            int x = in.nextInt();
            int y = in.nextInt();
            Mountain highestMountain  = getHighestMountain(in);
            if(highestMountain.x == x && canShoot) {
                System.out.println("FIRE");
                canShoot = false;

            }
            else {
                System.out.println("HOLD");
            }
            boolean newAltitude = ++tour % 8 == 0;
            if(newAltitude) {
                canShoot = true;
            }
        }
    }

    private static Mountain getHighestMountain(Scanner in) {
        Mountain highestMountain = null;
        for (int i = 0; i < 8; i++) {
            int currentHeight = in.nextInt();
            if(highestMountain == null || highestMountain.height < currentHeight) {
                highestMountain = new Mountain(i, currentHeight);
            }
        }
        return highestMountain;
    }

    private static class Mountain {
        private final int x;
        private final int height;

        private Mountain(int x, int height) {
            this.x = x;
            this.height = height;
        }
    }
}
