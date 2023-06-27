
import java.io.IOException;
import java.nio.FloatBuffer;

import objects3D.*;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import GraphicsObjects.Arcball;
import GraphicsObjects.Utils;
import tools.Camera;

//Main windows class controls and creates the 3D virtual world , please do not change this class but edit the other classes to complete the assignment.
// Main window is built upon the standard Helloworld LWJGL class which I have heavily modified to use as your standard openGL environment.
//

// Do not touch this class, I will be making a version of it for your 3rd Assignment
public class MainWindow {

	private boolean MouseOnepressed = true;
	private boolean dragMode = false;
	private boolean BadAnimation = true;
	private boolean Earth = false;
	/** position of pointer */
	/** angle of rotation */
	float rotation = 0;
	/** time at last frame */
	long lastFrame;
	/** frames per second */
	int fps;
	/** last fps time */
	long lastFPS;

	long myDelta = 0; // to use for animation
	float Alpha = 0; // to use for animation
	long StartTime; // beginAnimiation

	Arcball MyArcball = new Arcball();

	boolean DRAWGRID = false;
	boolean waitForKeyrelease = true;
	/** Mouse movement */
	int LastMouseX = -1;
	int LastMouseY = -1;
	int human_x = 2101;
	int human_y = 200;
	int human_z = -700;

	float dog_posX = 810f;
	float dog_posY = 50f;
	float dog_posZ = 130f;
	int ball_x = 440;
	int ball_y = 20;
	int ball_z = -500;

	int fly_mode = 0;

	int ball_mode = 0;
	Camera camera = new Camera();

	float human_posX = 810f;
	float human_posY = 50f;
	float human_posZ = 130f;
	float car_x = 1190;
	float car_y = 60;
	float car_z = 600;



	boolean move = false;
	boolean dog_move = false;
	boolean isDog = false;
	boolean isCar = false;
	boolean isSwim = false;
	boolean isJump = false;

	boolean isWorship = false;
	float direction = 0;
	int dog_direction = 0;
	float world_rotate = 0.1f;
	int OrthoNumber = 1200; // using this for screen size, making a window of 1200 x 800 so aspect ratio 3:2
	// // do not change this for assignment 3 but you can change everything for your
	// project

	// basic colours
	static float black[] = { 0.0f, 0.0f, 0.0f, 1.0f };
	static float white[] = { 1.0f, 1.0f, 1.0f, 1.0f };

	static float grey[] = { 0.5f, 0.5f, 0.5f, 1.0f };
	static float spot[] = { 0.1f, 0.1f, 0.1f, 0.5f };

	// primary colours
	static float red[] = { 1.0f, 0.0f, 0.0f, 1.0f };
	static float green[] = { 0.0f, 1.0f, 0.0f, 1.0f };
	static float blue[] = { 0.0f, 0.0f, 1.0f, 1.0f };

	// secondary colours
	static float yellow[] = { 1.0f, 1.0f, 0.0f, 1.0f };
	static float magenta[] = { 1.0f, 0.0f, 1.0f, 1.0f };
	static float cyan[] = { 0.0f, 1.0f, 1.0f, 1.0f };

	// other colours
	static float orange[] = { 1.0f, 0.5f, 0.0f, 1.0f, 1.0f };
	static float brown[] = { 0.5f, 0.25f, 0.0f, 1.0f, 1.0f };
	static float dkgreen[] = { 0.0f, 0.5f, 0.0f, 1.0f, 1.0f };
	static float pink[] = { 1.0f, 0.6f, 0.6f, 1.0f, 1.0f };

	// static GLfloat light_position[] = {0.0, 100.0, 100.0, 0.0};

	// support method to aid in converting a java float array into a Floatbuffer
	// which is faster for the opengl layer to process

