package objects3D;

import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.io.IOException;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glPopMatrix;

public class House {
    static Texture texture_house;
    static Texture texture_roof;
    static Texture texture_window;
    static Texture texture_door;

    static Texture texture_water;
    static {
        try {
            texture_house = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/house.png"));
            texture_window = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("res/window.jpg"));
            texture_roof = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("res/roof.jpg"));
            texture_door = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("res/door.jpg"));
            texture_water = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/ice.png"));
            //Import material pictures
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public House() {

    }

    public void drawHouse() {
        //Wall
        glPushMatrix();
        {
            TexCube MyCube1 = new TexCube();
            glTranslatef(600, 160, 600);
            glScalef(275f, 175f, 320f);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP);
            Color.white.bind();
            texture_house.bind();
            glEnable(GL_TEXTURE_2D);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            MyCube1.drawTexCube(texture_house);
        }
        glPopMatrix();

        glPushMatrix();
        {
            TexCube MyCube1 = new TexCube();
            glTranslatef(200, 4, 600);
            glScalef(275f, 5f, 200f);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP);
            Color.white.bind();
            texture_house.bind();
            glEnable(GL_TEXTURE_2D);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            MyCube1.drawTexCube(texture_house);
        }
        glPopMatrix();

        glPushMatrix();
        {
            TexCube MyCube1 = new TexCube();
            glTranslatef(200, 4, 600);
            glScalef(275f, 15f, 200f);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP);
            Color.white.bind();
            texture_water.bind();
            glEnable(GL_TEXTURE_2D);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            MyCube1.drawTexCube(texture_water);
        }
        glPopMatrix();
        glPushMatrix();
        {
            TexCube MyCube1 = new TexCube();
            glTranslatef(200, 4, 800);
            glScalef(275f, 25f, 5f);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP);
            Color.white.bind();
            texture_house.bind();
            glEnable(GL_TEXTURE_2D);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            MyCube1.drawTexCube(texture_house);
        }
        glPopMatrix();
        glPushMatrix();
        {
            TexCube MyCube1 = new TexCube();
            glTranslatef(200, 4, 400);
            glScalef(275f, 25f, 5f);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP);
            Color.white.bind();
            texture_house.bind();
            glEnable(GL_TEXTURE_2D);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            MyCube1.drawTexCube(texture_house);
        }
        glPopMatrix();

        glPushMatrix();
        {
            TexCube MyCube1 = new TexCube();
            glTranslatef(700, 160, 650);
            glScalef(375f, 175f, 230f);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP);
            Color.white.bind();
            texture_house.bind();
            glEnable(GL_TEXTURE_2D);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            MyCube1.drawTexCube(texture_house);
        }
        glPopMatrix();
        //Roof
        glPushMatrix();
        {
            TexCube MyCube1 = new TexCube();
            glTranslatef(600, 335, 600);
            glScalef(195f, 175f, 320f);
            glRotatef(45,0.0f,0.0f,1.0f);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP);
            Color.white.bind();
            texture_house.bind();
            glEnable(GL_TEXTURE_2D);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            MyCube1.drawTexCube(texture_house);
        }
        glPopMatrix();

        glPushMatrix();
        {
            TexCube MyCube1 = new TexCube();
            glTranslatef(600, 335, 280);
            glRotatef(90,0.0f,1.0f,0.0f);
            glScalef(5f, 80f, 80f);

            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP);
            Color.white.bind();
            texture_window.bind();
            glEnable(GL_TEXTURE_2D);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            MyCube1.drawTexCube(texture_window);
        }
        glPopMatrix();
        glPushMatrix();
        {
            TexCube MyCube1 = new TexCube();
            glTranslatef(845, 335, 650);
            glScalef(230f, 175f, 160f);
            glRotatef(45,1.0f,0.0f,0.0f);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP);
            Color.white.bind();
            texture_house.bind();
            glEnable(GL_TEXTURE_2D);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            MyCube1.drawTexCube(texture_house);;
        }
        glPopMatrix();

        glPushMatrix();
        {
            TexCube MyCube1 = new TexCube();
            glTranslatef(437, 447, 600);
            glRotatef(48,0.0f,0.0f,-1.0f);
            glScalef(10f, 220f, 350f);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP);
            Color.white.bind();
            texture_roof.bind();
            glEnable(GL_TEXTURE_2D);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            MyCube1.drawTexCube(texture_roof);
        }
        glPopMatrix();

        glPushMatrix();
        {
            TexCube MyCube1 = new TexCube();
            glTranslatef(755, 440, 600);
            glRotatef(48,0.0f,0.0f,1.0f);
            glScalef(10f, 220f, 350f);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP);
            Color.white.bind();
            texture_roof.bind();
            glEnable(GL_TEXTURE_2D);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            MyCube1.drawTexCube(texture_roof);
        }
        glPopMatrix();

        glPushMatrix();
        {
            TexCube MyCube1 = new TexCube();
            glTranslatef(850, 445, 525);
            glRotatef(90,0.0f,2.0f,0.0f);
            glRotatef(43.5f,0.0f,0.0f,1.0f);
            glScalef(10f, 190f, 255f);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP);
            Color.white.bind();
            texture_roof.bind();
            glEnable(GL_TEXTURE_2D);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            MyCube1.drawTexCube(texture_roof);
        }
        glPopMatrix();
        glPushMatrix();

        {
            TexCube MyCube1 = new TexCube();
            glTranslatef(850, 446, 774);
            glRotatef(90,0.0f,2.0f,0.0f);
            glRotatef(-43.5f,0.0f,0.0f,1.0f);
            glScalef(10f, 190f, 255f);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP);
            Color.white.bind();
            texture_roof.bind();
            glEnable(GL_TEXTURE_2D);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            MyCube1.drawTexCube(texture_roof);
        }
        glPopMatrix();
        //Window
        glPushMatrix();
        {
            TexCube MyCube1 = new TexCube();
            glTranslatef(320, 180, 730);
            glScalef(5f, 80f, 80f);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP);
            Color.white.bind();
            texture_window.bind();
            glEnable(GL_TEXTURE_2D);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            MyCube1.drawTexCube(texture_window);
        }
        glPopMatrix();
        glPushMatrix();
        {
            TexCube MyCube1 = new TexCube();
            glTranslatef(320, 180, 490);
            glScalef(5f, 80f, 80f);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP);
            Color.white.bind();
            texture_window.bind();
            glEnable(GL_TEXTURE_2D);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            MyCube1.drawTexCube(texture_window);
        }
        glPopMatrix();
        //door
        glPushMatrix();
        glPopMatrix();
        {
            TexCube MyCube1 = new TexCube();
            glTranslatef(730, 90, 280);
            glScalef(60f, 100f, 5f);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP);
            Color.white.bind();
            texture_door.bind();
            glEnable(GL_TEXTURE_2D);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            MyCube1.drawTexCube(texture_door);
        }
        glPopMatrix();


    }
}
