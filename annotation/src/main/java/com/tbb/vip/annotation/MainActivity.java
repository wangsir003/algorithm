package com.tbb.vip.annotation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User user = new User();
        Class<User> userClass = User.class;
        try {
            Method method = userClass.getMethod("getUser", String.class, String.class);
            method.invoke(user,"李四","33");


            if (method.isAnnotationPresent(MyAnnotation.class)){
                MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
                String[] value = annotation.value();
                for (String v:
                     value) {
                    Log.e(TAG,"v->" + v);
                }
            }else {
                    Log.e(TAG,"v->没有这个注解");

            }


            method.invoke(user.aaa,user.age,user.name,"李四","名字","年龄");



        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    class User{
        @MyAnnotation("sss")
        String aaa;
        String name;
        String age;


        @MyAnnotation(value = {"张三","23"})
        public void getUser(String name,String age){
            Log.e(TAG,"name" + name + "|age = " + age);
        }
    }


}