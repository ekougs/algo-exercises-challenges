package perso.challenges.crackthecode.stacks;

import perso.challenges.crackthecode.structure.LinkedListStack;
import perso.challenges.crackthecode.structure.Stack;

/**
 * User: sennen
 * Date: 16/05/2014
 * Time: 06:47
 */
public class HanoiTowerSolver {
    private final Stack<Integer>[] stacks = new Stack[3];

    private HanoiTowerSolver(int numberOfDisks) {
        for (int i = 0; i < stacks.length; i++) {
            stacks[i] = new LinkedListStack<>();
        }
        for (int i = numberOfDisks; i > 0; i--) {
            stacks[0].offer(i);
        }
    }

    public static Stack<Integer> solve(int numberOfDisks) {
        HanoiTowerSolver hanoiTowerSolver = new HanoiTowerSolver(numberOfDisks);
        return hanoiTowerSolver.solve();
    }

    private Stack<Integer> solve() {
        int stackToPlayWith = 0;
        while (!twoStacksAreEmpty()) {
            if (stacks[stackToPlayWith].isEmpty()) {
                stackToPlayWith = getNextStackToPlayWith(stackToPlayWith);
                continue;
            }
            int availableStack = getAvailableStack(stackToPlayWith);
            if (stackHasOpenMove(availableStack)) {
                stacks[availableStack].offer(stacks[stackToPlayWith].poll());
                stackToPlayWith = getNextStackToPlayWith(stackToPlayWith, availableStack);
            } else {
                stackToPlayWith = getNextStackToPlayWith(stackToPlayWith);
            }
        }
        return !stacks[1].isEmpty() ? stacks[1] : stacks[2];
    }

    private int getNextStackToPlayWith(int stackToPlayWith) {
        return getNextStackToPlayWith(stackToPlayWith, null);
    }

    private int getNextStackToPlayWith(int stackToPlayWith, Integer availableStack) {
        stackToPlayWith = ++stackToPlayWith % 3;
        if (availableStack == null) {
            return stackToPlayWith;
        }
        stackToPlayWith = stackToPlayWith != availableStack ? stackToPlayWith : ++stackToPlayWith % 3;
        return stackToPlayWith;
    }

    private boolean twoStacksAreEmpty() {
        return (stacks[0].isEmpty() && stacks[1].isEmpty()) || (stacks[0].isEmpty() && stacks[2].isEmpty());
    }

    private int getAvailableStack(int stackToPlayWith) {
        int disk = stacks[stackToPlayWith].peek();
        int firstStack = (stackToPlayWith + 1) % 3;
        int secondStack = (firstStack + 1) % 3;
        int firstStackDisk = getAvailableDisk(firstStack, disk);
        int secondStackDisk = getAvailableDisk(secondStack, disk);
        if (firstStackDisk == -1 && secondStackDisk == -1) {
            return -1;
        }
        if (firstStackDisk == -1) {
            return secondStack;
        }
        if (secondStackDisk == -1) {
            return firstStack;
        }
        if (firstStackDisk == 0 && secondStackDisk == 0) {
            return firstStack;
        }
        return firstStack;
    }

    private int getAvailableDisk(int stack, int disk) {
        if (stacks[stack].isEmpty()) {
            return 0;
        }
        int stackDisk = stacks[stack].peek();
        return stackDisk > disk ? stackDisk : -1;
    }

    private boolean stackHasOpenMove(int availableStack) {
        return availableStack >= 0;
    }
}
