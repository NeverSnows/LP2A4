import java.util.Calendar;
import java.util.GregorianCalendar;

public class Task extends CalendarEvent{
    private boolean isCompleted;
    public Task(GregorianCalendar dateTime, String name, boolean isCompleted){
        super(dateTime, name);
        this.isCompleted = isCompleted;
    }

    @Override
    public String toString() {
        String currentState;
        if(this.isCompleted){
            currentState = "completa";
        }else{
            currentState = "incompleta";
        }
        return super.toString() + " Estado atual: " + currentState + ".";
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
