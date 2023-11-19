import nl.altindag.console.ConsoleCaptor;
import org.example.tasks.ExecService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AppTests {
    ConsoleCaptor captor = new ConsoleCaptor();

    private List<String> getOutput(final int expSize) {
        if (expSize > 1) {
            List<String> arr = new ArrayList<>();
            List<String> out = captor.getStandardOutput();
            for (int i = 0; i < expSize; i++) {
                arr.add(out.get(i));
            }
            return arr;
        } else
            return captor.getStandardOutput();
    }

    @Test
    public void shouldSayHello() {
        String[] testArr = new String[]{"8"};
        ExecService.execTasks(testArr);
        Assertions.assertEquals("Привет", getOutput(1).get(0));
    }

    @Test
    public void shouldSayHelloIfSevenFive() {
        String[] testArr = new String[]{"7.5"};
        ExecService.execTasks(testArr);
        Assertions.assertEquals("Привет", getOutput(1).get(0));
    }

    @Test
    public void shouldNotSayHelloIfSeven() {
        String[] testArr = new String[]{"7"};
        ExecService.execTasks(testArr);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> getOutput(1).get(0));
    }

    @Test
    public void shouldGetName() {
        String[] testArr = new String[]{"Вячеслав"};
        ExecService.execTasks(testArr);
        Assertions.assertEquals("Привет, Вячеслав", getOutput(1).get(0));
    }

    @Test
    public void shouldGetNameIfUpperCase() {
        String[] testArr = new String[]{"ВЯЧЕСЛАВ"};
        ExecService.execTasks(testArr);
        Assertions.assertEquals("Привет, Вячеслав", getOutput(1).get(0));
    }

    @Test
    public void shouldGetNameIfLowerCase() {
        String[] testArr = new String[]{"вячеслав"};
        ExecService.execTasks(testArr);
        Assertions.assertEquals("Привет, Вячеслав", getOutput(1).get(0));
    }

    @Test
    public void shouldNotGetName() {
        String[] testArr = new String[]{"Вячеславиус"};
        ExecService.execTasks(testArr);
        Assertions.assertEquals("Нет такого имени", getOutput(1).get(0));
    }

    @Test
    public void shouldNotGetHelloIfDigitStr() {
        String[] testArr = new String[]{"1,5"};
        ExecService.execTasks(testArr);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> getOutput(1).get(0));
    }

    @Test
    public void shouldGetArray() {
        String[] testArr = new String[]{"1", "2", "3", "6", "9"};
        ExecService.execTasks(testArr);
        Assertions.assertEquals("Число кратное трём: 3.0", getOutput(3).get(0));
        Assertions.assertEquals("Число кратное трём: 6.0", getOutput(3).get(1));
        Assertions.assertEquals("Число кратное трём: 9.0", getOutput(3).get(2));
    }

    @Test
    public void shouldGetArrayIfFractionalNum() {
        String[] testArr = new String[]{"1", "2", "3.4", "6.5", "9.2"};
        ExecService.execTasks(testArr);
        Assertions.assertEquals("Число кратное трём: 3.0", getOutput(2).get(0));
        Assertions.assertEquals("Число кратное трём: 9.0", getOutput(2).get(1));
    }

    @Test
    public void shouldNotGetAnswer() {
        String[] testArr = new String[]{};
        ExecService.execTasks(testArr);
        Assertions.assertEquals("Введите значение", getOutput(1).get(0));
    }
}
