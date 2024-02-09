import java.awt.*;

/**
 * <p>
 * This class creates a Panel which contains 3 awt.List components.
 * </p>
 * That lists set up awt.Font for the TextPanel class
 * @see ChooseColorPanel
 * @see TextPanel
 */
public class ChooseFontPanel {

    /**
     * Private field that updates font family of TextPanel (default - Agency FB)
     * @see TextPanel
     * @see #fontSize
     * @see #fontAngle
     */
    private static String fontName = "Agency FB";

    /**
     * Private field that updates font size of TextPanel
     * @see TextPanel
     * @see #fontName
     * @see #fontAngle
     */
    private static int fontSize = 12;

    /**
     * fontAngle - private field that updates font angle (Plain, Bold, Italic) of TextPanel
     * @see TextPanel
     * @see #fontName
     * @see #fontSize
     */
    private static int fontAngle = 0;

    private static Panel chooseFontPanel;
    private static List fontList;
    private static List fontTypeList;
    private static List fontSizeList;

    /**
     * @return List array that contains fontList, fontTypeList, fontSizeList
     * @see #fontList
     * @see #fontTypeList
     * @see #fontSizeList
     */
    public static List[] getFontLists(){
        return new List[] {fontList,fontTypeList,fontSizeList,};
    }

    public static Panel getFontPanel(){
        return chooseFontPanel;
    }


    public static Font getFont(){
        switch (fontAngle){
            case 1-> {return new Font(fontName, Font.BOLD, fontSize);}
            case 2-> {return new Font(fontName, Font.ITALIC, fontSize);}
            default -> {return new Font(fontName, Font.PLAIN, fontSize);}
        }
    }

    /**
     * <p>Creates panel (ChooseFontPanel) that contains 3 lists (awt.List)</p>
     * Those lists let user to customize text's (TextPanel) font
     * @see #fontList
     * @see #fontTypeList
     * @see #fontSizeList
     */
    public static void createChooseFontPanel() {
        chooseFontPanel = new Panel();
        chooseFontPanel.setLayout(new GridLayout());

        chooseFontPanel.setLocation(
                10,
                MainWindow.getHeight()/3
        );
        fontList = new List(267,false);
        String[] fontArray =
                GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String item : fontArray)
            fontList.add(item);

        fontList.select(0);
        fontList.addActionListener(e -> fontName = fontList.getSelectedItem());

        fontTypeList = new List(3,false);
        fontTypeList.add("Plain");
        fontTypeList.add("Bold");
        fontTypeList.add("Italic");
        fontTypeList.select(0);
        fontTypeList.addActionListener(e -> fontAngle = fontTypeList.getSelectedIndex());

        fontSizeList = new List(40,false);
        for(int i=2;i<=80;i+=2){
            fontSizeList.add(String.valueOf(i));
        }
        fontSizeList.select(5);

        fontSizeList.addActionListener(e -> fontSize = Integer.parseInt(fontSizeList.getSelectedItem()));
        chooseFontPanel.add(fontList);
        chooseFontPanel.add(fontTypeList);
        chooseFontPanel.add(fontSizeList);
    }

}
