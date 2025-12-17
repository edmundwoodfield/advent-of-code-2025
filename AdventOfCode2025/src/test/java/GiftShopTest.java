import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GiftShopTest {
    @Test
    void validateIdTest(){
        var giftShop = new GiftShop();
        var ranges = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124";
        var rangeStrings = giftShop.rangeStrings(ranges);
        long count = 0;
        for (var range : rangeStrings){
            count += giftShop.invalidIds(range);
        }
        Assertions.assertEquals(4174379265L, count);
    }
}
