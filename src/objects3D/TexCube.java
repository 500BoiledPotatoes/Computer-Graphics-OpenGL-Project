package objects3D;

import static org.lwjgl.opengl.GL11.*;
import org.newdawn.slick.opengl.Texture;

import GraphicsObjects.Point4f;
import GraphicsObjects.Vector4f;

public class TexCube {

	public TexCube() {


	}

	// Implement using notes and looking at TexSphere
	public void drawTexCube(Texture texture) {
		Point4f vertices[] = { new Point4f(-1.0f, -1.0f, -1.0f, 0.0f), new Point4f(-1.0f, -1.0f, 1.0f, 0.0f),
				new Point4f(-1.0f, 1.0f, -1.0f, 0.0f), new Point4f(-1.0f, 1.0f, 1.0f, 0.0f),
				new Point4f(1.0f, -1.0f, -1.0f, 0.0f), new Point4f(1.0f, -1.0f, 1.0f, 0.0f),
				new Point4f(1.0f, 1.0f, -1.0f, 0.0f), new Point4f(1.0f, 1.0f, 1.0f, 0.0f) };

		int faces[][] = { { 0, 4, 5, 1 }, { 0, 2, 6, 4 }, { 0, 1, 3, 2 }, { 4, 6, 7, 5 }, { 1, 5, 7, 3 },
				{ 2, 3, 7, 6 } };

		glBegin(GL_QUADS);

		for (int face = 0; face < 6; face++) { // per face
			Vector4f v = vertices[faces[face][1]].MinusPoint(vertices[faces[face][0]]);
			Vector4f w = vertices[faces[face][3]].MinusPoint(vertices[faces[face][0]]);
			Vector4f normal = v.cross(w).Normal();

			glNormal3f(normal.x, normal.y, normal.z);
			//In order to map the texture to the quadrangle correctly, the top right corner of the texture must be mapped to the top right corner of the quadrangle,
			//the top left corner of the texture must be mapped to the top left corner of the quadrangle, the bottom right corner of the texture must be mapped to the bottom left corner of the quadrangle,
			//and the bottom left corner of the texture must be mapped to the bottom left corner of the quadrangle
			glVertex3f(vertices[faces[face][0]].x, vertices[faces[face][0]].y, vertices[faces[face][0]].z);
			glTexCoord2f(0.0F, 0.0F);
			glVertex3f(vertices[faces[face][1]].x, vertices[faces[face][1]].y, vertices[faces[face][1]].z);
			glTexCoord2f( 1.0F, 0.0F);
			glVertex3f(vertices[faces[face][2]].x, vertices[faces[face][2]].y, vertices[faces[face][2]].z);
			glTexCoord2f( 1.0F, 1.0F );
			glVertex3f(vertices[faces[face][3]].x, vertices[faces[face][3]].y, vertices[faces[face][3]].z);
			glTexCoord2f( 0.0F, 1.0F );
		} // per face
		glEnd();
	}
	public void drawScaleTexCube(float x, float y,float z,Texture texture) {

		Point4f vertices[] = { new Point4f(-x, -y, -z, 0.0f), new Point4f(-x, -y, z, 0.0f),
				new Point4f(-x, y, -z, 0.0f), new Point4f(-x, y, z, 0.0f),
				new Point4f(x, -y, -z, 0.0f), new Point4f(x, -y, z, 0.0f),
				new Point4f(x, y, -z, 0.0f), new Point4f(x, y, z, 0.0f) };

		int faces[][] = { { 0, 4, 5, 1 }, { 0, 2, 6, 4 }, { 0, 1, 3, 2 }, { 4, 6, 7, 5 }, { 1, 5, 7, 3 },
				{ 2, 3, 7, 6 } };

		glBegin(GL_QUADS);

		for (int face = 0; face < 6; face++) { // per face
			//Because a cube is made up of six faces, each face is made up of two triangles, so there are twelve faces in total
			Vector4f v = vertices[faces[face][1]].MinusPoint(vertices[faces[face][0]]);
			Vector4f w = vertices[faces[face][3]].MinusPoint(vertices[faces[face][0]]);
			//Find two vectors
			Vector4f normal = v.cross(w).Normal();
			//Find the normal vector to these two vectors
			glNormal3f(normal.x, normal.y, normal.z);

			glVertex3f(vertices[faces[face][0]].x, vertices[faces[face][0]].y, vertices[faces[face][0]].z);

			glVertex3f(vertices[faces[face][1]].x, vertices[faces[face][1]].y, vertices[faces[face][1]].z);

			glVertex3f(vertices[faces[face][2]].x, vertices[faces[face][2]].y, vertices[faces[face][2]].z);

			glVertex3f(vertices[faces[face][3]].x, vertices[faces[face][3]].y, vertices[faces[face][3]].z);
			//Drawing a cube
		} // per face

		glEnd();

	}
}
