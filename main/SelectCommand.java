package main;

import java.io.IOException;
import java.util.ArrayList;



public class SelectCommand implements ICommand,IUndoable {


    private ShapeCustom shape;



    OutlineDrawer outlineDrawer = new OutlineDrawer();
    GroupOutlineDrawer groupOutlineDrawer = new GroupOutlineDrawer();
    GroupDrawer groupDrawer = new GroupDrawer();

    public static ArrayList<ArrayList<ShapeCustom>> selectGroupslist = new ArrayList<ArrayList<ShapeCustom>>();

    public static ArrayList<ArrayList<ShapeCustom>> groupOutlinelist = new ArrayList<ArrayList<ShapeCustom>>();

    //for group outlines
    public static ArrayList<ArrayList<ShapeCustom>> groupOutlinelist2 = new ArrayList<ArrayList<ShapeCustom>>();
    public static ArrayList<ArrayList<ShapeCustom>> selectGroupslist2 = new ArrayList<ArrayList<ShapeCustom>>();




    SelectCommand(ShapeCustom shape){
        this.shape = shape;
    }


    @Override
    public void run() throws IOException, CloneNotSupportedException {

        selectGroupslist.clear();
        groupOutlinelist.clear();
        groupOutlinelist2.clear();
        selectGroupslist2.clear();


        groupDrawer.draw();
        ArrayList <Object> tempList = new ArrayList<>();

        //create Temp List to hold the shapes that are part of groups
        for ( ArrayList g:  GroupCommand.groupslist){
            for (Object s: g){
                if(g.size()>1){
                    tempList.add(s);

                }
            }
        }

        for (ArrayList<ShapeCustom> g : GroupCommand.groupslist) {

                if(g.size()>1) {
                    for(ShapeCustom s : g){
                        if(shape.x < s.x2 && shape.x2 > s.x && shape.y < s.y2 && shape.y2 > s.y){
                            selectGroupslist2.add(g);

                    }


                    }
                }
                else if (g.size()==1){
                    for(ShapeCustom s : g){
                        //if templist does not contain any shape
                        if (!tempList.contains(s)){
                            if (shape.x < s.x2 && shape.x2 > s.x && shape.y < s.y2 && shape.y2 > s.y) {
                                ArrayList<ShapeCustom> group = new ArrayList<>();
                                group.add(s);
                                selectGroupslist.add(group);

                            }
                        }else {
                            selectGroupslist.add(g);
                        }

                }
        }
    }
        for(ArrayList<ShapeCustom> g :selectGroupslist){
                groupOutlinelist.add(g);

        }
        for(ArrayList<ShapeCustom> g :selectGroupslist2){
            groupOutlinelist2.add(g);

        }

        outlineDrawer.draw();
        groupOutlineDrawer.draw();



    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {


    }
}
//if shape already in groupList, then, do not add
//add everything with more than one shape, then, if not in list already, add the rest