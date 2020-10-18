    /**
     * @param origin         需要被隐藏的字符串
     * @param retainFrontLen 保留字符串前几位
     * @param retainAfterLen 保留字符串后几位
     * @param symbol         使用的隐藏符号
     * @param symbolCount    隐藏符号个数
     * @return 隐藏后的字符串
     */
    public static String stringHide(String origin, int retainFrontLen,
                                    int retainAfterLen, String symbol, int symbolCount) {
        if (origin == null || origin.length() == 0) {
            return "";
        }
        char[] chars = origin.toCharArray();
        int len;
        if ((len = origin.length()) <= 2) {
            return chars[0] + generateSymbol(symbol, symbolCount);
        }
        if (retainFrontLen + retainAfterLen >= len) {
            return chars[0] + generateSymbol(symbol, symbolCount) + chars[len - 1];
        }
        return origin.substring(0, retainFrontLen) +
                generateSymbol(symbol, symbolCount) + origin.substring(len - retainAfterLen);
    }

    // retain first and last character, replace the rest with default symbol *
    public static String defaultHide(String origin) {
        return stringHide(origin, 1, 1, "*", 1);
    }

    // replace four character with symbol * in the center
    public static String phoneHide(String phone) {
        return stringHide(phone, 3, 4, "*", 4);
    }

    public static String generateSymbol(String symbol, int count) {
        if (symbol == null || symbol.length() == 0) {
            symbol = "*";
        }
        if (count <= 0) {
            return symbol;
        }
        StringBuilder sb = new StringBuilder();
        while (count > 0) {
            sb.append(symbol);
            count--;
        }
        return sb.toString();
    }
