class Solution {
//                 solve(0)
//                /        \
//       take 2            take 22
//          |                  |
//      solve(1)            solve(2)
//       /     \               |
//  take2      take26        take6
//    |           |            |
// solve(2)    solve(3)     solve(3)
//     |            |          |
//  take6         END         END
//     |
//  solve(3)
//     |
//    END
    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return decodeWays(s, 0, memo);
    }

    private int decodeWays(String s, int index, int[] memo) {
        // agar string khatam to return kar do valid string count 1
        if(index == s.length()){
            return 1;
        }

        // current index value '0' aa gya it means invalid iska na to single digit bana skte na hi 2 digit bcoz leading zeros invalid hai
        if(s.charAt(index)=='0'){
            return 0;
        }

        //pehle check kar lo memo table pe value pada hai to recursive call mat karo
        if(memo[index]!=-1){
            return memo[index];
        }

        // Take one digit and process next pass
        int ways = decodeWays(s, index+1, memo);

        //Take 2 digit and process next pass but yeha check karna valid number hone chahiye 10~26 tak
        if(index+1<s.length()){
            int twoDigit = (s.charAt(index)-'0') * 10 + (s.charAt(index+1) - '0');
            if(10<= twoDigit && twoDigit<=26){
                ways += decodeWays(s, index+2, memo);
            }
        }

        //memo me store kar lo
        memo[index] = ways;
        // jab left and right dono ke ways aa jaye to return kar do
        return ways;
    }
}