	/****
	 * jitan yousahng 1815 50 90
	 *       zuoshang 1360 50 90
	 *       zuoxia   1365 50 -510
	 *       youxia   1865 50 -510
	 *       梯子xia   1320 50 -260
	 *       tizishang 1385 50 -150
	 *       jitanzuosahng 1440 50 -160
	 *       jitanyoushahg 1515 50 -150
	 *       jitanzuoxia 1440 50 -260
	 *       jitianyoushang 1515 50 -260
	 *
	 * fangzi youshang 1140 50 950
	 *        zuoshang 285 50 960
	 *        zuoxia 285 50 220
	 *        youxia 1075 50 230
	 *
	 * ludeng 900 50 250
	 *         775 50 250
	 *        775 50 170
	 *        900 50 170
	 * shu    595 50 250
	 *        370 50 150
	 *        370 50 110
	 *        595 50 110
	 * youshahg 2195 1440
	 *          -425 -1240
	 *
	 *  swimming -60 790
	 *  			290 830
	 *  		290 370
	 *  	-60 370
	 *
	 *  1335 780
	 *  1125 420
	 *
	 *  530 -450
	 *  -30 -590
	 */
	float[][] house = {{285, 1085}, {230, 950}};
	float[][] lamp = {{775, 900}, {170, 250}};
	float[][] tree = {{370, 595}, {110, 150}};
	float[][] alter = {{1325, 1875}, {-480, 70}};
	float[][] stair = {{1280, 1385}, {-260, -150}};
	float[][] car = {{car_x - 65, car_x +145}, {car_z-180, car_z+180}};
//	float car_x = 1190;
//	float car_y = 60;
//	float car_z = 600;
	float[][] pool = {{-60, 290}, {370, 830}};
	float[][] platform = {{1385, 1515}, {-260, -150}};

	float[][] group = {{-30, 530}, {-450, -590}};
	public void start() {

		StartTime = getTime();
		try {
			Display.setDisplayMode(new DisplayMode(1200, 800));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}

		initGL(); // init OpenGL
		getDelta(); // call once before loop to initialise lastFrame
		lastFPS = getTime(); // call before loop to initialise fps timer

		while (!Display.isCloseRequested()) {
			int delta = getDelta();
			update(delta);
			renderGL();
			Display.update();
			Display.sync(120); // cap fps to 120fps
		}

		Display.destroy();
	}

