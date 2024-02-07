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
     * fontName, fontSize, fontAngle - private fields that update when user use ChooseFontPanel
     * @see ChooseFontPanel
     * @see #fontList
     * @see #fontTypeList
     * @see #fontSizeList
     */
    private static String fontName = "Agency FB";
    private static int fontSize = 12;
    private static int fontAngle = 0;

    private static Panel chooseFontPanel;
    private static List fontList;
    private static List fontTypeList;
    private static List fontSizeList;

    /**
     * Getter that returns all 3 awt.List that ChooseFontPanel creates
     * @return List array that contains fontList, fontTypeList, fontSizeList
     * @see #fontList
     * @see #fontTypeList
     * @see #fontSizeList
     */

    public static Panel getFontPanel(){
        return chooseFontPanel;
    }

    public static Font getFont(){
        return new Font(fontName, fontAngle, fontSize);
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
        //chooseFontPanel.setSize(MainWindow.getWidth(),MainWindow.getHeight()/3);

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
        fontList.addActionListener(e -> {
            fontName = fontList.getSelectedItem();
            Font chosenFont = new Font(fontName,fontAngle,fontSize);
            MainWindow.setFont(chosenFont);
            System.out.println(chosenFont.getFontName());
        });

        fontTypeList = new List(3,false);
        fontTypeList.add("Plain");
        fontTypeList.add("Bold");
        fontTypeList.add("Italic");
        fontTypeList.select(0);
        fontTypeList.addActionListener(e -> {
            fontAngle = fontTypeList.getSelectedIndex();
            Font chosenFont = new Font(fontName,fontAngle,fontSize);
            MainWindow.setFont(chosenFont);
        });

        fontSizeList = new List(40,false);
        for(int i=2;i<=80;i+=2){
            fontSizeList.add(String.valueOf(i));
        }
        fontSizeList.select(5);

        fontSizeList.addActionListener(e -> {
            fontSize = Integer.parseInt(fontSizeList.getSelectedItem());
            Font chosenFont = new Font(fontName,fontAngle,fontSize);
            MainWindow.setFont(chosenFont);
        });
        chooseFontPanel.add(fontList);
        chooseFontPanel.add(fontTypeList);
        chooseFontPanel.add(fontSizeList);
    }

}
