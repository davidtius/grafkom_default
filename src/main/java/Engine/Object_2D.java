package Engine;

import org.joml.Vector3f;

import java.util.List;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL30.*;


public class Object_2D extends ShaderProgram {

    List<Vector3f> vertices;
    int vao;
    int vbo;
    public Object_2D(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        setupVAOVBO();
    }

    public void setupVAOVBO(){
        //set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        //set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(vertices), GL_STATIC_DRAW);
    }

    public void drawSetup(){
        bind();

        //bind vbo
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
    }

    public void draw(){
        drawSetup();

        //draw vertices
        //optional (ketebalan)
        glLineWidth(1);

        //optional (size vertex)
        glPointSize(0);

        //wajib (parametes pertama tergantung mau buat apa, contoh dibawah untuk segitiga GL_TRIANGLES)
       /*
        GL_LINES
        GL_LINE_STRIPS
        GL_LINE_LOOP
        GL_TRIANGLES
        GL_TRIANGLES_FAN
        GL_POINT
        */
        //parameter kedua, mxdnya mau gambar dari index/vertex ke berapa
        //parametes ketiga buat mau gambar berapa vertex
        glDrawArrays(GL_TRIANGLES,0, vertices.size());
    }
}
