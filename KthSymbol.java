class Solution {
    public int kthGrammar(int n, int k) {
       return getNthRowDigit(n,k);
    }

    private int getNthRowDigit(int n, int k) {
        if(n == 1 && k  == 1) {
            return 0;
        }

        else if(n == 2) {
            return k == 1 ? 0 : 1;
        }

        else {
            
            int digitAtPreviousLevel = k % 2 == 0 ? getNthRowDigit(n-1, k / 2) :  getNthRowDigit(n-1, (k + 1)/ 2);

            if(digitAtPreviousLevel == 0) {
                return k % 2 == 0 ? 1 : 0;
            } 
            else  {
                return k % 2 == 0 ? 0 : 1;
            }
        }
    }
}
