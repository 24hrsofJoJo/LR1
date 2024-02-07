import java.awt.*;


/**
 * Creates a frame (awt.Frame) that contains panels than let user set up awt.Font for the TextPanel
 * @see ChooseColorPanel
 * @see ChooseFontPanel
 * @see TextPanel
 */
public class MainWindow {

    private static Frame main_window;
    private static int height;
    private static int width;

    public static int getHeight(){
        return height;
    }
    public static int getWidth(){
        return width;
    }

    public static void setHeight(int val){
        height = val;
    }
    public static void setWidth(int val){
        width = val;
    }

    //TODO: Заменить label на TextPanel в методе setFont
    public static void setFont(Font font){
        main_window.revalidate();
    }
    public static void rep(){


    }
    /**
     * <p>Creates window width X height</p>
     * This window contains ChooseFontPanel, ChooseColorPanel, TextPanel
     * @param width width of the window (int)
     * @param height height of the window (int)
     * @see ChooseColorPanel
     * @see ChooseFontPanel
     * @see TextPanel
     */
    public static void setMainWindow(int width, int height){

        main_window = new Frame();
        new TextPanel();

        setHeight(height);
        setWidth(width);

        main_window.setSize(width, height);
        main_window.setLayout(new GridLayout(3,0));

        ChooseFontPanel.createChooseFontPanel();
        ChooseColorPanel.createChooseColorPanel();

        main_window.add(ChooseColorPanel.getChooseColorPanel());
        main_window.add(ChooseFontPanel.getFontPanel());
        main_window.add(TextPanel.getGraph());

        main_window.setVisible(true);
    }
}
