class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String s : strs){
            encoded.append(s.length()).append("#").append(s);
        }

        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()){
            int j = i;
            while (str.charAt(j) != '#'){
                j++;
            }

            int lengthOfWord = Integer.parseInt(str.substring(i, j));
            int wordStart = j + 1;
            result.add(str.substring(wordStart, wordStart + lengthOfWord));
            i = wordStart + lengthOfWord;
        }

        return result;
    }
}
