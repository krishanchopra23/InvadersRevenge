package edu.osucascades.cs361.chi;
import processing.core.PApplet;

import java.util.ArrayList;

public class Sketch extends PApplet {

    Screen screen;
    Game game;
    public ArrayList<Explosive> explosives = new ArrayList<>();
    public ArrayList<Fort> forts = new ArrayList<>();
    public ArrayList<VehicleSuper> vehicles = new ArrayList<>();

    private int playerMovementDirection = 0;
    private Tank player;

    public void settings() {
        fullScreen();
    }

    public void setup() {
        smooth();
        this.player = new Tank(0,600, this);
        for (int i=0; i<6 ; i++){
            Alien alien = new Alien(i * 50, 200, this);
        }

        this.game = new Game(this);
        this.screen = new Screen(0,4,this);
    }

    public void draw() {
        screen.draw();
        this.player.updateDirection(playerMovementDirection);
        game.drawEntities();
        game.checkForCollisions(explosives, vehicles);
    }

    public void keyReleased() {
        if (key == 'a' || key == 'd' ) {
            this.playerMovementDirection = 0;
        }
        if (key == ' ' && !this.player.isReloading()) {
            this.player.shoot(this);
        }
    }
    public void keyPressed() {
        if (key == 'a') {
            this.playerMovementDirection = -1;
        }

        if (key == 'd') {
            this.playerMovementDirection = 1;
        }
    }
}
