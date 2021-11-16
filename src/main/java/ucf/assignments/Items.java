package ucf.assignments;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Items{
    private String description;
    private Date dueDate;
    private boolean completed;

    public Items(String description, Date dueDate, boolean completed) {
        this.description = description;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    public Items(String description, String dueDate, boolean completed) throws ParseException {
        this.description = description;
        DateFormat f = new SimpleDateFormat("yyyy-mm-dd");
        this.dueDate = f.parse(dueDate);
        this.completed = completed;
    }

    public Items(){
        description = "";
        dueDate = null;
        completed = false;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        String dateToString = df.format(dueDate);
        return dateToString;
    }

    public void setDueDate(String dueDate) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        this.dueDate = (Date)formatter.parse(dueDate);
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


    public void editDescription (String newName){
        //change description to newName
        setDescription(newName);
    }

    public void editDueDate (String newDate) throws ParseException {
        //change dueDate to newDate
         setDueDate(newDate);
    }

    public void completed (){
        // set completed to true
         setCompleted(true);
    }

}