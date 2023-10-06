import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <p>
 * This class creates a Panel which contains 3 awt.List components.
 * </p>
 * That lists set up awt.Font for the TextPanel class
 */
public class ChooseFontPanel{
    /**
     * fontName, fontSize, fontAngle - private fields that update when user use ChooseFontPanel
     * @see ChooseFontPanel
     */
    private static String fontName = "Agency FB";
    private static int fontSize = 12;
    private static int fontAngle = 0;

    /**
     * awt.List's to update font's name, angle and size
     *
     */
    private static List fontList;
    private static List fontTypeList;
    private static List fontSizeList;

    /**
     * Getter that returns all 3 awt.List that ChooseFontPanel makes
     * @return List array that contains fontList, fontTypeList, fontSizeList
     * @see ChooseFontPanel
     */
    public static List[] getFontPanel(){
        return new List[] {fontList,fontTypeList,fontSizeList};
    }

    public static Font getFont(){
        return new Font(fontName, fontAngle, fontSize);
    }

    ChooseFontPanel() {
        fontList = new List(267,false);
        String[] fontArray =
                GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String item : fontArray)
            fontList.add(item);

        fontList.setBounds(10,
                MainWindow.getHeight()/3,
                MainWindow.getWidth()/3,
                MainWindow.getHeight()/3
        );
        fontList.select(0);
        fontList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fontName = fontList.getSelectedItem();
                Font chosenFont = new Font(fontName,fontAngle,fontSize);
                MainWindow.setFont(chosenFont);
            }
        });

        fontTypeList = new List(3,false);
        fontTypeList.add("Plain");
        fontTypeList.add("Bold");
        fontTypeList.add("Italic");
        fontTypeList.setBounds(MainWindow.getWidth()/3+10,
                MainWindow.getHeight()/3,
                MainWindow.getWidth()/3,
                MainWindow.getHeight()/3
        );
        fontTypeList.select(0);
        fontTypeList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fontAngle = fontTypeList.getSelectedIndex();
                Font chosenFont = new Font(fontName,fontAngle,fontSize);
                MainWindow.setFont(chosenFont);
            }
        });

        fontSizeList = new List(40,false);
        for(int i=2;i<=80;i+=2){
            fontSizeList.add(String.valueOf(i));
        }
        fontSizeList.setBounds(MainWindow.getWidth()/3*2+10,
                MainWindow.getHeight()/3,
                MainWindow.getWidth()/3-15,
                MainWindow.getHeight()/3
        );
        fontSizeList.select(5);

        fontSizeList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fontSize = Integer.parseInt(fontSizeList.getSelectedItem());
                Font chosenFont = new Font(fontName,fontAngle,fontSize);
                MainWindow.setFont(chosenFont);
            }
        });
    }

}
