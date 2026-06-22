class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        reverse(arr, 0, arr.length - 1);
        reverseWords(arr);
        return cleanSpaces(arr);
    }
    
    private void reverse(char[] arr, int start, int end){
        while(start<end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    private void reverseWords(char[] arr){
        int start = 0, n = arr.length;
        for(int i=0;i<n;i++){
             if(arr[i] == ' '){
                reverse(arr, start, i - 1);
                start = i + 1;
            }
            else if(i == n - 1){
                reverse(arr, start, i);
            }
        }
    }

    private String cleanSpaces(char[] arr) {
        StringBuilder sb = new StringBuilder();
        int n = arr.length;
        int i=0;
        while(i<n){
            while(i<n && arr[i]==' '){
                i++;
            }
            while(i<n && arr[i]!=' '){
                sb.append(arr[i++]);
            }
            while(i<n && arr[i]==' '){
                i++;
            }
            if(i<n){
                sb.append(' ');
            }
        }
        return sb.toString();
    }

}