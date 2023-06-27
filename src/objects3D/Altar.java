package objects3D;

import GraphicsObjects.Utils;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.io.IOException;

import static org.lwjgl.opengl.GL11.*;

public class Altar {
    static float cyan[] = {0.0f, 1.0f, 1.0f, 1.0f};
    static float white[] = {1.0f, 1.0f, 1.0f, 1.0f};
    static Texture texture_altar;
    static Texture texture_sphere;
    static {
        try {
            texture_altar = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/Altar.png"));
            texture_sphere = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/valley2022.PNG"));
            //Import material pictures
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Altar() {
    }

    public void drawAltar(float delta) {
        float theta = (float) (delta * 2 * Math.PI);
        float thetaDeg = delta * 360;
        float sphere_y = (float) Math.sin(theta);
        TexCube MyCube1 = new TexCube();
        Cylinder cylinder = new Cylinder();
        Cone cone = new Cone();
        TexSphere sphere = new TexSphere();
        //Base
        glPushMatrix();
        {
            glTranslatef(1600, 30, -200);
            glScalef(250f, 25f, 250f);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP);
            Color.white.bind();
            texture_altar.bind();
            glEnable(GL_TEXTURE_2D);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            MyCube1.drawTexCube(texture_altar);
        }
        glPopMatrix();
        glPushMatrix();
        {
            glTranslatef(1500, 30, -200);
            glScalef(80f, 80f, 80f);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP);
            Color.white.bind();
            texture_altar.bind();
            glEnable(GL_TEXTURE_2D);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            MyCube1.drawTexCube(texture_altar);
        }
        glPopMatrix();
        glPushMatrix();
        {
            glTranslatef(1400, 0, -200);
            glScalef(74f, 74f, 74f);
            glRotatef(45,0,0,1);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP);
            Color.white.bind();
            texture_altar.bind();
            glEnable(GL_TEXTURE_2D);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            MyCube1.drawTexCube(texture_altar);
        }
        glPopMatrix();
//        glPushMatrix();
//        {
//            glTranslatef(1420, 55, -200);
//            glScalef(30f, 30f, 30f);
//            glRotatef(45,0,0,1);
//            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP);
//            Color.white.bind();
//            texture_altar.bind();
//            glEnable(GL_TEXTURE_2D);
//            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
//            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
//            MyCube1.drawTexCube(texture_altar);
//        }
//        glPopMatrix();
        glPushMatrix();
        {
            glTranslatef(1600, 78f, -200);
            glScalef(200f, 25f, 200f);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP);
            Color.white.bind();
            texture_altar.bind();
            glEnable(GL_TEXTURE_2D);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            MyCube1.drawTexCube(texture_altar);

        }
        glPopMatrix();
        glPushMatrix();
        {
            glTranslatef(1600, 120f, -200);
            glScalef(50f, 50f, 50f);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP);
            Color.white.bind();
            texture_altar.bind();
            glEnable(GL_TEXTURE_2D);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            MyCube1.drawTexCube(texture_altar);
        }
        glPopMatrix();

        glColor3f(cyan[0], cyan[1],cyan[2]);
        glMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(cyan));
        glPushMatrix();
        {
            glTranslatef(1555, 160f, -160);
            glScalef(150f, 150f, 150f);
            glRotatef(-90,1,0,0);
            cylinder.drawCylinder(0.03f, 0.7f, 32);
        }
        glPopMatrix();
        glColor3f(cyan[0], cyan[1],cyan[2]);
        glMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(cyan));
        glPushMatrix();
        {
            glTranslatef(1645, 160f, -160);
            glScalef(150f, 150f, 150f);
            glRotatef(-90,1,0,0);
            cylinder.drawCylinder(0.03f, 0.7f, 32);
        }
        glPopMatrix();
        glColor3f(cyan[0], cyan[1],cyan[2]);
        glMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(cyan));
        glPushMatrix();
        {
            glTranslatef(1555, 160f, -245);
            glScalef(150f, 150f, 150f);
            glRotatef(-90,1,0,0);
            cylinder.drawCylinder(0.03f, 0.7f, 32);
        }
        glPopMatrix();
        glColor3f(cyan[0], cyan[1],cyan[2]);
        glMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(cyan));
        glPushMatrix();
        {
            glTranslatef(1645, 160f, -245);
            glScalef(150f, 150f, 150f);
            glRotatef(-90,1,0,0);
            cylinder.drawCylinder(0.03f, 0.7f, 32);
        }
        glPopMatrix();
        glColor3f(white[0], white[1],white[2]);
        glMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(white));
        glPushMatrix();
        {
            glTranslatef(1600, 260f, -200);
            glScalef(130f, 130f, 130f);
            glRotatef(-90,1,0,0);
            cone.drawCone(0.6f, 0.3f, 32);
        }
        glPopMatrix();
        glPushMatrix();
        {
            glTranslatef(1600, 213, -200);
            glScalef(45f, 45f, 45f);
            glTranslatef(0, sphere_y * 0.5f, 0);
            glRotatef(thetaDeg, 0.0f, 1.0f, 0.0f);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP);
            Color.white.bind();
            texture_sphere.bind();
            glEnable(GL_TEXTURE_2D);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            sphere.DrawTexSphere(0.5f, 32, 32,texture_sphere);
        }
        glPopMatrix();
    }
}
