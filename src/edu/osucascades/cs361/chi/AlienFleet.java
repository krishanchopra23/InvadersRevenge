package edu.osucascades.cs361.chi;
import processing.core.PApplet;
import java.util.ArrayList;

public class AlienFleet {
    private Sketch canvas;
    private int x;
    private int y;
    private static final int ALIEN_FLEET_ROWS = 1;    //Real game uses 5
    private static final int ALIEN_FLEET_COLUMNS = 6;  //Real game uses 11
    public Alien[][] aliens;

    AlienFleet(int x, int y, Sketch canvas) {
        this.x = x;
        this.y = y;
        this.canvas = canvas;

        buildAlienFleet();
    }

    private void buildAlienFleet() {
        aliens = new Alien[ALIEN_FLEET_ROWS][ALIEN_FLEET_COLUMNS];
        for (int r = 0; r < ALIEN_FLEET_ROWS; r++) {
            for (int c = 0; c < ALIEN_FLEET_COLUMNS; c++) {
                aliens[r][c] = new Alien(c * 50, y, canvas);
            }
        }
    }
}