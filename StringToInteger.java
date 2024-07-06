class Solution {
    public int myAtoi(String s) {
        int len = s.length();
        int i = 0;
        boolean isNegativeNumber = false;
        int result = 0;

        //ingore initial whitespaces
        while(i < len && s.charAt(i) == ' ') {
            i++;
        }

        //check if it is negative number
        if(i < len && s.charAt(i) == '-') {
            isNegativeNumber = true;
            i++;
        }

        //check if it starts with + character
        if(i < len && !isNegativeNumber && s.charAt(i) == '+') {
            i++;
        }

        while(i < len) {
            int temp = s.charAt(i) - '0';
            if(temp < 0 || temp > 9) {
                break;
            }
            
            if(isOutofRange(isNegativeNumber, result, temp)) {
                return isNegativeNumber ? -2147483648 : 2147483647;
            }

            result = isNegativeNumber ? result * 10 - temp : result * 10 + temp;

            i++;
        }

        return result;     
    }

    private boolean isOutofRange(boolean isNegativeNumber, int num, int nextChar) {
        int upperBound = 2147483647;
        int lowerBound = -2147483648;

        if(isNegativeNumber) {

            if((lowerBound / 10) > num) {
                return true;
            }

            if(((lowerBound / 10) == num) && (lowerBound % 10) > (nextChar * -1)) {
                return true;
            }
        }
        else {
            if((upperBound / 10) < num) {
                return true;
            }

            if(((upperBound / 10) == num) && (upperBound % 10) < nextChar) {
                return true;
            }
        }

        return false;
    }
}
