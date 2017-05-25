package UIFacade;

public class UIFacade {

    private static UIFacade instance;
    private UIFacade(){

    }

    public static UIFacade getInstance() {
        if (instance==null)
            instance=new UIFacade();
        return instance;
    }

    public void executeCommand(String command){
        System.out.println(new CommandParser(command));
    }
}
