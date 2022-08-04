package com.cb.recursion;

/*
 * Assume towers:
 * A (sourceTower),
 * B (auxTower), C (desTower)
 * */
public class R14_TowerOfHanoi {

    public static void move(int noOfDisk, char sourceTower, char auxTower, char desTower) {

        // if single disk in A, move it to C
        if (noOfDisk == 1) {
            moveSingleDisk(1, sourceTower, desTower);
            return;
        }

        // Move n-1 disks from A to B, so that the remaining last disk in A can be moved to C
        move(noOfDisk - 1, sourceTower, desTower, auxTower);

        // Move remaining disk in A to C
        moveSingleDisk(noOfDisk, sourceTower, desTower);

        // Move n-1 disks (came from A in first step) from B to C
        move(noOfDisk - 1, auxTower, sourceTower, desTower);
    }

    // just printing
    private static void moveSingleDisk(int diskNumber, char source, char dest) {
        System.out.println("Move disk: " + diskNumber + " from: " + source + " to: " + dest + ".");
    }

    public static void main(String[] args) {
        move(3, 'A', 'B', 'C');
    }
}
