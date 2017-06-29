#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_tech_joei_vr_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "hello from c++";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT void JNICALL
Java_tech_joei_vr_MainActivity_jniCallback(
        JNIEnv *env,
        jobject /* this */,
        jobject callback) {

    jclass clazz = env->GetObjectClass(callback);
    jmethodID myMethod = env->GetMethodID(clazz, "run", "()V");
    env->CallVoidMethod(callback, myMethod);
}