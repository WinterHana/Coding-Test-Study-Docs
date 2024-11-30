import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        List<String> lines = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }

        String[] answer = solution(lines);
        for (String single : answer) {
            bw.write(single);
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    static String[] solution(List<String> lines) {
        Map<Phase, String> dpMap = new HashMap<>();
        return lines.stream()
                .map((l) -> l + " " + singleGame(l, dpMap))
                .toArray(String[]::new);
    }

    static String singleGame(String game, Map<Phase, String> dpMap) {
        String[] previousPhases = game.split("");
        Map<Integer, Integer> initMap = new HashMap<>();
        for (int i = 1; i <= 6; i++) {
            initMap.put(i, 4);
        }
        int sum = 0;
        for (String s : previousPhases) {
            Integer parsed = Integer.parseInt(s);
            initMap.put(parsed, initMap.get(parsed) - 1);
            sum += parsed;
        }

        Phase phase = new Phase(initMap, sum, game.length() % 2 == 0 ? "A" : "B");

        return whoWillWin(phase, dpMap);
    }

    static String whoWillWin(Phase phase, Map<Phase, String> dpMap) {
        if (phase.scoreAcc == 31) {
            return phase.currentPlayer.equals("A") ? "B" : "A";
        }

        if (dpMap.containsKey(phase)) {
            return dpMap.get(phase);
        }

        Map<Integer, Integer> leftCards = phase.leftCards;

        String winner = phase.currentPlayer.equals("A") ? "B" : "A";
        for (Map.Entry<Integer, Integer> entry : leftCards.entrySet()) {
            Integer card = entry.getKey();
            Integer cardCount = entry.getValue();
            if (cardCount == 0) {
                continue;
            }

            
            if (phase.scoreAcc + card <= 31) {
                Map<Integer, Integer> newMap = new HashMap<>(phase.leftCards);
                newMap.put(card, cardCount - 1);
                Phase newPhase = new Phase(newMap, phase.scoreAcc + card, phase.currentPlayer.equals("A") ? "B" : "A");
                winner = whoWillWin(newPhase, dpMap);

                if (winner.equals(phase.currentPlayer)) {
                    break;
                }
            }
        }

        dpMap.put(phase, winner);
        return winner;
    }

    static class Phase {
        final Map<Integer, Integer> leftCards;
        final int scoreAcc;
        final String currentPlayer;
        final int equality;

        Phase(Map<Integer, Integer> leftCards, int scoreAcc, String lastPlayer) {
            this.leftCards = leftCards;
            this.scoreAcc = scoreAcc;
            this.currentPlayer = lastPlayer;

            int sum = 0;
            int num = 1;
            for (int i = 1; i <= 6; i++) {
                sum += num * leftCards.get(i);
                num *= 10;
            }
            this.equality = sum;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (!(obj instanceof Phase)) {
                return false;
            }

            Phase target = (Phase)obj;
            return this.equality == target.equality;
        }

        @Override
        public int hashCode() {
            return this.equality;
        }
    }
}