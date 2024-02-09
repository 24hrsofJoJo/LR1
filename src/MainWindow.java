import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/**
 * Creates a frame (awt.Frame) that contains panels than let user set up awt.Font for the TextPanel
 * @see ChooseColorPanel
 * @see ChooseFontPanel
 * @see TextPanel
 * @see Frame
 */
public class MainWindow {

    private static int height;
    private static int width;

    public static int getWidth() {
        return width;
    }
    public static int getHeight(){
        return height;
    }

    public static void setHeight(int val){
        height = val;
    }
    public static void setWidth(int val){
        width = val;
    }

    /**
     * <p>Creates awt.Frame width X height</p>
     * This window contains ChooseFontPanel, ChooseColorPanel, TextPanel
     * @param width width of the window (int)
     * @param height height of the window (int)
     * @see ChooseColorPanel
     * @see ChooseFontPanel
     * @see TextPanel
     * @see Frame
     */
    public static void setMainWindow(int width, int height){

        Frame main_window = new Frame();
        main_window.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }
        });

        setHeight(height);
        setWidth(width);

        main_window.setSize(width, height);
        main_window.setLayout(new GridLayout(3,0));

        ChooseFontPanel.createChooseFontPanel();
        ChooseColorPanel.createChooseColorPanel();
        TextPanel.createTextPanel();

        main_window.add(ChooseColorPanel.getChooseColorPanel());
        main_window.add(ChooseFontPanel.getFontPanel());
        main_window.add(TextPanel.getTextPanel());

        main_window.setVisible(true);
    }
}
