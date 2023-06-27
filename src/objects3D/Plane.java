package objects3D;

import org.lwjgl.util.vector.Vector3f;
import tools.Model;
import tools.OBJLoader;

import java.io.File;
import java.io.IOException;

import static org.lwjgl.opengl.GL11.*;

public class Plane {

    private static final String MODEL_LOCATION = "res/models/plane.obj";
    static Model m = null;
    static {
        try {
            m = OBJLoader.loadModel(new File(MODEL_LOCATION));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Plane() {
    }

    public void drawPlane() {
        glBegin(GL_TRIANGLES);
        for (Model.Face face : m.getFaces()) {
            Vector3f n1 = m.getNormals().get(face.getNormalIndices()[0] - 1);
            glNormal3f(n1.x, n1.y, n1.z);
            Vector3f v1 = m.getVertices().get(face.getVertexIndices()[0] - 1);
            glVertex3f(v1.x, v1.y, v1.z);
            Vector3f n2 = m.getNormals().get(face.getNormalIndices()[1] - 1);
            glNormal3f(n2.x, n2.y, n2.z);
            Vector3f v2 = m.getVertices().get(face.getVertexIndices()[1] - 1);
            glVertex3f(v2.x, v2.y, v2.z);
            Vector3f n3 = m.getNormals().get(face.getNormalIndices()[2] - 1);
            glNormal3f(n3.x, n3.y, n3.z);
            Vector3f v3 = m.getVertices().get(face.getVertexIndices()[2] - 1);
            glVertex3f(v3.x, v3.y, v3.z);
        }
        glEnd();
    }
}
