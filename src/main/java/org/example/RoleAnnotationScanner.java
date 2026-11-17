package org.example;

import java.lang.reflect.Method;

public class RoleAnnotationScanner {

    public static void scan(Class<?> targetClass) {
        System.out.println("Scanning class: " + targetClass.getName());

        for (Method method : targetClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(RequiresRole.class)) {
                RequiresRole annotation = method.getAnnotation(RequiresRole.class);
                System.out.printf("Method: %-20s | Required Role: %s%n",
                        method.getName(),
                        annotation.value()
                );
            }
        }
    }
}

