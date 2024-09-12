
import java.util.Comparator;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        User user1 = new User(1,"Константин","Рокоссовский",45,"Польша");
        User user2 = new User(2,"Теодор","Рузвельт",51,"США");
        User user3 = new User(3,"Павел","Корчагин",7,"Россия");
        User user4 = new User(4,"Шерлок","Холмс",35,"Соединенное Королевство");
        User user5 = new User(5,"Авраам","Линкольн",56,"США");
        List<User> userList = List.of(user1,user2,user3,user4,user5);

        System.out.println("Сортировка по фамилии:");
        lastNameSorted(userList);
        System.out.println("**********************");

        System.out.println("Сортировка по возрасту:");
        ageSorted(userList);
        System.out.println("**********************");

        System.out.println("Нету врзраста 7 и меньше:" + ageCheck(userList));
        System.out.println("**********************");

        System.out.println("Средний возраст: " + averageAge(userList));
        System.out.println("**********************");

        difCountry(userList);
        System.out.println("**********************");
        }
    // Сортировка и вывод по фамилии
      public static void lastNameSorted(List<User> userList){
       Comparator<User> userComparatorLN = (list1,list2) -> list1.getLastName().compareTo(list2.getLastName()); // компаратор по фамилиям
        userList.stream()
                .sorted(userComparatorLN)
                .forEach(System.out::println);

      }
    // Сортировка и вывод по возрасту
      public static void ageSorted(List<User> userList){
        Comparator<User> userComparatorAge = (list1,list2) -> Integer.compare(list1.getAge(),list2.getAge());
        userList.stream()
                .sorted(userComparatorAge)
                .forEach(System.out::println);
      }
    // Проверка возраста >7
    public static boolean ageCheck(List<User> userList) {
        return userList.stream()
                .allMatch(e -> e.getAge()>7);
    }
    // Средний возраст
    public static double averageAge(List<User> userList) {
        return userList.stream()
                .mapToDouble(User::getAge)
                .average()
                .orElse(0.0);// если возраст не указан принимаем за 0
    }
    //Количество разных стран
    public static void difCountry(List<User> userList) {
        System.out.print("Число разных стран проживания: ");
        System.out.println(userList.stream()
                .map(User::getCountry)
                .distinct()
                .count());

    }
    }