	public void update(int delta) {
		// rotate quad
		// rotation += 0.01f * delta;
		int MouseX = Mouse.getX();
		int MouseY = Mouse.getY();
		int WheelPostion = Mouse.getDWheel();

		boolean MouseButonPressed = Mouse.isButtonDown(0);

		if (MouseButonPressed && !MouseOnepressed) {
			MouseOnepressed = true;
			// System.out.println("Mouse drag mode");
			MyArcball.startBall(MouseX, MouseY, 1200, 800);
			dragMode = true;

		} else if (!MouseButonPressed) {
			// System.out.println("Mouse drag mode end ");
			MouseOnepressed = false;
			dragMode = false;
		}

		if (dragMode) {
			MyArcball.updateBall(MouseX, MouseY, 1200, 800);
		}

		if (WheelPostion > 0) {
			OrthoNumber += 30;
		}

		if (WheelPostion < 0) {
			OrthoNumber -= 30;
			if (OrthoNumber < 610) {
				OrthoNumber = 610;
			}
			// System.out.println("Orth nubmer = " + OrthoNumber);
		}

		/** rest key is R */
		if (Keyboard.isKeyDown(Keyboard.KEY_R))
			MyArcball.reset();


//		if (Keyboard.isKeyDown(Keyboard.KEY_Q))
//			rotation += 0.35f * delta;
//		if (Keyboard.isKeyDown(Keyboard.KEY_E)) {
//			Earth = !Earth;
//		}
		boolean isLeft, isRight, isDown, isUp = false;
		float speed_x = 5;
		float speed_z = 10;
		if (isCar) {

			isLeft = checkLeftHitBox(house, speed_x) && checkLeftHitBox(alter, speed_x) && checkLeftHitBox(tree, speed_x) &&
					checkLeftHitBox(lamp, speed_x)&&
					checkLeftHitBox(stair, speed_x)&&
					checkLeftHitBox(pool, speed_x)&&
					checkLeftHitBox(group, speed_x);

			isRight = checkRightHitBox(house, speed_x) && checkRightHitBox(alter, speed_x) && checkRightHitBox(tree, speed_x) &&
					checkRightHitBox(lamp, speed_x)&&checkRightHitBox(stair, speed_x)&&
					checkRightHitBox(pool, speed_x)&&
					checkRightHitBox(group, speed_x);

			isDown = checkDownHitBox(house,speed_z) && checkDownHitBox(alter,speed_z) && checkDownHitBox(tree, speed_z) &&
					checkDownHitBox(lamp, speed_z)&&
					checkDownHitBox(pool, speed_z)&&
					checkDownHitBox(stair, speed_z)&&
					checkDownHitBox(group, speed_z);

			isUp = checkUpHitBox(house, speed_z) && checkUpHitBox(alter, speed_z) && checkUpHitBox(tree, speed_z) &&
					checkUpHitBox(lamp, speed_z)&&
					checkUpHitBox(stair, speed_z)&&
					checkUpHitBox(pool, speed_z)&&
					checkUpHitBox(group, speed_z);

		}
		else {

			isLeft = checkLeftHitBox(house, speed_x) && checkLeftHitBox(alter, speed_x) && checkLeftHitBox(tree, speed_x) &&
					checkLeftHitBox(lamp, speed_x)&&
					checkLeftHitBox(stair, speed_x)&&
					checkLeftHitBox(pool, speed_x)&&
					checkLeftHitBox(group, speed_x)&&
					checkLeftHitBox(car, speed_x);

			isRight = checkRightHitBox(house, speed_x) && checkRightHitBox(alter, speed_x) && checkRightHitBox(tree, speed_x) &&
					checkRightHitBox(lamp, speed_x)&&checkRightHitBox(stair, speed_x)&&
					checkRightHitBox(pool, speed_x)&&
					checkRightHitBox(group, speed_x)&&
					checkLeftHitBox(car, speed_x);

			isDown = checkDownHitBox(house,speed_z) && checkDownHitBox(alter, speed_z) && checkDownHitBox(tree, speed_z) &&
					checkDownHitBox(lamp, speed_z)&&
					checkDownHitBox(stair,speed_z)&&
					checkDownHitBox(pool, speed_z)&&
					checkDownHitBox(car, speed_z)&&
					checkDownHitBox(group, speed_z);

			isUp = checkUpHitBox(house, speed_z) && checkUpHitBox(alter,  speed_z) && checkUpHitBox(tree, speed_z) &&
					checkUpHitBox(lamp, speed_z)&&
					checkUpHitBox(stair, speed_z)&&
					checkUpHitBox(pool,  speed_z)&&
					checkUpHitBox(car, speed_z)&&
					checkUpHitBox(group,  speed_z);

		}
		//Press Q or W to rotate the world
		if (Keyboard.isKeyDown(Keyboard.KEY_Q))
			world_rotate = world_rotate - 1f;

		if (Keyboard.isKeyDown(Keyboard.KEY_E)) {
			world_rotate = world_rotate + 1f;
		}
		//Press left or A to move the camera to the left
		if (Keyboard.isKeyDown(Keyboard.KEY_LEFT))
			camera.goLeft(10.0f);
		//Press right or D to move the camera to the right
		if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
			camera.goRight(10.0f);
		}
		//Press up or W to move the camera  up
		if (Keyboard.isKeyDown(Keyboard.KEY_UP))
			camera.goUp(10.0f);
		//Press down or S to move the camera down
		if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
			camera.goDown(10.0f);
		}

		move = false;
		dog_move = false;
		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			direction = 2;
			move = true;

			if (human_posX % 5 != 0) {
				human_posX = human_posX - human_posX % 5;
			}
			if (human_posZ % 5 != 0) {
				human_posZ = human_posZ - human_posZ % 5;
			}
			if (human_posX > -425){
//				System.out.println(isLeft);
//				System.out.println(isRight);
				if (isLeft){

					isSwim = false;
					if (!isCar){
						human_posY = 50;
					}
					human_posX = human_posX - speed_x;
					if (isDog){
						dog_posX = dog_posX - speed_x;
						dog_direction = 2;
						dog_move = true;
					}
				}else if (human_posX > stair[0][0] && human_posX <= stair[0][1] && human_posZ > stair[1][0] && human_posZ < stair[1][1]) {
					human_posY = human_posY - 5f;
					human_posX = human_posX - speed_x;
				}
				else if (human_posX >= platform[0][0] && human_posX <= platform[0][1] &&  human_posZ > platform[1][0] && human_posZ < platform[1][1]){
					human_posX = human_posX - speed_x;
				}else if (human_posX > pool[0][0] && human_posX < pool[0][1] &&  human_posZ > pool[1][0] && human_posZ < pool[1][1]){
					isSwim = true;
					human_posY = 15;
					human_posX = human_posX - speed_x;
					camera.goLeft(speed_x);
				}
			}




		} else if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			direction = 3;
			move = true;
			if (human_posX % 5 != 0) {
				human_posX = human_posX - human_posX % 5;
			}
			if (human_posZ % 5 != 0) {
				human_posZ = human_posZ - human_posZ % 5;
			}
			if (human_posX < 2195){
//				System.out.println(isRight);
				if (isRight){
					isSwim = false;
					if (!isCar){
						human_posY = 50;
					}
					human_posX = human_posX + speed_x;
					if (isDog){
						dog_posX = dog_posX + speed_x;
						dog_direction = 3;
						dog_move = true;
					}
				}else if (human_posX <= stair[0][1] && human_posZ > stair[1][0] && human_posZ < stair[1][1]) {
					human_posY = human_posY + 5f;
					human_posX = human_posX + speed_x;
				}
				else if (human_posX >= platform[0][0] && human_posX < platform[0][1] &&human_posZ > platform[1][0] && human_posZ < platform[1][1]){
					human_posX = human_posX + speed_x;
					camera.goRight(speed_x);
				}else if (human_posX > pool[0][0] && human_posX < pool[0][1] &&  human_posZ > pool[1][0] && human_posZ < pool[1][1]){
					isSwim = true;
					human_posY = 15;
					human_posX = human_posX + speed_x;
				}
			}
		} else if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			direction = 0;
			move = true;
			if (human_posX % 5 != 0) {
				human_posX = human_posX - human_posX % 5;
			}
			if (human_posZ % 5 != 0) {
				human_posZ = human_posZ - human_posZ % 5;
			}

				if (human_posZ > -1240){
					if (isDown){
						isSwim = false;
						if (!isCar){
							human_posY = 50;
						}
						human_posZ = human_posZ - speed_z;
						if (isDog){
							dog_posZ = dog_posZ - speed_z;
							dog_direction = 0;
							dog_move = true;
						}
					}else if (human_posX >= platform[0][0] && human_posX < platform[0][1] &&human_posZ > platform[1][0] && human_posZ < platform[1][1]){
						human_posZ = human_posZ - speed_z;
					}else if (human_posX > pool[0][0]+50 && human_posX < pool[0][1]-50 &&  human_posZ > pool[1][0]+50 && human_posZ < pool[1][1]-50){
						isSwim = true;
						human_posY = 15;
						human_posZ = human_posZ - speed_z;
					}
				}





		} else if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			direction = 1;
			move = true;
			if (human_posX % 5 != 0) {
				human_posX = human_posX - human_posX % 5;
			}
			if (human_posZ % 5 != 0) {
				human_posZ = human_posZ - human_posZ % 5;
			}
			if (human_posZ < 1440){
				if (isUp){
					isSwim = false;
					if (!isCar){
						human_posY = 50;
					}
					human_posZ = human_posZ + speed_z;
					if (isDog){
						dog_posZ = dog_posZ + speed_z;
						dog_direction = 1;
						dog_move = true;
					}
				}else if (human_posX >= platform[0][0] && human_posX < platform[0][1] &&human_posZ > platform[1][0] && human_posZ < platform[1][1]){
					human_posZ = human_posZ + speed_z;
				}else if (human_posX > pool[0][0]+50 && human_posX < pool[0][1]-50 &&  human_posZ > pool[1][0]+50 && human_posZ < pool[1][1]-50){
					isSwim = true;
					human_posY = 15;
					human_posZ = human_posZ + speed_z;
				}

			}
		}else if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			if (human_posY == 50) {
				isJump = true;
				camera.goUp(25);
				human_posY = human_posY + 50;
			}
		} else if (!Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {

			if (human_posY != 50 && isJump) {
				camera.goDown(25);
				human_posY = human_posY - 50;
				isJump = false;
			}
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_F) && human_posX >= platform[0][0] && human_posX <= platform[0][1] &&  human_posZ > platform[1][0] && human_posZ < platform[1][1] && direction == 3){
			 isWorship = !isWorship;
			 if (isWorship == true){
				 human_posY = 135;
			 }else{
				 human_posY = 155;
			 }
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_Z)) {
			if (human_posZ >= car_z - 100 && human_posZ < car_z + 100) {
				isCar = true;
				human_posY = car_y + 50;
				human_posZ = car_z;
				human_posX = car_x;

			}
		} else if (Keyboard.isKeyDown(Keyboard.KEY_X)) {
			isCar = false;
			human_posX = car_x + 200;
			human_posY = 50;
			human_posZ = car_z;

		}
		if (Keyboard.isKeyDown(Keyboard.KEY_C)) {
			isDog = !isDog;
		}

