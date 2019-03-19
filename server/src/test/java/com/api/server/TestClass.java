package com.api.server;

import jdk.nashorn.internal.objects.annotations.Setter;
import org.h2.util.SmallLRUCache;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestClass implements Serializable {

    @Test
    public void testSer() throws IOException, ClassNotFoundException {
        Person s = new Person();
        s.setName("Persona");
        Person p = new Person();
        p.setName("Person111a");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("text.txt"));
        objectOutputStream.writeObject(s);
        objectOutputStream.writeObject(p);


        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("text.txt"));
        Person s1 = (Person) objectInputStream.readObject();
        Person s2 = (Person) objectInputStream.readObject();
        if (objectInputStream.available() == 0) {
            Person s3 = (Person) objectInputStream.readObject();
            System.out.println(s3);
        }
        System.out.println(s1);
        System.out.println(s2);
    }

    class Person implements Serializable {
        private String name;

        /**
         * Gets the name
         *
         * @return value of name
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the name
         *
         * @param name the name
         */
        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    @Test
    public void testSynch() {
        Map map = Collections.synchronizedMap(new LinkedHashMap<>());
        Map synchronizedMap = Collections.synchronizedMap(SmallLRUCache.newInstance(100));
        synchronizedMap.put()
    }
}
