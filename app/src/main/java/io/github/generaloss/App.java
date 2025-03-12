package io.github.generaloss;

import android.opengl.GLES20;
import android.util.Log;

import jpize.context.JpizeApplication;
import jpize.opengl.gl.Gl;
import jpize.opengl.glenum.GlTarget;
import jpize.opengl.shader.Shader;
import jpize.opengl.tesselation.GlPrimitive;
import jpize.opengl.texture.Texture2D;
import jpize.opengl.type.GlType;
import jpize.opengl.vertex.GlVertAttr;
import jpize.util.math.matrix.Matrix4f;
import jpize.util.math.vector.Vec2i;
import jpize.util.mesh.Mesh;
import jpize.util.mesh.VertexBatch;
import jpize.util.res.Resource;

public class App extends JpizeApplication {

    VertexBatch vbatch;
    Vec2i size;
    Texture2D texture;

    @Override
    public void init() {
        Gl.clearColor(0.4, 0.6, 0.9);
        Gl.disable(GlTarget.CULL_FACE);
        vbatch = new VertexBatch(GlPrimitive.TRIANGLES);

        int progID = vbatch.getCurrentShader().getID();
        int posLocation = GLES20.glGetAttribLocation(progID, "v_pos");
        Log.i("JPIZE", "Pos: " + posLocation);

        size = new Vec2i();
        // texture = new Texture2D("/assets/grass_block_snow.png");
    }

    @Override
    public void update() {

    }

    @Override
    public void render() {
        Gl.clearColorBuffer();

        vbatch.setup(new Matrix4f().setOrthographic(0, 0, size.x, size.y));

        vbatch.drawVertex(0, 0,  1F, 0F, 0F);
        vbatch.drawVertex(size.x / 2F, size.y,  1F, 0F, 0F);
        vbatch.drawVertex(size.x, 0,  1F, 0F, 0F);

        vbatch.render();
    }

    @Override
    public void resize(int width, int height) {
        size.set(width, height);
    }

    @Override
    public void dispose() {
        vbatch.dispose();
    }

}
