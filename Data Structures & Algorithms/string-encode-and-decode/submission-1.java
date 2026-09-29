class Solution {
    public String encode(List<String> strs) {
    StringBuilder sb = new StringBuilder();
    for (String str : strs) {
        sb.append(str.length()).append("#").append(str);
    }
    return sb.toString();
    }

    public List<String> decode(String str) {

    List<String> result = new ArrayList<>();

    int i = 0;

    while (i < str.length()) {

        // Find where the length ends
        int j = i;

        while (str.charAt(j) != '#') {
            j++;
        }

        // Read complete length, e.g. "10"
        int len = Integer.parseInt(str.substring(i, j));

        // Move i after '#'
        i = j + 1;

        // Read exactly len characters
        String s = str.substring(i, i + len);

        result.add(s);

        // Move to the next encoded string
        i = i + len;
    }

    return result;
}
}
