package objects3D;

import GraphicsObjects.Utils;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_AMBIENT_AND_DIFFUSE;

public class Tree {

    static float green[] = {0.0f, 1.0f, 0.0f, 1.0f};
    static float brown[] = {0.5f, 0.25f, 0.0f, 1.0f, 1.0f};

    public Tree() {
    }

    public void drawTree() {
        Cone cone = new Cone();
        Cylinder cylinder = new Cylinder();

        glColor3f(green[0], green[1], green[2]);
        glMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(green));
        glPushMatrix();
        {
            glTranslatef(470f, 60f, 200f);
            glScalef(200f, 200f, 200f);
			glRotatef(90,-1.0f,0,0);
            cone.drawCone(0.4f, 0.7f, 32);
        }
        glPopMatrix();

        glPushMatrix();
        {
            glTranslatef(470f, 110f, 200f);
            glScalef(200f, 200f, 200f);
            glRotatef(90,-1.0f,0,0);
            cone.drawCone(0.3f, 0.7f, 32);
        }
        glPopMatrix();
        glColor3f(brown[0], brown[1], brown[2]);
        //Set neck color
        glMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(brown));
        glPushMatrix();
        {
            glTranslatef(470f, 0f, 200f);
            glScalef(150f, 150f, 150f);
            glRotatef(-90,1,0,0);
            cylinder.drawCylinder(0.1f, 0.7f, 32);
        }
        glPopMatrix();
    }
}
