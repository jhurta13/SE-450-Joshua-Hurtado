package main;

import java.io.IOException;
import java.util.ArrayList;

public class UngroupCommand implements ICommand,IUndoable {

    public static ArrayList<ArrayList<ShapeCustom>> groupslist = new ArrayList<ArrayList<ShapeCustom>>();
    ArrayList<ShapeCustom> g;

    GroupDrawer groupDrawer = new GroupDrawer();

    @Override
    public void run() throws IOException, CloneNotSupportedException {
        for ( ArrayList<ShapeCustom> g :SelectCommand.selectGroupslist2){
            for(ShapeCustom s : g){
                this.g = g;
                GroupCommand.groupslist.remove(g);


            }
        }
        CommandHistory.add(this);


    }



    @Override
    public void undo() {
        this.g = g;
        GroupCommand.groupslist.add(g);

    }

    @Override
    public void redo() {
        this.g = g;
        GroupCommand.groupslist.remove(g);

    }




}

