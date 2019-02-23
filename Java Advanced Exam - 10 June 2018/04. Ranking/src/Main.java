import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, String> contests = new LinkedHashMap<>();

        while (true) {
            String[] lines = bufferedReader.readLine().split(":");
            if (lines.length == 1) {
                break;
            }
            String contest = lines[0];
            String password = lines[1];

            contests.put(contest, password);

        }

        LinkedHashMap<String, LinkedHashMap<String, Integer>> candidates = new LinkedHashMap<>();

        while (true) {

            String[] lines = bufferedReader.readLine().split("=>");

            if (lines.length == 1) {
                break;
            }

            String candidateContestName = lines[0];
            String candidateContestPassword = lines[1];
            String candidateName = lines[2];
            Integer candidatePoints = Integer.parseInt(lines[3]);

            if (!contests.containsKey(candidateContestName)) {
                continue;
            } else {
                if (!contests.get(candidateContestName).equals(candidateContestPassword)) {
                    continue;
                }
            }

            if (!candidates.containsKey(candidateName)) {
                LinkedHashMap<String, Integer> courses = new LinkedHashMap<>();
                courses.put(candidateContestName, candidatePoints);
                candidates.put(candidateName, courses);
            } else {
                LinkedHashMap<String, Integer> courses = candidates.get(candidateName);

                if (!courses.containsKey(candidateContestName)) {
                    courses.put(candidateContestName, candidatePoints);
                } else {
                    int oldCoursePoints = courses.get(candidateContestName);
                    if (candidatePoints > oldCoursePoints) {
                        courses.put(candidateContestName, candidatePoints);
                    }
                }
            }

        }

        var candidatesSortedEntries = candidates.entrySet().stream().sorted((e1, e2) -> Integer.compare(e2.getValue().values().stream().mapToInt(Integer::intValue).sum(), e1.getValue().values().stream().mapToInt(Integer::intValue).sum())).collect(Collectors.toList());
        String bestCandidate = candidatesSortedEntries.get(0).getKey();
        int bestCandidatePoints = candidatesSortedEntries.get(0).getValue().values().stream().mapToInt(Integer::intValue).sum();
        System.out.printf("Best candidate is %s with total %s points.%n", bestCandidate, bestCandidatePoints);
        System.out.printf("Ranking: %n");

        candidates.entrySet().stream().sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey())).forEach(c -> {
            System.out.println(c.getKey());
            var sortedCourses = c.getValue().entrySet().stream().sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()));
            sortedCourses.forEach(course -> {
                System.out.printf("#  %s -> %s%n", course.getKey(), course.getValue());
            });
        });
    }
}
