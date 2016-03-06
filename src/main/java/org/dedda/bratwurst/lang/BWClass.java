package org.dedda.bratwurst.lang;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
 */
public class BWClass {

    private static List<BWClass> classes = new ArrayList<>();

    public final String name;
    public final BWFunction[] functions;

    public BWClass(String name, BWFunction[] functions) {
        this.name = name;
        this.functions = functions;
        if (classes.stream().filter(c -> c.name.equals(this.name)).findAny().isPresent()) {
            throw new RuntimeException("class " + name + " already registered");
        }
        classes.add(this);
    }

    public BWObject createInstance() {
        return new BWObject(this);
    }

    public static BWClass getClassForName(String name) {
        Optional<BWClass> classOptional = classes.stream().filter(c -> c.name.equals(name)).findFirst();
        if (classOptional.isPresent()) {
            return classOptional.get();
        } else {
            return new BWClass(name, new BWFunction[0]);
        }
    }

    public static void unregisterAll() {
        classes = new ArrayList<>();
    }

}
