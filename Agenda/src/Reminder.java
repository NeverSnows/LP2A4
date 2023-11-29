import java.util.GregorianCalendar;

public class Reminder extends CalendarEvent{
    private boolean isRepeating;
    public Reminder(GregorianCalendar dateTime, String name, boolean isRepeating) {
        super(dateTime, name);
        this.isRepeating = isRepeating;
    }

    @Override
    public String toString() {
        String repeating;
        if (this.isRepeating){
            repeating = "Sim";
        }else{
            repeating = "Não";
        }
        return super.toString() + "Repetindo: " + repeating;
    }

    public boolean isRepeating() {
        return isRepeating;
    }

    public void setRepeating(boolean repeating) {
        isRepeating = repeating;
    }

    /*
    Sim, isso é basicamente um bloco de notas, ja q n tem alarmes efetivos e eu n to afim de implementar isso.
    Fé.
     */
}
