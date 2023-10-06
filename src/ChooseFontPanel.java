import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class creates a Panel which contains 3 awt.List components
 * That lists set up awt.Font for the TextPanel class
 * @see TextPanel
 * @since 1.0
 * @author NVPEB
 */
public class ChooseFontPanel{
    private static String fontName = "Agency FB";
    private static int fontSize = 12;
    private static int fontAngle = 0;
    private static Font chosenFont = new Font(fontName,fontAngle,fontSize);
    private static List fontList;
    private static List fontTypeList;
    private static List fontSizeList;
    public static List[] getFontPanel(){
        return new List[] {fontList,fontTypeList,fontSizeList};
    }

    public static List getFontList(){
        return fontList;
    }
    public static List getFontTypeList(){
        return fontTypeList;
    }
    public static List getFontSizeList(){
        return fontSizeList;
    }
    public static Font getFont(){
        return chosenFont;
    }
    ChooseFontPanel() {

        fontList = new List(267,false);
        String fontArray[] =
                GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for(String item : fontArray) fontList.add(item);

        fontList.setBounds(10,
                MainWindow.getHeight()/3,
                MainWindow.getWidth()/3,
                MainWindow.getHeight()/3
        );
        fontList.select(0);
        fontList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.print(fontName+"->");
                fontName = fontList.getSelectedItem();
                chosenFont = new Font(fontName,fontAngle,fontSize);
                MainWindow.setFont(chosenFont);

                //System.out.println(fontName);
                //System.out.println(chosenfont.getFontName());
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
                //System.out.print(fontAngle+"->");
                fontAngle = fontTypeList.getSelectedIndex();
                chosenFont = new Font(fontName,fontAngle,fontSize);
                MainWindow.setFont(chosenFont);
                //System.out.println(fontAngle);

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
                //System.out.println(fontSizeList.getSelectedItem());
                //System.out.print(fontSize+"->");
                fontSize = Integer.parseInt(fontSizeList.getSelectedItem());
                chosenFont = new Font(fontName,fontAngle,fontSize);
                MainWindow.setFont(chosenFont);
                //System.out.println(fontSize);
            }
        });
    }

}