//		if (Keyboard.isKeyDown(Keyboard.KEY_R)){
//			System.out.println(human_posX >= platform[0][0]);
//			System.out.println(human_posX <= platform[0][1]);
//			System.out.println(human_posZ > platform[1][0]);
//			System.out.println(human_posZ < platform[1][1]);
//			System.out.println(direction == 3);
//		}


		if (waitForKeyrelease) // check done to see if key is released
		{
			if (Keyboard.isKeyDown(Keyboard.KEY_G)) {

				DRAWGRID = !DRAWGRID;
				Keyboard.next();
				if (Keyboard.isKeyDown(Keyboard.KEY_G)) {
					waitForKeyrelease = true;
				} else {
					waitForKeyrelease = false;

				}
			}
		}


		/** to check if key is released */
		if (Keyboard.isKeyDown(Keyboard.KEY_G) == false) {
			waitForKeyrelease = true;
		} else {
			waitForKeyrelease = false;

		}

		updateFPS(); // update FPS Counter

		LastMouseX = MouseX;
		LastMouseY = MouseY;


	}

	/**
	 * Calculate how many milliseconds have passed since last frame.
	 *
	 * @return milliseconds passed since last frame
	 */
	public int getDelta() {
		long time = getTime();
		int delta = (int) (time - lastFrame);
		lastFrame = time;

		return delta;
	}

	/**
	 * Get the accurate system time
	 *
	 * @return The system time in milliseconds
	 */
	public long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}

	/**
	 * Calculate the FPS and set it in the title bar
	 */
	public void updateFPS() {
		if (getTime() - lastFPS > 1000) {
			Display.setTitle("FPS: " + fps);
			fps = 0;
			lastFPS += 1000;
		}
		fps++;
	}

	public void initGL() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		changeOrth();
		MyArcball.startBall(0, 0, 1200, 800);
		glMatrixMode(GL_MODELVIEW);
		FloatBuffer lightPos = BufferUtils.createFloatBuffer(4);
		lightPos.put(10000f).put(1000f).put(1000).put(0).flip();

		FloatBuffer lightPos2 = BufferUtils.createFloatBuffer(4);
		lightPos2.put(0f).put(1000f).put(0).put(-1000f).flip();

		FloatBuffer lightPos3 = BufferUtils.createFloatBuffer(4);
		lightPos3.put(-500f).put(500f).put(1300).put(0).flip();

		FloatBuffer lightPos4 = BufferUtils.createFloatBuffer(4);
		lightPos4.put(1000f).put(1000f).put(1000f).put(0).flip();

