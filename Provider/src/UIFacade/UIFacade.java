package UIFacade;

public class UIFacade {

    UIInputCommandHelper uiInputCommandHelper;

    public UIFacade() {
        uiInputCommandHelper = new UIInputCommandHelper();
        uiInputCommandHelper.readChooseCommandNumberCommand();
    }
}
