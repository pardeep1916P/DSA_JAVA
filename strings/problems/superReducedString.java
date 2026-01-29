public static String superReducedString(String s) {
    if(s.length()==0) return "Empty String"; //optional
    StringBuilder sb = new StringBuilder();
    for (char ch : s.toCharArray()) {
        int len = sb.length();
        if (len > 0 && sb.charAt(len - 1) == ch)
            sb.deleteCharAt(len - 1);
        else
            sb.append(ch);
    }
    return sb.length() == 0 ? "Empty String" : sb.toString();
}
