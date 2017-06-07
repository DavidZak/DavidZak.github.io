package Helpers;

public class ProjectFinalsContainer {   //контейнер констант

    //Exceptions messages
    public final static String ROUTE_NOT_FOUND_EXCEPTION_MESSAGE = "Путь не найден";
    public final static String IO_EXCEPTION_MESSAGE = "При вводе данных произошла ошибка";

    //File paths
    public static final String FILE_PATH = "data.xml";

    //Values
    public static final int INF = 10000;

    //Final IO strings
    public static final String CHOOSE_COMMAND = "Выберите тип команды: \n 1 - добавить новую сеть \n " +
            "2 - удалить сеть \n 3 - добавить провайдера \n 4 - удалить провайдера  \n 5 - добавить элемент \n " +
            "6 - удалить элемент \n 7 - найти пути \n 0 - для выхода";

    public static final String INPUT_COMMAND = "Введите команду";
    public static final String INPUT_COMMAND_TRY_AGAIN = "Попробуйте снова";
    public static final String PARSING_FAILED = "Не удалось распознать команду";

    public static final String SELECT_COMMAND_HELPER = "route/route-ip NetworkName " +
            "ProviderName firstElementID/IP secondElementID/IP";

    //String for IODataManipulation
    public static final String NETWORK_ADDING_PROCESS = "Добавление новой сети";
    public static final String NETWORK_REMOVING_PROCESS = "Удаление сети";
    public static final String ROUTE_PROVIDER_ADDING_PROCESS = "Добавление нового провайдера";
    public static final String ROUTE_PROVIDER_REMOVING_PROCESS = "Удаление провайдера";
    public static final String PATH_ELEMENT_ADDING_PROCESS = "Добавление нового элемента";
    public static final String PATH_ELEMENT_REMOVING_PROCESS = "Удаление элемента";

    public static final String GO_TO_MAIN_COMMAND = "Нажмите 0 для выхода в меню выбора команд";

    public static final String ENTER_NAME = "Введите имя";
    public static final String ENTER_IP = "Введите IP";

    public static final String NAME_ALREADY_EXISTS = "Такое имя уже существует";
    public static final String IP_ALREADY_EXISTS = "Такой IP уже существует в этой сети";
}
