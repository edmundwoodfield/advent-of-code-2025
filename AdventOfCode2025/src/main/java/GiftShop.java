import java.util.ArrayList;

public class GiftShop {
    public boolean validateId(long id){
        String stringId = String.valueOf(id);
        if(stringId.length() % 2 == 1){
            return true;
        }
        else{
            var firstHalf = stringId.substring(0, stringId.length() / 2);
            var secondHalf = stringId.substring(stringId.length() / 2);
            return !firstHalf.equals(secondHalf);
        }
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
