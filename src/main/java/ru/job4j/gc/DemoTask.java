package ru.job4j.gc;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class DemoTask {

    public void exampleSoftRef() {
        List<SoftReference<String>> softReferences = new ArrayList<>(
                List.of(new SoftReference<>("anna"), new SoftReference<>("peter"))
        );
        for (SoftReference<String> stringSoftReference : softReferences) {
            String strongStr = stringSoftReference.get();
            if (strongStr != null) {
                System.out.println("Объект по strong ссылке: " + strongStr);
            } else {
                System.out.println("GC уже удалил объект, восстановить ссылку нельзя ...");
            }
        }
    }

    public void exampleWeakRef() {
        List<WeakReference<String>> weakReferences = new ArrayList<>(
                List.of(new WeakReference<>("anna"), new WeakReference<>("peter"))
        );
        for (WeakReference<String> stringWeakReference : weakReferences) {
            String strongStr = stringWeakReference.get();
            if (strongStr != null) {
                System.out.println("Объект по strong ссылке: " + strongStr);
            } else {
                System.out.println("GC уже удалил объект, восстановить ссылку нельзя ...");
            }
        }
    }
}