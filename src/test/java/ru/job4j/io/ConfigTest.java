package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        Config config = new Config("./data/pair_without_comment.properties");
        config.load();
        assertThat(config.value("name"), is("Ivan"));
    }

    @Test
    public void whenPairWithComment() {
        Config config = new Config("./data/pair_with_comment.properties");
        config.load();
        assertThat(config.value("# Comment"), is(nullValue()));
    }

    @Test
    public void whenPairWithCommentAndEmptyStrings() {
        Config config = new Config("./data/pair_with_comment_and_empty_strings.properties");
        config.load();
        assertThat(config.value(""), is(nullValue()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPairWithInvalidFormat() {
        Config config = new Config("./data/pair_with_invalid_format.properties");
        config.load();
    }
}