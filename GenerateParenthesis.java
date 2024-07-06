class Solution {
    public List<String> generateParenthesis(int n) {
        int left = n;
        int right = n;
        ValidString valid = new ValidString();
        dfs("", n, n, valid);
        return valid.str;
    }

    private void dfs(String str, int left, int right, ValidString valid) {

        if(left == 0 && right == 0) {
            System.out.println(str);
            if(isValid(str)) {
                valid.str.add(str);
            }
            return;
        }

        if(left > 0) {
            dfs(str + "(" , left - 1, right, valid);
        }

        if(right > 0) {
            dfs(str + ")" , left, right - 1, valid);
        }
    }

    private boolean isValid(String str) {

        int len = str.length();

        if(len == 0) {
            return false;
        }

        Stack<Character> stack = new Stack<Character>();

        stack.push(str.charAt(0));
        int i = 1;

        while(i < len) {

            if(stack.empty()) {
                stack.push(str.charAt(i));
            }

            else {
                Character ch = stack.peek();

                if(ch == '(' && str.charAt(i) == ')') {
                    stack.pop();
                }
                else if(ch == '(' && str.charAt(i) == '(') {
                    stack.push('(');
                }
                else if(ch == ')' && str.charAt(i) == '(') {
                    stack.push('(');
                }
                else if(ch == ')' && str.charAt(i) == ')') {
                    stack.push(')');
                }
            }
            i++;
        }
        return stack.isEmpty();
    }
}

class ValidString {
    public List<String> str = new ArrayList<String>();
}
