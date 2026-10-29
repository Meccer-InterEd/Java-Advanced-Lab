package org.example;

import java.lang.reflect.Method;

public class AnnotationScanner {

    public void scan(Class<?> clazz){
        Method[] methods = clazz.getDeclaredMethods();

        for(Method method : methods){
            if(method.isAnnotationPresent(Audited.class)){
                Audited audited = method.getAnnotation(Audited.class);

                System.out.println("Method: " + method.getName());
                System.out.println("Reason: " + audited.reason());
            }

            if(method.isAnnotationPresent(RequireRole.class)){
                RequireRole role = method.getAnnotation(RequireRole.class);

                System.out.println("Required role: " + role.value());
            }
        }
    }

}

//Note to self: treat Class<?> as a container that holds info about a class(The type of the class is not specific)
// Audited.class tells Java which annotation you are looking for

//Retention Policy: SOURCE- the annotation is discarded by the compiler and theres no output
//                  CLASS- annotation is stored in the .class file but not retained for runtime
