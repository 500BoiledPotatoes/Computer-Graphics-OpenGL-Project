package objects3D;

import org.lwjgl.opengl.GL11;

public class Cone {

    public Cone() {
    }

    // remember to use Math.PI isntead PI
    // Implement using notes and examine Tetrahedron to aid in the coding  look at lecture  7 , 7b and 8
    public void drawCone(float radius, float height, int nSegments )
    {
        GL11.glBegin(GL11.GL_TRIANGLES);
        for (float i = 0.0F; i < nSegments; i += 1.0) { /* a loop around circumference of a tube */
            float angle = (float) (Math.PI * i * 2.0 / nSegments);
            float nextAngle = (float) (Math.PI * (i + 1.0) * 2.0 / nSegments);
            /* compute sin & cosine */
            float x1 = (float) Math.sin(angle), y1 = (float) Math.cos(angle);
            float x2 = (float) Math.sin(nextAngle), y2 = (float) Math.cos(nextAngle);
            /* draw bottom (red) triangle */
            //Find the three points of the triangle
            GL11.glNormal3f(radius * x1, radius * y1, 0.0f);
            GL11.glVertex3f(radius * x1, radius * y1, 0.0f);
            GL11.glNormal3f(radius * x2, radius * y2, 0.0f);
            GL11.glVertex3f(radius * x2, radius * y2, 0.0f);
            GL11.glNormal3f(radius * x2, radius * y2, 0.0f);
            GL11.glVertex3f(0 * x2, 0 * y2, height);
            //Draw the top surface of the cone
            //By moving the points below the triangle to the center of the top circle
            GL11.glNormal3f(radius * x1, radius * y1, 0.0f);
            GL11.glVertex3f(radius * x1, radius * y1, 0.0f);
            GL11.glNormal3f(radius * x2, radius * y2, 0.0f);
            GL11.glVertex3f(radius * x2, radius * y2, 0.0f);
            GL11.glNormal3f(radius * x1, radius * y1, 0.0f);
            GL11.glVertex3f(0.0f, 0.0f, 0.0f);

        }
        GL11.glEnd();
    }
}
