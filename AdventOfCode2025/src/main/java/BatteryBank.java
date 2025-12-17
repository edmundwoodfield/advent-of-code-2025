public class BatteryBank {
    public int highestJolt(String bank) {
        var nonFinal = bank.substring(0, bank.length() - 1);
        var highestNonFinalDigit = 0;
        var startIndex = 0;
        for (var i = 9; i >= 0; i--){
            for (var j = 0; j <= nonFinal.length() -1; j++){
                if (Character.getNumericValue(nonFinal.charAt(j)) == i){
                    highestNonFinalDigit = i;
                    startIndex = j;
                    break;
                }
            }
            if (highestNonFinalDigit != 0){ break;}
        }
        var secondDigitSubstring = bank.substring(startIndex + 1);
        var secondDigit = 0;
        for (var i = 9; i >= 0; i--) {
            if (secondDigitSubstring.contains(Integer.toString(i))){
                secondDigit = i;
                break;
            }
        }
        var stringFinal = highestNonFinalDigit + Integer.toString(secondDigit);
        return Integer.parseInt(stringFinal);
    }
}
