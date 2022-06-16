package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GeneratorRndTest {

    @Ignore
    @Test
    public void produce() {
        Generator gen = new GeneratorRnd();
        String rsl = gen.produce(
                "I am a ${name}, Who are ${subject}? ",
                Map.of("name", "anna karenina", "subject", "you")
        );
        assertThat(rsl, is("I am a anna karenina, Who are you? "));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenTemplateHasKeysThatAreNotInMapThenEx() {
        Generator gen = new GeneratorRnd();
        gen.produce(
                "I'm ${age} years old, ${name} is your name? ",
                Map.of("name", "anna karenina", "subject", "you")
        );
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenKeysInMapDoNotMatchPatternThenEx() {
        Generator gen = new GeneratorRnd();
        gen.produce(
                "I am a ${name}, Who are ${subject}? ",
                Map.of("age", "100", "subject", "you")
        );
    }
}