package polymorphism.class_problems;

import java.util.*;

abstract class Question {
    protected int points;

    public Question(int points) {
        this.points = points;
    }

    public abstract double grade(String correctAnswer, String studentAnswer);
    public abstract String getType();
}

class McqQuestion extends Question {
    public McqQuestion(int points) {
        super(points);
    }

    @Override
    public double grade(String correctAnswer, String studentAnswer) {
        return correctAnswer.equalsIgnoreCase(studentAnswer) ? points : 0;
    }

    @Override
    public String getType() {
        return "MCQ";
    }
}

class TfQuestion extends Question {
    public TfQuestion(int points) {
        super(points);
    }

    @Override
    public double grade(String correctAnswer, String studentAnswer) {
        return correctAnswer.equalsIgnoreCase(studentAnswer) ? points : 0;
    }

    @Override
    public String getType() {
        return "TF";
    }
}

class EssayQuestion extends Question {
    public EssayQuestion(int points) {
        super(points);
    }

    @Override
    public double grade(String correctAnswer, String studentAnswer) {
        String[] keywords = correctAnswer.split(",");
        int matchCount = 0;
        String lowerStudent = studentAnswer.toLowerCase();
        for (String keyword : keywords) {
            if (lowerStudent.contains(keyword.trim().toLowerCase())) {
                matchCount++;
            }
        }
        if (matchCount >= 2) return points * 0.75;
        if (matchCount == 1) return points * 0.50;
        return 0;
    }

    @Override
    public String getType() {
        return "ESSAY";
    }
}

public class ExaminationQuestionGrader {

    private static String extractQuoted(String[] parts, int startIdx) {
        StringBuilder sb = new StringBuilder();
        for (int i = startIdx; i < parts.length; i++) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(parts[i]);
            if (parts[i].endsWith("\"") && (i > startIdx || parts[i].length() > 1)) break;
        }
        return sb.toString().replaceAll("^\"|\"$", "");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());

        List<Question> questions = new ArrayList<>();
        List<String> correctAnswers = new ArrayList<>();
        List<String> studentAnswers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] tokens = line.split("\"");
            String type = tokens[0].trim();
            String questionText = tokens[1];
            String correctAns = tokens[3];
            String studentAns = tokens[5];
            int pts = Integer.parseInt(tokens[6].trim());

            correctAnswers.add(correctAns);
            studentAnswers.add(studentAns);

            if (type.equals("MCQ")) questions.add(new McqQuestion(pts));
            else if (type.equals("TF")) questions.add(new TfQuestion(pts));
            else questions.add(new EssayQuestion(pts));
        }

        double total = 0;
        for (int i = 0; i < questions.size(); i++) {
            double score = questions.get(i).grade(correctAnswers.get(i), studentAnswers.get(i));
            total += score;
            System.out.printf("%s: %.2f%n", questions.get(i).getType(), score);
        }
        System.out.printf("Total Score: %.2f%n", total);
        scanner.close();
    }
}
