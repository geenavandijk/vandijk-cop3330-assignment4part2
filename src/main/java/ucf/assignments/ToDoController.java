package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.text.ParseException;

public class ToDoController {


    private ToDoList data;

    public ToDoController() {
        data = new ToDoList();
    }

    @FXML
    private TextField addItemDescription;

    @FXML
    private DatePicker addItemDueDate;

    @FXML
    private TextField descriptionItem;

    @FXML
    private DatePicker editDate;

    @FXML
    private ListView<Items> listView;

    @FXML
    private Menu loadList;

    @FXML
    private TextField searchItem;


    @FXML
    void completedClicked(ActionEvent event) {
        /* Search through items and find description = searchItem
         * completed = true */

       for( Items o : data.getItems()){
           if (o.getDescription().equals(searchItem.getText()))
               o.setCompleted(true);
       }
       searchItem.clear();


    }

    @FXML
    void descriptionItemClicked(ActionEvent event) {
        /* Search through items and find description = searchItem
         * update description = descriptionItem */


        for (Items q : data.getItems()){
            if (q.getDescription().equals(searchItem.getText()))
                q.setDescription(descriptionItem.getText());
        }

        searchItem.clear();

    }

    @FXML
    void editDateClicked(ActionEvent event) throws ParseException {
        /* Search through items and find description = searchItem
         * update dueDate = editDate */

        for (Items q : data.getItems()){
            if (q.getDescription().equals(searchItem.getText()))
                q.setDueDate(editDate.getPromptText());
        }
        searchItem.clear();

    }

    @FXML
    void editDeleteItemClicked(ActionEvent event) {
        /* Search through items and find description = searchItem
         * delete item */

        data.removeItem(searchItem.getText());
        searchItem.clear();

    }

    @FXML
    void addItemClicked(ActionEvent event) throws ParseException {
        /* create new item if item does not exist
         * description = addItemDescription
         * duedate = addItemDueDate*/

        for (Items o : data.getItems())
            if (o.getDescription().equals(addItemDescription.getText())) {
                return;
                //Item already exists
            }

        Items newItem = new Items();
        data.getItems().add(newItem);
        newItem.setDescription(addItemDescription.getText());
        newItem.setDueDate(addItemDueDate.getValue().toString());

        addItemDescription.clear();

    }


    @FXML
    void itemIncompleteClicked(ActionEvent event) {
        /* Search through items and find description = searchItem
         * completed = false */

        for( Items o : data.getItems()){
            if (o.getDescription().equals(searchItem.getText())) {
                o.setCompleted(false);
            }
        }
        searchItem.clear();

    }

    @FXML
    void loadListClicked(ActionEvent event) {
        data.loadList();
    }

    @FXML
    void storeListClicked(ActionEvent event) {

        //Call store list
        try {
            data.storeList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void viewAllItemsClicked(ActionEvent event) {

       //call viewList
        data.viewList(listView, 1);


    }

    @FXML
    void viewCompletedItemsClicked(ActionEvent event) {

        /*call viewList*/
       data.viewList(listView,2);
    }

    @FXML
    void viewIncompleteClicked(ActionEvent event) {

        //call viewList
        data.viewList(listView,3);
    }

}


