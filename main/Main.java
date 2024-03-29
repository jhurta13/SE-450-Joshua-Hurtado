//Select Class used for all cases
//ShapeList replaced with

package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.PaintCanvasBase;
import view.interfaces.IUiModule;


public class Main {
    public static ApplicationState applicationState;
    public static void main(String[] args){
        PaintCanvasBase paintCanvas = new PaintCanvas();
        paintCanvas.addMouseListener(new ClickHandler(paintCanvas));

        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        applicationState=appState;
        IJPaintController controller = new JPaintController(uiModule, appState);
        controller.setup();


        try {

            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
