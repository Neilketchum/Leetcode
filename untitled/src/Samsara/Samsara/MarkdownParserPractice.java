package Samsara;

public class MarkdownParserPractice {
    public static StringBuilder processheadings(String l, StringBuilder result) {
        int count = 0;
        for (int i = 0; i < l.length(); i++) {
            if (l.charAt(i) == '#') {
                count++;
            }
        }
        result.append("<h" + String.valueOf(count) + ">" + l.substring(count) + "</h" + String.valueOf(count) + ">");

        return result;
    }

    public static String handleDel(String text) {
        return text.replaceAll("~~(.*?)~~", "<del>$1</del>");
    }

    public static int getCurrentListLevel(String line) {
        int level = 0;
        while (level < line.length() && line.charAt(level) == '*') {
            level++;
        }
        return level;
    }

    public static String parseHtml(String input) {
        String[] paragraphs = input.split("\n\n");
        input = handleDel(input);
        StringBuilder result = new StringBuilder();
        for (String paragraph : paragraphs) {
            String[] line = paragraph.split("\n");
            boolean paragraphStarted = false; // Track if a paragraph has started
            boolean isBlockQuote = false; // Track if we are inside a blockquote
            String currentListType = null;
            boolean insideList = false;
            for (String l : line) {
                if (l.startsWith("#")) {
                    result = processheadings(l, result);
                    continue;
                }
               
                if (l.startsWith("*") || l.matches("^\\d+\\.")) {
                    currentListType = l.startsWith("*") ? "ul" : "ol";
                    if (!insideList) {
                        result.append("<" + currentListType + ">");
                        insideList = true;
                    }
                    result.append("<li>" + l.substring(2) + "</li>");
                } else {
                    if (paragraphStarted && !l.startsWith("#")) {
                        result.append("</br>");
                    }
                    if (!paragraphStarted) {
                        result.append("<p>");
                        paragraphStarted = true;
                    }
                    if (l.startsWith(">")) {
                        if (!isBlockQuote) {
                            result.append("<blockquote>");
                            isBlockQuote = true;
                        }
                        result.append(l.substring(2));
                    }else{
                        if(isBlockQuote){
                            result.append("</blockquote>");
                            isBlockQuote = false;
                        }
                        result.append(l);
                    }
                }
            }
            if (isBlockQuote) {
                result.append("</blockquote>");
            }
            if (insideList) {
                result.append("</" + currentListType + ">");
            }
            if (paragraphStarted) {
                result.append("</p>");
            }
        }

    return result.toString();

    }

    public static void main(String[] args) {
        String input = "This is a paragraph with a soft\n"
                + "line break.\n\n" + "* Item 1 in a list\n"
                + "* Item 2 in a list\n" + "* Item 3 in a list\n\n"
                + "1. First ordered item\n" + "2. Second ordered item\n"
                + "3. Third ordered item\n\n" + "> Some text that\n" +
                "> is in a\n" + "> block quote.\n\n"
                + "This is another paragraph with a ~~strikethrough~~ word.\n"
                + "# Heading 1\n\n"
                + "## Heading 2\n\n"
                + "### Heading 3\n\n";

        // System.out.println(parseHtml(input););

        System.out.println(parseHtml(input));
    }
}