//		glLight(GL_LIGHT0, GL_POSITION, lightPos); // specify the
//		// position
//		// of the
//		// light
//		 glEnable(GL_LIGHT0); // switch light #0 on // I've setup specific materials
//		// so in real light it will look abit strange
//		glLight(GL_LIGHT2, GL_DIFFUSE, Utils.ConvertForGL(grey));

//		glLight(GL_LIGHT1, GL_POSITION, lightPos2); // specify the
//		// position
//		// of the
//		// light
//		glEnable(GL_LIGHT1); // switch light #0 on
//		glLight(GL_LIGHT1, GL_DIFFUSE, Utils.ConvertForGL(grey));

		//Light from left to right
		glLight(GL_LIGHT2, GL_POSITION, lightPos3); // specify
		// the
		// position
		// of the
		// light
		glEnable(GL_LIGHT2); // switch light #0 on
		glLight(GL_LIGHT2, GL_DIFFUSE, Utils.ConvertForGL(grey));

//		glLight(GL_LIGHT3, GL_POSITION, lightPos4); // specify
//		// the
//		// position
//		// of the
//		// light
//		glEnable(GL_LIGHT3); // switch light #0 on
//		glLight(GL_LIGHT3, GL_DIFFUSE, Utils.ConvertForGL(grey));

		glEnable(GL_LIGHTING); // switch lighting on
		glEnable(GL_DEPTH_TEST); // make sure depth buffer is switched
		// on
		glEnable(GL_NORMALIZE); // normalize normal vectors for safety
		glEnable(GL_COLOR_MATERIAL);

		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		try {
			init();
			//Initializing Materials
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // load in texture

	}

	public void changeOrth() {

		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(1200 - OrthoNumber, OrthoNumber, (800 - (OrthoNumber * 0.66f)), (OrthoNumber * 0.66f), 100000, -100000);
		camera.setCamera();
		glMatrixMode(GL_MODELVIEW);

		FloatBuffer CurrentMatrix = BufferUtils.createFloatBuffer(16);
		glGetFloat(GL_MODELVIEW_MATRIX, CurrentMatrix);

		// if(MouseOnepressed)
		// {

		MyArcball.getMatrix(CurrentMatrix);
		// }

		glLoadMatrix(CurrentMatrix);

	}

	/*
	 * You can edit this method to add in your own objects / remember to load in
	 * textures in the INIT method as they take time to load
	 *
	 */
	public void renderGL() {


		changeOrth();

		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
		glColor3f(0.5f, 0.5f, 1.0f);

		myDelta = getTime() - StartTime;
		float delta = ((float) myDelta) / 10000;
		// code to aid in animation
		float theta = (float) (delta * 2 * Math.PI);
		float thetaDeg = delta * 360;
		float posn_x = (float) Math.cos(theta); // same as your circle code in your notes
		float posn_y = (float) Math.sin(theta);




		//Initialize all objects
		Human MyHuman = new Human();
		FlyingHuman flyingHuman = new FlyingHuman();
		FootballMan1 footballMan1 = new FootballMan1();
		FootballMan2 footballMan2 = new FootballMan2();
		TexSphere texSphere = new TexSphere();
		TexCube MyCube = new TexCube();
		House house = new House();
		Bunny bunny = new Bunny();
		Plane plane = new Plane();
		Tree tree = new Tree();
		Altar altar = new Altar();
		Lamp lamp = new Lamp();
		Sphere sphere = new Sphere();
		Car car = new Car();
		Dog dog = new Dog();
		glRotatef(world_rotate, 0.0f, -1.0f, 0.0f);

		/*
		 * This code draws a grid to help you view the human models movement You may
		 * change this code to move the grid around and change its starting angle as you
		 * please
		 */
		if (DRAWGRID) {
			glPushMatrix();
			Grid MyGrid = new Grid();
			glTranslatef(600, 400, 0);
			glScalef(200f, 200f, 200f);
			MyGrid.DrawGrid();
			glPopMatrix();
		}

		glPushMatrix() ;{
			glColor3f(white[0], white[1], white[2]);
			glMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(white));
			glTranslatef(700, 270, 550);
			glScalef(100f, 100f, 100f);
			glTranslatef(-posn_x * 6f, 0.0f, -posn_y * 6f);
			glRotatef(-thetaDeg,0,1,0);
			glRotatef(-thetaDeg * 3.0f,0,0,1);
			plane.drawPlane();
		}
		glPopMatrix();

		glPushMatrix() ;{
			glColor3f(black[0], black[1], black[2]);
			glMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
			glTranslatef(700, 5, 550);
			glScalef(100f, 1f, 130f);
			glTranslatef(-posn_x * 6f, 0.0f, -posn_y * 6f);
			glRotatef(-thetaDeg,0,1,0);
			glRotatef(-thetaDeg * 3.0f,0,0,1);
			sphere.drawSphere(0.5f, 32, 32);
		}
		glPopMatrix();


		glPushMatrix();{
			glTranslatef(human_posX, human_posY, human_posZ);
			glScalef(40f, 40f, 40f);

			if (direction == 0) {
				glRotatef(0, 0, 1.0f, 0);
			}
			if (direction == 1) {
				glRotatef(180, 0, 1.0f, 0);
			}
			if (direction == 2) {
				glRotatef(90f, 0, 1.0f, 0);
			}
			if (direction == 3) {
				glRotatef(-90, 0, 1.0f, 0);
			}


				if (move && !isCar) {
					if (isSwim) {
						glRotatef(-90,1,0,0);
						MyHuman.drawSwimmingHuman(delta);
					} else {
						MyHuman.drawHuman(delta, true);
						System.out.println(human_posX + ")---(" + human_posY + ")---(" + human_posZ);
					}
				} else {
					if (isWorship){
						MyHuman.drawWorshipHuman(delta);
					}else{
						MyHuman.drawHuman(delta, false);
					}
				}
		}
		glPopMatrix();
		glPushMatrix();{
			glColor3f(black[0], black[1], black[2]);
			glMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
			glTranslatef(human_posX, human_posY-45, human_posZ);
			glScalef(40f, 1f, 40f);


			if (move && !isCar) {
				if (isSwim) {
				} else {
					sphere.drawSphere(1.0f, 32, 32);
				}
			} else {
				if (isWorship){
					sphere.drawSphere(1.0f, 32, 32);
				}else{
					sphere.drawSphere(1.0f, 32, 32);
				}
			}
		}
		glPopMatrix();

