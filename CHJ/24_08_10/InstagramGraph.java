import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InstagramGraph {

    //Key 유저명 : Value : 유저를 팔로잉하는 리스트 즉 사용자의 팔로워 목록
    private Map<String, List<String>> followersMap;

    public InstagramGraph() {
        followersMap = new HashMap<>();
    }

    //사용자를 추가하는 메서드
    public void addUser(String user) {
        followersMap.putIfAbsent(user, new ArrayList<>());
    }

    // 팔로우 관계를 추가하는 메서드 follower가 following을 팔로잉한다.
    //(Alice,Bob) Alice가 Bob을 팔로우함.
    public void addFollow(String follower, String following) {
        followersMap.get(follower).add(following);
    }

    //특정 사용자의 팔로잉 목록을 출력하는 메서드
    public void displayFollowing(String user) {
        System.out.print(user + " follows: ");
        for (String following : followersMap.get(user)) {
            System.out.print(following + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        InstagramGraph graph = new InstagramGraph();

        graph.addUser("현준");
        graph.addUser("경도");
        graph.addUser("성진");

        graph.addFollow("현준","경도");
        graph.addFollow("현준","성진");
        graph.addFollow("성진","현준");

        graph.displayFollowing("현준");
        graph.displayFollowing("경도");
        graph.displayFollowing("성진");
    }//End Of Main

}
