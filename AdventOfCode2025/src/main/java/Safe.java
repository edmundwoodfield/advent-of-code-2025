public class Safe {
    public Safe(){
      this.currentPosition = 50;
      this.zeroCounter = 0;
    }
    public int currentPosition;
    public int zeroCounter;
    public void rotate(char direction, int distance){
        System.out.println("Current position: " + currentPosition + ". Rotating " + direction + distance);
        var startingAtZero = this.currentPosition == 0;
        if (direction == 'R'){
                currentPosition = currentPosition + distance;
                while (currentPosition > 99){
                    currentPosition -= 100;
                    if (currentPosition != 0) {zeroCounter ++;}
                    System.out.println("Zero Count: " + zeroCounter);
            }
        }
        if (direction == 'L'){
                currentPosition = currentPosition - distance;
                while (currentPosition < 0){
                    currentPosition += 100;
                    if (!startingAtZero){zeroCounter ++;}
                    startingAtZero = false;
                    System.out.println("Zero Count: " + zeroCounter);
            }
        }
        System.out.println("New position: " + currentPosition);
        if (currentPosition == 0){
            zeroCounter ++;
            System.out.println("Zero Count: " + zeroCounter);
        }
    }
}
