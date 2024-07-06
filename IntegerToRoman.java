class Solution {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        Map<Integer, String> baseValuesMap = new HashMap<Integer, String>();
        Map<Integer, String> singleDigitMap = new HashMap<Integer, String>();

        baseValuesMap.put(1, "I");
        baseValuesMap.put(5, "V");
        baseValuesMap.put(10, "X");
        baseValuesMap.put(50, "L");
        baseValuesMap.put(100, "C");
        baseValuesMap.put(500, "D");
        baseValuesMap.put(1000, "M");

        singleDigitMap.put(1, "I");
        singleDigitMap.put(2, "II");
        singleDigitMap.put(3, "III");
        singleDigitMap.put(4, "IV");
        singleDigitMap.put(5, "V");
        singleDigitMap.put(6, "VI");
        singleDigitMap.put(7, "VII");
        singleDigitMap.put(8, "VIII");
        singleDigitMap.put(9, "IX");

        while (num >= 10) {
            if(startFromFour(num)) {
                int baseValue = findBaseValueForFourAndNine(num);
                result.append(covertFour(num));
                num = num % baseValue;
            }
            else if(startFromNine(num)) {
                int baseValue = findBaseValueForFourAndNine(num);
                 result.append(convertNine(num));
                 num = num % baseValue;
            }
            else {
                int baseValue = findBaseValue(num);
                int quotient = num / baseValue;
                while(quotient > 0) {
                    quotient --;
                    result.append(baseValuesMap.get(baseValue));
                }
                num = num % baseValue;
            }
        }

        if(num >= 1 && num < 10) {
            result.append(singleDigitMap.get(num));
        }
        return result.toString();
    }

    private int findBaseValue(int num) {
         int[] basValueArray = new int[]{1, 5, 10, 50, 100, 500, 1000};

         for(int i = 0; i < 7; i++) {
            if(num < basValueArray[i]) {
                return basValueArray[i-1];
            }
         }
         return 1000;

    }

    private String covertFour(int num) {
        if(num < 5) {
            return "IV";
        }
        else if(num < 50) {
            return "XL";
        }
        else {
            return "CD";
        }
    }

    private String convertNine(int num) {
        if(num < 10) {
            return "IX";
        }
        else if(num < 100) {
            return "XC";
        }
        return "CM";
    }

    private boolean startFromFour(int num) {

        while(num > 10) {
            num = num / 10;
        }
        return num == 4;
    }

    private boolean startFromNine(int num) {

        while(num > 10) {
            num = num / 10;
        }
        return num == 9;
    }

    private int findBaseValueForFourAndNine(int num) {
        if(num < 10) {
            return 1;
        }

        if(num < 100) {
            return 10;
        }

        if(num < 1000) {
            return 100;
        }

        return 1000;
    }
}
