import java.util.GregorianCalendar;

public class Event extends CalendarEvent{
    private String location;
    public Event(GregorianCalendar dateTime, String name, String location) {
        super(dateTime, name);
        this.location = location;
    }

    @Override
    public String toString() {
        return super.toString() + " Local: " + this.location + ".";
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