//		glPushMatrix();{
//			glColor3f(black[0], black[1], black[2]);
//			glMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
//			glTranslatef(1800, 5, 700);
//			glScalef(40f, 1f, 40f);
//			glTranslatef(-posn_x * 3.0f, 0.0f, -posn_y * 3.0f);
//			glRotatef(-thetaDeg,0,1,0);
//			//Let the person rotate the direction with the turn
//			sphere.drawSphere(1.0f, 32, 32);// give a delta for the Human object ot be animated
//		}
//		glPopMatrix();

		glPushMatrix();{
			tree.drawTree();
		}
		glPopMatrix();


		glPushMatrix();{
			lamp.drawLamp();
		}
		glPopMatrix();

		glPushMatrix();{
			glTranslatef(50, 50, -500);
			glScalef(40f, 40f, 40f);
			glRotatef(90,0,-1,0);
			//Let the person rotate the direction with the turn
			footballMan1.drawFootballMan(delta); // give a delta for the Human object ot be animated
		}
		glPopMatrix();
		glPushMatrix() ;{
			glColor3f(black[0], black[1], black[2]);
			glMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
			glTranslatef(80, 2, -560);
			glRotatef(155,0,1,0);
			glScalef(80f, 0f, 130f);
			sphere.drawSphere(0.5f, 32, 32);
		}
		glPopMatrix();

		glPushMatrix();{
			glTranslatef(ball_x, ball_y, ball_z);
			glScalef(45f, 45f, 45f);
			glRotatef(thetaDeg * 5,1,1,1);
			if (ball_x  <= 60 ){

				ball_mode = 0;
			}
			else if (ball_x  >= 440){
				ball_mode = 1;
			}
			if (ball_mode == 0){
				ball_x = (int) (ball_x + 30);
			}
			else if (ball_mode == 1){
				ball_x = (int) (ball_x - 30);
			}
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP);
			Color.white.bind();
			texture_ball.bind();
			glEnable(GL_TEXTURE_2D);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
			glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
			texSphere.DrawTexSphere(0.5f, 32, 32,texture_ball);

		}
		glPopMatrix();



		glPushMatrix();{
			glTranslatef(450, 50, -500);
			glScalef(40f, 40f, 40f);
			glRotatef(90,0,1,0);
			//Let the person rotate the direction with the turn
			footballMan2.drawFootballMan(delta); // give a delta for the Human object ot be animated
		}
		glPopMatrix();
		glPushMatrix() ;{
			glColor3f(black[0], black[1], black[2]);
			glMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
			glTranslatef(480, 2, -560);
			glRotatef(155,0,1,0);
			glScalef(80f, 0f, 130f);
			sphere.drawSphere(0.5f, 32, 32);
		}
		glPopMatrix();

		glPushMatrix();{
			glTranslatef(human_x, human_y, human_z);
			glScalef(40f, 40f, 40f);

			//Let the person rotate the direction with the turn
			if (human_z <= 1300 && human_x >= 2100){
				fly_mode = 1;
				glRotatef(180,0,1,1);
			}
			else if (human_x >= -500 && human_z >= 1300){
				fly_mode = 2;
				glRotatef(90,0,0,1);
				glRotatef(90,0,1,0);
			}
			else if (human_z >= -700 && human_x <= -500){
				fly_mode = 3;
				glRotatef(90,-1,0,0);
			}
			else if (human_x <= -500 && human_z <= -700){
				fly_mode = 4;

			}
			if (fly_mode == 1){
				human_z = (int) (human_z + 10);
			}
			if (fly_mode == 2){
				human_x = (int) (human_x - 10);

			}
			if (fly_mode == 3){

				human_z = (int) (human_z - 10);
			}
			if (fly_mode == 4){
				human_x = (int) (human_x + 10);
				glRotatef(90,0,0,-1);
				glRotatef(90,0,-1,0);
			}
			flyingHuman.drawFlyingHuman(delta);
		}
		glPopMatrix();


		glPushMatrix();
		{
			if (!isCar) {
				glTranslatef(car_x, car_y, car_z);
				glScalef(40f, 40f, 40f);
				car.drawCar();

			} else {
				car_x = human_posX;
				car_z = human_posZ;
				glTranslatef(car_x, car_y, car_z);
				if (direction == 0) {
					glRotatef(0, 0, 1.0f, 0);
				}
				if (direction == 1) {
					glRotatef(180, 0, 1.0f, 0);
				}
				if (direction == 2) {
					glRotatef(90f, 0, 1.0f, 0);
				}
				if (direction == 3) {
					glRotatef(-90, 0, 1.0f, 0);
				}
				glScalef(40f, 40f, 40f);
				car.drawCar();
			}
		}
		glPopMatrix();

		glPushMatrix();
		{

			glTranslatef(dog_posX - 200, dog_posY, dog_posZ);
			glScalef(25f, 25f, 25f);
			glRotatef(90,0,1,0);
			if (dog_direction == 0) {
				glRotatef(0, 0, 1.0f, 0);
			}
			if (dog_direction == 1) {
				glRotatef(180, 0, 1.0f, 0);
			}
			if (dog_direction == 2) {
				glRotatef(90f, 0, 1.0f, 0);
			}
			if (dog_direction == 3) {
				glRotatef(-90, 0, 1.0f, 0);
			}

			if (dog_move) {
				dog.drawDog(delta, true);
			} else {
				dog.drawDog(delta, false);
			}
		}
		glPopMatrix();
