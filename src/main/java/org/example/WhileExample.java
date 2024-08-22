import java.util.*;


public static void main(String[] args) {
        Collection<String> set = new HashSet<>(Set.of("1", "2", "3"));
        Collection<String> set2 = new TreeSet<>(Set.of("1", "2", "3"));
        Collection<String> list = new ArrayList<>(Set.of("1", "2", "3"));
        Collection<String> list2 = new LinkedList<>(Set.of("1", "2", "3"));

        System.out.println(set.equals(set2) + "-" + list.equals(list2) + "-" + set.equals(list2));
    }
