public class BatteryBank {
    public long highestJolt(String bank) {
        StringBuilder batteries = new StringBuilder();
        var eligibleForFirstDigit = bank.substring(0, bank.length() - 11);
        var firstDigit = 0;
        var startIndex = 0;
        for (var i = 9; i >= 0; i--){
            for (var j = 0; j <= eligibleForFirstDigit.length() -1; j++){
                if (Character.getNumericValue(eligibleForFirstDigit.charAt(j)) == i){
                    firstDigit = i;
                    startIndex = j;
                    break;
                }
            }
            if (firstDigit != 0){ break;}
        }
        batteries.append(firstDigit);
        var remainingString = bank.substring(startIndex + 1);
        var remainingInts = 11;
        var nextDigit = 0;
        while (remainingInts > 0){
            var eligibleForNextDigit = remainingString.substring(0, remainingString.length() - remainingInts + 1);
            for (var i = 9; i >= 0; i--) {
                if (eligibleForNextDigit.contains(Integer.toString(i))){
                    nextDigit = i;
                    remainingString = remainingString.substring(remainingString.indexOf(Integer.toString(i)) + 1);
                    break;
                }
            }
            remainingInts --;
            batteries.append(nextDigit);
            nextDigit = 0;

        }
        return Long.parseLong(batteries.toString());
    }
}