//		glPushMatrix() ;{
//			glTranslatef(610f, 50f, 130f);
//			glScalef(25f, 25f, 25f);
//			glRotatef(90,0,1,0);
//			dog.drawDog(delta,true);
//		}
//		glPopMatrix();

		glPushMatrix() ;{
			glTranslatef(970, 20, 330);
			glScalef(60f, 60f, 60f);
			glRotatef(180, 0, 1, 0);
			bunny.drawBunny();
		}
		glPopMatrix();

		glPushMatrix() ;{
			glTranslatef(-250, 20, 1100);
			glScalef(60f, 60f, 60f);
			glRotatef(thetaDeg, 0, 1, 0);
			bunny.drawBunny();
		}
		glPopMatrix();

		glPushMatrix() ;{
			glColor3f(black[0], black[1], black[2]);
			glMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
			glTranslatef(-200, 10, 1020);
			glRotatef(45,0,1,0);
			glScalef(130f, 0f, 160f);
			sphere.drawSphere(0.5f, 32, 32);
		}
		glPopMatrix();



		//Ground
		glPushMatrix();{
			glTranslatef(900,0,100);
			glScalef(1500f, 1f, 1500f);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP);
			Color.white.bind();
			texture_ground.bind();
			glEnable(GL_TEXTURE_2D);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
			glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
			MyCube.drawTexCube(texture_ground);
		}
		glPopMatrix();


		glPushMatrix();{
			house.drawHouse();
		}
		glPopMatrix();

		glPushMatrix();{
			altar.drawAltar(delta);
		}
		glPopMatrix();

		glPushMatrix() ;{
			glColor3f(black[0], black[1], black[2]);
			glMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
			glTranslatef(1800, 10, -400);
			glRotatef(135,0,1,0);
			glScalef(300f, 0f, 340f);
			sphere.drawSphere(0.5f, 32, 32);
		}
		glPopMatrix();




	}
	public boolean checkLeftHitBox(float[][] position, float speed_x) {
		boolean is_in = false;
		if (human_posX > position[0][0] && human_posX < position[0][1] && human_posZ > position[1][0] && human_posZ < position[1][1]) {
			is_in = true;
		}
		return (!is_in || human_posX == position[0][0] + speed_x);


	}

	public boolean checkRightHitBox(float[][] position, float speed_x) {
		boolean is_in = false;
		if (human_posX > position[0][0] && human_posX < position[0][1] && human_posZ > position[1][0] && human_posZ < position[1][1]) {
			is_in = true;
		}
		return (!is_in || human_posX== position[0][1] - speed_x);


	}

	public boolean checkDownHitBox(float[][] position,float speed_z) {
		boolean is_in = false;
		if (human_posX > position[0][0] && human_posX < position[0][1] && human_posZ > position[1][0] && human_posZ < position[1][1]) {
			is_in = true;
		}

		return (!is_in || human_posZ == position[1][0] + speed_z);


	}

	public boolean checkUpHitBox(float[][] position, float speed_z) {
		boolean is_in = false;
		if (human_posX > position[0][0] && human_posX < position[0][1] && human_posZ > position[1][0] && human_posZ < position[1][1]) {
			is_in = true;
		}

		return (!is_in || human_posZ == position[1][1] - speed_z);

	}
	public static void main(String[] argv) {
		MainWindow hello = new MainWindow();
		hello.start();
	}

	Texture texture;
	Texture texture_ground;
	Texture texture_sky;
	Texture texture_ball;
	Texture texture_shadow;

	/*
	 * Any additional textures for your assignment should be written in here. Make a
	 * new texture variable for each one so they can be loaded in at the beginning
	 */
	public void init() throws IOException {
		texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/wood.png"));
		texture_ground = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/ground3.png"));
		texture_sky = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/sky.png"));
		texture_ball = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/ball.png"));
		texture_shadow = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/shadow.png"));
		System.out.println("Texture loaded okay ");
	}

}
