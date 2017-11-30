import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    
    private final double meanResult;
    private final double standardDeviationResult;
    private final double confidenceLoResult;
    private final double confidenceHiResult;
    
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0)
            throw new IllegalArgumentException();
        double[] result = new double[trials];
        
        if (n == 1) {
            meanResult = 1;
            standardDeviationResult = Double.NaN;
            confidenceLoResult = Double.NaN;
            confidenceHiResult = Double.NaN;
        }
        else {
        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);
            int times = 0;
            do {
                int row = StdRandom.uniform(1, n + 1);
                int col = StdRandom.uniform(1, n + 1);
                if (!percolation.isOpen(row, col)) {
                    percolation.open(row, col);
                    times++;
                }
                
            } while (!percolation.percolates());
            result[i] = (double) times / (n * n);
        }
        
        meanResult = StdStats.mean(result);
        standardDeviationResult = StdStats.stddev(result);
        double difference = (1.96 * standardDeviationResult) / Math.sqrt(trials);
        confidenceLoResult = meanResult - difference;
        confidenceHiResult = meanResult + difference;
        }
    }
    
    public double mean() {
        return meanResult;
    }
    
    public double stddev() {
        return standardDeviationResult;
    }
    
    public double confidenceLo() {
        return confidenceLoResult;
    }
    
    public double confidenceHi() {
        return confidenceHiResult;
    }
    
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        
        PercolationStats percolationStats = new PercolationStats(n, trials);
        System.out.println("mean: " + percolationStats.mean());
        System.out.println("stddev:" + percolationStats.stddev());
        System.out.println("95% confidence interval: ["
                           + percolationStats.confidenceLo() + ", "
                           + percolationStats.confidenceHi() + "]");
    }
}