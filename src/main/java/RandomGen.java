public class RandomGen {

    // Values that may be returned by nextNum() private
    private int size;
    private int[] randomNums;

    // Probability of the occurence of randomNums private
    private float[] probabilities;


    public RandomGen(int[] randomNums, float[] probabilities) {
        assert randomNums.length == probabilities.length;
        this.size = randomNums.length;
        this.randomNums = randomNums;
        this.probabilities = probabilities;
    }

    /**
     Returns one of the randomNums. When this method is called
     multiple times over a long period, it should return the
     numbers roughly with the initialized probabilities.
     */
    public int nextNum() {
        double[] summedProbs = new double[size];
        double sum = 0;

        for (int i = 0; i < size; i++) {
            sum += probabilities[i];
            summedProbs[i] = sum;
        }

        double random = Math.random() * sum;
        Integer selected = null;
        int index = 0;
        do {
            double summedProb = summedProbs[index];
            if(random < summedProb) {
                selected = randomNums[index];
            }
            index += 1;
        } while (selected == null);

        return selected;
    }

}
