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
            "6 - удалить элемент \n 7 - найти пути \n";

    public static final String INPUT_COMMAND = "Введите команду";
    public static final String INPUT_COMMAND_TRY_AGAIN = "Попробуйте снова";
    public static final String PARSING_FAILED = "Не удалось распознать команду";

    public static final String SELECT_COMMAND_HELPER = "route/route-ip NetworkName " +
            "ProviderName firstElementID/IP secondElementID/IP";
}
