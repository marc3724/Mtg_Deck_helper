import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;

public class Main {
    public static void main(String[] args) {
        try {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            String clipboardContent = (String) clipboard.getData(DataFlavor.stringFlavor);

            // Process the clipboard content as needed
            System.out.println("Clipboard content:");
            System.out.println(clipboardContent);

            // Split the clipboard content into lines
            String[] lines = clipboardContent.split("\n");

            // Perform your desired operations on the lines
            StringBuilder modifiedContent = new StringBuilder();

            // Example: Print the modified lines
            for (String line : lines) {
                int indexOfParenthesis = line.indexOf("(");
                if (indexOfParenthesis != -1) {
                    line = line.substring(0, indexOfParenthesis) + "\n";
                }
                System.out.print(line);
                modifiedContent.append(line);
            }

            // Set modified content to clipboard
            StringSelection selection = new StringSelection(modifiedContent.toString());
            clipboard.setContents(selection, selection);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}