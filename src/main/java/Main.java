import Engine.Window;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;
import static  org.lwjgl.opengl.GL11.*;
import static  org.lwjgl.opengl.GL30.*;

public class Main {

    private Window window = new Window(500,500,"besar dan kuat");

    public static void main(String[] args) {
        new Main().run();;
    }

    public void init(){
        window.init();
        GL.createCapabilities();
        //dua diatas harus paten dan gabole diganti posisinya

        //code CUMA BOLE DISINI


    }

    public void loop(){
        while (window.isOpen()){
            window.update();
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GL.createCapabilities();

            //code CUMA BOLE DISINI

            //Restore state
            glDisableVertexAttribArray(0);

            //Poll  for window events
            //The key callback allows above will only be invoked during this call
            glfwPollEvents();
        }
    }

    public void run() {
        init();
        loop();

        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }
}