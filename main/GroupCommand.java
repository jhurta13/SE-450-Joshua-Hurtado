package main;

import java.io.IOException;
import java.util.ArrayList;

public class GroupCommand implements ICommand,IUndoable {

    //GroupList includes both individual shapes and grouped shapes
    public static ArrayList<ArrayList<ShapeCustom>> groupslist = new ArrayList<ArrayList<ShapeCustom>>();

    GroupDrawer groupDrawer = new GroupDrawer();

    ArrayList<ShapeCustom> tempGroup2 = new ArrayList<>();
    ArrayList<ShapeCustom> group = new ArrayList<>();


    @Override
    public void run() throws IOException, CloneNotSupportedException {

        ArrayList<ShapeCustom> group = new ArrayList<>();
        this.group= group;

        for (ArrayList<ShapeCustom> g : SelectCommand.selectGroupslist) {
            for(ShapeCustom s:g){
                group.add(s);
            }
        }
        groupslist.add(group);

        ArrayList <Object> tempList = new ArrayList<>();

        //add all items from grouplist to templist as shapecustom objects
        for ( ArrayList g:groupslist){
            for (Object s: g){
                tempList.add(s);
            }
        }
        for (ShapeCustom s : AddShapeCommand.shapeList) {
            if (!tempList.contains(s)) {
                ArrayList<ShapeCustom> tempGroup = new ArrayList<>();
                tempGroup.add(s);
                groupslist.add(tempGroup);
            }
        }

        groupDrawer.draw();
        CommandHistory.add(this);


    }



    @Override
    public void undo() {
        this.group = group;
        groupslist.remove(group);

    }

    @Override
    public void redo() {
        this.group = group;
        groupslist.add(group);

    }




}

