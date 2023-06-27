package objects3D;

import GraphicsObjects.Utils;
import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_AMBIENT_AND_DIFFUSE;

public class Lamp {
    static float grey[] = {0.5f, 0.5f, 0.5f, 1.0f};
    static float pink[] = {1.0f, 0.6f, 0.6f, 1.0f, 1.0f};

    static float orange[] = {1.0f, 0.5f, 0.0f, 1.0f, 1.0f};
    public Lamp() {
    }

    public void drawLamp(){
        Cylinder cylinder = new Cylinder();
        Sphere sphere = new Sphere();

        FloatBuffer lightPos = BufferUtils.createFloatBuffer(4);
        lightPos.put(840f).put(200f).put(150f).put(1f).flip();
        glLight(GL_LIGHT0, GL_POSITION, lightPos);
        glEnable(GL_LIGHT0);
        glLight(GL_LIGHT0, GL_DIFFUSE, Utils.ConvertForGL(orange));
        glEnable(GL_LIGHTING);
        glEnable(GL_DEPTH_TEST);
        glEnable(GL_NORMALIZE);
        glEnable(GL_COLOR_MATERIAL);

        glColor3f(grey[0], grey[1], grey[2]);
        glMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(grey));
        glPushMatrix();
        {
            glTranslatef(840f, 0f, 200f);
            glScalef(100f, 100f, 100f);
            glRotatef(-90,1,0,0);
            cylinder.drawCylinder(0.05f, 2f, 32);
        }
        glPopMatrix();

        glPushMatrix();
        {
            glTranslatef(840f, 200f, 200f);
            glScalef(40f, 40f, 40f);
            sphere.drawSphere(0.5f, 32, 32);
        }
        glPopMatrix();
    }
}
