package com.cyrus.sandbox.display;

import android.opengl.GLSurfaceView;
import android.opengl.GLU;
import android.util.Log;

import com.cyrus.sandbox.shapes.Triangle;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class ScreenRenderer implements GLSurfaceView.Renderer {
    public static final ScreenRenderer RENDERER = new ScreenRenderer();

    private Triangle triangle1;
    private Triangle triangle2;

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        Log.d("MyOpenGLRenderer", "Surface changed. Width=" + width
                + " Height=" + height);
        triangle1 = new Triangle(0.5f, 1, 0, 0);
        triangle2 = new Triangle(0.5f, 0, 1, 0);
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
        //Calculate The Aspect Ratio Of The Window
        GLU.gluPerspective(gl, 45.0f, (float) width / (float) height,
                0.1f, 100.0f);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        Log.d("MyOpenGLRenderer", "Surface created");
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1f);
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        gl.glLoadIdentity();
        gl.glTranslatef(0.0f, 0.0f, -5.0f);
        triangle1.draw(gl);
        gl.glTranslatef(2.0f, 0.0f, -5.0f);
        triangle2.draw(gl);
    }
}