import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class BatteryBankTest {
    @Test
    void highestJoltTest(){
        var banks = Arrays.asList("987654321111111","811111111111119","234234234234278","818181911112111");
        var batteryBank = new BatteryBank();
        var total = 0L;
        for (var bank : banks){
            var highest = batteryBank.highestJolt(bank);
            System.out.println(highest);
            total += highest;
        }
        Assertions.assertEquals(3121910778619L, total);
    }
}
