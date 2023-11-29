import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class CalendarEvent {
    private GregorianCalendar dateTime;
    private String name;

    public CalendarEvent(GregorianCalendar dateTime, String name) {
        this.dateTime = dateTime;
        this.name = name;
    }

    public GregorianCalendar getDateTime() {
        return dateTime;
    }

    public void setDateTime(GregorianCalendar dateTime) {
        this.dateTime = dateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        GregorianCalendar temp = this.getDateTime();

        String dateString = temp.get(Calendar.DAY_OF_MONTH) + "/" + temp.get(Calendar.MONTH) + "/" + temp.get(Calendar.YEAR);
        String timeString = temp.get(Calendar.HOUR) + ":" + temp.get(Calendar.MINUTE) + ":" + temp.get(Calendar.SECOND);

        return this.getName() + ". Dia " + dateString + " às " + timeString + ".";
    }
}
