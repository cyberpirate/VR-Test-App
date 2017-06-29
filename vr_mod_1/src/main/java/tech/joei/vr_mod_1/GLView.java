package tech.joei.vr_mod_1;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by cyberpirate on 6/23/2017.
 */

public class GLView extends GLSurfaceView {

    static {
        System.loadLibrary("vr_mod_1");
    }

    public GLView(Context context) {
        super(context);
        init(context);
    }


    public GLView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        // Pick an EGLConfig with RGB8 color, 16-bit depth, no stencil,
        // supporting OpenGL ES 2.0 or later backwards-compatible versions.
        setEGLConfigChooser(8, 8, 8, 0, 16, 0);
        setEGLContextClientVersion(3);
        setRenderer(new Renderer());

        Log.d("DEBUG", "got from jni: " + stringFromJNI());

        jniCallback(new Runnable() {
            @Override
            public void run() {
                Log.d("DEBUG", "Ran from JNI");
            }
        });
    }

    private native String stringFromJNI();
    private native void jniCallback(Runnable run);
    private native void init();
    private native void resize(int width, int height);
    private native void step();

    private class Renderer implements GLSurfaceView.Renderer {
        public void onDrawFrame(GL10 gl) {
            step();
        }

        public void onSurfaceChanged(GL10 gl, int width, int height) {
            resize(width, height);
        }

        public void onSurfaceCreated(GL10 gl, EGLConfig config) {
            init();
        }
    }



}
