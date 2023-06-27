package tools;


import org.lwjgl.util.glu.GLU;


public class Camera {
    float pos_x=0;
    float pos_y=0;
    float pos_z=0;

    float look_x=0;
    float look_y=0;
    float look_z=0;

    float dir_x=0;
    float dir_y=0;
    float dir_z=0;


    public Camera() {
        pos_x = 0;
        pos_y = -2f;
        pos_z = 10;

        look_x = 0;
        look_y = -1f;
        look_z = 0;

        dir_x = 0;
        dir_y = 1;
        dir_z = 0;


    }

    public void goRight(float a) {
        pos_x +=  a;
        look_x +=  a;
    }
    public void goLeft(float a) {
        pos_x -= a;
        look_x -= a;
    }
    public void goUp(float a) {
        pos_y += a;
        look_y += a;
    }
    public void goDown(float a) {
        pos_y -= a;
        look_y -= a;
    }


    public void setCamera() {
        GLU.gluLookAt(pos_x, pos_y, pos_z, look_x, look_y, look_z, dir_x,dir_y,dir_z);
    }

}