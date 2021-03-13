package controller;
import main.*;
import model.interfaces.IApplicationState;
import view.EventName;
import view.interfaces.IEventCallback;
import view.interfaces.IUiModule;

import java.io.IOException;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, () -> applicationState.setActiveStartAndEndPointMode());

        IEventCallback callback = new IEventCallback() {
            @Override
            public void run() {

                ICommand cmd = new UndoCommand();
                try {
                    cmd.run();
                } catch (IOException | CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        };

        uiModule.addEvent(EventName.UNDO,callback);

        IEventCallback callback2 = new IEventCallback() {
            @Override
            public void run() {

                ICommand cmd = new RedoCommand();
                try {
                    cmd.run();
                } catch (IOException | CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        };

        uiModule.addEvent(EventName.REDO,callback2);

        IEventCallback callback3 = new IEventCallback() {
            @Override
            public void run() {
                ICommand cmd = new CopyCommand();
                try {
                    cmd.run();
                } catch (IOException | CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        };
        uiModule.addEvent(EventName.COPY,callback3);

        IEventCallback callback4 = new IEventCallback() {
            @Override
            public void run() {
                ICommand cmd = new PasteCommand();
                try {
                    cmd.run();
                } catch (IOException | CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        };
        uiModule.addEvent(EventName.PASTE,callback4);

        IEventCallback callback5 = new IEventCallback() {
            @Override
            public void run() {
                ICommand cmd = new DeleteCommand();
                try {
                    cmd.run();
                } catch (IOException | CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        };
        uiModule.addEvent(EventName.DELETE,callback5);

        IEventCallback callback6 = new IEventCallback() {

            @Override
        public void run() {
            ICommand cmd = new GroupCommand();
            try {
                cmd.run();
            } catch (IOException | CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
    };
        uiModule.addEvent(EventName.GROUP,callback6);

        IEventCallback callback7 = new IEventCallback() {

            @Override
            public void run() {
                ICommand cmd = new UngroupCommand();
                try {
                    cmd.run();
                } catch (IOException | CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        };
        uiModule.addEvent(EventName.UNGROUP,callback7);



    }
}
