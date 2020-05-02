package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ValidateInputTest {
    @Test
    public void whenInvalidInput() {
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(mem));
        ValidateInput input = new ValidateInput(new StubInput(new String[] {"error", "1"}));
        input.askInt("some text");
        assertThat(
                mem.toString(),
                is(String.format("Invalid data! Enter again, please.%n"))
        );
        System.setOut(out);
    }

    @Test
    public void whenOutOfBoundInput() {
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(mem));
        ValidateInput input = new ValidateInput(new StubInput(new String[] {"22", "2"}));
        input.askInt("some text", 7);
        assertThat(
                mem.toString(),
                is(String.format("Please, select another number.%n"))
        );
        System.setOut(out);
    }
}
