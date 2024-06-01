package com.zrl.core.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamSample {

    public static void main(String[] args) {

        StreamSample streamSample = new StreamSample();
        streamSample.test();

    }

    private void test(){
        List<Person> personList = new ArrayList<Person>();
        Person person10 = new Person(10);
        Person person22 = new Person(22);
        Person person30 = new Person(30);

        personList.add(person10);
        personList.add(person22);
        personList.add(person30);

        //过滤出年龄大于20的人个数
        long count = personList.stream().filter(person -> person.age > 20).count();
        System.out.println(count);

        List<Person> personList20 = personList.stream().filter(person -> person.age > 20).collect(Collectors.toList());
        System.out.println(personList20);

    }

    class Person{

        public Person(int age){
            this.age = age;
        }

        int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "age:" + age;
        }
    }

}
