package com.cyrus.sandbox.shapes;

import com.cyrus.sandbox.attributes.Vertex;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * @author impaler
 *
 */
public class Triangle {

    private FloatBuffer vertexBuffer;
    private float base = 1.0f;
    private float red, green, blue;

    private Vertex a = new Vertex(-0.5f, -0.5f, 0.0f);
    private Vertex b = new Vertex(0.5f, -0.5f, 0.0f);
    private Vertex c = new Vertex(0.0f, 0.5f, 0.0f);

    private float[] vertexArray() {
        return new float[] {
          a.getX(), a.getY(), a.getZ(),
          b.getX(), b.getY(), b.getZ(),
          c.getX(), c.getY(), c.getZ()
        };
    }

    public Triangle(float scale, float red, float green, float blue) {
        a = new Vertex(-base * scale, -base * scale, 0.0f);
        b = new Vertex(base * scale, -base * scale, 0.0f);
        c = new Vertex(0.0f, base * scale, 0.0f);

        this.red = red;
        this.green = green;
        this.blue = blue;
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(3 * 3 * 4);
        byteBuffer.order(ByteOrder.nativeOrder());
        vertexBuffer = byteBuffer.asFloatBuffer();
        vertexBuffer.put(vertexArray());
        vertexBuffer.flip();
    }

    public void draw(GL10 gl) {
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        // set the colour for the triangle
        gl.glColor4f(red, green, blue, 0.5f);
        // Point to our vertex buffer
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
        // Draw the vertices as triangle strip
        gl.glDrawArrays(GL10.GL_TRIANGLES, 0, vertexArray().length / 3);
        // Disable the client state before leaving
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }

}
