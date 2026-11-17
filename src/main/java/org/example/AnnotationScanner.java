package org.example;

import java.lang.reflect.Method;

public class AnnotationScanner {

    public static void scan(Class<?> targetClass) {
        System.out.println("Scanning class: " + targetClass.getName());

        for (Method method : targetClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Audited.class)) {
                Audited audited = method.getAnnotation(Audited.class);
                System.out.printf("Method: %-20s | Reason: %s%n",
                        method.getName(),
                        audited.reason()
                );
            }
        }
    }
}
