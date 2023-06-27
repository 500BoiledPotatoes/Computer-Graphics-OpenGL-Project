package objects3D;

import GraphicsObjects.Utils;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glPopMatrix;

public class Dog {
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

    public Dog() {

    }
    public void drawDog(float delta, boolean GoodAnimation) {
        float theta = (float) (delta * 15 * Math.PI);
        //The speed at which a person moves
        float LimbRotation;
        if (GoodAnimation) {
            LimbRotation = (float) Math.cos(theta) * 60;
        } else {
            LimbRotation = 0;
        }

        Cube cube = new Cube();
        Cylinder cylinder = new Cylinder();
        TexSphere Mysphere = new TexSphere();
        Sphere sphere = new Sphere();
        Tetrahedron tetrahedron = new Tetrahedron();

        glPushMatrix();
        //Push current matrix
        {
            glColor3f(white[0], white[1], white[2]);
            glMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(white));
            glPushMatrix();
            {
                glTranslatef(0.0f, 0.5f, 0.0f);

                cube.drawScaleCube(2.3f,1,1);


                glColor3f(white[0], white[1], white[2]);
                glMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(white));
                glPushMatrix();
                {
                    glTranslatef(1.0f, 0.0f, 0f);
                    cube.drawScaleCube(1.0f, 1.2f, 1.2f);


                }
                glPopMatrix();

                glPushMatrix();
                {
                    glTranslatef(1.5f, -0.3f, 0f);
                    cube.drawScaleCube(1.5f, 0.4f, 0.4f);

                }
                glPopMatrix();
                glColor3f(black[0], black[1], black[2]);
                //Set neck color
                glMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
                glPushMatrix();
                {
                    glTranslatef(2.2f, 0.5f, 0.5f);
                    cube.drawScaleCube(0.2f, 0.2f, 0.2f);
                }
                glPopMatrix();
                glPushMatrix();
                {
                    glTranslatef(2.2f, 0.5f, -0.5f);
                    cube.drawScaleCube(0.2f, 0.2f, 0.2f);
                }
                glPopMatrix();
                glPushMatrix();
                {
                    glTranslatef(1.3f, 1.3f, 0.5f);
                    cube.drawScaleCube(0.1f, 0.4f, 0.3f);
                }
                glPopMatrix();
                glPushMatrix();
                {
                    glTranslatef(1.3f, 1.3f, -0.5f);
                    cube.drawScaleCube(0.1f, 0.4f, 0.3f);
                }
                glPopMatrix();
                glColor3f(white[0], white[1], white[2]);
                glMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(white));
                glPushMatrix();
                {
                    glTranslatef(1.3f, -1f, 0.7f);
                    glRotatef(90,0.0f,1.0f,0.0f);
                    glRotatef((-LimbRotation / 3), 1.0f, 0.0f, 0.0f);
                    cube.drawScaleCube(0.3f, 1.5f, 0.3f);
                }
                glPopMatrix();

                glPushMatrix();
                {
                    glTranslatef(-1.5f, -1f, 0.7f);
                    glRotatef(90,0.0f,1.0f,0.0f);
                    glRotatef((-LimbRotation / 3), -1.0f, 0.0f, 0.0f);
                    cube.drawScaleCube(0.3f, 1.5f, 0.3f);
                }
                glPopMatrix();

                glPushMatrix();
                {
                    glTranslatef(1.3f, -1f, -0.7f);
                    glRotatef(90,0.0f,1.0f,0.0f);
                    glRotatef((-LimbRotation / 3), -1.0f, 0.0f, 0.0f);
                    cube.drawScaleCube(0.3f, 1.5f, 0.3f);
                }
                glPopMatrix();
                glPushMatrix();
                {
                    glTranslatef(-1.5f, -1f, -0.7f);
                    glRotatef(90,0.0f,1.0f,0.0f);
                    glRotatef((-LimbRotation / 3), 1.0f, 0.0f, 0.0f);
                    cube.drawScaleCube(0.3f, 1.5f, 0.3f);
                }
                glPopMatrix();
//
                glPushMatrix();
                {
                    glTranslatef(-2.5f, -0.3f, 0f);
                    glRotatef(45,0,0,-1);
                    cube.drawScaleCube(0.3f, 1.5f, 0.3f);
                }
                glPopMatrix();
//
//                glPushMatrix();
//                {
//                    glTranslatef(-1.5f, 0f, -4.3f);
//                    cylinder.drawCylinder(0.3f, 0.3f, 32);
//                }
//                glPopMatrix();
//
//                glPushMatrix();
//                {
//                    glTranslatef(0.0f, 1.0f, -2.0f);
//                    cube.drawScaleCube(2f,1,1f);
//                }
//                glPopMatrix();
            }
            glPopMatrix();
        }
        glPopMatrix();
    }



}
