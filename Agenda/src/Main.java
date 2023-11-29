import java.util.*;

public class Main {
    private static int actionType;
    private static int calendarEventType;
    private static List<Task> tasks = new ArrayList<>();
    private static List<Event> events = new ArrayList<>();
    private static List<Reminder> reminders = new ArrayList<>();

    public static void main(String[] args) {
        testLists();

        System.out.println("Calendario Dario");

        do{
            System.out.println("Digite o número da opção desejada:");
            System.out.println("1 - Visualisar.");
            System.out.println("2 - Deletar.");
            System.out.println("3 - Criar.");
            System.out.println("0 - Sair.");

            actionType = getNextInt();
            switch(actionType){
                case 1 -> printViewWindow();
                case 2 -> printDeleteWindow();
                case 3 -> printCreateWindow();
                case 0 -> System.out.println("Adeus.");
                default -> System.out.println("\nEntrada invalida.\n");
            }
        }while(actionType != 0);
    }

    private static void printViewWindow(){
        do{
            printOptions("Visualisar");

            calendarEventType = getNextInt();
            System.out.println();

            switch (calendarEventType) {
                case 1 -> listCalendarEvent(tasks);
                case 2 -> listCalendarEvent(reminders);
                case 3 -> listCalendarEvent(events);
                case 0 -> System.out.println("Retornando...");
                default -> System.out.println("Entrada invalida.");
            }
            System.out.println();
        }while(calendarEventType != 0);
    }
    private static void printDeleteWindow(){
        do {
            printOptions("Deletar");

            calendarEventType = getNextInt();

            switch (calendarEventType) {
                case 1 -> deleteCalendarEvent("da Tarefa", tasks);
                case 2 -> deleteCalendarEvent("do Lembrete", reminders);
                case 3 -> deleteCalendarEvent("do Evento", events);
                case 0 -> System.out.println("Retornando...");
                default -> System.out.println("Entrada invalida.");
            }
        }while(calendarEventType != 0);
    }
    private static void printCreateWindow(){
        printOptions("Criar");
        calendarEventType = getNextInt();
        switch (calendarEventType){
            case 1 -> createTask();
            case 2 -> createReminder();
            case 3 -> createEvent();
            case 0 -> System.out.println("Retornando...");
            default -> System.out.println("Entrada invalida.");
        }
    }

    private static <T extends CalendarEvent> void listCalendarEvent(List<T> calendarEvents){
        int index = 1;
        for(CalendarEvent event : calendarEvents){
            System.out.println(index + " - " + event);
        }
    }
    private static void createTask(){
        System.out.println("Insira o nome da tarefa: ");
        String name = getNextString();
        System.out.println("Insira o dia da tarefa: ");
        int day = getNextInt();
        System.out.println("Insira o mês da tarefa: ");
        int month = getNextInt();
        System.out.println("Insira o ano da tarefa: ");
        int year = getNextInt();
        System.out.println("Insira a hora que ocorrera a tarefa: ");
        int hour = getNextInt();
        System.out.println("Insira o minuto que ocorrera a tarefa: ");
        int min = getNextInt();
        System.out.println("Digite 'S' se a tarefa estiver completa e 'N' se não estiver.");
        boolean isComplete = false;
        String complete = getNextString();
        if(Objects.equals(complete, "S")){ //Poderia ter uma confirmação aqui com um loop bonitinho pra saber se realmente foi digitado 'S' e 'N'? Poderia.
            isComplete = true;
        }

        //TODO estudar como o highlight de "Mês" no constructor de GregorianCalendar foi feito.
        Task task = new Task(new GregorianCalendar(year, month - 1, day, hour, min), name, isComplete);
        tasks.add(task);
    }
    private static void createReminder(){
        System.out.println("Insira o nome do lembrete: ");
        String name = getNextString();
        System.out.println("Insira o dia do lembrete: ");
        int day = getNextInt();
        System.out.println("Insira o mês do lembrete: ");
        int month = getNextInt();
        System.out.println("Insira o ano do lembrete: ");
        int year = getNextInt();
        System.out.println("Insira a hora que ocorrera o lembrete: ");
        int hour = getNextInt();
        System.out.println("Insira o minuto que ocorrera o lembrete: ");
        int min = getNextInt();
        System.out.println("Digite 'S' se o lembrete repetir e 'N' se não repetir.");
        boolean isRepeating = false;

        String repeat = getNextString();
        if(Objects.equals(repeat, "S")){
            isRepeating = true;
        }

        Reminder reminder = new Reminder(new GregorianCalendar(year, month - 1, day, hour, min), name, isRepeating);
        reminders.add(reminder);
    }
    private static void createEvent(){
        System.out.println("Insira o nome da evento: ");
        String name = getNextString();
        System.out.println("Insira o dia da evento: ");
        int day = getNextInt();
        System.out.println("Insira o mês da evento: ");
        int month = getNextInt();
        System.out.println("Insira o ano da evento: ");
        int year = getNextInt();
        System.out.println("Insira a hora que ocorrera a evento: ");
        int hour = getNextInt();
        System.out.println("Insira o minuto que ocorrera a evento: ");
        int min = getNextInt();
        System.out.println("Insira o local do evento: ");
        String location = getNextString();

        Event event = new Event(new GregorianCalendar(year, month - 1, day, hour, min), name, location);
        events.add(event);
    }
    private static <T extends CalendarEvent> void deleteCalendarEvent(String calendarEventName, List<T> calendarEvents){
        if(calendarEvents.isEmpty()){
            System.out.println("\nNão há nada para ser deletado.\n");
            return;
        }
        boolean success = false;
        System.out.println("Digite o número " + calendarEventName + " que deseja deletar: ");
        listCalendarEvent(calendarEvents);
        do{
            try{
                calendarEvents.remove(getNextInt() - 1);
                success = true;
            }catch(IndexOutOfBoundsException exception){
                System.out.println("Número invalido.");
            }
        }while(!success);
    }
    private static void printOptions(String action){
        System.out.println("Digite o número da opção desejada:");
        System.out.println("1 - " + action + " Tarefas.");
        System.out.println("2 - " + action + " Lembretes.");
        System.out.println("3 - " + action + " Eventos.");
        System.out.println("0 - Retornar.");
    }

    /**
     * This method isolates an instance of a "Scanner" so that every time a new input is requested, we make sure that the scanner buffer is empty.
     * @apiNote   Using the ".close()" method sometimes causes issues because reasons, so deleting the instance at the end of the call is the safest way to handle this scenario.
     * @return the next int on console.
     */
    private static int getNextInt(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    private static String getNextString(){
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    private static void testLists(){
        tasks.add(new Task(new GregorianCalendar(), "Limpar a bosta do cachorro", false));
        reminders.add(new Reminder(new GregorianCalendar(), "Remedio de esquisofrenia, pra fazer o Rogerio sumir", true));
        events.add(new Event(new GregorianCalendar(), "Role na casa do Rogerio, filho da marcia, chaminé de maria fumaça, rei do cabaré, procurado em 28 estados", "Casa do rogerin"));
    }
}