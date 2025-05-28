class Solution {
    public boolean isUgly(int n) {
        
      if (n < 1) return false;

            int[] primes = {2, 3, 5};

            for (int i = 0; i < primes.length; ++i){
                while (n % primes[i] == 0){
                    n /= primes[i];
                }
            }

            return n == 1;

    }
}