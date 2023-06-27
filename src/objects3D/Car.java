package objects3D;

import GraphicsObjects.Utils;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.io.IOException;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glPopMatrix;

public class Car {
    static float black[] = {0.0f, 0.0f, 0.0f, 1.0f};
    static float white[] = {1.0f, 1.0f, 1.0f, 1.0f};

    static float grey[] = {0.5f, 0.5f, 0.5f, 1.0f};
    static float spot[] = {0.1f, 0.1f, 0.1f, 0.5f};

    // primary colours
    static float red[] = {1.0f, 0.0f, 0.0f, 1.0f};
    static float green[] = {0.0f, 1.0f, 0.0f, 1.0f};
    static float blue[] = {0.0f, 0.0f, 1.0f, 1.0f};

    // secondary colours
    static float yellow[] = {1.0f, 1.0f, 0.0f, 1.0f};
    static float magenta[] = {1.0f, 0.0f, 1.0f, 1.0f};
    static float cyan[] = {0.0f, 1.0f, 1.0f, 1.0f};

    // other colours
    static float orange[] = {1.0f, 0.5f, 0.0f, 1.0f, 1.0f};
    static float brown[] = {0.5f, 0.25f, 0.0f, 1.0f, 1.0f};
    static float dkgreen[] = {0.0f, 0.5f, 0.0f, 1.0f, 1.0f};
    static float pink[] = {1.0f, 0.6f, 0.6f, 1.0f, 1.0f};
    static Texture texture;

    static {
        try {
            texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/ice.png"));
            //Import material pictures
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Car() {

    }

    public void drawCar() {


        Cube cube = new Cube();
        TexCube texCube = new TexCube();
        Cylinder cylinder = new Cylinder();
        TexSphere Mysphere = new TexSphere();
        Sphere sphere = new Sphere();
        Tetrahedron tetrahedron = new Tetrahedron();

        glPushMatrix();
        //Push current matrix
        {
            glColor3f(red[0], red[1], red[2]);
            glMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(red));
            glPushMatrix();
            {
                glTranslatef(0.0f, 0.5f, 0.0f);

                cube.drawScaleCube(2,1,4);

                glColor3f(white[0], white[1], white[2]);
                //Set neck color
                glMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(white));

                //Specify the material parameters of the lighting model
                glPushMatrix();
                {
                    glTranslatef(0.0f, 1.0f, -3.0f);
                    glRotatef(45,1.0f,0.0f,0.0f);
                    cube.drawScaleCube(2f, 0.7f, 0.7f);
                }
                glPopMatrix();

                //Specify the material parameters of the lighting model
                glPushMatrix();
                {
                    glTranslatef(0.0f, 1.0f, -2.0f);
                    cube.drawScaleCube(2f,1,1f);
                }
                glPopMatrix();

                glColor3f(brown[0], brown[1], brown[2]);
                //Set neck color
                glMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(brown));
                glPushMatrix();
                {
                    glTranslatef(0.0f, 2.2f, 1.7f);
                    cube.drawScaleCube(2f, 1.2f, 2f);
                }
                glPopMatrix();

                glColor3f(black[0], black[1], black[2]);
                glMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));

                glPushMatrix();
                {
                    glTranslatef(2f, -1f, 2.5f);
                    glRotatef(90,0.0f,1.0f,0.0f);
                    cylinder.drawCylinder(1f, 0.5f, 32);
                }
                glPopMatrix();
                glPushMatrix();
                {
                    glTranslatef(-2.5f, -1f, 2.5f);
                    glRotatef(90,0.0f,1.0f,0.0f);
                    cylinder.drawCylinder(1f, 0.5f, 32);
                }
                glPopMatrix();

                glPushMatrix();
                {
                    glTranslatef(2f, -1f, -2.5f);
                    glRotatef(90,0.0f,1.0f,0.0f);
                    cylinder.drawCylinder(1f, 0.5f, 32);
                }
                glPopMatrix();
                glPushMatrix();
                {
                    glTranslatef(-2.5f, -1f, -2.5f);
                    glRotatef(90,0.0f,1.0f,0.0f);
                    cylinder.drawCylinder(1f, 0.5f, 32);
                }
                glPopMatrix();
                glColor3f(yellow[0], yellow[1], yellow[2]);
                //Set neck color
                glMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(yellow));
                glPushMatrix();
                {
                    glTranslatef(1.5f, 0f, -4.3f);
                    cylinder.drawCylinder(0.3f, 0.3f, 32);
                }
                glPopMatrix();

                glPushMatrix();
                {
                    glTranslatef(-1.5f, 0f, -4.3f);
                    cylinder.drawCylinder(0.3f, 0.3f, 32);
                }
                glPopMatrix();


            }
            glPopMatrix();
        }
        glPopMatrix();
    }




}
