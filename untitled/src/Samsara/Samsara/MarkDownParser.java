package Samsara;

public class MarkDownParser {
    public static String handleDel(String text){
       return text.replaceAll("~~(.*?)~~","<del>$1</del>" );
    }
    
    public static StringBuilder processheadings(String l,StringBuilder result){
        int level = 0;
        while(level< l.length() && l.charAt(level) == '#'){
            level++;
        }
        if(level == 1){
            result.append("<h1>");
            result.append(l.substring(level));
            result.append("</h1>");
        }
        if(level == 2){
            result.append("<h2>");
            result.append(l.substring(level));
            result.append("</h2>"); 
        }
        if(level == 3){
            result.append("<h3>");
            result.append(l.substring(level));
            result.append("</h3>");
        }
        if(level == 4){
            result.append("<h4>");
            result.append(l.substring(level));
            result.append("</h4>");
        }
        return result;
    }

    // Hn elper method to replace **text** with <strong>text</strong> without regex
    public static String replaceBoldTextWithoutRegex(String text) {
        StringBuilder result = new StringBuilder();
        text = handleDel(text);
        String[] paragraphs = text.split("\n\n");
        
        for (String paragraph : paragraphs) {
            String[] line = paragraph.split("\n");
            boolean paragraphStarted = false; // Track if a paragraph has started
            boolean isBlockQuote = false; // Track if we are inside a blockquote
            int currentListLevel = 0; // Track current list level
     
            for (String l : line) {
                if (l.startsWith("#")) {
                    result = processheadings(l, result);
                    continue;
                }
                if (!paragraphStarted && !l.startsWith("#")) {
                    result.append("<p>");
                    paragraphStarted = true;
                }

                int indentationLevel = 0;
                while (indentationLevel < l.length() && l.charAt(indentationLevel) == ' ') {
                    indentationLevel++;
                }
                int listLevel = indentationLevel / 2; // Assuming 2 spaces per level

                while (currentListLevel < listLevel) {
                    if (l.trim().startsWith("*")) {
                        result.append("<ul>");
                    } else if (l.trim().matches("^\\d+\\.\\s")) {
                        result.append("<ol>");
                    }
                    currentListLevel++;
                }
                while (currentListLevel > listLevel) {
                    if (l.trim().startsWith("*")) {
                        result.append("</ul>");
                    } else if (l.trim().matches("^\\d+\\.\\s")) {
                        result.append("</ol>");
                    }
                    currentListLevel--;
                }

                if (l.trim().startsWith("*")) {
                    result.append("<li>" + l.trim().substring(2) + "</li>");
                } else if (l.trim().matches("^\\d+\\.\\s")) {
                    result.append("<li>" + l.trim().substring(l.trim().indexOf(' ') + 1) + "</li>");
                } else {
                    if (paragraphStarted && !l.startsWith("#")) {
                        result.append("</br>");
                    }
                    if (l.startsWith("> ")) {
                        if (!isBlockQuote) {
                            result.append("<blockquote>");
                            isBlockQuote = true;
                        }
                        result.append(l.substring(2));
                    } else {
                        if (isBlockQuote) {
                            result.append("</blockquote>");
                            isBlockQuote = false;
                        }
                        result.append(l);
                    }
                }
            }
            while (currentListLevel > 0) {
                result.append("</ul>");
                currentListLevel--;
            }
            if (isBlockQuote) {
                result.append("</blockquote>"); // Close blockquote if still open
            }
            if (paragraphStarted) {
                result.append("</p>"); // Close paragraph if it was started
            }
        }
        System.out.println(result.toString());
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
        replaceBoldTextWithoutRegex(input);
    
    }
}
