import Engine.Object_2D;
import Engine.ShaderProgram;
import Engine.Window;
import org.joml.Vector3f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static  org.lwjgl.opengl.GL11.*;
import static  org.lwjgl.opengl.GL30.*;

public class Main {

    private Window window = new Window(500,500,"besar dan kuat");
    private ArrayList<Object_2D> object2DS = new ArrayList<>();

    public static void main(String[] args) {
        new Main().run();;
    }

    public void init(){
        window.init();
        GL.createCapabilities();
        //dua diatas harus paten dan gabole diganti posisinya

        //code CUMA BOLE DISINI

object2DS.add(new Object_2D(
        Arrays.asList(
                //lokasi shaderFile menyusaikan objectnya
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(0.0f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, 0.5f, 0.0f)
                )
)
));
    }

    public void loop(){
        while (window.isOpen()){
            window.update();
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GL.createCapabilities();

            //code CUMA BOLE DISINI

            for (Object_2D ob: object2DS){
                ob.draw();
            }


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