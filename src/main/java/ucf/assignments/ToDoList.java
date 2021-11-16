package ucf.assignments;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ToDoList {


    private List <Items> items;


    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }


    public ToDoList() {
        items = new ArrayList<Items>();
    }

    public void removeItem (String itemName){

        for (Items o : getItems())
            if (o.getDescription().equals(itemName))
                items.remove(o);
    }

    public void viewList (ListView listView, int i){

        List<String> descriptionItems = new ArrayList<>();
        ListProperty<String> listProperty = new SimpleListProperty<>();

        listProperty.set(FXCollections.observableArrayList(descriptionItems));


        for (Items o : getItems()){

            if (i == 1)
                descriptionItems.add(o.getDescription());

            if (i == 2)
                    if (o.isCompleted())
                        descriptionItems.add(o.getDescription());

            if (i == 3)
                if (!(o.isCompleted()))
                    descriptionItems.add(o.getDescription());

        }
        listView.itemsProperty().bind(listProperty);
        listProperty.set(FXCollections.observableArrayList(descriptionItems));


    }

    public void storeList () throws IOException {


        File file = new File ("ToDoList.txt");



        FileWriter myWriter = new FileWriter(file, false);
        for (Items o : getItems())
            myWriter.write(o.getDescription()+"\n"+o.getDueDate()+"\n"+o.isCompleted()+"\n");

        myWriter.close();

    }

    public void loadList (){

            File f = new File("C:\\Users\\geena\\IdeaProjects\\vandijk-cop3330-assignment4part2\\ToDoList.txt");

            if (items.size() > 0)
                items.clear();

            try{
                Scanner scanner = new Scanner(f);
                while (scanner.hasNextLine()) {

                    Items newItem = new Items();

                    for (int i = 0; i < 3; i++){
                        String line = scanner.nextLine();
                        if (i == 0)
                            newItem.setDescription(line);
                        if (i == 1)
                            newItem.setDueDate(line);
                        if (i == 2)
                            if (line.equals("false"))
                                newItem.setCompleted(false);
                            else
                                newItem.setCompleted(true);
                    }
                    items.add(newItem);
                }
                scanner.close();
            } catch (FileNotFoundException | ParseException e) {
                e.printStackTrace();
            }

    }



}

