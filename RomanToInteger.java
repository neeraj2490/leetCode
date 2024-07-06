class Solution {
    public int romanToInt(String s) {

        final Map<Character,Integer> symbolMap = new HashMap<Character, Integer>();
        int result = 0;

        symbolMap.put('I', 1);
        symbolMap.put('V', 5);
        symbolMap.put('X', 10);
        symbolMap.put('L', 50);
        symbolMap.put('C', 100);
        symbolMap.put('D', 500);
        symbolMap.put('M', 1000);

        int len = s.length();
        
        for(int i = 0; i < len; i++) {
            Character currentChar = Character.valueOf(s.charAt(i));

            int subResult = checkIfSubtractionIsUsed(s, i);

            if(subResult != -1) {
                result = result  + subResult;
                i++;
            }

            else if(symbolMap.get(currentChar)!= null && symbolMap.get(currentChar) != 1)  {
                result = result + symbolMap.get(currentChar);
            }

            else if(symbolMap.get(currentChar)!= null && symbolMap.get(currentChar) == 1) {
                result = result + 1;
            }
        }

        return result;
    }

    private int checkIfSubtractionIsUsed(String s, int pos) {

        int len = s.length();

        if(pos + 1 >= len) {
            return -1;
        }

        String substr = s.substring(pos, pos + 2);

        if(substr.equalsIgnoreCase("IV")) {
            return 4;
        }

        if(substr.equalsIgnoreCase("IX")) {
            return 9;
        }

        if(substr.equalsIgnoreCase("XL")) {
            return 40;
        }

        if(substr.equalsIgnoreCase("XC")) {
            return 90;
        }

        if(substr.equalsIgnoreCase("CD")) {
            return 400;
        }

        if(substr.equalsIgnoreCase("CM")) {
            return 900;
        }

        return -1; 
    }
}
