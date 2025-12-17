import java.util.ArrayList;

public class GiftShop {
    public boolean validateId(long id){
        String stringId = String.valueOf(id);
        for (var i = 1; i <= stringId.length() /2; i++){
            if (stringId.length() % i == 0){
                var stringFraction = stringId.length() / i;
                var substring = stringId.substring(0, i);
                var multipliedSubstring = substring.repeat(stringFraction);
                if (stringId.equals(multipliedSubstring)){
                    return false;
                }
            }
        }
        return true;
    }

    public String[] rangeStrings (String range){
        return range.split(",");
    }

    public long invalidIds(String rangeString){
        var index = rangeString.indexOf("-");
        var first = Long.parseLong(rangeString.substring(0,index));
        var last = Long.parseLong(rangeString.substring(index + 1));
        var list = new ArrayList<Long>();
        long count = 0;
        for (long i = first; i <= last; i++) {
            if (!validateId(i)){
                list.add(i);
                count += i;
            }
        }
        System.out.println(list);
        return count;
    }
}
