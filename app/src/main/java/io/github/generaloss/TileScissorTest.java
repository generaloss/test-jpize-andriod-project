package io.github.generaloss;

import jpize.context.Jpize;
import jpize.context.JpizeApplication;
import jpize.context.input.MouseBtn;
import jpize.opengl.gl.Gl;
import jpize.opengl.tesselation.GlScissor;
import jpize.opengl.texture.Texture2D;
import jpize.util.camera.OrthographicCameraCentered;
import jpize.util.font.Font;
import jpize.util.math.Mathc;
import jpize.util.math.Maths;
import jpize.util.math.vector.Vec2f;
import jpize.util.mesh.TextureBatch;
import jpize.util.pixmap.PixmapRGBA;

public class TileScissorTest extends JpizeApplication {

    private TextureBatch batch;
    private OrthographicCameraCentered camera;
    private Texture2D texture;
    private GlScissor<String> scissor;

    private float scale = 0.05F;
    private Vec2f prev = new Vec2f();
    private Vec2f position = new Vec2f();
    private Vec2f cinematic_position = new Vec2f();

    public void init() {
        this.batch = new TextureBatch();
        this.camera = new OrthographicCameraCentered();
        this.camera.setScale(scale);
        this.texture = new Texture2D(
                new PixmapRGBA(21, 21).fillRGB(0, 0, 20, 20, 0xFFFFFF).fillRGB(0, 0, 17, 17, 0x666666)
        );
        this.scissor = new GlScissor<String>()
                .put("scissor_1",  100, 100, camera.getWidth() - 200, camera.getHeight() - 200);
    }

    @Override
    public void update() {
        scale *= Mathc.pow(1.15F, Jpize.getScroll());
        camera.setScale(camera.getScale() + (scale - camera.getScale()) * 0.1F);

        if(MouseBtn.LEFT.down())
            Jpize.input.getCursorPos(prev);
        if(MouseBtn.LEFT.pressed())
            cinematic_position.sub(Jpize.input.getCursorPos(position).copy().sub(prev).div(camera.getScale()));
        prev.set(position);
        camera.position().add(cinematic_position.copy().sub(camera.position()).div(10));

        camera.update();
    }

    @Override
    public void render() {
        Gl.clearColorBuffer();
        batch.setup(camera);
        scissor.apply();

        for(int i = Maths.floor((camera.getX() - camera.getScaledHalfWidth()) / 50); i <= (camera.getX() + camera.getScaledHalfWidth()) / 50; i++)
            for(int j = Maths.floor((camera.getY() - camera.getScaledHalfHeight()) / 50); j <= (camera.getY() + camera.getScaledHalfHeight()) / 50; j++)
                batch.draw(texture, i * 50, j * 50, 50, 50);

        batch.render();
        scissor.disable();

        batch.draw(texture, -25, -25, 50, 50);
        batch.render();
    }

    @Override
    public void resize(int width, int height) {
        camera.resize(width, height);
    }

    @Override
    public void dispose() {
        batch.dispose();
        texture.dispose();
    }

}
